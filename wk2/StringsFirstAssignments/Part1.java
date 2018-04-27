
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    /**
     *
     */
    public String findSimpleGene(String dna) {
        // Finds the index position of the start/stop codons “ATG”/"TAA. If either is missing, 
        //returns the empty string, If both exist and substring is multiple of 3, then return substring.
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1)//no ATG
        {
            return "";
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        result = dna.substring(startIndex, stopIndex+3);
        
        return result;
    }

    public void testSimpleGene(){
        
        String dna = "";
        String gene = "";
                
        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";//complete gene
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
                        
        dna = "ATCCTATGCTTCGGCTGCTCAATATGGT";//no stopCodon
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);

                        
        dna = "ATCCTTGCTTCGGCTGCTCTAATATGGT";//no startCodon
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
    
    
    
    
    }
    
    
}
