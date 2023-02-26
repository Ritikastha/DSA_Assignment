package Assignment_Question;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
/*
Question 4a)	Design and Implement LFU caching
*/


class LFU_Cache {
    private int cap;
//   represents the actual cache, mapping keys to values.
    private Map<Integer, Integer> cache;
//   represents the frequency of usage of each key.
    private Map<Integer, Integer> freq;
//    maps the frequency to a set of keys that have that frequency
    private Map<Integer, LinkedHashSet<Integer>> freqKeys;
    private int minFreq;
//constructor
    public LFU_Cache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.freq = new HashMap<>();
        this.freqKeys = new HashMap<>();
        this.minFreq = 0;
    }
//    retrieves a value from the cache given a key
    public int get(int key) {
//        If the key is not in the cache, it returns -1
        if (!cache.containsKey(key)) {
            return -1;
        }
//        If the key is in the cache, it updates the frequency of usage of the key
        int value = cache.get(key);
//        moves the key from its current frequency set to the next frequency set
        int keyFreq = freq.get(key);
        freq.put(key, keyFreq + 1);
        freqKeys.get(keyFreq).remove(key);
        if (keyFreq == minFreq && freqKeys.get(keyFreq).isEmpty()) {
//            increments
            minFreq++;
        }
        freqKeys.computeIfAbsent(keyFreq + 1, k -> new LinkedHashSet<>()).add(key);
        return value;
    }

//    inserts a key-value pair into the cache
    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }
//        If the key is already in the cache, it updates its value and updates its frequency of usage
        if (cache.containsKey(key)) {
            cache.put(key, value);
            get(key);
            return;
        }
        if (cache.size() >= cap) {
            int evict = freqKeys.get(minFreq).iterator().next();
            cache.remove(evict);
            freq.remove(evict);
            freqKeys.get(minFreq).remove(evict);
        }
        cache.put(key, value);
        freq.put(key, 1);
        freqKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }

    public static void main(String[] args) {
        LFU_Cache lfuCache = new LFU_Cache(5);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1)); // returns 1
        lfuCache.put(3, 3); // evicts key 2
        System.out.println(lfuCache.get(4)); // returns -1 (not found)
        System.out.println(lfuCache.get(3)); // returns 3
        lfuCache.put(4, 4); // evicts key 1
        System.out.println(lfuCache.get(5)); // returns -1 (not found)
        System.out.println(lfuCache.get(3)); // returns 3
        System.out.println(lfuCache.get(4)); // returns 4

    }
}




