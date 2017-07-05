

public class TestaListaEncadeada {

	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		lista.append("2");
		lista.append("3");
		lista.append("4");
		lista.append("5");
		lista.append("6");
		lista.addFirst("1");
		imprime(lista);
	}

	private static void imprime(ListaEncadeada lista) {
		No iter = lista.getFirst();
		while (iter != null) {
			System.out.println("Valor: "+iter.getData());
			if (iter.hasNext()) {
				System.out.println("Valor P: "+iter.next().getData());
			}
			if (iter.hasPrevious()) {
				System.out.println("Valor A: "+iter.previous().getData());
			}
			iter = iter.next();
		}
	}

}
