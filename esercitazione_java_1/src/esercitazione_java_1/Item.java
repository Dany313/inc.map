package esercitazione_java_1;

public abstract class Item {
	Attribute attribute;
	Object value;
	
	Item(Attribute attribute , Object value){
		this.attribute=attribute;
		this.value=value;
	}
	
	void update(Data data , ArraySet clusteredData) {
		
	}
	
	Attribute getAttribute() {
		return attribute;
	}
	
	Object getValue() {
		return value;
	}
	
	public String toString() {
		return String.valueOf(value);
	}
	
	abstract double distance(Object a) {
		
	}

}
