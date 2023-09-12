package it.corso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity // Indica che questa classe è una classe di entità gestita da JPA.
@Table(name = "property_addresses") // Specifica il nome della tabella nel database.

public class Propertyaddress {

	@Id // Indica che questo campo è l'identificatore primario per l'entità.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Specifica la strategia di generazione dell'ID automatico.
	private int id; // Identificatore univoco dell'indirizzo della proprietà.

	@Pattern(regexp = "[a-zA-Z0-9\\sàèìòù'.]{1,50}", message = "Errore nel campo strada")
	@Column(name = "street") // Specifica il nome della colonna nel database.
	private String street; // Nome della strada dell'indirizzo della proprietà.

	@Pattern(regexp = "[a-zA-Z0-9/_-]{1,20}", message = "Errore nel campo civico")
	@Column(name = "civic") // Specifica il nome della colonna nel database.
	private String civic; // Numero civico dell'indirizzo della proprietà.

	@Pattern(regexp = "[a-zA-Z0-9\\sàèìòù'.]{1,50}", message = "Errore nel campo città")
	@Column(name = "town") // Specifica il nome della colonna nel database.
	private String town; // Città dell'indirizzo della proprietà.

	@Pattern(regexp = "[a-zA-Z]{2}", message = "Provincia non valida")
	@Column(name = "province") // Specifica il nome della colonna nel database.
	private String province; // Provincia dell'indirizzo della proprietà.
		public int getId()
		{
			return id;
		}
		public void setId(int id)
		{
			this.id = id;
		}
		public String getStreet()
		{
			return street;
		}
		public void setStreet(String street)
		{
			this.street = street;
		}
		public String getCivic()
		{
			return civic;
		}
		public void setCivic(String civic)
		{
			this.civic = civic;
		}

		public String getTown()
		{
			return town;
		}
		public void setTown(String town)
		{
			this.town = town;
		}
		public String getProvince()
		{
			return province;
		}
		public void setProvince(String province)
		{
			this.province = province;
		}
	}

