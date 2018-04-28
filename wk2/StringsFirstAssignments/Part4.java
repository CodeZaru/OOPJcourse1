
/**
 * Write a description of Part4 here.
 * @author (kevinSullivan) 
 * @version (4-27-18)
 */

import edu.duke.*;

public class Part4 {

    public void findAndPrintUrls(String url) {
        URLResource targetUrl = new URLResource(url);
        for(String word : targetUrl.words()) {
         if(word.toLowerCase().indexOf("youtube.com") != -1) {
             int argIndexStart = word.indexOf("\"");
             int argIndexEnd = word.indexOf("\"",argIndexStart+1);
             System.out.println(word.substring(argIndexStart+1,argIndexEnd)); 
            }
        }
        
    }
    
    public void testFindAndPrintUrls() {
     findAndPrintUrls("http://www.dukelearntoprogram.com/course2/data/manylinks.html");   
      
    }
    
    
    
    
}