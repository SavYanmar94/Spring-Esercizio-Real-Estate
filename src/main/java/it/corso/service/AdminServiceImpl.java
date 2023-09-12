package it.corso.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.corso.dao.AdminDao;
import it.corso.helper.ResponseManager;
import it.corso.helper.SecurityManager;
import it.corso.model.Admin;


 //Questa classe fornisce l'implementazione dei metodi del servizio di amministratori.
 
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private ResponseManager responseManager;

    //Questo metodo gestisce l'accesso di un amministratore al sistema.
    
    @Override
    public ObjectNode adminLogin(Admin admin) {
        // Cerca un amministratore nel database in base al nome utente e alla password forniti.
        Admin existing = adminDao.findByUsernameAndPassword(admin.getUsername(),
                SecurityManager.encode(admin.getPassword()));

        // Se l'amministratore non viene trovato, restituisci una risposta di errore.
        if (existing == null)
            return responseManager.getResponse(401, "Non Autorizzato");

        // Genera un nuovo token di autenticazione per l'amministratore e lo memorizza.
        existing.setAuthToken(SecurityManager.generateToken(existing.getUsername()));
        adminDao.save(existing);

        // Restituisci una risposta di successo con il token generato.
        return responseManager.getResponse(202, existing.getAuthToken());
    }

    // Questo metodo gestisce il logout di un amministratore dal sistema.
     
    @Override
    public ObjectNode adminLogout(String token) {
        // Cerca l'amministratore nel database in base al token di autenticazione.
        Admin existing = adminDao.findByAuthToken(token);

        // Se l'amministratore non viene trovato, restituisci una risposta di errore.
        if (existing == null)
            return responseManager.getResponse(401, "Non Autorizzato");

        // Rimuovi il token di autenticazione memorizzato per l'amministratore.
        existing.setAuthToken(null);
        adminDao.save(existing);

        // Restituisci una risposta di successo confermando il logout.
        return responseManager.getResponse(202, "Logout Accettato");
    }
}