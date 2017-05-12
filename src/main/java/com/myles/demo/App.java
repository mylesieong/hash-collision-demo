package com.myles.demo;

public class App {
    public static void main( String[] args ){
        /* MyHashMap is a simplified hash map that takes
         * string as Key and int as Value, and its hash 
         * function is the number of ascii code of the 
         * first char */
        MyHashMap map = new MyHashMap();
        System.out.println("Put Key: alice, Value: 25");
        map.put("alice", 25);
        System.out.println("Put Key: Bob, Value: 28");
        map.put("Bob", 28);
        System.out.println("Put Key: Alex, Value: 30");
        map.put("Alex", 30);

        /* The result should be 25 but because of the 
         * hash collision, the result becomes 28 */
        int resultForAlice = map.get("alice");
        System.out.println("The result of \"alice\": " + resultForAlice); 
        int resultForBob = map.get("Bob");
        System.out.println("The result of \"Bob\": " + resultForBob); 
        int resultForAlex = map.get("Alex");
        System.out.println("The result of \"Alex\": " + resultForAlex); 

    }

    public static class MyHashMap {

        private int[] _table;

        private static int hash(String str){
            char keyInitiate = str.toUpperCase().charAt(0);
            return (int)keyInitiate - 65;
        }

        public MyHashMap(){
            this._table = new int[26];  //For 26 english alphebet
        }

        public void put(String key, int value){
            this._table[MyHashMap.hash(key)] = value;
        }
        
        public int get(String key){
            int index = MyHashMap.hash(key);
            return this._table[index];
        }

    }
}
