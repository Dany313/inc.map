package esercitazione_java_1;

public class Tuple {
	
	Item[] tuple;
	
	Tuple (int size){
		 tuple= new Item[size];
	}
	
	int getLength() {
		return tuple.length;
	}
	
	Item get(int i) {
		return tuple[i];
	}
	
	void add(Item c , int i) {
		tuple[i]=c;
	}
	
//	double getDistance(tuple obj) {
		//return 
		
	//}
	
	double avgDistance(Data data, int clusteredData[]){
			double p=0.0,sumD=0.0;
			for(int i=0;i<clusteredData.length;i++){
			double d= getDistance(data.getItemSet(clusteredData[i]));
			sumD+=d;
			}
			p=sumD/clusteredData.length;
			return p;
	}
}


