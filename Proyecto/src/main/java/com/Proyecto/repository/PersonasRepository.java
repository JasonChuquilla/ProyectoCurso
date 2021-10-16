package com.Proyecto.repository;
import org.springframework.data.repository.CrudRepository;

import com.Proyecto.models.Personas;


public interface PersonasRepository extends CrudRepository<Personas, String> {

}
