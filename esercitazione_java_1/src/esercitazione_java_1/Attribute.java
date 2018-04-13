package esercitazione_java_1;

public abstract class Attribute {
	String name;
	int index;
	
	protected Attribute(String n,int index){
		index=0;
		name=n;
		
	}
	
	 String getName() {
		return name;
	}
	
	int getIndex() {
		return index;
	}
	
	public String toString() {
		return name;
	}

}
