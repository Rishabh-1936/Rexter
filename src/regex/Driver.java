package regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Driver{
	
	public static void printMenu() {
	
		System.out.println("a. Social Security Number");
		System.out.println("b. US Phone number");
		System.out.println("c. E-mail address");
		System.out.println("d. Name on a class roster");
		System.out.println("e. Date in MM-DD-YYYY format");
		System.out.println("f. House address - Street number, street name, abbreviation for road, street, boulevard or avenue");
		System.out.println("g. City followed by state followed by zip as it should appear on a letter");
		System.out.println("h. Military time, including seconds");
		System.out.println("i. US Currency down to the penny");
		System.out.println("j. URL, including http:// (upper and lower case should be accepted)");
		System.out.println("k. Password (contains at least 10 characters and 1 uppercase, lowercase character, digit, punctuation mark, and not more than 3 consecutive lowercase characters)");
		System.out.println("l. All words containing an odd number of alphabetic characters, ending in 'ion'");
		System.out.println("q. Quit");
		System.out.println("--------------------------------------------------------");
		System.out.println("Enter the choice (a-l and q for quit) :");
	
	}
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		Regex rg = new Regex();
		String input = "", data = "", choice = "";
		
		System.out.println("Choose the input option (1/2):");
		System.out.println("1. Input");
		System.out.println("2. File Input");
		String inputChoice = sc.nextLine();
		
		if(inputChoice.equals("1")) 
		{
			do 
			{
				printMenu();
				input = sc.nextLine();
				
				if(input.equals("q")) {
					System.exit(0);
				}
				
				System.out.println("Enter the data:");
				data = sc.nextLine();

				if(!rg.check(input, data)) {
					
					System.out.println("");
					System.out.println("*****************");
					System.out.println("Invalid Format!!!");
					System.out.println("*****************");
					System.out.println("");
					
					choice="y";
					continue;
				}
				
				System.out.println("Do you want more operations (Y/N)?");
				choice = sc.nextLine();
				
			}while(choice.equalsIgnoreCase("y"));
			
		}
		else 
		{
			System.out.println("Enter the file path:");
			String fileName = sc.nextLine();
			
			File file = new File(fileName);
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String textFileData = "";
			while (((textFileData = br.readLine()) != null)) 
			{
				String[] tokens = textFileData.split(" ");
				
				if(tokens.length == 1) 
				{
					input = tokens[0];
					
					if(input.equals("q")) {
						System.out.println("File Read Successfully");
						br.close();
						System.exit(0);
					}
					else {
						// it means newLine character is encountered
						data = br.readLine();
						
						if(!rg.check(input, data)) {
							System.out.println("");
							System.out.println("*****************");
							System.out.println("Invalid Format!!!");
							System.out.println("*****************");
							System.out.println("");	
							continue;
						}
					}
				}
				else 
				{
					// format is : option space data
					for(int idx = 1; idx < tokens.length; ++idx) {
						data += tokens[idx];
					}
					if(!rg.check(input, data)) {
						System.out.println("");
						System.out.println("*****************");
						System.out.println("Invalid Format!!!");
						System.out.println("*****************");
						System.out.println("");	
						continue;
					}	
				}
			}
			System.out.println("File Read Successfully");
			br.close();
		}
		sc.close();
	}
}