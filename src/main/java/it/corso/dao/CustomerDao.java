package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Customer;
//Questa è un'interfaccia per l'accesso ai dati dei clienti (Customer) nel database.
//Estende CrudRepository, che fornisce metodi per le operazioni CRUD (Create, Read, Update, Delete).

//Nota: In questa interfaccia non sono stati aggiunti metodi personalizzati.
//Ciò è dovuto al fatto che l'interfaccia estende CrudRepository, che già fornisce
//i metodi standard per l'accesso ai dati. Se fossero necessari metodi personalizzati,
//potrebbero essere aggiunti qui.
public interface CustomerDao extends CrudRepository<Customer, Integer> {
 // Non sono stati aggiunti metodi personalizzati in questa interfaccia
}