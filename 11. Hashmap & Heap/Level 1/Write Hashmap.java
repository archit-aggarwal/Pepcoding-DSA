import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
    
    private class HMNode {
        K key;
        V value;
        
        HMNode(){}
        
        HMNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    
    private LinkedList<HMNode>[] buckets;
    private int noOfNodes;
    private int noOfBuckets;
    private double loadingFactor;
    
    public HashMap(){
        noOfBuckets = 4;
        noOfNodes = 0;
        loadingFactor = 0.0;
        init();
    }
    
    public void init(){
        buckets = new LinkedList[noOfBuckets];
        
        for(int i=0; i<noOfBuckets; i++){
            buckets[i] = new LinkedList<>();           
        }
    }
    
    public int getBucketId(K key) throws Exception{
        // O(1)
        int hashCode = key.hashCode();
        int bucketId = (Math.abs(hashCode)) % noOfBuckets;
        return bucketId;
    }
    
    private HMNode getData(int bucketId, K key) throws Exception{
        
        for(HMNode node: buckets[bucketId]){
            if(node.key.equals(key) == true){
                return node; // data already exist
            }
        }
        
        return null; // data not exist
    }
    
    public void put(K key, V value) throws Exception {
        
        // O(1)
        int bucketId = getBucketId(key);
        HMNode data = getData(bucketId, key);    
        
        if(data == null){
            // Insertion
            
            double newLoadingFactor = (noOfNodes + 1.0) / (noOfBuckets);
            
            if(newLoadingFactor > 2.0){
                // rehashing
                
                LinkedList<HMNode>[] oldBuckets = buckets;
                noOfBuckets = 2 * noOfBuckets;
                init();
                
                
                for(int i=0; i<oldBuckets.length; i++){
                    for(HMNode node: oldBuckets[i]){
                        int newBucketId = getBucketId(node.key);
                        buckets[newBucketId].addLast(node);
                    }
                } 
            }
            
            int newBucketId = getBucketId(key);
            HMNode node = new HMNode(key, value);
            buckets[newBucketId].addLast(node);
            noOfNodes++;
            loadingFactor = (noOfNodes * 1.0) / noOfBuckets;
            
        } else {
            // Updation
            data.value = value;
        }
        
        
    }

    public V get(K key) throws Exception {
        
        int bucketId = getBucketId(key);
        HMNode data = getData(bucketId, key);
        
        if(data != null){
            return data.value;
        } else {
            return null;
        }
    }

    public boolean containsKey(K key) throws Exception{
        int bucketId = getBucketId(key);
        HMNode data = getData(bucketId, key);
        
        if(data != null) return true;
        return false;
    }

    public V remove(K key) throws Exception {
        int bucketId = getBucketId(key);
        HMNode data = getData(bucketId, key);
        
        if(data == null) return null;
        
        V value = data.value;
        buckets[bucketId].remove(data);
        noOfNodes--;
        loadingFactor = (noOfNodes * 1.0) / noOfBuckets;
        return value;
    }

    public ArrayList<K> keyset() throws Exception {
        ArrayList<K> keys = new ArrayList<>();
        
        for(int i=0; i<noOfBuckets; i++){
            for(HMNode node: buckets[i]){
                keys.add(node.key);
            }
        }
        
        return keys;
    }

    public int size() throws Exception{
        return noOfNodes;
    }

   public void display() throws Exception{
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}
