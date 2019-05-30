package listas;

public interface ILista<T> extends Iterable<T> {

	public void addFirst(T dato);
	
	public void addLast(T dato);
	
	//Pre: pos>=0
	public void addAtPosition(T dato, int pos);
	
	public void addInOrder(T dato);
	
	//Pre: !esVacia()
	public void deleteFirst();

	//Pre: !esVacia()	
	public void deleteLast();
	
	//Pre: !esVacia && pos < largo
	public void deleteAtPosition(int pos);
	
	//Pre: existe(dato)
	public void delete(T dato);
	
	public void deleteAll(T dato);
	
	public void empty();

	public boolean exists(T dato);
	
	public T getObject(int pos);
	
	public boolean isEmpty();
		
	public boolean isFull(int max);
	
	public int length();
		
	public T recover(T dato);
	
	public void show();
	
}
