package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.dao.AdminDao;
import it.corso.dao.CustomerDao;
import it.corso.dao.PropertyDao;
import it.corso.dao.RequestDao;
import it.corso.helper.ResponseManager;
import it.corso.model.Property;
import it.corso.model.Request;

//Questa classe fornisce l'implementazione dei metodi del servizio di gestione delle proprietà.

@Service
public class PropertyServiceImpl implements PropertyService {

	//Autowired: ioc container si occupa dell'iniezione automatica dipendenze
    @Autowired
    private PropertyDao propertyDao;

    @Autowired
    private ResponseManager responseManager;

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private RequestDao requestDao;

    @Autowired
    private RequestService requestService;

    // Questo metodo gestisce la registrazione di una nuova proprietà nel sistema.
 
    @Override
    public ObjectNode propertyRegistration(Property property, String token) {
        // Verifica se l'amministratore è autorizzato mediante il token fornito.
        if (adminDao.findByAuthToken(token) == null)
            return responseManager.getResponse(401, "Non Autorizzato");

        // Imposta lo stato della proprietà come "disponibile" e la registra nel database.
        property.setStatus("disponibile");
        propertyDao.save(property);

        // Restituisci una risposta di successo confermando la registrazione.
        return responseManager.getResponse(201, "Proprietà Registrata");
    }

    //Questo metodo gestisce l'aggiornamento dei dati di una proprietà nel sistema.
     
    @Override
    public ObjectNode propertyDataUpdate(Property property, String token) {
        // Verifica se l'amministratore è autorizzato mediante il token fornito.
        if (adminDao.findByAuthToken(token) == null)
            return responseManager.getResponse(401, "Non Autorizzato");

        // Cerca la proprietà nel database in base all'ID fornito.
        Optional<Property> propertyOptional = propertyDao.findById(property.getId());

        // Se la proprietà non viene trovata, restituisci una risposta di errore.
        if (!propertyOptional.isPresent())
            return responseManager.getResponse(404, "Proprietà Non Trovata");

        Property existing = propertyOptional.get();
        // Controlla se lo stato attuale della proprietà è "venduto".
        // Se è già venduto, restituisci una risposta di errore.
        /*if (existing.getStatus().toLowerCase().equals("venduto"))
            return responseManager.getResponse(406, "Impossibile modificare lo stato della proprietà. Proprietà già venduta");*/

        // Imposta lo stato della proprietà come "venduto".
        existing.setStatus("venduto");

        // Ottieni l'elenco degli ID delle richieste associate a questa proprietà.
        List<Integer> requestId = new ArrayList<>();
        for (Request singleRequest : existing.getRequests()) {
            requestId.add(singleRequest.getId());
        }

        // Rimuovi tutte le richieste associate alla proprietà e cancellale dal database.
        existing.getRequests().clear();
        requestDao.deleteAllById(requestId);

        // Salva la proprietà aggiornata nel database.
        propertyDao.save(existing);

        // Restituisci una risposta di successo confermando l'aggiornamento dei dati della proprietà.
        return responseManager.getResponse(202, "Dati della Proprietà Aggiornati");
    }

    // Questo metodo restituisce un elenco di tutte le proprietà presenti nel sistema.
   
    @Override
    public List<Property> getProperties() {
        // Recupera tutte le proprietà dal database e restituiscile come lista.
        return (List<Property>) propertyDao.findAll();
    }
}