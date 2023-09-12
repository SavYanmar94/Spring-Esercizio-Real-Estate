package it.corso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.dao.RequestDao;
import it.corso.helper.ResponseManager;
import it.corso.model.Request;

/**
 * Questa classe fornisce l'implementazione dei metodi del servizio di gestione delle richieste.
 * L'annotazione @Service indica che questa classe è un componente di servizio gestito da Spring.
 */
@Service
public class RequestServiceImpl implements RequestService {
	
	//L'annotazione @Autowired viene utilizzata per l'iniezione delle dipendenze.
	@Autowired
	private RequestDao requestDao;
	
	@Autowired
	private ResponseManager responseManager;

	//Questo metodo gestisce la registrazione di una nuova richiesta nel sistema.
	
	@Override
	public ObjectNode RequestRegistration(Request request) {
		// Imposta lo stato della richiesta come "da evadere" e la registra nel database.
		request.setStatus("da evadere");
		requestDao.save(request);
		
		// Restituisci una risposta di successo confermando la registrazione della richiesta.
		return responseManager.getResponse(201, "Richiesta Registrata");
	}

	//Questo metodo gestisce l'aggiornamento dei dati di una richiesta nel sistema.
	
	@Override
	public ObjectNode RequestDataUpdate(Request request) {
		// Cerca la richiesta nel database in base all'ID fornito.
		Optional<Request> requestOptional = requestDao.findById(request.getId());
		
		// Se la richiesta non viene trovata, restituisci una risposta di errore.
		if(!requestOptional.isPresent())
			return responseManager.getResponse(404, "Richiesta Non Trovata");
		
		Request existing = requestOptional.get();
		
		// Imposta lo stato della richiesta come "evasa".
		existing.setStatus("evasa");
		requestDao.save(existing);
		
		// Restituisci una risposta di successo confermando l'aggiornamento dei dati della richiesta.
		return responseManager.getResponse(202, "Dati della Richiesta Aggiornati");
	}

	// Questo metodo restituisce un elenco di tutte le richieste presenti nel sistema.
	 
	@Override
	public List<Request> getRequests(String token) {
		// Recupera tutte le richieste dal database e restituiscile come lista.
		return (List<Request>) requestDao.findAll();
	}
}
