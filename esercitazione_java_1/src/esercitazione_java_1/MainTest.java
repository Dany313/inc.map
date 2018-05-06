package esercitazione_java_1;

import java.util.*;

import data.Data;
import data.OutOfRangeSampleSize;
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
		try {
		
		KMeansMiner kmeans=new KMeansMiner(k);

		int numIter=kmeans.kmeans(data);
		System.out.println("Numero di Iterazione:"+numIter);
		System.out.println(kmeans.getC().toString(data));
		}
		catch(OutOfRangeSampleSize e){
			System.out.println("valore di k non valido");;
			
		}
			System.out.println("per eseguire ancora inserire yes altrimenti inserire no");
			esecuzione=input.next();
			while((esecuzione.equals("yes")==false) && (esecuzione.equals("no")==false)) {
				System.out.println("errore\n");
				System.out.println("per eseguire ancora inserire yes altrimenti inserire no");
				esecuzione=input.next();
			}
			
		
			
		}
		
		
		input.close();
		
		
	}

}
