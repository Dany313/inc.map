package esercitazione_java_1;

public class Tuple {
	Item[] tuple;
	
	Tuple(int size){
		 this.tuple= new Item[size];
	}
	
	int getLength() {
		return this.tuple.length;
	}
	
	Item get(int i) {
		
		return this.tuple[i];
	}
	//possibile eccezione da gestire (i assegnato più grande dell'attuale size)
	void add(Item c,int i) {
		this.tuple[i]=c;
		
	}
	
	double getDistance(Tuple obj) {
		double x=0;
		for(int i = 0;i<obj.getLength();i++) {
			x+= this.get(i).distance(obj.get(i).getValue());
		}
		return x;
	}
	
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
