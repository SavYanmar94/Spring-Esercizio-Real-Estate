package it.corso.service;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Property;
import it.corso.model.Request;

public interface PropertyService {
	
	//metodo per la registrazione proprietà , che accetta un oggetto proprietà ad un token 
	//perchè l'admin deve essere loggato 
	ObjectNode propertyRegistration(Property property,String token);
	
	//metodo per la modifica proprietà , che accetta un oggetto proprietà ad un token 
	//perchè l'admin deve essere loggato

	ObjectNode propertyDataUpdate(Property property,String token);
	
	//lista delle proprietà(metodo accessibile sia a customer che admin) 
	List<Property> getProperties();
	
	

}
