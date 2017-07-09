
public interface Iterador {
	boolean hasNext();
	Object next();
	void insertAfter(Object o);
	void insertBefore(Object o);
	void remove();
	// A partir daqui, � opcional!
	boolean hasPrevious();
	Object previous();
	Object getActual();
}
