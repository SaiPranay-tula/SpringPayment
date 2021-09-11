package com.payment.web.custom;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class SDNList {
	static List<String> names= new ArrayList<>();
	public static String[] parsing() throws FileNotFoundException, IOException, CsvValidationException {
		

		 try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Administrator\\Desktop\\Pa.txt"))) {
		      String[] lineInArray;
		      int i=0; 
		      while ((lineInArray = reader.readNext()) != null) {
		          names.add(lineInArray[0]+lineInArray[1].replace("; ", "") );
		      }
		      
		  return lineInArray;

	}
	}
	public static boolean Search(String name) throws CsvValidationException, FileNotFoundException, IOException {
		parsing();
		//System.out.println(names);
		for(String Mnames:names)
	{
			if(Mnames.matches(name)) {
				return true;
			}
	}
		return false;
	}
		
	
		
	
	
}

