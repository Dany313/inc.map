package data;

import utility.ArraySet;

public class DiscreteAttribute extends Attribute {
	
	private String values[]; //oggetti corrispondenti ai valori del dominio discreto
	
	

	
DiscreteAttribute(String name,int index,String values[]){
	super(name,index);
	this.values = values;

}
int getNumberOfDistinctValues(){
	
	return this.values.length;
}

String getValue(int i) {
	
	 return this.values[i];
}

//metodi es2

 public int frequency(Data data,ArraySet idList,String v) {
	
	/*int frequency = 0;
	
	for(int i = 0;i< data.getNumberOfExamples();i++) {
		for (int j = 0; j <data.getNumberOfAttributes();j++) {
			if (v.equals(data.getAttributeValue(i, j))){
				idList.add(i);
				frequency ++;
				}
			}
	}
	


	return frequency;*/
	int [] vettIndex = idList.toArray();
	int f = 0;
	for (int i = 0; i<vettIndex.length;i++) {
		if(data.getAttributeValue(vettIndex[i],this.getIndex()).equals(v)) {
			f++;
		}
	}
	
	return f;
}


}


