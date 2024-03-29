class RandomizedSet {
    //ListNode head,tail;
    HashMap<Integer,Integer> map;
    Random random;
    List<Integer> keys;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        keys = new ArrayList<>();
        random = new Random();
        //head = new ListNode(0);
        //tail = head;   
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        
        
        map.put(val,keys.size());
        keys.add(keys.size(),val);

        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;    
        }
        
        int tail = keys.get(keys.size()-1);
        int index = map.get(val);
        keys.set(index,tail);
        map.put(tail,index);
        keys.remove(keys.size()-1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int i = random.nextInt(keys.size());
        return keys.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */