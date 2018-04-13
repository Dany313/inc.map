package esercitazione_java_1;

public class DiscreteAttribute extends Attribute {
	
	String values [];
	
	DiscreteAttribute(String name, int index, String values[]){
		super(name,index);
		
		
	}
	
	int getNumberOfDistinctValues() {
		
		return values.length;
	 
	}
	
	String getValue(int i) {
		return values[i];
	}
	
	int frequency(Data data, ArraySet idList,String v) {
		
		
	}
	

}
