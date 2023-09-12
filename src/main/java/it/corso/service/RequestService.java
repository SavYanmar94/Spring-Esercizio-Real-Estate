package it.corso.service;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Request;

public interface RequestService {

	//registrazione richiesta da parte di un potenziale acquirente
	ObjectNode RequestRegistration(Request request);
	
    //modifica richiesta
    ObjectNode RequestDataUpdate(Request request);
    
    //lista delle richieste per una determinata proprietà 
	List<Request> getRequests(String token);
}
