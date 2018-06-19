public class Gara 
{
	//Attributi
	private Partecipante[] elencoPartecipanti;
	private final int NUM_MAX_PARTECIPANTI=100;
	
	
	public Gara()
	{
		elencoPartecipanti=new Partecipante[NUM_MAX_PARTECIPANTI];
	}
	
	// aggiunge un partecipante nel primo "posto libero" dell'array.
	// Se non � possibile aggiungerlo perch� non vi � pi� spazio nella array viene sollevata un'eccezione 
	// del tipo EccezionePostiEsauriti.
	public void aggiungiPartecipante(Partecipante partecipante) throws EccezionePostiEsauriti
	{
		for (int i = 0; i < NUM_MAX_PARTECIPANTI; i++) 
		{
			if (elencoPartecipanti[i]==null)
			{
				elencoPartecipanti[i]=new Partecipante(partecipante);
				return;
			}
			
		}
		throw new EccezionePostiEsauriti ("Tutti i posti per la partecipazione alla gara sono occupati");
	}
	
	// Crea una stringa contenente tutti i partecipanti inseriti
	public String toString()
	{
		String risultato="";
		for (int i = 0; i < NUM_MAX_PARTECIPANTI; i++) 
		{
			if (elencoPartecipanti[i]!=null)
			{
				risultato+=elencoPartecipanti[i].toString()+"\n";
			}
		}
		return risultato;
	}
	
}