
public class Tempo 
{
//Attributi
	private int ore;
	private int minuti;
	private int secondi;

	public Tempo(int ore, int minuti, int secondi) throws EccezioneDatiNonValidi
	{
		setOre(ore);
		setMinuti(minuti);
		setSecondi(secondi);
	}
	
	public Tempo(Tempo t) throws EccezioneDatiNonValidi
	{
		setOre(t.getOre());
		setMinuti(t.getMinuti());
		setSecondi(t.getSecondi());
	}
	
/*	public Tempo()
	{
		setOre(0);
		setMinuti(0);
		setSecondi(0);
	}
*/	
	public int getOre()
	{
		return ore;
	}
	
	//se parametro è al di fuori dei limiti previsti (0-23) viene sollevata una eccezione di tipo 
	//EccezioneDatiNonValidi
	public void setOre(int ore) throws EccezioneDatiNonValidi
	{
		if (ore<0 || ore >23)
			throw new EccezioneDatiNonValidi("Ore non valide");
		else
			this.ore = ore;
	}
	public int getMinuti() 
	{
		return minuti;
	}
	
	//se parametro minuti è al di fuori dei limiti previsti (0-59) viene sollevata una eccezione di tipo 
	//EccezioneDatiNonValidi
	public void setMinuti(int minuti) throws EccezioneDatiNonValidi 
	{
		if (minuti<0 || minuti>59)
			throw new EccezioneDatiNonValidi("Minuti inseriti non validi");
		else
			this.minuti = minuti;
	}
	public int getSecondi() 
	{
		
		return secondi;
	}
	
	//se parametro secondi è al di fuori dei limiti previsti (0-59) viene sollevata una eccezione di tipo 
	//EccezioneDatiNonValidi
	public void setSecondi(int secondi) throws EccezioneDatiNonValidi
	{
		
		if (secondi<0 || secondi>59)
			throw new EccezioneDatiNonValidi("Secondi inseriti non validi");
		else
			this.secondi=secondi;
	}
	
	private int tuttoInSecondi(Tempo t)
	{
		return (t.getOre()*3600+t.getMinuti()*60+t.getSecondi());
	}
	
	public int compareTo(Tempo t)
	{
		int thisSecondi=tuttoInSecondi(this);
		int tSecondi=tuttoInSecondi(t);
		if (thisSecondi==tSecondi)
			return 0;
		else if (tSecondi>thisSecondi)
			return 1;
		else
			return-1;
	}
	
	public String toString()
	{
		return(getOre()+":"+getMinuti()+":"+getSecondi());
	}
}
