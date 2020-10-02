import java.util.ArrayList;
import java.util.Scanner;
//import edu.duke.*;

public class EarthQuakeClient2 {
   

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 


    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }
    
        void start() {
        	int ans;
            EarthQuakeParser parser = new EarthQuakeParser(); 
            //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
            String source = "data/nov20quakedata.atom";
            ArrayList<QuakeEntry> list  = parser.read(source);         
            //System.out.println("read data for "+list.size()+" quakes");

        	
        	Scanner sc = new Scanner(System.in);
        	int ch;
    		System.out.println("Menu: \n1. Filter by magnitude \n2. Filter by depth \n3. Filter by distance \n4. Filter by phrase \n5. Multiple filters");
    		MatchAllFilter maf= new MatchAllFilter();
    		
    		ch=sc.nextInt();
    		switch(ch) {
    		case 1: 
        		System.out.println("Enter minimum and maximum magnitudes");
        		double min=sc.nextDouble();
        		double max=sc.nextDouble();
        	
                maf.addFilter(new MagnitudeFilter(min, max));

    		
    		break;
    			
    		case 2: System.out.println("Enter minimum and maximum depths");
    		double minD=sc.nextDouble();
    		double maxD=sc.nextDouble();
    	
            maf.addFilter(new DepthFilter(minD, maxD));
            
            break;
    			
    		case 3:  System.out.println("Enter minimum distance to selected location");
    		double distance= sc.nextDouble();
            Location loc=new Location(55.7308, 9.1153);
    	
            maf.addFilter(new DistanceFilter(loc, distance));
            
            break;
    			
    		case 4: 
    			System.out.println("Enter phrase");
    			String phrase=sc.next();
    			System.out.println("Enter start/end/any for location of phrase");
    			String location=sc.next();
    			maf.addFilter(new PhraseFilter(location, phrase));
    		
    		
    		break;
    		
    		case 5:
    			System.out.println("Add magnitude filter? 1/0");
    			ans=sc.nextInt();
    			if(ans==1) {
    				System.out.println("Enter minimum and maximum magnitudes");
            		double minMag=sc.nextDouble();
            		double maxMag=sc.nextDouble();
            	
                    maf.addFilter(new MagnitudeFilter(minMag, maxMag));
    			}
    			
    			System.out.println("Add distance filter? 1/0");
    			ans=sc.nextInt();
    			if(ans==1) {
    				System.out.println("Enter minimum distance to selected location");
    	    		double dist= sc.nextDouble();
    	            Location loca=new Location(55.7308, 9.1153);
    	    	
    	            maf.addFilter(new DistanceFilter(loca, dist));
    			}
    			
    			System.out.println("Add depth filter? 1/0");
    			ans=sc.nextInt();
    			if(ans==1) {
    				System.out.println("Enter minimum and maximum depths");
    	    		double minDe=sc.nextDouble();
    	    		double maxDe=sc.nextDouble();
    	    	
    	            maf.addFilter(new DepthFilter(minDe, maxDe));
    			}
    			
    			System.out.println("Add phrase filter? 1/0");
    			ans=sc.nextInt();
    			if(ans==1) {
    				System.out.println("Enter phrase");
        			String ph=sc.next();
        			System.out.println("Enter start/end/any for location of phrase");
        			String locat=sc.next();
        			maf.addFilter(new PhraseFilter(locat, ph));
    			}
    			
    			
    				
    			
    		
    			
            default:
        		System.out.println("Invalid Entry");
    		}
        
        
        
        ArrayList<QuakeEntry> m7  = filter(list, maf); 

        
        for (QuakeEntry qe: m7) { 
            System.out.println(qe);
        } 
        
        System.out.println("Filters used are: "+maf.getName());
                        System.out.println("result "+m7.size()+" quakes");
    }


}
