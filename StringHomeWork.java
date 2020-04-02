package week1.day3;

public class StringHomeWork {

	public static void main(String[] args) {
		
		String txt= "Welcome";
		
		int count = txt.length();	
		for(int i=count-1; i>=0; i--)
		{
			char[] charArray= txt.toCharArray();
			System.out.print(charArray[i]);
		}

	}


}
