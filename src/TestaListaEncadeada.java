public class TestaListaEncadeada {

	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		
		System.out.println("LISTA");
		lista.append("2");
		lista.append("3");
		lista.append("4");
		lista.append("5");
		lista.append("6");
		lista.addFirst("1");
		imprime(lista);
		
		System.out.println("===============================");
		System.out.println("LISTA COM INSERT ANTES E DEPOIS");
		
		Iterador iter = lista.iterador();
		for (int i = 0; i < 3; i++) {
			iter.next();
		}
		iter.insertBefore("Antes do 4");
		iter.insertAfter("Depois do 4");
		imprime(lista);
		
		System.out.println("===============================");
		System.out.println("LISTA AO CONTRARIO");
		
		imprimeContrario(lista);
		
		System.out.println("===============================");
		System.out.println("LISTA COM DELETE");
		
		lista.remove("3");
		imprime(lista);
	}
	private static void imprime(ListaEncadeada lista) {
		try {
			Iterador iter = lista.iterador();
			while (iter.hasNext()) {
				System.out.println(iter.next());
			}
			System.out.println(iter.next());
		} catch (Exception e) {
			System.out.println("OPS! Nenhum item adicionado na lista");
		}
	}
	private static void imprimeContrario(ListaEncadeada lista){
		try {
			Iterador iter = lista.getLast();
			while (iter.hasPrevious()) {
				System.out.println(iter.previous());
			}
			System.out.println(iter.previous());
		} catch (Exception e) {
			System.out.println("OPS! Nenhum item adicionado na lista");
		}
	}
}