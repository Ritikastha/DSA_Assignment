package Assignment_Ques;

//Question 4a)	Design and Implement LFU caching

import java.util.HashMap;
import java.util.Map;

class pair {
    int value, frequency;

    public pair(int value, int frequency)
    {
        this.value = value;
        this.frequency = frequency;
    }
}

class LFU {
    int cacheSize;
    Map<Integer, pair> cache;

    public LFU(int cacheSize)
    {
        this.cacheSize = cacheSize;
        this.cache = new HashMap<Integer, pair>();
    }

    // Self made heap tp Rearranges
    // the nodes in order to maintain the heap property
    public void increment(int value)
    {
        if (cache.containsKey(value)) {
            cache.get(value).frequency += 1;
        }
    }

    // Function to Insert a new node in the heap
    public void insertNewNode(int value)
    {
        if (cache.size() == cacheSize) {
            // remove least frequently used
            int lfuKey = find_LFU();
            System.out.println("Cache block " + lfuKey
                    + " removed.");
            cache.remove(lfuKey);
        }

        pair newPair = new pair(value, 1);
        cache.put(value, newPair);
        System.out.println("Cache block " + value
                + " inserted.");
    }

    // Function to refer to the block value in the cache
    public void refer_blockval(int value)
    {
        if (!cache.containsKey(value)) {
            insertNewNode(value);
        }
        else {
            increment(value);
        }
    }

    // Function to find the LFU block
    public int find_LFU()
    {
        int lfuKey = 0;
        int minFrequency = Integer.MAX_VALUE;
        for (Map.Entry<Integer, pair> entry :
                cache.entrySet()) {
            if (entry.getValue().frequency < minFrequency) {
                minFrequency = entry.getValue().frequency;
                lfuKey = entry.getKey();
            }
        }
        return lfuKey;
    }
}

public class Q4a {
    public static void main(String[] args)
    {
        LFU lfuCache = new LFU(4);
        lfuCache.refer_blockval(1);
        lfuCache.refer_blockval(2);
        lfuCache.refer_blockval(1);
        lfuCache.refer_blockval(3);
        lfuCache.refer_blockval(2);
        lfuCache.refer_blockval(4);
        lfuCache.refer_blockval(5);
    }
}


