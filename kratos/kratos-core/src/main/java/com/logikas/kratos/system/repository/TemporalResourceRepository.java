package com.logikas.kratos.system.repository;

import com.logikas.kratos.core.repository.Repository;
import com.logikas.kratos.system.domain.TemporalResource;

import com.google.inject.servlet.RequestScoped;
@RequestScoped
public interface TemporalResourceRepository extends Repository<TemporalResource, Long> {

}
