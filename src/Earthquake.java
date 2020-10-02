import java.util.*;
public class Earthquake {
	
	public static void main(String args[]) throws Exception{
		Scanner sc= new Scanner(System.in);
		
		int ch;
		System.out.println("Menu: \n1. Filter 2. Sort");
		
		ch=sc.nextInt();
		switch(ch) {
		case 1:
			EarthQuakeClient2 objnew= new EarthQuakeClient2();
			objnew.start();
			break;
			
		case 2:  
			DifferentSorters obj = new DifferentSorters();
			obj.start();
			break;
			
        default:
    		System.out.println("Invalid Entry");

        	
			
		}
		
	}
	

}
