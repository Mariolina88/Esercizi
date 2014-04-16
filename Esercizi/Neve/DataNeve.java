package Neve;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ElaborateFile.TextIO;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class DataNeve {
	

	public static void main(String[] args) throws IOException {
		String inputFileName="/Users/marialaura/Desktop/dottorato/Neve/meteo_fin.csv";
		FileReader f=new FileReader(inputFileName);
		CSVReader reader = new CSVReader(f);
		
		String outputFileName="/Users/marialaura/Desktop/dottorato/Neve/output_prova.csv";
	    FileWriter newf= new FileWriter(outputFileName);
	    //CSVWriter writer = new CSVWriter(newf, '\n');
	    	    
		String [] nextLine;
		int cols=2616;
		int rows=4075;
		String [][] vls=new String [rows][cols];

			for(int i=0;i<rows;i++){
				nextLine = reader.readNext();
				for(int k=0;k<cols;k++){
	        	vls[i][k]=nextLine[k];
	        	//System.out.print(vls[i][k]+" ");
				}
				//System.out.println("");
			} 
	    
		
			reader.close();	

			TextIO.writeFile(outputFileName);

			//writes data
			for(int i=0;i<rows;i++){
				for(int j=0;j<2;j++){
					TextIO.putf(vls[i][j]+",");
				}
				TextIO.putf("\n");
			}
		}
		
	    
	}


