
public class DistanceFilter implements Filter {
    
     private Location location;
     private double maxDistance;
    
    public DistanceFilter(Location loc, double max) { 
        location = loc;
        maxDistance=max;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        
        if(location.distanceTo(qe.getLocation())<maxDistance)
        return true;
        return false;
    } 
    
    public String getName(){
        return "Distance";
    }


}
