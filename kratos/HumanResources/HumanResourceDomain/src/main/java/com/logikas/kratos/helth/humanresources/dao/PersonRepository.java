/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.kratos.helth.humanresources.dao;

import com.logikas.kratos.helth.humanresources.domain.Person;
import java.util.List;

/**
 * Human Resource Domain OSGi Bundle
 *
 * Documentation of Class PersonDto
 *
 *
 * Package: com.logikas.kratos.helth.humanresources.dao 
 * Last modification: 01/12/2012
 * File: PersonDto.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public class PersonRepository implements Repository<Long, Person> {

    @Override
    public Person finById(Long type) {
        return new Person();
    }

    @Override
    public List<Person> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    

}
