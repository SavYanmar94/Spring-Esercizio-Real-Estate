package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Propertyaddress;

public interface PropertyAddressDao extends CrudRepository<Propertyaddress, Integer> {
	// Non sono stati aggiunti metodi personalizzati in questa interfaccia
}
