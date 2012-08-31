package com.logikas.kratos.core.facade;

import com.logikas.kratos.system.domain.UserAvatar;
import com.logikas.kratos.system.service.UserAvatarService;

import com.google.common.base.Strings;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;

import java.io.IOException;
import java.sql.SQLException;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;

@Singleton
public class UserAvatarServlet extends HttpServlet {
  
  private final UserAvatarService service;
  
  UserAvatarServlet(UserAvatarService service) {
    this.service = service;
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    String response = null;
    
    try {      
      final UserAvatar avatar = service.create("avatar", req.getContentType(), req.getInputStream());
      response = String.format("{'id': %d}", avatar.getId());
    } catch(ValidationException e) {
      response = String.format("{'validation': '%s'}", e.getMessage());
    } finally {
      resp.getOutputStream().print(response);
    }
  }
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {
    
    final String idStr = req.getParameter("id");
  
    if(!Strings.isNullOrEmpty(idStr)) {
      final Integer id = Ints.tryParse(idStr);
      if(id != null) {
        final UserAvatar avatar = service.findOne(id.longValue());        
        try {
          ByteStreams.copy(avatar.getContent().getBinaryStream(), resp.getOutputStream());
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

}
