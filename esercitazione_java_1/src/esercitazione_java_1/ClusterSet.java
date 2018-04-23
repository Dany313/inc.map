package esercitazione_java_1;

public class ClusterSet {
	
	Cluster C[];
	int i= 0;
	
	ClusterSet(int k){
		C= new Cluster[k];
	}
	
	void add(Cluster c) {
		C[i]=c;
		i++;
	}
	
	Cluster get(int i) {
		return C[i];
	}
	
	void inizializeCentroids(Data data) {
		int centroidIndexes[] = data.sampling(C.length);  //prende array di centroidi da data
		for(int i=0; i<centroidIndexes.length;i++) {      
			Tuple centroidI = data.getItemSet(centroidIndexes[i]); //per ogni centroide viene creata una tupla
			add(new Cluster(centroidI));     //la tupla viene assegnata ad un cluster che a sua volta è memorizzato ne clusterset (C)
		}
		
	}
	
	Cluster nearestCluster(Tuple tuple) {
		// fare getDistance in tuple
		
	}
	
	Cluster currentCluster(int id) {
		for(int i=0;i<C.length;i++) {
			if(C[i].contain(id)) {
				return C[i];
			}
		}
		return null;
	}
	
	void updateCentroids(Data data) {
		
	}

	public String toString() {
		
	String a = new String();
	a += data.sampling(C.length);
	
	return a;
	}
}


