package week1.day4;

public class IndexNumberInArray {

	public static void main(String[] args) {
		
		int[] a= {200, 500, 10, 3000};
		
		for (int i = 0; i < a.length; i++) {
			
			if(a[i]==10) {
				System.out.println(i);
				break;
			}
			
	}
	
}
}