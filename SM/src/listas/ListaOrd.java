package listas;

public class ListaOrd<T extends Comparable<T>> extends Lista<T> {

	@Override
	public void addAtPosition(T dato, int pos) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addFirst(T dato) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void addInOrder(T dato) {
		if(_inicio == null || dato.compareTo(_inicio.getDato()) < 0)
		{
			_inicio = new NodoLista<T>(dato, _inicio);
		} else {
			NodoLista<T> aux = _inicio;
			while(aux.getSig() != null && 
					dato.compareTo(aux.getSig().getDato()) >= 0){
				aux = aux.getSig();
			}
			aux.setSig(new NodoLista<T>(dato, aux.getSig()));
		}
	}
	
	@Override
	public void addLast(T dato) {
		throw new UnsupportedOperationException();
	}
	
}
