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
		
		No iter = lista.getFirst();
		for (int i = 0; i < 3; i++) {
			iter = iter.next();
		}
		iter.insertBefore(new No("Antes do 4"));
		iter.insertAfter(new No("Depois do 4"));
		imprime(lista);
		
		System.out.println("===============================");
		System.out.println("LISTA AO CONTRARIO");
		
		imprimeContrario(lista);	
	}
	private static void imprime(ListaEncadeada lista) {
		No iter = lista.getFirst();
		while (iter != null) {
			System.out.println("Valor: "+iter.getData());
			iter = iter.next();
		}
	}
	private static void imprimeContrario(ListaEncadeada lista){
		No iter = lista.getLast();
		while (iter != null) {
			System.out.println("Valor: "+iter.getData());
			iter = iter.previous();
		}
	}
}