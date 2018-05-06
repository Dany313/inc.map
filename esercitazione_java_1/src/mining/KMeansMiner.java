package mining;

import data.Data;
import data.OutOfRangeSampleSize;
import mining.ClusterSet;

public class KMeansMiner {
	
	ClusterSet C;
	
	public KMeansMiner(int k){
		  this.C= new ClusterSet(k);
	}
	
	public ClusterSet getC() {
		return this.C;
	}
	
	public int kmeans(Data data)throws OutOfRangeSampleSize{
		int numberOfIterations=0;
//STEP 1// scelta casuale centroide per ogni cluster
		C.initializeCentroids(data);
		boolean changedCluster=false;
		do{
		numberOfIterations++;
		//STEP 2 //Assegnazione di ciascuna riga della matrice in data al cluster avente centroide più vicino all'esempio.
		changedCluster=false;
		for(int i=0;i<data.getNumberOfExamples();i++){
		Cluster nearestCluster = C.nearestCluster(
		data.getItemSet(i));
		Cluster oldCluster=C.currentCluster(i);
		boolean currentChange=nearestCluster.addData(i);
		if(currentChange)
		changedCluster=true;
		//rimuovo la tupla dal vecchio cluster
		if(currentChange && oldCluster!=null)
		//il nodo va rimosso dal suo vecchio cluster
		oldCluster.removeTuple(i);
		}
		//STEP 3 //Calcolo dei nuovi centroidi per ciascun cluster
		C.updateCentroids(data);
		}
		while(changedCluster);
		return numberOfIterations;
		//Ripete i passi 2 e 3. finché due iterazioni consecuitive non restituiscono  centroidi uguali .

		}


}
