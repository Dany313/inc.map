package data;

public abstract class Attribute {
	
	protected String name; //nome attributo
	protected int index;   //numero attributo
	
	

public Attribute(String name, int index){
	
	this.name = name;
	this.index = index;
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