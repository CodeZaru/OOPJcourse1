
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {

    public boolean twoOccurrences(String stringa, String stringb) {
        //returns true if stringa appears at least twice in stringb, 
        //otherwise it returns false
        int indexOfCount1 = stringb.indexOf(stringa);
        
        if(indexOfCount1 != -1) {
         int indexOfCount2 = stringb.indexOf(stringa, indexOfCount1+1);
         if(indexOfCount2 != -1) {
             return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
    
    public void testing() {
        
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "banana"));
        System.out.println(twoOccurrences("atg", "ctgtatgta"));
        
    }
    
}

