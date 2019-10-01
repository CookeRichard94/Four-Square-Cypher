//Richard Cooke - G00331787
//Menu Class
//Runs a menu that will call the Parse class

package ie.gmir.sw;

//imports
import java.util.Scanner;

public class Menu {
	public void go(){

		//Scanner
        Scanner scanner = new Scanner(System.in);
        
        //variables
        int choice2;
        
        //Prompt for user to begin encryption/decryption process
        System.out.println("Enter Menu option:");
        System.out.println("Enter 1 to Begin:");
        System.out.println("Enter -1 exit:");
        choice2=scanner.nextInt();
        
        while(choice2!= -1)
        {
        	//switch to control choice2 int
        	switch(choice2) {
        	case 1:
        		//calling the parse() method
        		new Parser().parse();
        		break;
        	default:
        		System.out.println("Invalid option, please try again");
        	}
        	
        	//reiterating loop via sentinel
        	System.out.println("Enter Menu option:");
            System.out.println("Enter 1 to Begin:");
            System.out.println("Enter -1 exit:");
            choice2=scanner.nextInt();
        }//while
        
}
	
	
}
