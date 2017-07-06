
public class ListaEncadeada {
	private No head;
	private No tail;
	
	public ListaEncadeada(){
		this.head = null;
		this.tail = null;
	}
	/*INSERE O OBJETO NO FIM DA LISTA*/
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
	/*INSERE O OBJETO NO COMEÇO DA LISTA*/
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
	/*RETORNA O PRIMEIRO NO*/
	public No getFirst() {
		return this.head;
	}
	/*RETORNA O ULTIMO NO*/
	public No getLast() {
		return this.tail;
	}
	/*REMOVE O OBJETO DA LISTA*/
	public void remove(Object elemento){
		if (hasObject(elemento)) {
			No iter = this.getFirst();
			while (iter != null ) {
				if (elemento == iter.getData()) {
					iter.remove();
				}
				iter = iter.next();
			}
		}				
	}
	/*TESTA SE O OBJETO EXISTE NA LISTA*/
	public boolean hasObject(Object elemento){
		if (elemento == null) {
			return false;
		}
		return true;
	}
}
