import java.util.HashMap;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class ParallelWordsCounter implements Runnable
{
    public ParallelHashMap phm;
    public String fileFullName;
    public Thread t;
    public String threadName;
    
    /**
     * Constructor for objects of class WordsCounter
     * @param String _fileFullName
     */
    public ParallelWordsCounter(String _fileFullName, String _threadName, ParallelHashMap _phm)
    {
        this.fileFullName = _fileFullName;
        this.phm = _phm;
        this.threadName = _threadName;
        this.t = new Thread(this,this.threadName);
    }
    
    /**
     * counts unique words in a given file, and updates the hashMap
     * @param String fileFullName - file's full name with path
     * @return nothig
     */
    public void run()
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
                    this.phm.parallelAddKey(s);
                }
            }
        }
        catch(Exception e)  {}
    }
    
    public void start () 
    {
        t.start ();
    }
    
    /**
     * prints the word counts contained in the hashMap
     * @return nothing
     */
    public void printWordCount ()
    {
        Set<String> ks = this.phm.hm.keySet();
        for (String i : ks) 
        {
            System.out.println(i + " " + this.phm.hm.get(i));
        }
    }
}
