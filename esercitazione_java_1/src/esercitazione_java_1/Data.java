package esercitazione_java_1;

import java.util.Random;



class Data {
	// Le visibilità di classi , attributi e metodi devono essere decise dagli studenti	
		private Object data[][];
		private int numberOfExamples;
		private Attribute attributeSet[];
		
		
		Data(){
			attributeSet = new Attribute[5];

			
			
			String outLookValues[]=new String[3];
			outLookValues[0]="overcast";
			outLookValues[1]="rain";
			outLookValues[2]="sunny";
			attributeSet[0] = new DiscreteAttribute("Outlook",0, outLookValues);
			
			String TemperatureValues[]=new String[3];
			TemperatureValues[0]="Hot";
			TemperatureValues[1]="Mild";
			TemperatureValues[2]="Cool";
			attributeSet[1] = new DiscreteAttribute("Temperature",1, TemperatureValues);
			
			String HumidityValues[]=new String[2];
			HumidityValues[0]="High";
			HumidityValues[1]="Normal";
			attributeSet[2] = new DiscreteAttribute("Humidity",2, HumidityValues);
			
			String WindValues[]=new String[2];
			WindValues[0]="Weak";
			WindValues[1]="Strong";
			attributeSet[3] = new DiscreteAttribute("Wind",3,  WindValues);
			
			String PlayValues[]=new String[2];
			PlayValues[0]="Yes";
			PlayValues[1]="No";
			attributeSet[4] = new DiscreteAttribute("PlayTennis",4,  PlayValues);	
			
			this.data = new Object[14][5];
			data[0][0]="sunny";
			data[0][1]="hot";
			data[0][2]="high";
			data[0][3]="weak";
			data[0][4]="no";
			
			data[1][0]="sunny";
			data[1][1]="hot";
			data[1][2]="high";
			data[1][3]="strong";
			data[1][4]="no";
			
			data[2][0]="overcast";
			data[2][1]="hot";
			data[2][2]="high";
			data[2][3]="weak";
			data[2][4]="yes";
			
			data[3][0]="rain";
			data[3][1]="mild";
			data[3][2]="high";
			data[3][3]="weak";
			data[3][4]="yes";
			
			data[4][0]="rain";
			data[4][1]="cool";
			data[4][2]="normal";
			data[4][3]="weak";
			data[4][4]="yes";
			
			data[5][0]="rain";
			data[5][1]="cool";
		    data[5][2]="normal";
		    data[5][3]="strong";
		    data[5][4]="no";
		    
		    data[6][0]="overcast";
		    data[6][1]="cool";
		    data[6][2]="normal";
		    data[6][3]="strong";
		    data[6][4]="yes";
		    
		    data[7][0]="sunny";
		    data[7][1]="mild";
		    data[7][2]="high";
		    data[7][3]="weak";
		    data[7][4]="no";
		    
		    data[8][0]="sunny";
		    data[8][1]="cool";
		    data[8][2]="normal";
		    data[8][3]="Weak";
		    data[8][4]="yes";
		    
		    data[9][0]="rain";
		    data[9][1]="mild";
		    data[9][2]="normal";
		    data[9][3]="weak";
		    data[9][4]="yes";
		    
		    data[10][0]="sunny";
		    data[10][1]="mild";
		    data[10][2]="normal";
		    data[10][3]="strong";
		    data[10][4]="yes";
	        
		    data[11][0]="overcast";
		    data[11][1]="mild";
		    data[11][2]="high";
		    data[11][3]="strong";
		    data[11][4]="yes";
		    
		    data[12][0]="overcast";
		    data[12][1]="hot";
		    data[12][2]="normal";
		    data[12][3]="weak";
		    data[12][4]="yes";
		    
		    data[13][0]="rain";
		    data[13][1]="mild";
		    data[13][2]="high";
		    data[13][3]="strong";
		    data[13][4]="no";
			
	
	                   
	                
	                 
	          
	
				// numberOfExamples
				
				 numberOfExamples=14;		 
				 
				
				//explanatory Set
				
	
	
				
			
		}
		
		int getNumberOfExamples(){
			return numberOfExamples;
		}
		
		int getNumberOfAttributes(){
			return attributeSet.length;
		}
		
		Attribute[] getAttributeSchema(){
			return attributeSet;
		}
		
		Object getAttributeValue(int exampleIndex, int attributeIndex){
			return data[exampleIndex][attributeIndex];
		}
		
		Attribute getAttribute(int index){
			return attributeSet[index];
		}
		
	
		public String toString(){
			String  s= new String();
			for(int i=0;i<this.getNumberOfAttributes();i++) {
				s +=this.attributeSet[i].toString();
				s +=",";
				
			}
			//metodo con for
			for(int i=0,j=0;i<getNumberOfExamples();i++,j++) { //fixato i che partiva da 1
                s+="\n";
                s+=(i+1)+":"; //fixato la virgola con i 2 punti come lo richiede la traccia
                			  //fixata anche la successione dei numeri che si fermava al 13
                for(int z=0;z<getNumberOfAttributes();z++) {
                    s+= getAttributeValue(j,z)+",";
                }
			}
			//metodo con for each
			/*
			s+="\n";
			int i=1;
			for(Object[] x:data) {
				s+=i+":";
				i++;
				for(Object elem:x) {
					s+=elem+",";
				}
				s+="\n";
			}
			*/
			return s;
		}
		
		Tuple getItemSet(int index){
			Tuple tuple=new Tuple(attributeSet.length);
			for(int i=0;i<attributeSet.length;i++)
				tuple.add(new DiscreteItem((DiscreteAttribute)attributeSet[i],(String)data[index][i]),i); //fatto downcast
			return tuple;
			}
		
		int[] sampling(int k){
			int centroidIndexes[]=new int[k];
			//choose k random different centroids in data.
			Random rand=new Random();
			rand.setSeed(System.currentTimeMillis());
			for (int i=0;i<k;i++){
				boolean found=false;
				int c;
			do
			{
			found=false;
			c=rand.nextInt(getNumberOfExamples());
			// verify that centroid[c] is not equal to a centroide already stored in CentroidIndexes
			for(int j=0;j<i;j++)
			if(compare(centroidIndexes[j],c)){
			found=true;
			break;
			}
			}
			while(found);
			centroidIndexes[i]=c;
			}
			return centroidIndexes;
		}
		
		 private boolean compare(int i,int j){
			boolean flag = false;
			for(int k=0;k<getNumberOfAttributes();k++) {
				if (getAttributeValue(i,k).equals(getAttributeValue(j,k)))
						flag = true;
				else {
					    flag = false;
				        k=getNumberOfAttributes();
				        }
			}
			return flag;
		}
		 
		 Object computePrototype(ArraySet idList,Attribute attribute){
			 return computePrototype(idList,(DiscreteAttribute)attribute);
			 
		 }
		 
		 String computePrototype(ArraySet idList,DiscreteAttribute attribute){
			 /*String value = new String();
			 int max=0;
			 int f=0;
			 for(int i = 0; i< attribute.getNumberOfDistinctValues();i++) {
				 f =	attribute.frequency(this,idList,attribute.getValue(i));
				  if(f>=max) {
					  value=attribute.getValue(i);
					  max = f;
				  }
				 
			 }
			 
			 
			 
			 return value;*/
			 int f = 0;
			 int fmax = 0;
			 int imax = 0;
			 for(int i =0; i<attribute.getNumberOfDistinctValues();i++) {
				 f = attribute.frequency(this, idList, attribute.getValue(i));
				 if(f>fmax) {
					 fmax=f;
					 imax=i;
				 }
			 }
			 return attribute.getValue(imax);
			 
			 
		 }
		 
		
		
}
