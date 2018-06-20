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
	
	
	//Elimina il partecipante con il codice specificato.
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
	
	
	//Restituisce una stringa che contiene codice e nome dei partecipanti con una determinata marca di auto passata come paraemtro
	public String elencoPartecipantiAuto (String marca)
	{
		String risultato="";
		for (int i = 0; i < NUM_MAX_PARTECIPANTI; i++) 
		{
			if (elencoPartecipanti[i]!=null)
			{
				if (elencoPartecipanti[i].getMarca().compareToIgnoreCase(marca)==0)
				{
					risultato+=elencoPartecipanti[i].getCodice()+" "+elencoPartecipanti[i].getNome()+ "\n";
				}
				
			}
		}
		if (risultato.compareTo("")==0)
			risultato="Nessun partecipante con auto "+marca;
		return risultato;
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
	
	
	/**
	 * Metodo privato che scambia fra loro due interi di un'array di oggetti della classe Partecipante
	 * @param array	Array su cui effettuare lo scambio
	 * @param pos1	posizione del primo elemento da scambiare
	 * @param pos2	posizione del secondo elemento da scambiare
	 */
	private static void scambia (Partecipante[] array, int pos1, int pos2)
	{
		Partecipante s=array[pos1];
		array[pos1]=array[pos2];
		array[pos2]=s;
	}
	
	/**
	 * Metodo  che ordina una array di Partecipante in ordine alfabetico in base al nome (A-Z) utilizzando l'algoritmo 
	 * Selection Sort. L'algoritmo non è Case sansitive, quindi ordina indipndentemente dal fatto che una nome
	 * contenga lettere minuscole o maiuscole.
	 * @return Altro array di Partecipante con i valori ordinati alfabeticamente (A-Z)
	 */
	public  Partecipante[] ordineAlfabetico()
	{
		
		//creo una array di partecipanti, chiamata risultato, in cui siano presenti tutti i partecipanti
		//senza "posti vuoti". Poi ordinerò l'array risultato
		
		int c=0; //contatore per costruire l'array da ordinare
		int numeroPartecipanti=numeroPartecipanti();  //numeroPartecipanti è un metodo che "conta" quanti partecipanti sono presenti nell'elenco
		Partecipante[] risultato=new Partecipante[numeroPartecipanti]; 
		
		for (int i = 0; i < NUM_MAX_PARTECIPANTI; i++) 
		{
			if (elencoPartecipanti[i]!=null)
			{
				risultato[c]=new Partecipante(elencoPartecipanti[i]);
				c++;
			}		
		}
		
		for (int i = 0; i < risultato.length-1; i++) 
		{
			for (int j = i+1; j < risultato.length; j++) 
			{
				if (risultato[i].getNome().compareToIgnoreCase(risultato[j].getNome())>0)
					scambia(risultato,i,j);
			}
		}
		return risultato;
	}
	
	/**
	 * Metodo  che ordina una array di Partecipante in ordine crescente in base al tempo impiegato utilizzando l'algoritmo 
	 * Selection Sort.
	 * @return Altro array di Partecipante con i valori ordinati alfabeticamente (A-Z)
	 */
	public  Partecipante[] ordineTempoCrescente()
	{
		
		//creo una array di partecipanti, chiamata risultato, in cui siano presenti tutti i partecipanti
		//senza "posti vuoti". Poi ordinerò l'array risultato
		
		int c=0; //contatore per costruire l'array da ordinare
		int numeroPartecipanti=numeroPartecipanti();  //numeroPartecipanti è un metodo che "conta" quanti partecipanti sono presenti nell'elenco
		Partecipante[] risultato=new Partecipante[numeroPartecipanti]; 
		
		for (int i = 0; i < NUM_MAX_PARTECIPANTI; i++) 
		{
			if (elencoPartecipanti[i]!=null)
			{
				risultato[c]=new Partecipante(elencoPartecipanti[i]);
				c++;
			}		
		}
		
		for (int i = 0; i < risultato.length-1; i++) 
		{
			for (int j = i+1; j < risultato.length; j++) 
			{
				if (risultato[i].getTempoImpiegato().compareTo(risultato[j].getTempoImpiegato())<0)
					scambia(risultato,i,j);
			}
		}
		return risultato;
	}
	
	
	//Restituisce il numero di partecipanti presenti nell'elenco
	public int numeroPartecipanti()
	{
		int contatore=0;
		for (int i = 0; i < NUM_MAX_PARTECIPANTI; i++) 
		{
			if (elencoPartecipanti[i]!=null)
				contatore++;
		}
		return contatore;
	}
	
	
}
