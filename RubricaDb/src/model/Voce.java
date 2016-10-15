package model;

public class Voce {
	private String nome;
	private String cognome;
	private String telefono;
	private int id_Rubrica;
	private int id_Voce;
	
	public Voce() {


	}

	public Voce(int id_Voce,String nome, String cognome, String telefono, int id_Rubrica) {
		super();
		this.id_Voce=id_Voce;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.id_Rubrica=id_Rubrica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getId_Rubrica() {
		return id_Rubrica;
	}

	public void setId_Rubrica(int id_Rubrica) {
		this.id_Rubrica = id_Rubrica;
	}

	public int getId_Voce() {
		return id_Voce;
	}

	public void setId_Voce(int id_Voce) {
		this.id_Voce = id_Voce;
	}
	
	
	
	
	
	
	
}
