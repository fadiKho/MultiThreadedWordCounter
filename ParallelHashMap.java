import java.util.*;
import java.io.*;

public class ParallelHashMap
{
    public HashMap<String, Integer> hm;
    
    public ParallelHashMap()
    {
        this.hm = new HashMap<String, Integer>();
    }
    
    public synchronized void parallelAddKey(String key)
    {
        if (this.hm.containsKey(key))
            this.hm.put(key,this.hm.get(key) + 1);
        else
            this.hm.put(key,1);
    }
}