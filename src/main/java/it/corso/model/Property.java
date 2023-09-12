package it.corso.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity // Indica che questa classe è una classe di entità gestita da JPA.
@Table(name = "properties") // Specifica il nome della tabella nel database.

public class Property {

	@Id // Indica che questo campo è l'identificatore primario per l'entità.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifica la strategia di generazione dell'ID automatico.
    private int id; // Identificatore univoco della proprietà immobiliare.

	@Pattern(regexp = "[a-zA-Z0-9.\\sàèìòù']{1,50}", message = "Errore nel campo tipo di proprietà")
    @Column(name = "property_type") // Specifica il nome della colonna nel database.
    private String propertyType; // Tipo di proprietà immobiliare.

    @Column(name = "area") // Specifica il nome della colonna nel database.
    private double area; // Area della proprietà immobiliare.

    @Column(name = "price") // Specifica il nome della colonna nel database.
    private double price; // Prezzo della proprietà immobiliare.

    @Column(name = "floor_level") // Specifica il nome della colonna nel database.
    private int floorLevel; // Livello dell'edificio in cui si trova la proprietà.

    @Pattern(regexp = "[a-zA-Z0-9.\\sàèìòù']{1,30}", message = "Errore nel campo condizioni tecniche")
    @Column(name = "technical_conditions") // Specifica il nome della colonna nel database.
    private String technicalConditions; // Condizioni tecniche della proprietà.

    @Column(name = "description") // Specifica il nome della colonna nel database.
    private String description; // Descrizione della proprietà.

    @Column(name = "photo") // Specifica il nome della colonna nel database.
    private String photo; // Foto della proprietà.

    @Pattern(regexp = "[a-zA-Z0-9.\\sàèìòù']{1,30}", message = "Errore nel campo stato")
    @Column(name = "status") // Specifica il nome della colonna nel database.
    private String status; // Stato della proprietà.

    @Column(name = "accessories") // Specifica il nome della colonna nel database.
    private String accessories; // Accessori associati alla proprietà.

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id") // Specifica la colonna di join nel database.
    private Propertyaddress address; // Indirizzo della proprietà.

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id") // Specifica la colonna di join nel database.
    private Customer customer; // Cliente associato alla proprietà.

    @JsonIgnore // Indica di non serializzare questo campo in JSON.( per evitare di fare i DTO ) 
    @OneToMany(
    		// Indica che la proprietà "requests" nell'entità "Property" è mappata come parte proprietaria della relazione.
    		// In altre parole, la colonna "property" nella tabella delle richieste ("Request") fa riferimento a questa relazione.
    		mappedBy = "property",

    		// Specifica che quando si eseguono operazioni di aggiornamento sull'entità "Property", 
    		// le stesse operazioni verranno eseguite in cascata sulle entità correlate "Request".
    		cascade = CascadeType.REFRESH,

    		// Definisce il tipo di recupero delle associazioni tra entità. In questo caso, "FetchType.EAGER" 
    		// indica il caricamento anticipato, il che significa che le entità correlate verranno caricate 
    		// immediatamente quando si recupera un'istanza di "Property".
    		fetch = FetchType.EAGER,

    		// Quando impostato su "true", abilita la rimozione automatica delle entità correlate 
    		// se vengono rimosse dalla collezione dell'entità genitore. Ad esempio, se una "Request" 
    		// non è più associata a una "Property", verrà rimossa dal database quando si rimuove la relazione.
    		orphanRemoval = true
	)
    
    private List<Request> requests; // Elenco delle richieste associate alla proprietà.
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getFloorLevel() {
		return floorLevel;
	}

	public void setFloorLevel(int floorLevel) {
		this.floorLevel = floorLevel;
	}

	public String getTechnicalConditions() {
		return technicalConditions;
	}

	public void setTechnicalConditions(String technicalConditions) {
		this.technicalConditions = technicalConditions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccessories() {
		return accessories;
	}

	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}


	public Propertyaddress getAddress() {
		return address;
	}

	public void setAddress(Propertyaddress address) {
		this.address = address;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

    
 
	
}
