import java.util.Scanner;

public class ArrayOrdenado {

	public static void main(String[] args) {

		Scanner entradaNum = new Scanner(System.in);

		int tamanhoVetor1;
		int tamanhoVetor2;

		System.out.println("\tSistema de registro de números\n");

		System.out.println("Informe quantos números serão adicionados no primeiro vetor: ");
		tamanhoVetor1 = entradaNum.nextInt();

		System.out.println("Informe quantos números serão adicionados no segundo vetor: ");
		tamanhoVetor2 = entradaNum.nextInt();

		int vetor1[] = new int[tamanhoVetor1];
		int vetor2[] = new int[tamanhoVetor2];
		int vetorFinal[] = new int[tamanhoVetor1 + tamanhoVetor2];

		for (int i = 0; i < vetor1.length; i++) {
			System.out.printf("Informe o %dº número para ser adicionado no primeiro vetor: ", i + 1);
			vetor1[i] = entradaNum.nextInt();
		}

		for (int i = 0; i < vetor2.length; i++) {
			System.out.printf("Informe o %dº número para ser adicionado no segundo vetor: ", i + 1);
			vetor2[i] = entradaNum.nextInt();
		}

		for (int i = 0; i < vetor1.length; i++) {
			vetorFinal[i] = vetor1[i];
		}

		for (int i = vetor1.length, j = 0; i < vetorFinal.length; i++, j++) {
			vetorFinal[i] = vetor2[j];
		}

		for (int i = 0; i < vetorFinal.length; i++) {
			for (int j = 0; j < vetorFinal.length - 1; j++) {
				if (vetorFinal[i] < vetorFinal[j]) {
					int aux = vetorFinal[i];
					vetorFinal[i] = vetorFinal[j];
					vetorFinal[j] = aux;
				}
			}
		}

		System.out.println("<-------------------------- Resultado -------------------------->");

		for (int i = 0; i < vetorFinal.length; i++) {
			System.out.println("Posição " + i + " = "+ vetorFinal[i]);
		}
	}

}
