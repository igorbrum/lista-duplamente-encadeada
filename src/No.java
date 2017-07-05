
public class No {
	private No previous;
	private No next;
	private Object elemento;

	public No(Object elemento) {
		this.elemento = elemento;
		this.previous = null;
		this.next = null;
	}
	/*VERIFICA SE EXISTE NO APOS DESSE NO*/
	public boolean hasNext(){
    	if (this.next == null) {
			return false;
		}
    	return true;
    }
	/*VERIFICA SE EXISTE NO ANTES DESSE NO*/
	public boolean hasPrevious(){
    	if (this.previous == null) {
			return false;
		}
    	return true;
    }
	/*RETORNA PROXIMO NO*/
	public No next() {
		if (this.hasNext()) {
			return this.next;
		}
		return null;
	}
	/*RETORNA NO ANTERIOR*/
	public No previous(){
		if (this.hasPrevious()) {
			return this.previous;
		}
		return null;
	}
	/*SET PROXIMO*/
	public void setNext(No no) {
		this.next = no;
	}
	/*SET ANTERIOR*/
	public void setPrevious(No no) {
		this.previous = no;
	}
    public Object getData() {
		return this.elemento;
	}

}
