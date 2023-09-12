package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Request;

public interface RequestDao extends CrudRepository<Request, Integer>{
	// Non sono stati aggiunti metodi personalizzati in questa interfaccia
}
