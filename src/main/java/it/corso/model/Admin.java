package it.corso.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indica che questa classe è una classe di entità JPA e sarà mappata a una tabella del database.
@Table(name = "admins") // Specifica il nome della tabella del database a cui questa entità è mappata.
public class Admin
{
	@Id // Indica che questo campo è la chiave primaria dell'entità.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Specifica la strategia di generazione dell'identificatore, in questo caso, l'IDENTITY indica l'auto-incremento.
	private int id;
	
	@Column(name = "username") // Specifica il nome della colonna del database a cui è mappato questo campo.
	private String username;
	
	@Column(name = "password") // Specifica il nome della colonna del database a cui è mappato questo campo.
	private String password;
	
	@Column(name = "auth_token") // Specifica il nome della colonna del database a cui è mappato questo campo.
	private String authToken;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getAuthToken()
	{
		return authToken;
	}
	public void setAuthToken(String authToken)
	{
		this.authToken = authToken;
	}
}