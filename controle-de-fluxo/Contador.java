import java.util.Scanner;

public class Contador {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o primeiro parâmetro: ");
		int parametroUm = scanner.nextInt();
		System.out.print("Digite o segundo parâmetro: ");
		int parametroDois = scanner.nextInt();
		
		try {
			//chamando o método contendo a lógica de contagem
			contar(parametroUm, parametroDois);
		
		}catch (ParametrosInvalidosException exception) {
			System.out.println("O segundo parâmetro deve ser maior que o primeiro");
		}
		
	}
	static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
		//validar se parametroUm é MAIOR que parametroDois e lançar a exceção
		int contagem = parametroDois - parametroUm;
		
		if (contagem < 0) {
			throw new ParametrosInvalidosException("Não foi possivel realizar a contagem, o segundo parâmetro deve ser maior que o primeiro!");
		}
		//realizar o for para imprimir os números com base na variável contagem
		for(int i = 0; i <= contagem; i++){
			System.out.println(i);
		}
	}
}