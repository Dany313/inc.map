package esercitazione_java_1;

public class DiscreteItem extends Item {
	
	DiscreteItem(DiscreteAttribute attribute , String value){
		super(attribute,value);
		//value=String.valueOf(this.value);
		
	}
	
	double distance(Object a) {
		if(getValue().equals(a)) {
			return 0;
		}else {
			return 1;
		}
	}

}
