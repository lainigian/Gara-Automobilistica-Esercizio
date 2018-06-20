import java.io.IOException;

public class MainClass 
{

	public static void main(String[] args)
	{

		Gara g1= new Gara();
		//Deserializzazione
		String nomeFileBinario="Gara.bin";
		try 
		{
			g1=g1.caricaGara(nomeFileBinario);
		} 
		catch (IOException e1) 
		{
			System.out.println("Non è possibile caricare i dati dal file "+nomeFileBinario);
		}
		
		//creo le voci del menu
		String[] elencoVociMenu1= {"0-->Esci","1-->Aggiungi un partecipante",
				"2-->Visualizza dati di un partecipante","3-->Elimina un partecipante","4-->Visualizza partecipanti con una specifica marca di auto",
				"5-->Visualizza partecipanti in ordine alfabetico","6-->Visualizza la classifica",
				"7-->Stampa su file di testo l'elenco dei partecipanti in ordine alfabetico", };
		
		//creo il menu
		Menu menu1=new Menu("MENU SOFTWARE GARA AUTOMOBILISTICA", elencoVociMenu1);
		ConsoleInput tastiera=new ConsoleInput();
		//invoco il metodo che consente all'utente di scegliere una voce del menu
		int scelta=1;
		
		//Gestione del menu
		
		while (scelta!=0)
		{
			scelta=menu1.scelta();
			switch (scelta) 
			{
			case 0:
				System.out.println("L'applicazione verrà terminata");
				break;

			case 1: //Inserimento nuovo partecipante
				int codice = 0;
				String nome = null, marca = null,modello = null;
				int ore = 0,minuti = 0,secondi = 0;
				
				try 
				{
					System.out.println("Inserisci il codice");
					codice=tastiera.readInt();
					System.out.println("Inserisci il nome");
					nome=tastiera.readString();
					System.out.println("Inserisci la marca dell' automobile");
					marca=tastiera.readString();
					System.out.println("Inserisci il modello dell'automobile");
					modello=tastiera.readString();
					System.out.println("Inserisci il tempo impiegato in ore, minuti e secondi, ore (max 10):");
					ore=tastiera.readInt();
					System.out.println("minuti:");
					minuti=tastiera.readInt();
					System.out.println("secondi:");
					secondi=tastiera.readInt();
				} 
				catch (NumberFormatException e) 
				{
					System.out.println("Dato inserito non corretto");
				} 
				catch (IOException e) 
				{
					System.out.println("Impossibile leggere da tastiera");
				}
				//Istanzio il nuovo partecipante
				
				try 
				{
					Partecipante p=new Partecipante(codice,nome, marca,modello,new Tempo(ore,minuti,secondi));
					g1.aggiungiPartecipante(p);
					g1.salvaGara(nomeFileBinario);  //Serializzazione
				} 
				catch (EccezioneDatiNonValidi e) 
				{
					System.out.println(e.toString());
				} 
				catch (EccezionePostiEsauriti e) 
				{
					System.out.println(e.toString());
				} 
				catch (IOException e) 
				{
					System.out.println("Non è stato possibile salvare la modifica sul file "+nomeFileBinario);
				}
				break;
				
			case 2: //Visualizzazione di un partecipante
				System.out.println("Inserisci il codice del partecipante da visualizzare");
				int codiceCercato = 0;
				try
				{
					codiceCercato=tastiera.readInt();
				} 
				catch (NumberFormatException e) 
				{
					System.out.println("Dato inserito non corretto");
				} 
				catch (IOException e) 
				{
					System.out.println("Impossibile leggere da tastiera");
				}
				
				Partecipante partecipanteCercato;
				try 
				{
					partecipanteCercato=g1.getPartecipante(codiceCercato);
					System.out.println(partecipanteCercato.toString());
				} 
				catch (EccezionePartecipanteNonPresente e) 
				{
					System.out.println(e.toString());
				}
				
				break;	
			
			case 3: //Eliminazione di un partecipante
				System.out.println("Inserisci il codice del partecipante da eliminare");
				codiceCercato = 0;
				try
				{
					codiceCercato=tastiera.readInt();
				} 
				catch (NumberFormatException e) 
				{
					System.out.println("Dato inserito non corretto");
				} 
				catch (IOException e) 
				{
					System.out.println("Impossibile leggere da tastiera");
				}
				
				try 
				{
					g1.eliminaPartecipante(codiceCercato);
					System.out.println("Partecipante con codice "+codiceCercato+ " eliminato con successo");
					g1.salvaGara(nomeFileBinario);
				} 
				catch (EccezionePartecipanteNonPresente e) 
				{
					System.out.println(e.toString());
				} 
				catch (IOException e) 
				{
					System.out.println("Non è stato possibile salvare la modifica sul file "+nomeFileBinario);
				}
				
				break;	
			
				
			case 4://Visualizza partecipanti con una determinata auto
				
				String marcaAutoCercata = null;
				System.out.println("Inserisci la marca dell' automobile");
				try 
				{
					marcaAutoCercata=tastiera.readString();
				} 
				catch (NumberFormatException e) 
				{
					System.out.println("Dato inserito non corretto");
				} 
				catch (IOException e) 
				{
					System.out.println("Impossibile leggere da tastiera");
				}
				
				System.out.println(g1.elencoPartecipantiAuto(marcaAutoCercata));
				
				break;	
				
			case 5: //Visualizza partecipanti in ordine alfabetico
				Partecipante[] elenco=null;
				elenco=g1.ordineAlfabetico();
				for (int i = 0; i < elenco.length; i++) 
				{
					System.out.println(elenco[i].toString());
				}
				if (elenco.length==0)
				{
					System.out.println("Nessun partecipante presente");
				}
				break;
				
			case 6: //Visualizza classifica
				elenco=null;
				elenco=g1.ordineTempoCrescente();
				for (int i = 0; i < elenco.length; i++) 
				{
					System.out.println(elenco[i].toString());
				}
				if (elenco.length==0)
				{
					System.out.println("Nessun partecipante presente");
				}
				break;
				
			case 7: //Stampa su file
				String nomeFile="ElencoPartecipanti.txt";
				try 
				{
					g1.stampaSuFile(nomeFile);
					System.out.println("Scrittura sul file "+nomeFile+" avvenuta correttamente.");
				} 
				catch (IOException e) 
				{
					System.out.println("Impossibile scrivere sul file "+nomeFile);
				} 
				catch (EccezioneFile e) 
				{
					System.out.println(e.toString());
				}
				break;
			default:
				break;
			}
			
		}
		
	
		
		
		
		
		
/*		
//------------------Debug classe Tempo------------------------------------------
		Tempo t1 = null;
		Tempo t2 = null;
		Tempo t3 = null;
		Tempo t4 = null;
		Tempo t5 = null;
		try 
		{
			t1 = new Tempo(2,20,44);
			t2=new Tempo(1,0,4);
			t3=new Tempo(2,0,4);
			t4=new Tempo(2,10,4);
			t5=new Tempo(8,9,7);
		} 
		catch (EccezioneDatiNonValidi e) 
		{
			System.out.println(e.toString());
		}
	

//---------------------Debug partecipante------------------------------
		Partecipante p1=new Partecipante(1,"Bruno", "Fiat", "Punto", t1);
		Partecipante p2=new Partecipante(2,"Antonio", "Renault", "Clio", t2);
		Partecipante p3=new Partecipante(3,"Liccio", "Fiat", "128", t3);
		Partecipante p4=new Partecipante(4,"Siani", "Peugeut", "205", t4);
		Partecipante p5=new Partecipante(5,"Lillo", "Fiat", "Fiorino", t5);
	
		
//----------------------Debug gara------------------------------------------
		//debug aggiungiPartecipante
		Gara g1=new Gara();
		try 
		{
			g1.aggiungiPartecipante(p1);
			g1.aggiungiPartecipante(p2);
			g1.aggiungiPartecipante(p3);
			g1.aggiungiPartecipante(p4);
			g1.aggiungiPartecipante(p5);
			
		} 
		catch (EccezionePostiEsauriti e) 
		{
			System.out.println(e.toString());
		}
		
	
		//debug ordine Alfabetico
		Partecipante[] elencoAlfabetico;
		elencoAlfabetico=g1.ordineAlfabetico();
		for (int i = 0; i < elencoAlfabetico.length; i++) 
		{
			System.out.println(elencoAlfabetico[i].toString());
		}
		
		//debug classifica
		Partecipante[] elencoClassifica;
		elencoClassifica=g1.ordineTempoCrescente();
		for (int i = 0; i < elencoAlfabetico.length; i++) 
		{
			System.out.println(elencoClassifica[i].toString());
		}
		
		//Debug stampa su file
		try 
		{
			g1.stampaSuFile("ElencoPartecipanti.txt");
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (EccezioneFile e) 
		{
			System.out.println(e.toString());
		}
		
		//Debug serializzazione/deserializzazione
		
		try
		{
			g1.salvaGara("Gara.bin");
		} catch (IOException e) 
		{
			System.out.println("Impossibile salvare sul file Gara.bin");
		}
		
		Gara g2=new Gara();
		try 
		{
			g2=g2.caricaGara("Gara.bin");
		} 
		catch (IOException e) 
		{
			System.out.println("Impossibile caricare i dati dal file Gara.bin");
		}
		
		System.out.println(g2.toString());
		
		
*/		
	}

}






