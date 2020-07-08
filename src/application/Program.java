package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter with path and source file: ");
		String srtPath = sc.nextLine();
		
		File sourceFile = new File(srtPath);
		String sourceFolderStr = sourceFile.getParent();
				
		boolean success = new File(sourceFolderStr + "\\out").mkdir();
		String srtPathDest = sourceFolderStr + "\\out\\summary.csv";
				
		try (BufferedReader br = new BufferedReader(new FileReader(srtPath))) {
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");			
				
				list.add(new Product(fields[0], 
						   Double.parseDouble(fields[1]), 
						   Integer.parseInt(fields[2])));
								
				System.out.println(line);
				line = br.readLine();
			}			
		}catch(IOException e ) {
			System.out.println("Error: " + e.getMessage());			
		}		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(srtPathDest))){
			
			for (Product item : list) {
				bw.write(item.getName() + "," + String.format("%.2f", item.totalValue()));
				bw.newLine();
			}			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		sc.close();
	}

}
