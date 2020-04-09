import java.util.Iterator;
/**
 * An interface for a dictionary with distinct search keys
 * @author leey2
 *
 */
public interface DictionaryInterface<K, V> {
	
	/**
	 * Adds new entry to dictionary. If given key exists in dictionary, replaces the value
	 * @param key
	 * @param value
	 * @return the replaced value or null is value did not exist in the dictionary
	 */
	public V add(K key, V value);
	
	/**
	 * Removes specific entry from dictionary.
	 * @param key
	 * @return the removed value or null if key did not exist in the dictionary
	 */
	public V remove(K key);
	
	/**
	 * Retrievs value associated with given search key
	 * @param key
	 * @return the retrieved value or null if the key did not exist in the dictionary
	 */
	public V getValue(K key);
	
	/**
	 * Sees if an entry with given key is in the dictionary
	 * @param key
	 * @return true or false
	 */
	public boolean contains(K key);
	
	/**
	 * Sees if dictionary is empty
	 * @return true or false
	 */
	public boolean isEmpty();
	
	/**
	 * Removes all entries
	 */
	public void clear();
	
	/**
	 * Creates iterator that traverses all search keys in the dictionary
	 * @return Iterator that provides sequential access to all keys in the dictionary
	 */
	public Iterator<K> getKeyIterator();
	
	/**
	 * Creates an iterator that traverses all values in the dictionary
	 * @return Iterator that provides sequential access to all values in the dictionary
	 */
	public Iterator<V> getValueIterator();
}
