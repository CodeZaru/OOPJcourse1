
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
  //This completes part 1, step 5 of StringSecondAssignments) just completed on 5/15/18.

  //find first occurance of "ATG", startIndex
    int startIndex = dna.indexOf("ATG");
  //if startIndex is -1, return ""
    if (startIndex == -1) {
        return "-1";
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
  //another way to do this is to nest, like int he comment below
  //int minIndex = Math.min(taaIndex,Math.min(tag.Index,tgaIndex));
  //if minIndex is dna.length() then nothing found b/c that is what the findStopCodon() returns when there is none,
   if (minIndex == dna.length()){
     return "-2";
    }
  //otherwise answer is text from startIndex to minIndex + 3 (this is the last bullet in step 5
   return dna.substring(startIndex, minIndex + 3 );
}

public void testFindStopCodon(){
    //This completes part 1, step 4 of StringSecondAssignments) just completed on 5/15/18...
    //            012345678901234567890123456789
    String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
    //test 1
    int dex = findStopCodon(dna,0,"TAA");
    if (dex != 9) System.out.println("error on 9");
    //test 2
    dex = findStopCodon(dna,9,"TAA");
    if (dex != 21) System.out.println("error on 21");
    //test 3
    dex = findStopCodon(dna,1,"TAA");
    if (dex != 26) System.out.println("error on 26");
    //test 4
    dex = findStopCodon(dna,0,"TAG");
    if (dex != 26) System.out.println("error on 26 TAG");
    //if get this far then all the tests finished successfully
    System.out.println("tests finished");
        
}

public void testFindGene(){
   //This completes part 1, step 6 of StringSecondAssignments) just completed on 5/21/18...
   //Write the void method testFindGene that has no parameters. 
   //You should create fi ve DNA strings.
   //The strings should have speci c test cases such as:
   //DNA with no “ATG”
   //DNA with “ATG” and one valid stop codon
   //DNA with “ATG” and multiple valid stop codons
   //DNA with “ATG” and no valid stop codons
   //Think carefully about what would be good examples to test.
   //For each DNA string you should: 
   //1) Print the DNA string, 
   //2) Calculate the gene by sending this DNA as a sting argument to findGene. If a gene exists
   //following our algorithm above, then pring the gene, otherwise print the empty string.

    String dna;
    String returnedFromFindGene;

   //test 1: DNA with no “ATG”
   //      012345678901234567890123456789
    dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
    returnedFromFindGene = findGene(dna);

    if (returnedFromFindGene == "-1") System.out.println("Test1: No startCodon");
    else if (returnedFromFindGene == "-2") System.out.println("Test1: No Gene");
    else System.out.println("Test1 with DNA with no “ATG” for findGene(): " + returnedFromFindGene);

   //test 2: DNA with “ATG” and one valid stop codon
   //      012345678901234567890123456789
    dna = "ATGxxxyyyzzzTAAxxxyyyzzzxx";
    returnedFromFindGene = findGene(dna);

    if (returnedFromFindGene == "-1") System.out.println("Test2: No startCodon");
    else if (returnedFromFindGene == "-2") System.out.println("Test2: No Gene");
    else System.out.println("Test2 with DNA with “ATG” and one valid stop codon for findGene(): " + returnedFromFindGene);

   //test 3: DNA with “ATG” and multiple valid stop codons
   //      012345678901234567890123456789
    dna = "xxxyyyzzzTAAxxxATGyyyzzzTAGxxxTAAyyyTGA";
    returnedFromFindGene = findGene(dna);

    if (returnedFromFindGene == "-1") System.out.println("Test3: No startCodon");
    else if (returnedFromFindGene == "-2") System.out.println("Test3: No Gene");
    else System.out.println("Test3 with DNA with “ATG” and multiple valid stop codons for findGene(): " + returnedFromFindGene);

   //test 4: DNA with “ATG” and no valid stop codons at all
   //      012345678901234567890123456789
    dna = "ATGxxxyyyzzzxxxyyyzzzxx";
    returnedFromFindGene = findGene(dna);

    if (returnedFromFindGene == "-1") System.out.println("Test4: No startCodon");
    else if (returnedFromFindGene == "-2") System.out.println("Test4: No Gene");
    else System.out.println("Test4 with DNA with “ATG” and no valid stop codons at all for findGene(): " + returnedFromFindGene);

   //test 5: DNA with “ATG” and some valid and invalid stop codons--TGA is answer
   //      012345678901234567890123456789
    dna = "xxxyyyzzzATGxTAAyTAGzxxxTGAyyyzzzTAAxx";
    returnedFromFindGene = findGene(dna);

    if (returnedFromFindGene == "-1") System.out.println("Test5: No startCodon");
    else if (returnedFromFindGene == "-2") System.out.println("Test5: No Gene");
    else System.out.println("Test5 with DNA with “ATG” and some valid and invalid stop codons--end in TGA is answer for findGene(): " + returnedFromFindGene);
    
        
}

 
}