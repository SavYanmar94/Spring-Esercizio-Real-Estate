package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Property;

public interface PropertyDao extends CrudRepository<Property, Integer>{
	// Non sono stati aggiunti metodi personalizzati in questa interfaccia
}
