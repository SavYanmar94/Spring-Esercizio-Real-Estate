Traccia

Esercitazione Real Estate ( Esercizio svolto in gruppo , in cui 5 persone hanno

fatto la parte Angular e le altre 4 hanno fatto la parte backend Spring. Io mi sono occupato

della parte Spring insieme a Filippo Dentale, Corinne Dellisanti , Matteo Cecchini )

---



Viene commissionato al team, lo sviluppo di una web application atta a soddisfare
determinate esigenze gestionali e commerciali di un'Agenzia Immobiliare; nello specifico, il
software dovrà offrire le seguenti funzionalità:

1. Area di libera navigazione composta da:
   ◦ Home page con elenco di tutti gli immobili trattati dall'agenzia purchè
   disponibili alla vendita.
   ◦ Scheda di dettaglio immobile che offra, agli utenti, informazioni dettagliate su
   ciascun immobile disponibile oltre alla possibilità di inviare all'agenzia una
   richiesta di informazioni registrando contestualmente i propri dati personali
   con profilo “acquirente”.
2. Area gestionale accessibile, previo login, solo all'amministratore per le seguenti
   funzionalità:
   ◦ Visualizzazione tabellare di tutti gli immobili trattati dall'agenzia.
   ◦ Visualizzazione tabellare di tutte le richieste di informazioni ricevute.
   ◦ Registrazione di un nuovo immobile trattato con specificazione di tutte le
   caratteristiche e registrazione contestuale dell'anagrafica cliente con profilo
   “venditore”.
   ◦ Visualizzazione dettagliata di ciascun immobile trattato.
   ◦ Possibilità, per ciascun immobile, di modificarne lo stato da “disponibile” a
   “venduto” (processo non reversibile).
   ◦ Possibilità, per ciascuna richiesta ricevuta, di inviare una risposta testuale
   (simulazione) modificando lo stato della richiesta stessa da “da evadere” a
   “evasa” (processo non reversibile).

---

Il progetto deve essere sviluppato con architettura a servizi secondo il modello consumerprovider e pertanto composto da:
• Database MySql opportunamente relazionato.
• Applicativo provider realizzato mediante Spring Boot Project.
• Applicativo consumer realizzato mediante Angular Framework.
--------------------------------------------------------------

Requisiti minimi applicativo

1. Validazione dei dati in ingresso, per cui si ritiene necessaria, da eseguirsi sia lato
   front-end che lato back-end.
2. Protezione degli endpoint, per cui si ritiene necessaria, da eseguirsi mediante token
   autorizzativo.
3. Protezione della/e rotta/e dell'applicativo front-end riservate all'amministratore.

---

Ciascun immobile trattato, deve essere rappresentato dalle seguenti caratteristiche:
• Tipologia (ad esempio appartamento, casa indipendente, ecc.)
• Superficie espressa in mq
• Prezzo espresso in Euro
• Piano di Elevazione
• Condizioni tecniche (ad esempio buono/abitabile, ottimo/ristrutturato, ecc.)
• Descrizione testuale
• N°1 fotografia
• Stato (“disponibile” o “venduto”)
• Elenco di accessori (ad esempio ascensore, giardino, box auto, ecc.)
• Indirizzo immobile:
◦ via/piazza
◦ civico
◦ comune
◦ provincia
• Proprietario immobile (Cliente):
◦ nome
◦ cognome
◦ telefono
◦ mail
◦ ruolo (“venditore”)
Ciascuna richiesta, deve essere rappresentata dalle seguenti caratteristiche:
• Data di ricezione
• Messaggio testuale
• Stato (“da evadere” o “evasa”)
• Richiedente (Cliente):
◦ nome
◦ cognome
◦ telefono
◦ mail
◦ ruolo (“acquirente”)
• Immobile cui la richiesta è riferita
Non è prevista registrazione per l'amministratore che potrà pertanto procedere al login e
operare sulla base di credenziali predefinite e, pre-archiviate in un'apposita tabella del
database.
L'invio delle risposte alle richieste ricevute dai clienti, deve essere simulato senza
previsione di archiviazione ma con semplice modifica dello stato della richiesta stessa da
“da evadere” a “evasa”.
Nel momento in cui, lo stato di un immobile, viene modificato da “disponibile” a “venduto”,
tutte le eventuali richieste relative allo stesso, indipendentemente dal loro stato, devono
essere automaticamente cancellate dal database.Ciascun immobile trattato, deve essere rappresentato dalle seguenti caratteristiche:
• Tipologia (ad esempio appartamento, casa indipendente, ecc.)
• Superficie espressa in mq
• Prezzo espresso in Euro
• Piano di Elevazione
• Condizioni tecniche (ad esempio buono/abitabile, ottimo/ristrutturato, ecc.)
• Descrizione testuale
• N°1 fotografia
• Stato (“disponibile” o “venduto”)
• Elenco di accessori (ad esempio ascensore, giardino, box auto, ecc.)
• Indirizzo immobile:
◦ via/piazza
◦ civico
◦ comune
◦ provincia
• Proprietario immobile (Cliente):
◦ nome
◦ cognome
◦ telefono
◦ mail
◦ ruolo (“venditore”)
Ciascuna richiesta, deve essere rappresentata dalle seguenti caratteristiche:
• Data di ricezione
• Messaggio testuale
• Stato (“da evadere” o “evasa”)
• Richiedente (Cliente):
◦ nome
◦ cognome
◦ telefono
◦ mail
◦ ruolo (“acquirente”)
• Immobile cui la richiesta è riferita
Non è prevista registrazione per l'amministratore che potrà pertanto procedere al login e
operare sulla base di credenziali predefinite e, pre-archiviate in un'apposita tabella del
database.
L'invio delle risposte alle richieste ricevute dai clienti, deve essere simulato senza
previsione di archiviazione ma con semplice modifica dello stato della richiesta stessa da
“da evadere” a “evasa”.
Nel momento in cui, lo stato di un immobile, viene modificato da “disponibile” a “venduto”,
tutte le eventuali richieste relative allo stesso, indipendentemente dal loro stato, devono
essere automaticamente cancellate dal database.
