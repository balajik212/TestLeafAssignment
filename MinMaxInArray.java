package week1.day4;

public class MinMaxInArray {

	public static void main(String[] args) {
		
		int[] a= {200, 500, 10, 3000};
		int min= a[0];
		int max= a[0];
		int count= a.length;
		
		for (int i = 0; i < count; i++) {
			
			if(a[i]<min) {
				min = a[i];
			}
			if(a[i]<max) {
				max = a[i];
			}
		}
		System.out.println(min +" "+ max);
	}

}
