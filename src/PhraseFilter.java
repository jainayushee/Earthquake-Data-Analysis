
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter{
    
    private String where, phrase;
    
    public PhraseFilter(String w, String p)
    {
        where=w;
        phrase=p;     
        
    }
    
     public boolean satisfies(QuakeEntry qe) {
            boolean flag=false;
            String check= qe.getInfo();
            String arr[]=check.split(",|\\ ");            
            int n=arr.length;
            
            if(where.equals("end") && arr[n-1].equals(phrase))
            flag=true;
            else if(where.equals("start") && arr[0].equals(phrase))
            flag=true;
            
            else if(where.equals("any")){
                int q=phrase.length();
                int l=check.length();
                for(int i=0;i<=(l-q);i++)
                {
                    String ch=check.substring(i,i+q);
                    if(ch.equals(phrase)){
                    flag=true;
                    break;}
                }
                    
                               
            }
           
            
            
            
            return flag;

        }
        
        public String getName(){
            return "Phrase";
    }
         
        }


