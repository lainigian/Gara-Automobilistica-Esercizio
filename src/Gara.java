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
	// Se non è possibile aggiungerlo perchè non vi è più spazio nella array viene sollevata un'eccezione 
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
	
	
	//Restituisce il partecipante con il codice specificato.
	//Se il partecipante non è presente nell'elenco viene sollevata una eccezione del tipo EccezionePartecipanteNonPresente
	public Partecipante getPartecipante(int codice) throws EccezionePartecipanteNonPresente
	{
		Partecipante p=null;
		for (int i = 0; i < NUM_MAX_PARTECIPANTI; i++) 
		{
			if (elencoPartecipanti[i]!=null)
			{
				if (elencoPartecipanti[i].getCodice()==codice)
				{
					p=new Partecipante(elencoPartecipanti[i]);
					return p;
				}
			}
		}
		
		throw new EccezionePartecipanteNonPresente("Il partecipante con codice "+codice+" non è presente nell'elenco");		
	}
	
	
	//Elimia il partecipante con il codice specificato.
	//Se il partecipante non è presente nell'elenco viene sollevata una eccezione del tipo EccezionePartecipanteNonPresente
	public void eliminaPartecipante(int codice) throws EccezionePartecipanteNonPresente
	{
		Partecipante p=null;
		for (int i = 0; i < NUM_MAX_PARTECIPANTI; i++) 
		{
			if (elencoPartecipanti[i]!=null)
			{
				if (elencoPartecipanti[i].getCodice()==codice)
				{
					elencoPartecipanti[i]=null;	//eliminazione del partecipante
					return;
				}
			}
		}
		
		throw new EccezionePartecipanteNonPresente("Il partecipante con codice "+codice+" non è presente nell'elenco");		
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
