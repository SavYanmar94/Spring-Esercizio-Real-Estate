package it.corso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity // Indica che questa classe è una classe di entità JPA e sarà mappata a una tabella del database.
@Table(name = "customers") // Specifica il nome della tabella del database a cui questa entità è mappata.
public class Customer {

	@Id // Indica che questo campo è la chiave primaria dell'entità.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Specifica la strategia di generazione dell'identificatore, in questo caso, l'IDENTITY indica l'auto-incremento.
	private int id;
	
	// Il seguente pattern verifica che il campo "name" contenga solo caratteri alfabetici, spazi e apostrofi.
		// {1,50} specifica che la lunghezza deve essere compresa tra 1 e 50 caratteri.
		@Pattern(regexp = "[a-zA-Z\\sàèìòù']{1,50}", message = "Errore nel campo nome")
		@Column(name = "name")
		private String name;
		
		// Il seguente pattern verifica che il campo "lastname" contenga solo caratteri alfabetici, spazi e apostrofi.
		// {1,50} specifica che la lunghezza deve essere compresa tra 1 e 50 caratteri.
		@Pattern(regexp = "[a-zA-Z\\sàèìòù']{1,50}", message = "Errore nel campo cognome")
		@Column(name = "lastname")
		private String lastname;
		
		// Il seguente pattern verifica che il campo "phone" contenga un numero di telefono valido, con una lunghezza compresa tra 10 e 20 caratteri.
		@Pattern(regexp = "^[0-9\\s+.]{10,20}$", message = "Errore nel campo telefono")
		@Column(name = "phone")
		private String phone;
		
		// Il seguente pattern verifica che il campo "email" contenga un indirizzo email valido.
		@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Errore nel campo email")
		@Column(name = "email")
		private String email;
		
		// Il seguente pattern verifica che il campo "role" contenga solo caratteri alfabetici, spazi e apostrofi.
		// {1,30} specifica che la lunghezza deve essere compresa tra 1 e 30 caratteri.
		@Column(name = "role")
		@Pattern(regexp = "[a-zA-Z\\sàèìòù']{1,30}", message = "Errore nel campo ruolo")
		private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
