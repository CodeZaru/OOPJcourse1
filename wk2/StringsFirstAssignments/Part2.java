
/**
 * Write a description of Part2 here.
 * 
 * @author (kevinSullivan) 
 * @version (4-27-18)
 */
public class Part2 {
    /**
     *Programming Exercise: code written from scratch
     */
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        // Finds the index position of the start/stop codons “ATG”/"TAA. If either is missing, 
        //returns the empty string, If both exist and substring is multiple of 3, then return substring.
        String result = "";
        
        if(Character.isUpperCase(dna.charAt(0))){
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();    
        } else {
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();    
        }
        
        int startIndex = dna.indexOf(startCodon);
        if(startIndex == -1)//no startCodon
        {
            return "";
        }
        int stopIndex = dna.indexOf(stopCodon, startIndex+3);
        if(stopIndex == -1)//no stopCodon
        {
         return "";   
        }
        result = dna.substring(startIndex, stopIndex+3);
        if(result.length() % 3 != 0)
        {
            return "has start/stop codons, but isn't multiple of three";
        }
        return result;
    }

    public void testSimpleGene(){
        
        String dna = "";
        String gene = "";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        
        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";//complete gene
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
                       
        dna = "ATCCTTGCTTCGGCTGCTCTAATATGGT";//no ATG startCodon
        System.out.println("DNA strand is (no startCodon) " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
    
        dna = "ATCCTATGCTTCGGCTGCTCAATATGGT";//no TAA stopCodon
        System.out.println("DNA strand is (no stopCodon) " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
   
        dna = "ATCCTATTCGGCTGCTCTAT";//neither start nor stop codons exist
        System.out.println("DNA strand is (neither start/stopCodons exist) " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        
        dna = "gatgctataat";//lower case
        System.out.println("DNA strand is (neither start/stopCodons exist) " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        
        dna = "ATCCTATGTTCGGCTGCTCTAATATGGT";//not a multiple of 3
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
                       

        
    }
    
    
}

