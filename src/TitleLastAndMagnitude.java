import java.util.*;

public class TitleLastAndMagnitude implements Comparator<QuakeEntry> {   
    
    
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        String one[] =(q1.getInfo()).split(",|\\ ");
        String two[] =(q2.getInfo()).split(",|\\ ");
        
        String onee=one[one.length-1];
        String twoo=two[two.length-1];
        
        
        if(onee.compareTo(twoo) <0)
        return -1;
        
        else if(onee.compareTo(twoo) >0)
        return 1;
        
        else
        {
            return Double.compare(q1.getMagnitude(), q2.getMagnitude());
        }
    }
    
}
 