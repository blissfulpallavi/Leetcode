package com.pal;

import java.util.*;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache.
 * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 * Reference for implementation logic : https://www.geeksforgeeks.org/linkedhashmap-removeeldestentry-method-in-java/
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 *
 * Constraints:
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 */
public class LRUCache {
    /**
     * The removeEldestEntry(Map.Entry) method may be overridden to impose a policy for removing
     * stale mappings automatically when new mappings are added to the map.
     */
    LinkedHashMap<Integer, Integer> map =
            new LinkedHashMap<Integer, Integer>() {
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest)
                {
                    return size() > capacity;
                }
            };

    int capacity;

    public LRUCache() {}

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public int get(int key){
        if(!map.containsKey(key))
            return -1;

        int value = map.get(key);

        map.remove(key);
        map.put(key,value);

        return value;
    }

    public void put(int key,int value){
        if(map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);

            return;
        }

        map.put(key,value);
    }

    public static void main(String[] args){
        LRUCache lru = new LRUCache();
        String[] inputKey={"LRUCache","get","put","get","put","put","get","get"};
        int[][] inputValue= {{2},{2},{2,6},{1},{1,5},{1,2},{1},{2}};
        for(int i=0;i<inputKey.length;i++){
            if(inputKey[i].equals("LRUCache")) {
                lru = new LRUCache(inputValue[i][0]);
                System.out.print("null ");
            }
            else if(inputKey[i].equals("put")) {
                lru.put(inputValue[i][0], inputValue[i][1]);
                System.out.print("null ");
            }
           else if(inputKey[i].equals("get"))
                System.out.print(lru.get(inputValue[i][0])+" ");
        }
    }
}
