package week1.day3;

public class NextString {

	public static void main(String[] args) {
		
		String txt= "A1B2C3D";
		
		int count = txt.length();	
		for(int i=0; i<count; i++)
		{
			char[] charArray= txt.toCharArray();
			int ascii = (int) charArray[i];
			ascii = ascii+1;
			char c = (char)ascii;
			System.out.println(c);
			
			
		}

	}


}
