import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class Pessoa {

	private int idade;
	private String sexo;

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String toString() {
		return "\nidade: " + idade + "\nsexo: " + sexo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(idade, other.idade);
	}
	

}

public class CalculoIdade {

	public static void main(String[] args) {

		Scanner entraNum = new Scanner(System.in);
		Scanner entraStr = new Scanner(System.in);
		
		Pessoa mulherMaisVelha, mulherMaisNova, homemMaisVelho, homemMaisNovo;

		List<Pessoa> listaFeminina = new ArrayList<>();
		List<Pessoa> listaMasculina = new ArrayList<>();
		int cont = 0;

		System.out.println("\tBem vindo ao cadastro de pessoas e soma das idades!");

		do {
			Pessoa pessoa = new Pessoa();

			System.out.println("Informe o sexo da " + (cont + 1) +"ª pessoa, sendo --> Feminino ou Masculino: ");
			pessoa.setSexo(entraStr.nextLine());
			while (!pessoa.getSexo().equalsIgnoreCase("masculino") && !pessoa.getSexo().equalsIgnoreCase("feminino")) {
				System.out.println("Informação inválida, gentileza digite Feminino ou Masculino!");
				pessoa.setSexo(entraStr.nextLine());
			}
			if (pessoa.getSexo().equalsIgnoreCase("feminino") && listaFeminina.size() == 2) {
				while (pessoa.getSexo().equalsIgnoreCase("feminino")) {
					System.out.println("Só pode ser cadastrado 2 pessoas do sexo Feminino, gentileza cadastrar uma pessoa do sexo Masculino!");
					System.out.println("Informe o sexo da pessoa, sendo --> Feminino ou Masculino: ");
					pessoa.setSexo(entraStr.nextLine());
					while (!pessoa.getSexo().equalsIgnoreCase("masculino")
							&& !pessoa.getSexo().equalsIgnoreCase("feminino")) {
						System.out.println("Informação inválida, gentileza digite Feminino ou Masculino!");
						pessoa.setSexo(entraStr.nextLine());
					}
				}
			}else if (pessoa.getSexo().equalsIgnoreCase("masculino") && listaMasculina.size() == 2){
				while (pessoa.getSexo().equalsIgnoreCase("masculino")) {
					System.out.println("Só pode ser cadastrado 2 pessoas do sexo Masculino, gentileza cadastrar uma pessoa do sexo Feminino!");
					System.out.println("Informe o sexo da pessoa, sendo --> Feminino ou Masculino: ");
					pessoa.setSexo(entraStr.nextLine());
					while (!pessoa.getSexo().equalsIgnoreCase("masculino")
							&& !pessoa.getSexo().equalsIgnoreCase("feminino")) {
						System.out.println("Informação inválida, gentileza digite Feminino ou Masculino!");
						pessoa.setSexo(entraStr.nextLine());
					}
				}
			}
			
			System.out.println("Informe a idade da " + (cont + 1) + "ª pessoa : "); 	
			pessoa.setIdade(entraNum.nextInt());
			while(pessoa.getIdade() < 0 || pessoa.getIdade() > 125 ) {
				System.out.println("Idade informada inválida, gentileza digitar uma idade entre 0 à 125 anos!");
				pessoa.setIdade(entraNum.nextInt());
			}
			if(!listaFeminina.isEmpty() && pessoa.getSexo().equalsIgnoreCase("feminino")) {
				while(listaFeminina.stream().allMatch(item -> item.getIdade() == pessoa.getIdade())) {
					System.out.println("A idade das mulheres não pode ser repetida, gentileza informar outra idade!");
					pessoa.setIdade(entraNum.nextInt());
				}
			}else if(!listaMasculina.isEmpty() && pessoa.getSexo().equalsIgnoreCase("masculino")) {
				while(listaMasculina.stream().allMatch(item -> item.getIdade() == pessoa.getIdade())) {
					System.out.println("A idade dos homens não pode ser repetida, gentileza informar outra idade!");
					pessoa.setIdade(entraNum.nextInt());
				}
			}

			if (pessoa.getSexo().equalsIgnoreCase("feminino")) {
				listaFeminina.add(pessoa);
			} else {
				listaMasculina.add(pessoa);
			}

			cont++;
		} while (cont < 4);
		
		mulherMaisVelha = listaFeminina.stream().max(Comparator.comparing(Pessoa::getIdade)).orElseThrow();
		mulherMaisNova = listaFeminina.stream().min(Comparator.comparing(Pessoa::getIdade)).orElseThrow();
		homemMaisVelho = listaMasculina.stream().max(Comparator.comparing(Pessoa::getIdade)).orElseThrow();
		homemMaisNovo = listaMasculina.stream().min(Comparator.comparing(Pessoa::getIdade)).orElseThrow();
		
		System.out.println("A idade da mulher mais velha é de: " + mulherMaisVelha.getIdade());
		System.out.println("A idade da mulher mais nova é de: " + mulherMaisNova.getIdade());
		System.out.println("A idade do homem mais velho é de: " + homemMaisVelho.getIdade());
		System.out.println("A idade do homem mais novo é de: " + homemMaisNovo.getIdade());
		
		System.out.println("\nO resultado da soma entre a idade do homem mais velho e da mulher mais nova é de: "
		+ soma(homemMaisVelho.getIdade(),mulherMaisNova.getIdade()));
		
		System.out.println("O resultado da multiplicação entre a idade do homem mais novo e da mulher mais velha é de: "
				+ multiplicacao(homemMaisNovo.getIdade(), mulherMaisVelha.getIdade()));
	}
	
	public static int soma(int num1, int num2) {
		return num1 + num2;
	}

	public static int multiplicacao(int num1, int num2) {
		return num1 * num2;
	}
}
