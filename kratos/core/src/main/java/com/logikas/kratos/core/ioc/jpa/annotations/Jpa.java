/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.ioc.jpa.annotations;

import com.google.inject.BindingAnnotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author Cristian Rinaldi
 */
@Retention(RetentionPolicy.RUNTIME)
@BindingAnnotation 
public @interface Jpa {}