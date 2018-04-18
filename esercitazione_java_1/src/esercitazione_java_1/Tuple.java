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
	
	double getDistance(tuple obj) {
		
	}
	
	double avgDistance(Data data , int clusteredData) {
		
	}

}
