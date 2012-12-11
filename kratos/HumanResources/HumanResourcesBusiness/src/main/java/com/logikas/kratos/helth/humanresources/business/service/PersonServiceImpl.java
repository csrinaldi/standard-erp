/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.kratos.helth.humanresources.business.service;

import com.google.inject.Inject;
import com.logikas.kratos.helth.humanresources.dao.PersonRepository;
import com.logikas.kratos.helth.humanresources.domain.Person;

/**
 * Human Resources Business OSGi Bundle
 *
 * Documentation of Class PersonServiceImpl
 *
 *
 * Package: com.logikas.kratos.helth.humanresources.business.service 
 * Last modification: 01/12/2012
 * File: PersonServiceImpl.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public class PersonServiceImpl implements PersonService{

    private final PersonRepository repository;
    
    @Inject
    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonProxy findById(Long id) {
        Person p = this.repository.finById(id);
        return new PersonProxy();
    }

}
