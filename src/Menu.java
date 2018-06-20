/**
 * Classe che consente di realizzzare un menu
 */

import java.io.IOException;

public class Menu 
{
	
	private String[] elencoVoci;
	private int numeroVoci;
	private String titolo;
	
/**
 * Costruttore
 * @param titolo del menu
 * @param elenco Arrai di stringhe in cui ogni elemento dell'array rappresenta una voce del menu.
 * Ogni elemento dell'arrray deve iniziare con il numero corrispondente alla posizione della voce nell' elenco.
 * Esempio:
 * 0-->Esci (Esci è la voce in posizione 0)
 * 1-->Visualizza (Visualizza è la voce in posizione 1)
 * 2-->Aggiungi (Aggiungi è la voce in posizione 1)
 * .....
 */
	public Menu(String titolo,String elenco[])
	{
		numeroVoci=elenco.length;
		this.titolo=titolo;
		elencoVoci=new String[numeroVoci];
		for (int i = 0; i < numeroVoci; i++)
		{
			elencoVoci[i]=elenco[i];
		}
	}
	
	/**
	 * Metodo che visualizza le voci del menu
	 */
	public void visualizza()
	{
		for (int i = 0; i < numeroVoci; i++) 
		{
			System.out.println(elencoVoci[i]);
		}
	}

	/**
	 * Metodo che restituisce il numero inserito dall'utente
	 * Tale numero deve corrispondere alla posizione della voce del menu scelta dall'utente
	 * @return posizione della voce scelta. Esempio:
	 * 0--> Se l'utente inserisce 0
	 * 1--> Se l'utente inserisce 1
	 * .....
	 */
	public int scelta()
	{
		int voceScelta=-1;
		ConsoleInput tastiera= new ConsoleInput();
		
		do
		{
			System.out.println("MENU "+titolo);
			visualizza();
			System.out.println("Scegli voce:");
			try 
			{
				voceScelta=tastiera.readInt();
				if (voceScelta<0||voceScelta>=numeroVoci)
					System.out.println("Scelta non consentita. Ripetere la scelta");
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("Formato non corretto. Ripetere la scelta.");
			} 
			catch (IOException e) 
			{
				System.out.println("Impossibile leggere dal dispositivo di input.");
			}
		} while (voceScelta<0 || voceScelta>=numeroVoci);
		
		return voceScelta;

		
		
		
	}
	
	
}
