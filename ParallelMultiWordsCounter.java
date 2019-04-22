import java.util.*;
import java.io.*;

public class ParallelMultiWordsCounter
{
    public String[] fileFullNames;
    public ParallelHashMap phm;

    /**
     * Constructor for objects of class WordsCounter
     */
    public ParallelMultiWordsCounter()
    {
        this.fileFullNames = new String[3];
        this.phm = new ParallelHashMap();
    }
    
    /**
     * counts unique words in the given files, and updates the hashMap
     * @return nothing
     */
    public void count() throws InterruptedException
    {
        ParallelWordsCounter tempPwc1 = new ParallelWordsCounter(this.fileFullNames[0],"th1", this.phm);
        tempPwc1.start();
        
        ParallelWordsCounter tempPwc2 = new ParallelWordsCounter(this.fileFullNames[1],"th2", this.phm);
        tempPwc2.start();
        
        ParallelWordsCounter tempPwc3 = new ParallelWordsCounter(this.fileFullNames[2],"th3", this.phm);
        tempPwc3.start();
        
        tempPwc1.t.join();
        tempPwc2.t.join();
        tempPwc3.t.join();
        
        this.printWordCount();
    }
    
    /**
     * prints the word counts contained in the hashMap
     * @return nothing
     */
    public void printWordCount ()
    {
        Set<String> ks = this.phm.hm.keySet();
        for (String i : ks) {
            System.out.println(i + " " + this.phm.hm.get(i));
        }
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        ParallelMultiWordsCounter pmwc = new ParallelMultiWordsCounter();
        pmwc.fileFullNames[0] = "";
        pmwc.fileFullNames[1] = "";
        pmwc.fileFullNames[2] = "";
        pmwc.count();
    }
}

