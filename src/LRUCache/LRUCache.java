package LRUCache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache {
	private int capacity;
	private int curCapacity = 0;
	LinkedHashMap<Integer, Integer> queue;//实际上没有用到value，只用了key,value统一填入-1
	HashMap<Integer, Integer> map;

	public LRUCache(int capacity) {
		queue = new LinkedHashMap<Integer, Integer>();
		map = new HashMap<Integer, Integer>(capacity * 2);
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!queue.containsKey(key)) {
			return -1;
		} else {
			queue.remove(key);
			queue.put(key, -1);
			return map.get(key);
		}
	}

	public void set(int key, int value) {
		if (queue.containsKey(key)) {
			queue.remove(key);
			queue.put(key, -1);
			map.put(key, value);
			return;
		}
		if (curCapacity < capacity) {
			queue.put(key, -1);
			map.put(key, value);
			curCapacity++;
		} else {
			int keyToRemove = -1;
			Iterator<Entry<Integer, Integer>> iter = queue.entrySet().iterator();
			if (iter.hasNext()) {
				keyToRemove = iter.next().getKey();
				iter.remove();
			}
			queue.put(key, -1);
			map.remove(keyToRemove);
			map.put(key, value);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache c = new LRUCache(2);
		c.set(2, 1);
		c.set(1, 1);
		System.out.println(c.get(2));
		c.set(4, 1);
		System.out.println(c.get(1));
		System.out.println(c.get(2));
	}

}
