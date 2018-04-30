package esercitazione_java_1;



public class ClusterSet {
	Cluster C[];
	int i = 0; //posizione valida per la memorizzazione di un nuovo cluster in CMetodi
	
	ClusterSet(int k){
		this.C = new Cluster[k];
	}
	//possibile eccezione se i >k
	void add(Cluster c) {
		this.C[i]=c;
		this.i++;
		
	}
	
	Cluster get(int i){
		return this.C[i];
	}
	
	void initializeCentroids(Data data){
		int centroidIndexes[]=data.sampling(C.length);
		for(int i=0;i<centroidIndexes.length;i++){
			Tuple centroidI=data.getItemSet(centroidIndexes[i]);
			add(new Cluster(centroidI));
		}
	}
	
	Cluster nearestCluster(Tuple tuple) {
		/*double x=0.0;
		int j=0;
		double min=get(j).getCentroid().getDistance(tuple);
		
		Cluster nearestCluster = get(j);
		j++;
		while(j<i) {
			if(get(j).getCentroid().getDistance(tuple)<=min) {
				min = get(j).getCentroid().getDistance(tuple);
				nearestCluster = get(j);
			}
			j++;
		}
		return nearestCluster;
		*/
		
		double dist = 0.0;
		double min_dist = tuple.getDistance(C[0].getCentroid());
		int pos_min = 0;
		for(int i =1; i<C.length;i++) {
			dist = tuple.getDistance(C[i].getCentroid());
			if (dist<min_dist) {
				min_dist = dist;
				pos_min = i;
			}
		}
		

		return C[pos_min];
				
	}
	
	Cluster currentCluster(int id) {
		for(int j=0;j<this.C.length;j++) {
			if(C[j].contain(id)==true) {
				return this.get(j);
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
