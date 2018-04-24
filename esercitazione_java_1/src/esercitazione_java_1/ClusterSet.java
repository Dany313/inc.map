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
	
	void initializeCentroids(Data data) {
		int centroidIndexes[] = data.sampling(C.length);  //prende array di centroidi da data
		for(int i=0; i<centroidIndexes.length;i++) {      
			Tuple centroidI = data.getItemSet(centroidIndexes[i]); //per ogni centroide viene creata una tupla
			add(new Cluster(centroidI));     //la tupla viene assegnata ad un cluster che a sua volta è memorizzato ne clusterset (C)
		}
		
	}
	
	Cluster nearestCluster(Tuple tuple) {
		double x=0;
		Tuple t = new Tuple(tuple.getLength());
		int i=0;
		double min=tuple.getDistance(tuple)-t.getDistance(C[i].getCentroid());
		
		Cluster m = new Cluster(tuple);
		
		for(i=1;i<tuple.getLength();i++) {
			x=tuple.getDistance(tuple)-t.getDistance(C[i].getCentroid());
			if(x<=min) {
				min=x;
				m=get(i);
			}
		}
		
		return m;
		
		
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
		for(int i=0;i<C.length;i++) {
			C[i].computeCentroid(data);
		}
		
		
	}

	public String toString() {
		
	String a = new String();
	for(int i=0;i<C.length;i++) {
		a +=C[i].getCentroid();
	}
	
	return a;
	}
	//restituisce una stringa che descrive lo stato di ciascun cluster
	public String toString(Data data) {
		String str="";
		for(int i=0;i<C.length;i++){
		if (C[i]!=null){
		str+=i+":"+C[i].toString(data)+"\n";
		}
		}
		return str;

		
	}
}


