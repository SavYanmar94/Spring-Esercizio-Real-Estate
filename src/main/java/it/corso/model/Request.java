package it.corso.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity // Indica che questa classe è una classe di entità gestita da JPA.
@Table(name = "requests")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // Identificatore univoco della richiesta.

	@Column(name = "reception_date")
	private LocalDate receptionDate; // Data di ricezione della richiesta.

	@Column(name = "text_message")
	private String textMessage; // Messaggio di testo associato alla richiesta.

	@Pattern(regexp = "[a-zA-Z0-9.\\sàèìòù']{1,30}", message = "Errore nel campo stato")
	@Column(name = "status")
	private String status; // Stato della richiesta, limitato a caratteri alfanumerici, spazi, punti e apostrofi.

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "requester_id", referencedColumnName = "id")
	private Customer customer; // Cliente che ha effettuato la richiesta, con relazione uno-a-uno.

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "property_id", referencedColumnName = "id")
	private Property property; // Proprietà associata alla richiesta, con relazione molti-a-uno.


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getReceptionDate() {
		return receptionDate;
	}

	public void setReceptionDate(LocalDate receptionDate) {
		this.receptionDate = receptionDate;
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
	

	
}
