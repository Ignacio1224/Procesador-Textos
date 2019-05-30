package listas;

import java.util.Iterator;

public class Lista<T> implements ILista<T> {

	protected NodoLista<T> _inicio;
	protected int _cant;


	@Override
	public void addAtPosition(T dato, int pos) {
		if(_inicio == null || pos == 0)
		{
			_inicio = new NodoLista<T>(dato, _inicio);
		} else {
			NodoLista<T> aux = _inicio;
			while(aux.getSig()!=null && pos > 1)
			{
				aux = aux.getSig();
			}
			aux.setSig(new NodoLista<T>(dato, aux.getSig()));
		}
		_cant++;
	}
	
	@Override
	public void addFirst(T dato) {
		_inicio = new NodoLista<T>(dato, _inicio);
		_cant++;
	}
	
	@Override
	public void addInOrder(T dato) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void addLast(T dato) {
		if (_inicio == null)
			_inicio = new NodoLista<T>(dato, _inicio);//insertarPpio(dato);
		else {
			NodoLista<T> aux = _inicio;
			while (aux.getSig() != null) {
				aux = aux.getSig();
			}
			NodoLista<T> nuevo = new NodoLista<T>(dato);
			aux.setSig(nuevo);
			// O más cortito:
			// aux.setSig(new NodoLista<T>(dato));
		}
		_cant++;
	}

	@Override
	public void delete(T dato) {
		if(dato.equals(_inicio.getDato()))
			_inicio = _inicio.getSig();
		else
		{
			NodoLista<T> aux = _inicio;
			while(aux.getSig().getDato() != dato)
				aux = aux.getSig();
			aux.setSig(aux.getSig().getSig());
		}
		_cant--;			
	}

	@Override
	public void deleteAll(T dato) {
		while(_inicio != null && _inicio.getDato().equals(dato)){
			_inicio = _inicio.getSig();
			_cant--;
		}
		if(_inicio != null)
		{
			NodoLista<T> aux = _inicio;
			while(aux.getSig() != null)
			{
				if(aux.getSig().getDato().equals(dato))
				{
					aux.setSig(aux.getSig().getSig());
					_cant--;
				}
				else
					aux = aux.getSig();
			}
		}
	}
	
	@Override
	public void deleteAtPosition(int pos) {
		if(pos == 0)
		{
			_inicio = _inicio.getSig(); //borrarPpio();
		}
		else
		{
			NodoLista<T> aux = _inicio;
			while(pos > 1)
			{
				aux = aux.getSig();
				pos--;
			}
			aux.setSig(aux.getSig().getSig());
		}
		_cant--;
	}
	
	@Override
	public void deleteFirst() {
		_inicio = _inicio.getSig();
		_cant--;
	}

	@Override
	public void deleteLast() {
		if(_inicio.getSig() == null)
		{
			_inicio = null; //borrarPpio();
		} else {
			NodoLista<T> aux = _inicio;
			while(aux.getSig().getSig() != null)
				aux = aux.getSig();
			aux.setSig(null);
		}
		_cant--;
	}
	
	public void empty() {
		while(!isEmpty()) {
			deleteFirst();
		}
	}
	
	private boolean existeRec(T dato, NodoLista<T> nodo) {
		if(nodo == null)
			return false;
		else
			return dato.equals(nodo.getDato()) || existeRec(dato, nodo.getSig());
	}
	
	@Override
	public boolean exists(T dato) {
		return existeRec(dato, _inicio);
	}

	public T getObject(int pos) {
		NodoLista<T> aux = _inicio;
		
		while(pos > 0)
		{
			aux = aux.getSig();
			pos--;
		}

		return aux.getDato();
	}
	
	public boolean isEmpty() {
		return _cant == 0;
	}
	
	public boolean isFull(int max) {
		return _cant > max;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			NodoLista<T> aux = _inicio;
			
			@Override
			public boolean hasNext() {
				return aux != null;
			}

			@Override
			public T next() {
				T ret = aux.getDato();
				aux = aux.getSig();
				return ret;
			}
		};
	}
	
	@Override
	public int length() {
		return _cant;
	}

	@Override
	public T recover(T dato) {
		NodoLista<T> aux = _inicio;
		while(aux != null)
		{
			if(dato.equals(aux.getDato()))
			{
				return aux.getDato();
			}
			else
			{
				aux = aux.getSig();
			}
		}
		return null;
	}

	@Override
	public void show() {
		NodoLista<T> aux = _inicio;
		while (aux != null) {
			System.out.print(aux.getDato() + " ");
			aux = aux.getSig();
		}
		System.out.println();
	}

}
