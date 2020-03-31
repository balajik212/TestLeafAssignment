package week1.day1;

public class Android {
	
	long totalUsers=1000000000;
	boolean isAndroid = true;
	String versionName = "Android Pie";
	int price=10000;
	float version = 9.1f;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating class reference
		Android android = new Android();
		
		//Print total number of android users
		long totalUsers2 = android.totalUsers;
		System.out.println("Total number of Android users" + "=" + totalUsers2);
		
		//Print if the current phone is Android
		boolean isAndroid2 = android.isAndroid;
		System.out.println("Check if current phone is Android" + "="+ isAndroid2);
		
		//Print the current Android Version name
		String versionName2 = android.versionName;
		System.out.println("Current version name" +"="+ versionName2);
		
		//Print current version number
		float version2 = android.version;
		System.out.println("Current Android version no" + "="+ version2);
		
		//Print the price of the Android phone
		int price2 = android.price;
		System.out.println("The price of the Android phone is" + "="+ price2);
	}	

}
