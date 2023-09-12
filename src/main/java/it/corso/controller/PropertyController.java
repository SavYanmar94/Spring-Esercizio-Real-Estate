package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Property;
import it.corso.service.PropertyService;

/**
 * Questa classe è un controller REST che gestisce le richieste relative alle proprietà immobiliari.
 * L'annotazione @RestController indica che questa classe è un controller REST.
 */
@RestController
/**
 * L'annotazione @RequestMapping definisce il mapping di base per le richieste HTTP gestite da questo controller.
 * In questo caso, tutte le richieste relative alle proprietà inizieranno con "/realestate/property".
 */
@RequestMapping("/realestate/property")
/**
 * L'annotazione @CrossOrigin consente alle richieste provenienti da origini diverse (ad esempio, domini diversi)
 * di accedere a questo controller. Nel nostro caso, "*" indica che qualsiasi origine è consentita.
 */
@CrossOrigin(origins = {"*"})
public class PropertyController {
	
	/**
	 * Questa annotazione @Autowired indica che l'istanza di PropertyService deve essere iniettata automaticamente
	 * da Spring quando viene creato un oggetto di questa classe.
	 */
	@Autowired
	private PropertyService propertyService;
	
	/**
	 * Questo metodo gestisce una richiesta di registrazione di una proprietà immobiliare.
	 * L'annotazione @PostMapping specifica che questo metodo risponde alle richieste HTTP di tipo POST sulla route "/reg/{admin token}".
	 * Il token dell'amministratore è passato come parte dell'URL.
	 */
	@PostMapping("/reg/{tkn}")
	public ResponseEntity<ObjectNode> propertyRegistration(@RequestBody Property property,
			@PathVariable("tkn") String token){
		
		// Invoca il metodo propertyRegistration del PropertyService per registrare una proprietà immobiliare.
		ObjectNode response = propertyService.propertyRegistration(property, token);
		
		// Crea una risposta HTTP con il corpo fornito dal metodo propertyRegistration e il codice HTTP corrispondente.
		return new ResponseEntity<ObjectNode>(response, HttpStatusCode.valueOf(response.get("code").asInt()));
	}
	
	
	/**
	 * Questo metodo gestisce una richiesta di modifica dei dati di una proprietà immobiliare.
	 * L'annotazione @PutMapping specifica che questo metodo risponde alle richieste HTTP di tipo PUT sulla route "/update/{admin token}".
	 * Il token dell'amministratore è passato come parte dell'URL.
	 */
	@PutMapping("/update/{tkn}")
	public ResponseEntity<ObjectNode> propertyDataUpdate(@RequestBody Property property,
			@PathVariable("tkn") String token){
	
		// Invoca il metodo propertyDataUpdate del PropertyService per aggiornare i dati di una proprietà immobiliare.
		ObjectNode response = propertyService.propertyDataUpdate(property, token);
		
		// Crea una risposta HTTP con il corpo fornito dal metodo propertyDataUpdate e il codice HTTP corrispondente.
		return new ResponseEntity<ObjectNode>(response, HttpStatusCode.valueOf(response.get("code").asInt()));
		
	}
	
	/**
	 * Questo metodo gestisce una richiesta per ottenere l'elenco di tutte le proprietà immobiliari.
	 * L'annotazione @GetMapping specifica che questo metodo risponde alle richieste HTTP di tipo GET sulla route "/get".
	 */
	@GetMapping("/get")
	public ResponseEntity<List<Property>> getProperties()
	{
		// Invoca il metodo getProperties del PropertyService per ottenere l'elenco di tutte le proprietà immobiliari.
		List<Property> response = propertyService.getProperties();
		
		// Crea una risposta HTTP con il corpo fornito dal metodo getProperties e lo stato HTTP OK (200).
		return new ResponseEntity<List<Property>>(response, HttpStatus.OK);
	}
}
