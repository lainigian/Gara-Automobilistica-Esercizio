import java.io.Serializable;

public class Partecipante implements Serializable
{
	//Attributi
	private int codice;
	private String nome;
	private String marca;
	private String modello;
	private Tempo tempoImpiegato;
	
	
	public Partecipante(int codice, String nome, String marca, String modello, Tempo tempoImpiegato)
	{

		setCodice(codice);
		setNome(nome);
		setMarca(marca);
		setModello(modello);
		setTempoImpiegato(tempoImpiegato);	
	}
	
	public Partecipante (Partecipante p)
	{
		setCodice(p.getCodice());
		setNome(p.getNome());
		setMarca(p.getMarca());
		setModello(p.getModello());
		setTempoImpiegato(p.getTempoImpiegato());
	}
	
	
	public int getCodice() 
	{
		return codice;
	}
	private void setCodice(int codice) 
	{
		this.codice = codice;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getMarca() 
	{
		return marca;
	}
	public void setMarca(String marca) 
	{
		this.marca = marca;
	}
	public String getModello() 
	{
		return modello;
	}
	public void setModello(String modello) 
	{
		this.modello = modello;
	}
	public Tempo getTempoImpiegato() 
	{
		Tempo tempoImpiegato= null;
		try 
		{
			tempoImpiegato=new Tempo(this.tempoImpiegato);
		} 
		catch (EccezioneDatiNonValidi e) 
		{
			
		}
		return tempoImpiegato;
	}
	public void setTempoImpiegato(Tempo tempoImpiegato) 
	{
		try 
		{
			this.tempoImpiegato = new Tempo(tempoImpiegato);
		} 
		catch (EccezioneDatiNonValidi e) 
		{
			
		}
	}
	
	public void stampaSuFileOrdineAlfabetico()
	{
		
	}
	
	public String toString()
	{
		return (getCodice()+" "+getNome()+" "+getMarca()+" "+getModello()+" Tempo:"+getTempoImpiegato().toString());
	}
	

	
}
