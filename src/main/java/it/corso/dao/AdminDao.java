package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Admin;

// Questa è un'interfaccia per l'accesso ai dati degli amministratori (Admin) nel database.
// Estende CrudRepository, che fornisce metodi per le operazioni CRUD (Create, Read, Update, Delete).
public interface AdminDao extends CrudRepository<Admin, Integer> {
    
    // Questo metodo cerca un amministratore nel database in base al nome utente e alla password.
    Admin findByUsernameAndPassword(String username, String password);
    
    // Questo metodo cerca un amministratore nel database in base al token di autenticazione.
    Admin findByAuthToken(String authToken);
}

/*CrudRepository fornisce metodi predefiniti per le operazioni CRUD (Create, Read, Update, Delete) su un'entità. Ecco una breve spiegazione dei principali metodi forniti da CrudRepository:

Save (Create):

Metodo: save(S entity)
Descrizione: Salva un'entità nel database. Se l'entità non esiste, viene creata. Se esiste, viene aggiornata con i nuovi dati se necessario.
Find (Read):

Metodo: findById(ID id)
Descrizione: Trova un'entità nel database in base all'ID specificato. Restituisce un'istanza dell'entità se trovata o null se non esiste.
FindAll (Read):

Metodo: findAll()
Descrizione: Restituisce una lista di tutte le entità presenti nel database.
Count (Read):

Metodo: count()
Descrizione: Restituisce il numero totale di entità nel database.
Exists (Read):

Metodo: existsById(ID id)
Descrizione: Verifica se un'entità con l'ID specificato esiste nel database. Restituisce true se esiste, altrimenti false.
Delete (Delete):

Metodo: deleteById(ID id)
Descrizione: Elimina un'entità dal database in base all'ID specificato.
Delete (Delete):

Metodo: delete(T entity)
Descrizione: Elimina un'entità specifica dal database.
DeleteAll (Delete):

Metodo: deleteAll()
Descrizione: Elimina tutte le entità dal database

*/