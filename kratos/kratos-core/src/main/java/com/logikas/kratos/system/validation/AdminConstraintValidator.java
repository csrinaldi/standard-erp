package com.logikas.kratos.system.validation;

import com.logikas.kratos.system.domain.User;
import com.logikas.kratos.system.service.UserService;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AdminConstraintValidator implements ConstraintValidator<Admin, User>{
  
  private final UserService userService;
    
  @Inject
  AdminConstraintValidator(UserService userService) {
    this.userService = userService;
  }
  
  @Override
  public void initialize(Admin admin) {
    
  }

  @Override
  public boolean isValid(User user, ConstraintValidatorContext context) {
    return userService.isAdmin(user);
  }
}
