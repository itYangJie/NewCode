package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;

public class InsertDeleteGetRandom {
	
	private HashMap<Integer,HashSet<Integer>> map = null;
	private ArrayList<Integer> nums = null;
	private Random r;
	 /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
    	map = new HashMap<>();
    	nums = new ArrayList<>();
    	r = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean flag = false;
        if(!map.containsKey(val)) {
        	flag = true;
        	map.put(val, new HashSet<>());
        }
        nums.add(val);
        map.get(val).add(nums.size()-1);
        
        return flag;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean flag=false;
        if(map.containsKey(val)) {
        	flag = true;
        	//É¾³ýÔªËØ
        	HashSet<Integer> positions = map.get(val);
        	int delPos = positions.iterator().next();
        	positions.remove(delPos);
        	
        	if(delPos!=nums.size()-1) {
        		int lastNum = nums.get(nums.size()-1);
        		nums.set(delPos,lastNum);
        		HashSet<Integer> temp = map.get(lastNum);
        		temp.remove(nums.size()-1);
        		temp.add(delPos);
        	}
        	nums.remove(nums.size()-1);
        	if(positions.size()==0)
        		map.remove(val);
        }
        return flag;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(r.nextInt(nums.size()));
    }
}
