 /*
 Author: Elizabeth Fiator & Luis Diniz
 Version: April 10, 2016
 Description and Background: The purpose of this class is to encrypt and decrypt a
 test using an Affine Cipher. An Affine Cipher uses the equation c=ap-b(mod 26)
 to encrypt a plaintext. a takes a numerical value that is not a factor or multiple of
 26. c is the numerical value of the ciphered text while p is the numerical value 
 of the plaintext.
 The function used in decrypting is p=((inverse of a (mod 26)*(c-b))(mod 26)
*/
import javax.swing.JOptionPane;
public class AffineCipher
{
	//Gets the a and b values from the user to be used in the affine cipher equation
	private final static String inputValue = JOptionPane.showInputDialog("Please input a value for a");
	private static int a= Integer.parseInt(inputValue);
	private final static String inputValue1 = JOptionPane.showInputDialog("Please input a value for b");
	private static int b= Integer.parseInt(inputValue1);

	public final static void main(String[]args)
	{
		//Encrypts and decrypts a string "HELLO" using the affine cipher equation
		String t = "HELLO";
		String e = AffineCipher.encrypt(t);
		System.out.println("The encrypted text is "+e);
		String d = AffineCipher.decrypt(e);
		System.out.println("The decrypted text is "+d);
	}
	//Encrypts the string and takes an input of plain text
	public static String encrypt(String ptxt)
	{
		//The encrypted or ciphered text will be stored in this string
		String ctxt = "";
		//Finds the numerical equivalence of a character using the inverse equation. 
		for(int i=0;i<ptxt.length();i++)
		{
			ctxt = ctxt+(char) ((((a*ptxt.charAt(i))+b)%26)+65);
		}
		return ctxt;//returns the encrypted text
	}

	/*
	This method decrypts an ecrypted text. 
	It finds the inverse mod of a and uses it to 
	find the correct numerical value of the plaintext
	The parameter is the ciphered text
	*/
	public static String decrypt(String ctxt)
	{
		String ptxt = "";
		int inv_a =0;
		int x =0;
		//finds the inverse mod of a
		for(int i=0; i<26;i++)
		{
			x=(a * i)%26;
			if(x==1)
			{
				inv_a=i;
				System.out.println("the inverse of a is "+i);
			}
		}
		//Uses the inverse of a to compute the correct numerical equivalence
		//of the plaintext
		for(int i=0;i<ctxt.length();i++)
		{
			ptxt = ptxt+(char) (((inv_a*((ctxt.charAt(i)-b))%26))+65);
		}
		return ptxt;//returns the decrypted text
	}
	
}