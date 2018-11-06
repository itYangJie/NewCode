package com.xmu.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class AllOneDataStruct {
	TreeMap<Integer, HashSet<String>> reversedIndex;
	HashMap<String, Integer> index;

	/** Initialize your data structure here. */
	public AllOneDataStruct() {
		this.reversedIndex = new TreeMap<>();
		this.index = new HashMap<>();
	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */

	public void inc(String key) {
		if (this.index.containsKey(key) == false) {
			this.index.put(key, 1);
			if (this.reversedIndex.containsKey(1) == false)
				this.reversedIndex.put(1, new HashSet<String>());
			this.reversedIndex.get(1).add(key);
		} else {
			int currentCounts = this.index.get(key);
			this.reversedIndex.get(currentCounts).remove(key);
			// �������Ҫ��remove,��ΪtreemapҪֱ��firstkey()����lastkey,����decͬ��
			if (this.reversedIndex.get(currentCounts).size() == 0) {
				this.reversedIndex.remove(currentCounts);
			}
			if (this.reversedIndex.containsKey(currentCounts + 1) == false) {
				this.reversedIndex.put(currentCounts + 1, new HashSet<>());
			}
			this.index.put(key, currentCounts + 1);
			this.reversedIndex.get(currentCounts + 1).add(key);
		}
	}

	/**
	 * Decrements an existing key by 1. If Key's value is 1, remove it from the data
	 * structure.
	 */
	public void dec(String key) {
		if (this.index.containsKey(key)) {
			int currentCounts = this.index.get(key);
			this.reversedIndex.get(currentCounts).remove(key);
			if (this.reversedIndex.get(currentCounts).size() == 0) {
				this.reversedIndex.remove(currentCounts);
			}
			if (currentCounts == 1) {
				this.index.remove(key);
			} else {
				if (this.reversedIndex.containsKey(currentCounts - 1) == false) {
					this.reversedIndex.put(currentCounts - 1, new HashSet<>());
				}
				this.reversedIndex.get(currentCounts - 1).add(key);
				this.index.put(key, currentCounts - 1);
			}
		}
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		if (this.index.size() == 0)
			return "";
		return this.reversedIndex.get(this.reversedIndex.lastKey()).iterator().next();
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		if (this.index.size() == 0)
			return "";
		return this.reversedIndex.get(this.reversedIndex.firstKey()).iterator().next();
	}
}
