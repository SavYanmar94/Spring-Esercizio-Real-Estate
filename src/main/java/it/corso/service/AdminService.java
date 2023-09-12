package it.corso.service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Admin;

public interface AdminService {

	//metodo admin login
	ObjectNode adminLogin(Admin admin);
	
	//metodo admin logout
	ObjectNode adminLogout(String token);
}
