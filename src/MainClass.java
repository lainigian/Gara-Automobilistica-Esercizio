
public class MainClass {

	public static void main(String[] args)
	{
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
		
		Gara g1=new Gara();
		try 
		{
			g1.aggiungiPartecipante(p1);
			g1.aggiungiPartecipante(p2);
			g1.aggiungiPartecipante(p3);
			g1.aggiungiPartecipante(p4);
			g1.aggiungiPartecipante(p5);
			
			//verifico se superando i 100 posti si genera l'eccezione EccezionePostoEsauriti
			for (int i = 5; i < 100; i++) 
			{
				g1.aggiungiPartecipante(p1);
			}
		} 
		catch (EccezionePostiEsauriti e) 
		{
			System.out.println(e.toString());
		}

		
		System.out.println(g1.toString());
	
	}

}
