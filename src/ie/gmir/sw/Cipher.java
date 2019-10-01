//Richard Cooke - G00331787
//Cipher class
//Encrpts and decrypts the files that have been chosen

package ie.gmir.sw;

//imports
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class Cipher {
	
	// "4" square cipher
	char[][][] array = {
			{
			{'A', 'B', 'C', 'D', 'E'},
			{'F', 'G', 'H', 'I', 'K'},
			{'L', 'M', 'N', 'O', 'P'},
			{'Q', 'R', 'S', 'T', 'U'},
			{'V', 'W', 'X', 'Y', 'Z'}
			},
			{
				{'Z', 'G', 'P', 'T', 'F'},
				{'O', 'I', 'H', 'M', 'U'},
				{'W', 'D', 'R', 'C', 'N'},
				{'Y', 'K', 'E', 'Q', 'A'},
				{'X', 'V', 'S', 'B', 'L'}
				},
			{
				{'M', 'F', 'N', 'B', 'D'},
				{'C', 'R', 'H', 'S', 'A'},
				{'X', 'Y', 'O', 'G', 'V'},
				{'I', 'T', 'U', 'E', 'W'},
				{'L', 'Q', 'Z', 'K', 'P'}
				}
	};

	//Encryption function
	//Runs in O(2) since it encrypts 2 characters at a time
	public String encryption(char a, char b, String key) throws IOException {
		
		//variables
		int aRow = 0;
		int aCol = 0;
		int bRow = 0;
		int bCol = 0;
		int i;
		int j;
		int c = 0;
		char encA;
		char encB;
		String line ="";
		String newKey = key;
		
		//for loop to apply first half of new key to the cipher
		for (i=0; i<5;i++)
		{
			for(j=0;j<5;j++) {
				array[1][i][j] = newKey.charAt(c);
				c++;
			}//for
		}//for
		
		//for loop to apply second half of new key to the cipher
		for (i=0; i<5;i++)
		{
			for(j=0;j<5;j++) {
				array[2][i][j] = newKey.charAt(c);
				c++;
			}//for
		}//for
		
		//for loop to determine the positions of characters 		
		for (i=0; i<5;i++)
		{
			for(j=0;j<5;j++) {
				//if to determine position for char a
				if(a==array[0][i][j])
				{
					aRow = i;
					aCol = j;
				}
				
				//if to determine position of char b
				if(b==array[0][i][j]) {
					bRow = i;
					bCol = j;
				}
			}//for
		}//for
		
		//mapping the original characters to their encrypted counterparts
		encA = array[1][aRow][bCol];
		encB = array[2][bRow][aCol];
		
		//adding both characters to the string to be output
		line +=encA;
		line +=encB;
		
		return line;
	}
	
	//Decryption function
	//runs at O(2) as it decrpyts 2 characters at a time
	public String decryption(char a, char b, String key)
	{
		//variables
		int aRow = 0;
		int aCol = 0;
		int bRow = 0;
		int bCol = 0;
		int i;
		int j;
		int c = 0;
		char decA;
		char decB;
		String line ="";
		String newKey = key;
		
		//for loop to apply first half of new key to the cipher
		for (i=0; i<5;i++)
		{
			for(j=0;j<5;j++) {
				array[1][i][j] = newKey.charAt(c);
				c++;
			}//for
		}//for
		
		//for loop to apply second half of new key to the cipher
		for (i=0; i<5;i++)
		{
			for(j=0;j<5;j++) {
				array[2][i][j] = newKey.charAt(c);
				c++;
			}//for
		}//for
		
		//for loop to determine the position of characters
		for (i=0; i<5;i++)
		{
			for(j=0;j<5;j++) {
				//if to determine the position of char a
				if(a==array[1][i][j])
				{
					aRow = i;
					aCol = j;
				}
				
				//if to determine the position of char b
				if(b==array[2][i][j]) {
					bRow = i;
					bCol = j;
				}
			}//for
		}//for
		
		//mapping the original characters to their decryption counterparts
		decA = array[0][aRow][bCol];
		decB = array[0][bRow][aCol];
		
		//adding the new decrypted characters to the string for output
		line+=decA;
		line+=decB;
		
		return line;
	}
	
}





