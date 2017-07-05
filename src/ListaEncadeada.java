
public class ListaEncadeada {
	private No head;
	private No tail;
	
	public ListaEncadeada(){
		this.head = null;
		this.tail = null;
	}

	public void append(Object elemento) {
		No novoNo = new No(elemento);
		if (this.head == null) {
			this.addFirst(elemento);
		} else {
			this.tail.setNext(novoNo);
			novoNo.setPrevious(this.tail);
			this.tail = novoNo;
		}
	}

	public void addFirst(Object elemento) {
		No novoNo = new No(elemento);
		if (this.head == null) {
			this.head = novoNo;
			this.tail = novoNo;
		} else {
			this.head.setPrevious(novoNo);
			novoNo.setNext(this.head);
			this.head = novoNo;
		}
	}

	public No getFirst() {
		return this.head;
	}
	
	public No getLast() {
		return this.tail;
	}

}
