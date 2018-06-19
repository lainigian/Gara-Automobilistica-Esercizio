
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
	
		
/*		System.out.println(t1.compareTo(t2));
		System.out.println(t2.compareTo(t1));
		System.out.println(t2.compareTo(t2));
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		System.out.println(t3.toString());
		System.out.println(t4.toString());
		System.out.println(t5.toString());
*/
//---------------------Test partecipante------------------------------
		Partecipante p1=new Partecipante(1,"Bruno", "Fiat", "Punto", t1);
		Partecipante p2=new Partecipante(2,"Antonio", "Renault", "Clio", t2);
		Partecipante p3=new Partecipante(3,"Liccio", "Fiat", "128", t3);
		Partecipante p4=new Partecipante(3,"Siani", "Peugeut", "205", t4);
		Partecipante p5=new Partecipante(5,"Lillo", "Fiat", "Fiorino", t5);
		Partecipante p6=new Partecipante(p5);
		
		
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		System.out.println(p4.toString());		
		System.out.println(p5.toString());
		System.out.println(p6.toString());
	
	}

}
