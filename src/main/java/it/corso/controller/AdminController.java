package it.corso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.corso.model.Admin;
import it.corso.service.AdminService;

/**
 * Questa classe è un controller REST che gestisce le richieste relative agli amministratori.
 * L'annotazione @RestController indica che questa classe è un controller REST.
 */
@RestController
/**
 * L'annotazione @RequestMapping definisce il mapping di base per le richieste HTTP gestite da questo controller.
 * In questo caso, tutte le richieste relative agli amministratori inizieranno con "/realestate/admin".
 */
@RequestMapping("/realestate/admin")
/**
 * L'annotazione @CrossOrigin consente alle richieste provenienti da origini diverse (ad esempio, domini diversi)
 * di accedere a questo controller. Nel nostro caso, "*" indica che qualsiasi origine è consentita.
 */
@CrossOrigin(origins = {"*"})
public class AdminController
{
	/**
	 * Questa annotazione @Autowired indica che l'istanza di AdminService deve essere iniettata automaticamente
	 * da Spring quando viene creato un oggetto di questa classe.
	 */
	@Autowired
	private AdminService adminService;
	
	/**
	 * Questo metodo gestisce una richiesta di login per un amministratore.
	 * L'annotazione @PutMapping specifica che questo metodo risponde alle richieste HTTP di tipo PUT sulla route "/login".
	 */
	@PutMapping("/login")
	public ResponseEntity<ObjectNode> adminLogin(@RequestBody Admin admin)
	{
		// Invoca il metodo adminLogin dell'AdminService per gestire il login dell'amministratore.
		ObjectNode response = adminService.adminLogin(admin);
		// Crea una risposta HTTP con il corpo fornito dal metodo adminLogin e il codice HTTP corrispondente.
		return new ResponseEntity<ObjectNode>(response, 
				HttpStatusCode.valueOf(response.get("code").asInt()));
	}
	
	/**
	 * Questo metodo gestisce una richiesta di logout per un amministratore.
	 * L'annotazione @GetMapping specifica che questo metodo risponde alle richieste HTTP di tipo GET sulla route "/logout/{admin token}".
	 * Il token dell'amministratore è passato come parte dell'URL.
	 */
	@GetMapping("/logout/{tkn}")
	public ResponseEntity<ObjectNode> adminLogout(@PathVariable("tkn") String token)
	{
		// Invoca il metodo adminLogout dell'AdminService per gestire il logout dell'amministratore.
		ObjectNode response = adminService.adminLogout(token);
		// Crea una risposta HTTP con il corpo fornito dal metodo adminLogout e il codice HTTP corrispondente.
		return new ResponseEntity<ObjectNode>(response, 
				HttpStatusCode.valueOf(response.get("code").asInt()));
	}
}