import java.util.Iterator;

public class ArrayDictionary<K,V> implements DictionaryInterface<K,V> {
	
	private Entry<K,V>[] entries;
	private int numberOfEntries;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 10;
	private boolean initialized = false;
	
	@SuppressWarnings("unchecked")
	public ArrayDictionary(int capacity) {
		this.capacity = capacity;
		numberOfEntries = 0;
		entries = new Entry[capacity];
		initialized = true;
	}
	
	public ArrayDictionary() {
		this(DEFAULT_CAPACITY);
	}
	

	/**
	 * ABLE TO REPLACE
	 * @return null if key did not exist in entry, V value it replaced if key existed
	 */
	@Override
	public V add(K key, V value) {
		checkInitialized();
		int index = locatePosition(key);
		if (index < numberOfEntries) {
			V oldValue = entries[index].getValue();
			entries[index].setValue(value);
			return oldValue;
		}
		entries[numberOfEntries] = new Entry<K,V>(key, value);
		numberOfEntries++;
		return null;
	}

	/**
	 * Replaces index entry w/ last entry if removal is carried out
	 * @return null if key not in entries; value connected to removed entry w/ given key if in entries
	 */
	@Override
	public V remove(K key) {
		int index = locatePosition(key);
		if (index == numberOfEntries) {
			return null;
		}
		V oldValue = entries[index].getValue();
		entries[index] = entries[numberOfEntries - 1];
		entries[--numberOfEntries] = null;
		return oldValue;
	}

	@Override
	public V getValue(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<K> getKeyIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<V> getValueIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Returns index location of key
	 * @param key
	 * @return
	 */
	public int locatePosition(K key) {
		int index = 0;
		while (index < numberOfEntries) {
			if (key.equals(entries[index].getKey())) {
				break;
			}
			index++;
		}
		return index;
	}
	
	/**
	 * @throws SecurityException if not initialized
	 */
	private void checkInitialized() {
		if (!initialized) {
			throw new SecurityException();
		}
	}
	
	/**
	 * Doubles capacity of entries if entries is full
	 */
	private void ensureCapacity() {
		if (capacity == numberOfEntries) {
			@SuppressWarnings("unchecked")
			Entry<K,V>[] temp = new Entry[capacity*2];
			for (int i = 0; i < numberOfEntries; i++) {
				temp[i] = entries[i];
			}
			capacity *= 2;
			entries = temp;
		}
	}

}
