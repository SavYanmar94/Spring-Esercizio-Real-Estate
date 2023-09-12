package it.corso.controller;

import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.helper.ResponseManager;
import it.corso.model.Request;
import it.corso.service.RequestService;

/**
 * Questa classe è un controller REST che gestisce le richieste relative alle richieste immobiliari.
 * L'annotazione @RestController indica che questa classe è un controller REST.
 */
@RestController
/**
 * L'annotazione @RequestMapping definisce il mapping di base per le richieste HTTP gestite da questo controller.
 * In questo caso, tutte le richieste relative alle richieste inizieranno con "/realestate/request".
 */
@RequestMapping("/realestate/request")
/**
 * L'annotazione @CrossOrigin consente alle richieste provenienti da origini diverse (ad esempio, domini diversi)
 * di accedere a questo controller. Nel nostro caso, "*" indica che qualsiasi origine è consentita.
 */
@CrossOrigin(origins = {"*"})
public class RequestController {

	/**
	 * Questa annotazione @Autowired indica che l'istanza di RequestService deve essere iniettata automaticamente
	 * da Spring quando viene creato un oggetto di questa classe.
	 */
	@Autowired
	private RequestService requestService;
	
	/**
	 * Questa annotazione @Autowired indica che l'istanza di ResponseManager deve essere iniettata automaticamente
	 * da Spring quando viene creato un oggetto di questa classe.
	 */
	@Autowired
	private ResponseManager responseManager;
	
	
	/**
	 * Questo metodo gestisce una richiesta di registrazione di una richiesta immobiliare.
	 * L'annotazione @PostMapping specifica che questo metodo risponde alle richieste HTTP di tipo POST sulla route "/reg".
	 */
	@PostMapping("/reg")
	public ResponseEntity<ObjectNode> requestRegistration(@RequestBody Request request){
		
		// Invoca il metodo RequestRegistration del RequestService per registrare una richiesta immobiliare.
		ObjectNode response = requestService.RequestRegistration(request);
		
		// Crea una risposta HTTP con il corpo fornito dal metodo RequestRegistration e il codice HTTP corrispondente.
		return new ResponseEntity<ObjectNode>(response, HttpStatusCode.valueOf(response.get("code").asInt()));
	}
	
	
	/**
	 * Questo metodo gestisce una richiesta di modifica dei dati di una richiesta immobiliare.
	 * L'annotazione @PutMapping specifica che questo metodo risponde alle richieste HTTP di tipo PUT sulla route "/update/{tkn}".
	 * Il token dell'amministratore è passato come parte dell'URL.
	 */
	@PutMapping("/update/{tkn}")
	public ResponseEntity<ObjectNode> requestDataUpdate(@RequestBody Request request,
			@PathVariable("tkn") String token){
	
		// Invoca il metodo RequestDataUpdate del RequestService per aggiornare i dati di una richiesta immobiliare.
		ObjectNode response = requestService.RequestDataUpdate(request);
		
		// Crea una risposta HTTP con il corpo fornito dal metodo RequestDataUpdate e il codice HTTP corrispondente.
		return new ResponseEntity<ObjectNode>(response, HttpStatusCode.valueOf(response.get("code").asInt()));
		
	}
	
	/**
	 * Questo metodo gestisce una richiesta per ottenere l'elenco di tutte le richieste immobiliari.
	 * L'annotazione @GetMapping specifica che questo metodo risponde alle richieste HTTP di tipo GET sulla route "/get/{tkn}".
	 * Il token dell'amministratore è passato come parte dell'URL.
	 */
	@GetMapping("/get/{tkn}")
	public ResponseEntity<List<Request>> getRequests(@PathVariable("tkn") String token)
	{
		// Invoca il metodo getRequests del RequestService per ottenere l'elenco di tutte le richieste immobiliari.
		List<Request> response = requestService.getRequests(token);
		
		// Crea una risposta HTTP con il corpo fornito dal metodo getRequests e lo stato HTTP OK (200).
		return new ResponseEntity<List<Request>>(response, HttpStatus.OK);
	}
		
	/**
	 * Questo metodo gestisce le eccezioni di tipo DateTimeParseException, che possono verificarsi
	 * quando viene effettuato il parsing di una data.
	 * Restituisce una risposta HTTP con un messaggio di errore appropriato e uno stato HTTP BAD_REQUEST (400).
	 */
	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<ObjectNode> handleOrderDateException(DateTimeParseException e)
	{
		// Crea una risposta HTTP con un messaggio di errore per gestire l'eccezione di parsing della data.
		ObjectNode errorMessage = responseManager.getResponse(400, "Invalid Request Date");
		return new ResponseEntity<ObjectNode>(errorMessage, HttpStatus.BAD_REQUEST);
	}
}
