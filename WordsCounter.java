import java.util.HashMap;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class WordsCounter
{
    public HashMap<String, Integer> hm;
    public String fileFullName;
    
    /**
     * Constructor for objects of class WordsCounter
     */
    public WordsCounter()
    {
        this.fileFullName = null;
        this.hm = new HashMap<String, Integer>();
    }
    
    /**
     * Constructor for objects of class WordsCounter
     * @param String _fileFullName
     */
    public WordsCounter(String _fileFullName)
    {
        this.fileFullName = _fileFullName;
        this.hm = new HashMap<String, Integer>();
    }
    
    /**
     * counts unique words in a given file, and updates the hashMap
     * @param String fileFullName - file's full name with path
     * @return nothig
     */
    public void count()
    {
        Scanner sc;
        String currLine;
        String[] lineArr;
        int currCount;
        File file = new File(this.fileFullName); 
        
        try
        {
            sc = new Scanner(file); 
            while (sc.hasNextLine()) 
            {
                currLine = sc.nextLine();
                lineArr = currLine.split(" ");
                for (String s : lineArr)
                {
                    if (this.hm.containsKey(s))
                        this.hm.put(s,this.hm.get(s) + 1);
                    else
                        this.hm.put(s,1);
                }
            }
        }
        catch(Exception e)
        {
            
        }
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
        WordsCounter wc = new WordsCounter("");
        wc.count();
        wc.printWordCount();
    }
}
