import java.util.*;
import java.io.*;

public class MultiWordsCounter
{
    public String[] fileFullNames;
    public HashMap<String, Integer> hm;

    /**
     * Constructor for objects of class WordsCounter
     */
    public MultiWordsCounter()
    {
        this.fileFullNames = new String[3];
        this.hm = new HashMap<String, Integer>();
    }
    
    /**
     * counts unique words in the given files, and updates the hashMap
     * @return nothing
     */
    public void count()
    {
        WordsCounter tempWc = new WordsCounter();
        for (String s : this.fileFullNames)
        {
            tempWc.fileFullName = s;
            tempWc.count();
        }
        
        this.hm = tempWc.hm;
    }
    
    /**
     * prints the word counts contained in the hashMap
     * @return nothing
     */
    public void printWordCount ()
    {
        Set<String> ks = this.hm.keySet();
        for (String i : ks) {
            System.out.println(i + " " + this.hm.get(i));
        }
    }
    
    public static void main(String[] args)
    {
        MultiWordsCounter mwc = new MultiWordsCounter();
        mwc.fileFullNames[0] = "";
        mwc.fileFullNames[1] = "";
        mwc.fileFullNames[2] = "";
        mwc.count();
        mwc.printWordCount();
    }
}
