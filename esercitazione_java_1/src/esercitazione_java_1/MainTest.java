package esercitazione_java_1;

import java.util.*;

import data.Data;
import mining.KMeansMiner;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Data data =new Data();
		System.out.println(data);
		String esecuzione = new String ();
		esecuzione = "yes";
		
		while(esecuzione.equals("yes")) {
		
		System.out.println("\n\ninserire numero di cluster:");
		int k= input.nextInt();
		KMeansMiner kmeans=new KMeansMiner(k);

		int numIter=kmeans.kmeans(data);
		System.out.println("Numero di Iterazione:"+numIter);
		System.out.println(kmeans.getC().toString(data));
		/*System.out.println("per eseguire ancora inserire y altrimenti inserire n");
		esecuzione=input.nextLine();
		System.out.println(esecuzione);

		do {
			System.out.println("errore");
			System.out.println("per eseguire ancora inserire y altrimenti inserire n");
			esecuzione=input.nextLine();
		}
		while((esecuzione.equals("yes")==false) && (esecuzione.equals("no")==false));*/
		}
		
		
		input.close();
		
		
	}

}
