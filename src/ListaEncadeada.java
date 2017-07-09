
public class ListaEncadeada {
	private No head;
	private No tail;
	
	private static class No {
		private No next;
		private No previous;
		private Object elemento;
		
		public No(Object elemento){
			this.next = null;
			this.previous = null;
			this.elemento = elemento;
		}
		public void setNext(No no){
			this.next = no;
		}
		public void setPrevious(No no){
			this.previous = no;
		}
		public Object getData(){
			return this.elemento;
		}
	}
	
	private static class ListaIterador implements Iterador {
		
		private No noIterador;
		
		protected ListaIterador(No noIterador) {
			this.noIterador = noIterador;
		}
		@Override
		public boolean hasNext() {
			if (this.noIterador.next != null) {
				return true;
			}
			return false;
		}
		@Override
		public Object next() {
			if (this.hasNext()) {
				this.noIterador = this.noIterador.next;
				return this.noIterador.previous.getData();
			} else {
				return this.noIterador.getData();
			}
		}

		@Override
		public void insertAfter(Object o) {
			if (this.hasNext()) {
				No novoNo = new No(o);
				
				novoNo.setPrevious(this.noIterador);
				novoNo.setNext(this.noIterador.next);
				this.noIterador.next.setPrevious(novoNo);
				this.noIterador.setNext(novoNo);
			}
		}

		@Override
		public void insertBefore(Object o) {
			if (this.hasPrevious()) {
				No novoNo = new No(o);
				novoNo.setNext(this.noIterador);
				novoNo.setPrevious(this.noIterador.previous);
				this.noIterador.previous.setNext(novoNo);
				this.noIterador.setPrevious(novoNo);
			}
		}

		@Override
		public void remove() {
			No proximo, anterior, atual;
			atual = this.noIterador;
			proximo = this.noIterador.next;
			anterior = this.noIterador.previous;
			
			anterior.setNext(proximo);
			proximo.setPrevious(anterior);
			atual.setNext(null);
			atual.setPrevious(null);
		}

		@Override
		public boolean hasPrevious() {
			if (this.noIterador.previous != null) {
				return true;
			}
			return false;
		}

		@Override
		public Object previous() {
			if (this.hasPrevious()) {
				this.noIterador = this.noIterador.previous;
				return this.noIterador.next.getData();
			} else {
				return this.noIterador.getData();
			}
		}
		
	}
	/*CONSTRUTOR*/
	public ListaEncadeada(){
		this.head = null;
		this.tail = null;
	}
	/*INSERE O OBJETO NO FIM DA LISTA*/
	public void append(Object elemento) {
		if (this.head != null) {
			No novoNo = new No(elemento);
			this.tail.setNext(novoNo);
			novoNo.setPrevious(this.tail);
			this.tail = novoNo;
		} else {
			this.addFirst(elemento);
		}
	}
	/*INSERE O OBJETO NO INICIO DA LISTA*/
	public void addFirst(Object elemento) {
		No novoNo = new No(elemento);
		if (this.head != null) {
			this.head.setPrevious(novoNo);
			novoNo.setNext(this.head);
			this.head = novoNo;
		} else {
			this.head = novoNo;
			this.tail = novoNo;
		}
	}
	/*REMOVE O OBJETO DA LISTA*/
	public void remove(Object elemento) {
		if (this.hasObject(elemento)) {
			Iterador iter = this.getFirst();
			while (iter.hasNext()) {
				Object compara = iter.next();
				if (elemento == compara) {
					iter.previous();
					iter.remove();
				}
				iter.next();
			}
		}
	}
	/*RECUPERA O ITERADOR PARA O PRIMEIRO NO DA LISTA*/
	public Iterador iterador(){
		return this.getFirst();
	}
	/*RECUPERA O ITERADOR PARA O PRIMEIRO NO DA LISTA*/
	public Iterador getFirst(){
		Iterador iter = new ListaIterador(this.head);
		return iter;
	}
	/*RECUPERA O ITERADOR PARA O ULTIMO NO DA LISTA*/
	public Iterador getLast(){
		Iterador iter = new ListaIterador(this.tail);
		return iter;
	}
	/*TESTA SE O OBJETO EXISTE NA LISTA*/
	public boolean hasObject(Object elemento){
		if (elemento != null) {
			return true;
		}
		return false;
	}
}