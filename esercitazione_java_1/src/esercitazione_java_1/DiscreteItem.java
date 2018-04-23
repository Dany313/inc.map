package esercitazione_java_1;

public class DiscreteItem extends Item {
	
	DiscreteItem(Attribute attributeSet , String value){
		super(attributeSet,value);
	
		
	}
	
	public double distance(Object a) {
		if(getValue().equals(a)) {
			return 0;
		}else {
			return 1;
		}
	}

}
