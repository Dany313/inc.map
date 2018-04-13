package esercitazione_java_1;

class Data {
		private Object data [][];
		private int numberOfExamples;
		private Attribute attributeSet[];
		
		
		private Data(){
			
			
			 data = new Object[14][5];
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
			
			attributeSet = new Attribute[5];

			
			String outLookValues[]=new String[3];
			outLookValues[0]="overcast";
			outLookValues[1]="rain";
			outLookValues[2]="sunny";
			attributeSet[0] = new DiscreteAttribute("Outlook",0, outLookValues);
			
			String temperatureValues[]= new String[3];
			temperatureValues[0]="hot";
			temperatureValues[1]="mild";
			temperatureValues[2]="cool";
			attributeSet[1] = new DiscreteAttribute("Temperature",1,temperatureValues);
			
			String humidityValues[] = new String[2];
			humidityValues[0]="high";
			humidityValues[1]="normal";
			attributeSet[2] = new DiscreteAttribute("Humidity",2,humidityValues);
			
			String windValues[] = new String[2];
			windValues[0]="weak";
			windValues[1]="strong";
			attributeSet[3] = new DiscreteAttribute("Wind",3,windValues);
			
			String playtennisValues[] = new String [2];
			playtennisValues[0]="yes";
			playtennisValues[1]="no";
			attributeSet[4] = new DiscreteAttribute("PlayTennis",4,playtennisValues);
			
			
		}
		
		private int getNumberOfExamples(){
			return numberOfExamples;
		}
		
		private int getNumberOfAttributes(){
			return attributeSet.length;
		}
		
		
		
		private Object getAttributeValue(int exampleIndex, int attributeIndex){
			return data[exampleIndex][attributeIndex];
		}
		
		private Attribute getAttribute(int index){
			return attributeSet[index];
		}
		
		
		public String toString(){
			String s= new String();
			for(int j=0;j<getNumberOfAttributes();j++) {
				s += getAttribute(j);
				s+=",";
			}
			for(int i=0;i<getNumberOfExamples();i++) {
				s+="\n";
				s+=(i+1)+":";
				for(int z=0;z<getNumberOfAttributes();z++) {
					s+= getAttributeValue(i,z)+",";
				}
			}
			
			return s;
			
			
			
			
		}


		
		public static void main(String args[]){
			Data trainingSet=new Data();
			System.out.println(trainingSet);

			
			
		}

	}
