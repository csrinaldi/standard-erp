package com.logikas.kratos.core.facade;

import com.logikas.kratos.system.domain.UserAvatar;
import com.logikas.kratos.system.service.UserAvatarService;

import com.google.common.base.Strings;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.validation.ValidationException;

@Singleton
public class UserAvatarServlet extends HttpServlet {

  private static final String CONTENT_DISPOSITION = "Content-Disposition";
  private static final String FILENAME = "filename";

  private final UserAvatarService service;

  UserAvatarServlet(UserAvatarService service) {
    this.service = service;
  }

  private String getFileName(Part part) {

    // String partHeader = part.getHeader("content-disposition");

    // logger.info("Part Header = " + partHeader);

    for (String cd : part.getHeader(CONTENT_DISPOSITION).split(";")) {
      if (cd.trim().startsWith(FILENAME)) {
        return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
      }
    }
    return null;
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {

    try {

      final Part part = req.getPart("avatar");

      if (part != null) {

        final String contentType = part.getContentType();
        final String filename = getFileName(part);
        final InputStream content = part.getInputStream();
        final UserAvatar avatar = service.create(filename, contentType, content);
        final String result = String.format("{'id': %d, 'code': 'OK'}", avatar.getId());
        
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("text/html");
        resp.getOutputStream().print(result);
        
      } else {        
        // Usado por Google cuando se requieren parametros
        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        resp.setContentType("text/html");
        final String result = String.format("{'code': 'PARAMETER', 'message': '%s'}", "Parameter avatar is required.");
        resp.getOutputStream().print(result);
      }
    } catch (ValidationException e) {      
      
      resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
      resp.setContentType("text/html");
      final String result = String.format("{'code': 'VALIDATION', 'message': '%s'}", e.getMessage());
      resp.getOutputStream().print(result);
      
    } catch (ServletException e) {
      
      // Usado por Google cuando se requieren parametros
      resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
      resp.setContentType("text/html");
      final String result = String.format("{'code': 'MULTIPART', 'message': '%s'}", "Multipart is required.");
      resp.getOutputStream().print(result);

    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {

    final String idStr = req.getParameter("id");

    if (!Strings.isNullOrEmpty(idStr)) {
      final Integer id = Ints.tryParse(idStr);
      if (id != null) {
        final UserAvatar avatar = service.findOne(id.longValue());
        
        if(avatar != null) {
        
        try {
          
          resp.setStatus(HttpServletResponse.SC_OK);
          resp.setContentType(avatar.getContentType());
          resp.setHeader(CONTENT_DISPOSITION, "attachment;  filename=" + avatar.getFilename());

          ByteStreams.copy(avatar.getContent().getBinaryStream(), resp.getOutputStream());                  
        } catch (SQLException e) {
                   
          resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
          resp.setContentType("text/html");
          resp.getOutputStream().print("File Database Exception: " + e.getMessage());
        }
        } else {

          resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
          resp.setContentType("text/html");
          resp.getOutputStream().print("Unable to find resource with id " + id);
          
        }
      } else {
        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        resp.setContentType("text/html");
        resp.getOutputStream().print("Unable to find resource with id " + id);                
      }
    }
  }
}