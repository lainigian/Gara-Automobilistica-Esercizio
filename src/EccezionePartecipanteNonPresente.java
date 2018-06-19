
public class EccezionePartecipanteNonPresente extends Exception 
{

	private String messaggio;
	
	public EccezionePartecipanteNonPresente(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
}
