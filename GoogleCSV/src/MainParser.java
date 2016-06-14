import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class MainParser {
	
	public static void main(String[] args) throws IOException{
		
		String csvFilename = "/Users/jayati.singhal/Downloads/latLongList.xlsx";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		String[] row = null;
		while((row = csvReader.readNext()) != null) {
		    System.out.println(row[0]);
		           //   + " # " + row[1];
		            //  + " #  " + row[2]);
		}
		csvReader.close();
		
		
	}

}
