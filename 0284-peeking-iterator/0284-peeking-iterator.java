// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    
    List<Integer> list = new ArrayList<>();
    int index = -1;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (index + 1 < list.size()) {
            return list.get(index + 1);
        }
        return null;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        ++index;
        if (index < list.size()) {
            return list.get(index);
        }
	    return null;
	}
	
	@Override
	public boolean hasNext() {
	    if (index + 1 < list.size())
            return true;
        return false;
	}
}