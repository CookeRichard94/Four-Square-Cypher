//Richard Cooke - G00331787
//Generate Key Class
//Randomly generates a 50 character String consisting of two shuffled versions of the cipher alphabet

package ie.gmir.sw;

//imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateKey {

	//key function
	//runs at O(1) constant time
	public String key()    {
		
		//Initial string containing 25 characters used in cipher
		String alphabet ="ABCDEFGHIKLMNOPQRSTUVWXYZ";
		List<String> letters = Arrays.asList(alphabet.split(""));
		
		//shuffling the letters to a random order
		  Collections.shuffle(letters);
		  String key = "";
		  
		  //for loop to add the newly organized letters to the key string
		  for (String letter : letters) {
		    key += letter;
		  }
		  
		  //shuffling the letters again
		  Collections.shuffle(letters);
		  
		  //econd for loop to add the re-shuffled letters to the key string
		  for (String letter : letters) {
		    key += letter;
		  }
		  
		  //printing out the key
		  System.out.println(key);
		  return key;
	}
}

