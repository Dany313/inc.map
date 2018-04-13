package esercitazione_java_1;

public class ContinousAttribute extends Attribute {
	
	double max;
	double min;
	
	ContinousAttribute(String name,int index,double min, double max){
		
		super (name,index);
		this.min=min;
		this.max=max;
		
		
	}
	
	double getScaledValue(double v) {
		double x;
		x = (v-min)/(v-max);
		return x;
		
	}
	  

}
