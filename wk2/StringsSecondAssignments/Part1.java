
/**
 * Write a description of Part1 here.
 * 
 * @author Kevin 
 * @version today
 */
public class Part1 {
    
    /**
     *This method returns the
     *index of the  first occurrence of stopCodon that appears past startIndex and is a multiple of
     *3 away from startIndex. If there is no such stopCodon, this method returns the length of
     *the dna strand.     
     */
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon) {
        // find stopCodon Starting from (startIndex + 3),currIndex
        int currIndex = dnaStr.indexOf(stopCodon,startIndex+3);
        //as long as currIndex is not equal to -1
        while (currIndex != -1) {
            //check if currIndex - startIndex is a multiple of 3
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                //if so, currIndex is answer, return it
                return currIndex;
            }
            else {
                //if not, update currIndex, looking for stopCodon starting from currIndex + 1
                currIndex = dnaStr.indexOf(stopCodon, currIndex+1);
        
        }
                     
    }
    //if we exit loop, we didn't find stopCodon so return dnaStr.length()
    return dnaStr.length();

}

public String findGene(String dna) {
 //find first occurance of "ATG", startIndex
    int startIndex = dna.indexOf("ATG");
 //if startIndex is -1, return ""
    if (startIndex == -1) {
        return "";
    }
//Find the index of the first occurrence of the stop codon “TAA” after the first occurrence of
//“ATG” that is a multiple of three away from the “ATG”. Hint: call findStopCodon. AND do same for TAG and TGA
//use taaIndex to store findStopCodon(dna,startIndex,"TAA");
 int taaIndex = findStopCodon(dna,startIndex,"TAA");
 //use tagIndex to store findStopCodon(dna,startIndex);
 int tagIndex = findStopCodon(dna,startIndex,"TAG");
 //use tgaIndex to store findStopCodon(dna,startIndex);
 int tgaIndex = findStopCodon(dna,startIndex,"TGA");
//Return the gene formed from the “ATG” and the closest stop codon that is a multiple of three
//away. If there is no valid stop codon and therefore no gene, return the empty string
//store in minIndex the smallest of these three
 int temp = Math.min(taaIndex,tagIndex);
 int minIndex = Math.min(temp, tgaIndex);
 //int minIndex = Math.min(taaIndex,Math.min(tag.Index,tgaIndex));
 //if minIndex is dna.length()? nothing found,
 if (minIndex == dna.length()){
     return "";
    }
 //otherwise answer is text from startIndex to minIndex + 3
 return dna.substring(startIndex, minIndex + 3 );
}

public void testFindStop(){
    //I left off here (part 1, step 4 of StringSecondAssignments) just completed on 5/15/18...
    //            012345678901234567890123456789
    String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
    int dex = findStopCodon(dna,0,"TAA");
    if (dex != 9) System.out.println("error on 9");
    dex = findStopCodon(dna,9,"TAA");
    if (dex != 21) System.out.println("error on 21");
    dex = findStopCodon(dna,1,"TAA");
    if (dex != 26) System.out.println("error on 26");
    dex = findStopCodon(dna,0,"TAG");
    if (dex != 26) System.out.println("error on 26 TAG");
    System.out.println("tests finished");
        
}
 
}