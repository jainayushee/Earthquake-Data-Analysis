import java.util.*;

public class TitleandDepthComparator implements Comparator<QuakeEntry> {

    
    
    
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        String one = q1.getInfo();
        String two = q2.getInfo();
        
        if(one.compareTo(two) <0)
        return -1;
        
        else if(one.compareTo(two) >0)
        return 1;
        
        else
        {
            return Double.compare(q1.getDepth(), q2.getDepth());
        }
    }
    
}
 