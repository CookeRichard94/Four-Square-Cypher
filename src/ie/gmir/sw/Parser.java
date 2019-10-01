//Richard Cooke - G00331787
//Parser Class
//Parses Files and calls encrytpion and decryption methods

package ie.gmir.sw;

//imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;


public class Parser {
	
	//Declaring and initializing variables
	static long startTime;
	static long endTime;
	BufferedReader br = null;
	char a;
	char b;
	
    //Parse function
    public void parse() {
    	
    	//Variables
    	int choice2;
    	int choice;
    	int choice3;
    	String key = "";
    	String fileName = "";
    	
    	//Scanner
    	Scanner scanner = new Scanner(System.in);
    	
    	//prompt for user to either generate a new key or start with the preset key
    	System.out.println("Enter Menu option:");
   	 	System.out.println("Enter 1 to randomly generate a key:");
        System.out.println("Enter -1 to exit:");
        choice3=scanner.nextInt(); 
    	
    	while(choice3 != -1)
        {
    		//switch to control choice3 int
        	switch(choice3) {
        	case 1:
       		 System.out.println("Generate Key");
       		 
       		 //Calling the key() method
       		 key = new GenerateKey().key();
       		 
       		 //setting choice3 to -1 to exit the loop
       		 choice3 = -1;
       		 break;
        	default:
        		//reiteration of prompt for sentinel control
        		 System.out.println("Invalid option, please try again");
        		 System.out.println("Enter Menu option:");
            	 System.out.println("Enter 1 to randomly generate a key:");
                 System.out.println("Enter -1 to exit:");
                 choice3=scanner.nextInt();
        	}       	 
        }//while
    	
    	//Prompt for user to chose between parsing a file or URL
    	System.out.println("Enter Menu option:");
        System.out.println("Enter 1 to parse file:");
        System.out.println("Enter 2 to parse URL:");
        System.out.println("Enter -1 to exit:");
        choice2=scanner.nextInt(); 
    
	    while(choice2 != -1)
	    {
	    	//switch to control choice2 int
	    	switch(choice2) {
	    	case 1:
	    		//prompt for user to input fileName with options listed
	            System.out.println("Enter the name of the file:");
	            System.out.println("./Input/PoblachtNaHEireann.txt");
	            System.out.println("./Input/DeBelloGallico.txt");
	            System.out.println("./Input/WarAndPeace-LeoTolstoy.txt");
	            fileName = scanner.next();
	            
	            //calling parseFile() method with fileName as parameter
	            ParseFile(fileName);
	    		break;
	    	case 2:
	    		//prompt for user to input URL for parsing
	    		System.out.println("Enter the URL:");
	            fileName = scanner.next();
	            
	            //calling parseURL method with fileName as a parameter
	            parseURL(fileName);
	    		break;
	    	default:
	    		//reiteration of prompt for sentinel controlled while loop
	            System.out.println("Invalid option, please try again:");
	            System.out.println("Enter Menu option:");
	            System.out.println("Enter 1 to parse file:");
	            System.out.println("Enter 2 to parse URL:");
	            System.out.println("Enter -1 to exit:");
	            choice2=scanner.nextInt();
	    		
	    	}//while
	    	
	    	//if statement that runs if choice2 is = to either 1 or 2
	    	if(choice2 == 1|| choice2 ==2)
		    {
		    
	    		//to determine if br is = parseFile
		    	if(choice2 ==1)
		    	{
		    		br = ParseFile(fileName);
		    	}
		    	//to determine if br = parseURL
		    	if(choice2 ==2)
		    	{
		    		br = parseURL(fileName);
		    	}
		    	
		    	//Starting the clock for timing encryption
				startTime = System.currentTimeMillis();
				
				try {
					
					//Initializing printwriter for encryption.txt file
					PrintWriter Writer = new PrintWriter(new FileWriter("./Ouput/Encryption.txt"));
					
					String line;
					
					String output;
					
					//While loop to read through the file line by line
					while ((line=br.readLine()) != null) {
						
						//Removing everything from the file that is not the fiel A-Z and then
						//replacing all instances of J with I
						line = line.toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
						
						//if statement to append an X to the end of a line if it is not divisible by 2
						if(line.length() % 2 !=0)
						{
							line += "X";
						}
						
						//for loop to iterate through the line of the file and disect into bigrams
						for(int i=0; i< line.length();i+=2)
						{
							
							a = line.charAt(i);
							b = line.charAt(i+1);
							
							//calling the encryption mthod with a, b and key as paramters
							output = new Cipher().encryption(a,b, key);
							
							//writing output to encryption.txt
							Writer.print(output);
							
							//System.out.print(output);
						}
						//printing line to encryption.txt to start new line
						Writer.println();
						//System.out.println();

					}//while
					
					//ending clock for time on encryption method
					endTime = System.currentTimeMillis();
					
					//determing the time taken for the encryption method
					long timeTaken = endTime - startTime;
					
					//outputting the time taken to the console
					System.out.println("Encryption Took : " + timeTaken + " ms");
					
					//closing files
					br.close();
					Writer.close();
					
				}catch (IOException e) {
					e.printStackTrace();
				}
				
				//prompt for user if they want to decrypt file
				System.out.println("Would you like to decrypt the file");
				System.out.println("Enter 1 to decrypt");
				System.out.println("Enter -1 to exit");
				choice=scanner.nextInt();
				while(choice!= -1)
				{
					//switch to control choice int
					switch(choice) {
					case 1:
						//starting clock on decryption method
						startTime = System.currentTimeMillis();

						try {
							//bufferedReader to read in the encryption.txt file
							BufferedReader br = new BufferedReader(new FileReader("./Ouput/Encryption.txt"));
							
							//Writer to write out to the Decryption.txt file
							PrintWriter Writer = new PrintWriter(new FileWriter("./Ouput/Decryption.txt"));
							
							String line;
							
							String output;
							
							//while loop to read through the encryption.txt file
							while ((line=br.readLine()) != null) {
								// for loop to iterate through the file and disect it into bigrams
								for(int i=0; i< line.length();i+=2)
								{
									
									a = line.charAt(i);
									b = line.charAt(i+1);
									
									//calling decryption method with a,b and key as paramters
									output = new Cipher().decryption(a,b, key);
									
									//writing output to decryption file
									Writer.print(output);
									
								//System.out.print(output);
								}
								Writer.println();
								//System.out.println();

							}//while
							
							//ending the clock on the decryption method
							endTime = System.currentTimeMillis();
							
							//calculating the time taken for decryption method
							long timeTaken = endTime - startTime;
							
							//outputting the time taken to the console
							System.out.println("Decryption Took : " + timeTaken + " ms");
							
							//closing files
							br.close();
							Writer.close();
								
							
						}catch(IOException e) {
							e.printStackTrace();
						}
						
						//setting choice to -1 to break the loop
						choice = -1;
						break;
						default:
							//reiteration of prompt for sentinel controlled loop
							System.out.println("Invalid option, please try again");
							System.out.println("Would you like to decrypt the file");
							System.out.println("Enter 1 to decrypt");
							System.out.println("Enter -1 to exit");
							choice=scanner.nextInt();
					}
				}

	    }//if
	    }//while
    
}
	//ParseFile function
    //Runs at O(1) constant tiem
	public BufferedReader ParseFile(String fileName) {	
		try {
			 br = new BufferedReader(new FileReader(fileName));
					
		}catch (IOException e) {
			e.printStackTrace();
		}		
		return br;	
	}
	
	//ParseURL function
	//runs at O(1) constant time
	public BufferedReader parseURL(String fileName) {
		try {
			URL url = new URL(fileName);
			br = new BufferedReader(new InputStreamReader(url.openStream()));
																				
		} catch (IOException e) {

		} 
		return br;
	}

}
