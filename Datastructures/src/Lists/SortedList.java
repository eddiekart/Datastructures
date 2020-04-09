package Lists;

public class SortedList<T extends Comparable<? super T>> implements SortedListInterface<T> {
	
	private ListInterface<T> list;
	
	/**
	 * Constructor; makes list to be used
	 */
	public SortedList() {
		list = new LinkedList<>();
	}

	/**
	 * Adds entry to the correct spot depending on getPosition outcome
	 */
	@Override
	public void addEntry(T newEntry) {
		int newPosition = getPosition(newEntry);
		if (newPosition < 0) {
			newPosition = -newPosition - 1;
		}
		list.add(newEntry, newPosition);
		
	}

	/**
	 * Quantifies entries and compares entries; gets relative position in list for anEntry
	 */
	@Override
	public int getPosition(T anEntry) {
		int position = 0;
		while (position < getLength() && anEntry.compareTo(getEntry(position)) > 0) {
			position++;
		}
		if (getLength() == 0) {
			return position;
		}
		if (position == getLength()) {
			return position;
		}
		if (anEntry.compareTo(getEntry(position)) == 0) {
			return position;
		}
		return (-position - 1);
	}

	/**
	 * Removes specific entry; returns false if no anEntry detected
	 */
	@Override
	public boolean removeEntry(T anEntry) {
		int position = getPosition(anEntry);
		if (position < 0) {
			return false;
		} else {
			remove(position);
		}
		return true;
	}
	
	/**
	 * Removes entry at given position
	 */
	@Override
	public T remove(int givenPosition) {
		return list.remove(givenPosition);
	}
	
	/**
	 * Returns entry of given index position
	 */
	@Override
	public T getEntry(int position) {
		return list.getEntry(position);
	}

	/**
	 * Clears list
	 */
	@Override
	public void clear() {
		list.clear();		
	}

	/**
	 * Returns an array that is a copy of list
	 */
	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	/**
	 * Returns if it has a specific entry
	 */
	@Override
	public boolean contains(T anEntry) {
		return list.contains(anEntry);
	}

	/**
	 * Returns number of entries in list
	 */
	@Override
	public int getLength() {
		return list.getLength();
	}

	/**
	 * Returns boolean true/false on emptiness
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
