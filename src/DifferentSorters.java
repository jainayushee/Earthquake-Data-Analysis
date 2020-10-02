import java.util.*;

public class DifferentSorters {
    public void sortWithCompareTo() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        
        
        
        Collections.sort(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
        
//        int quakeNumber = 600;
//        System.out.println("Print quake entry in position " + quakeNumber);
//        System.out.println(list.get(quakeNumber));

    }    

    public void sortByMagnitude() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new MagnitudeComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }

    public void sortByDistance() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        // Location is Durham, NC
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(list, new DistanceComparator(where));
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }
    
    public void sortByTitleAndDepth(){
        
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/earthQuakeDataWeekDec6sample2.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        
        
        
        Collections.sort(list, new TitleandDepthComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
        
//        int quakeNumber = 500;
//        System.out.println("Print quake entry in position " + quakeNumber);
//        System.out.println(list.get(quakeNumber));
        
    }
    
    public void sortByLastWordInTitleThenByMagnitude(){
        
         EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        
        
        
        Collections.sort(list, new TitleLastAndMagnitude());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
        
//        int quakeNumber = 500;
//        System.out.println("Print quake entry in position " + quakeNumber);
//        System.out.println(list.get(quakeNumber));
        
    }
    
    public void start(){
    	Scanner sc= new Scanner(System.in);
    	int ch;
		System.out.println("Menu: \n1. Sort by magnitude \n2. Sort by distance \n3. Sort by title and depth \n4. Sort by last word in title then magnitude\n5. Sort by magnitude with compare to");
		
		ch=sc.nextInt();
		switch(ch) {
		case 1: sortByMagnitude(); break;
			
		case 2: sortByDistance(); break;
			
		case 3:  sortByTitleAndDepth(); break;
			
		case 4: sortByLastWordInTitleThenByMagnitude(); break;
		
		case 5: sortWithCompareTo(); break;
			
        default:
    		System.out.println("Invalid Entry");
    	
    }
		
    }
    
}
