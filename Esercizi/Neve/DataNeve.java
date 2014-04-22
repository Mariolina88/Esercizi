package Neve;

import java.io.FileReader;
import java.io.IOException;

import ElaborateFile.TextIO;
import au.com.bytecode.opencsv.CSVReader;
// TODO: Auto-generated Javadoc
/**
 * gets a dataframe from a csv file.  
 * @author Marialaura Bancheri
 */

public class DataNeve {
	

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		/**
		 * The file to be read
		 */
		
		String path;
		System.out.println("Please enter the path of the input file: ");
		path = TextIO.getlnString();
		String fileName;
		System.out.println("Please enter the name of the input file: ");
		fileName = TextIO.getlnString();
		String inputFileName=path+fileName;
		System.out.println("Check the entire input path:"+inputFileName);
		
		//String inputFileName="/Users/marialaura/Desktop/dottorato/Neve/meteo_fin.csv";
		FileReader f=new FileReader(inputFileName);
		CSVReader reader = new CSVReader(f);
		
		/**
		 * This first part is necessary to obtain the dimensions of the csv file
		 * dataRow is the single string of the file read by the CSVReader 
		 * cols and rows are the dimensions of the dataframe
		 * vls is the matrix of cols*rows dimensions in which will be stored 
		 * the values of the dataframe 
		 * 
		 */
	    
		String[] dataRow = reader.readNext();
		int rows=0;
		int cols=dataRow.length;;
		while (dataRow != null){
	          rows++;
	          dataRow = reader.readNext();
	        }
		reader.close();
		
		/**
		 * In this second part we must apply again the class CSVreader
		 * in order to read again the csv file from the first line
		 * vls is the matrix of cols*rows dimensions in which will be stored 
		 * the values of the dataframe 
		 * 
		 */
		
		
		FileReader fnew=new FileReader(inputFileName);
		CSVReader readernew = new CSVReader(fnew);
		
		String [][] vls=new String [rows][cols];
		String [] nextLine;
			for(int i=0;i<rows;i++){
				nextLine = readernew.readNext();
				for(int k=0;k<cols;k++){
	        	vls[i][k]=nextLine[k];
	        	//System.out.print(vls[i][k]+" ");
				}
				//System.out.println("");
			} 

			reader.close();
			
			/**
			 * write the Data frame to a specified file (outputFileName)
			 * in a specified format (in this case a csv file)
			 * 
			 */
			
			String outputName;
			System.out.println("Please enter the name of the output file: ");
			outputName = TextIO.getlnString();
			String outputFileName=path+outputName;
			System.out.println("Check the entire output path:"+outputFileName);
			//String outputFileName="/Users/marialaura/Desktop/dottorato/Neve/output_prova.csv";
			TextIO.writeFile(outputFileName);
			
			String typeSeparator;
			System.out.println("Please enter the type of Separator:");
			typeSeparator = TextIO.getlnString();
			

			for(int i=0;i<rows;i++){
				for(int j=0;j<2;j++){
					TextIO.putf(vls[i][j]+typeSeparator);
				}
				TextIO.putf("\n");
			}
		}    
	}


