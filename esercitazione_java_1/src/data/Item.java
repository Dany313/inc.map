package data;

import utility.ArraySet;

public abstract class Item {
	
	Attribute attribute;  //attributo coinvolto nell'item
	Object value;         //valore assegnato all'attributo 
	
//Methods
	
	Item(Attribute attribute,Object value){
		
		this.attribute=attribute;
		this.value = value;
		
		
	}
	
	 Attribute getAttribute() {
		 return attribute;
	 }
	 
	 Object getValue(){
		 return value;
	 }
	 
	 public String toString(){
		 return String.valueOf(value);
	 }
	 
	 abstract double distance(Object a);
	 
	 //modifica il membro value,assegnandogli il valore reatituito da data.computePrototype(), fare in seguito
	 public void update(Data data,ArraySet clusteredData){
		 this.value=data.computePrototype(clusteredData, attribute);
	 }
	 
	 
}
