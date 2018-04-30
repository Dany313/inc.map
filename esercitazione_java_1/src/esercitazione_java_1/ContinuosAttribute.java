package esercitazione_1;

public class ContinuosAttribute extends Attribute {
	

	double max;  //estremi del dominio
	double min;

ContinuosAttribute(String name,int index,double min,double max){
	
	super(name,index);
	this.min = min;
	this.max = max;
	
}

double getScaledValue(double v) {
	
	return (v-min)/(max-min);
}



}