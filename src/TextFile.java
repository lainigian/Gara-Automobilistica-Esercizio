/**
 * Classe che consente di scrivere\leggere delle stringhe su\da un file di testo
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile 
{

	private char mode;
	private BufferedReader reader;
	private BufferedWriter writer;

/**
 * Costruttore
 * @param fileName pathname del file di testo su cui si vuole scrivere o dal quale si vuoole leggere 
 * @param mode  'R' per aprire il file in lettura, 'W' per aprire il file in scrittura
 * @throws IOException Eccezione sollevata nel caso non sia possibile accedere al file
 */
	public TextFile(String fileName, char mode) throws IOException
	{
		this.mode='R';
		if (mode=='W'|| mode=='w')
		{
			this.mode='W';
			writer=new BufferedWriter(new FileWriter(fileName));
		}
		else
			reader=new BufferedReader(new FileReader(fileName));
		
	}
	
	/**
	 * Metodo che consente di scrivere una stringa sul file
	 * @param line stringa da scrivere sul file
	 * @throws EccezioneFile Eccezione sollevata nel caso in cui si tenti di scrivere su un file aperto in lettura
	 * @throws IOException  Eccezione sollevata nel caso non sia possibile accedere al file
	 */
	public void toFile(String line) throws EccezioneFile, IOException
	{
		
		if (mode=='R')
			throw new EccezioneFile("File aperto in lettura");
		
		writer.write(line);
		writer.newLine();
	}
	
	/**
	 * Metodi per leggere una stringa da un file. La lettura avviene una stringa alla volta, 
	 * ogni volta che viene invocato questo metodo si legge una riga del file di testo e il 
	 * lettore si "sposta" sulla riga successiva.
	 * Quando non ci sono più righe da leggere viene sollevata una eccezione del tipo EccezioneTextFileEOF
	 * @return una stringa contenente la riga letta dal file
	 * @throws EccezioneFile Eccezione sollevata nel caso si tenti di leggere da un file aperto in scrittura
	 * @throws IOException Eccezione sollevata nel caso in cui non sia possibile accedere al file
	 * @throws EccezioneTextFileEOF Eccezione sollevata quando non ci sono più dati da leggere sul file
	 */
	public String fromFile() throws EccezioneFile, IOException, EccezioneTextFileEOF
	{
		String line;
		
		if (mode=='W')
			throw new EccezioneFile("File aperto in scrittura");
		
		line=reader.readLine();
		
		if (line==null)
			throw new EccezioneTextFileEOF();
		
		return line;
	}
	
	/**
	 * Metodo per chiudere un file al termine delle operazioni di lettura\scrittura
	 * @throws IOException
	 */
	public void closeFile() throws IOException
	{
		if (mode=='R')
			reader.close();
		else
			writer.close();
	}
	
}
