import java.util.concurrent.ThreadLocalRandom;
import java.text.DecimalFormat;
import java.util.Random;

public class ProcessoSeletivo {
    public static void main(String[] args) throws InterruptedException {
        String [] candidatos = {"Armando", "Bernadette", "Cauan", "Dexter", "Emmanuel"};
        double [] salarios = new double[candidatos.length];

        System.out.println("<------------ CANDIDATOS ------------->");
        selecaoCandidatos(candidatos, salarios);
        System.out.println();
        System.out.println("<-- INICIANDO ANALISE DE CANDIDATOS -->");
        telefoneCandidato(analisarCandidato(candidatos, salarios));
    }

    static void telefoneCandidato(String [] aprovados) throws InterruptedException {
        int quantidadeTentativa = 1; 
        boolean atendeu = atender();
        for(int i = 0; i <= aprovados.length; i++){
            // não deixa o codigo exibir candidatos nulls
            if (aprovados[i] != null) {
                do {
                    System.out.println("Ligando para "+aprovados[i]+"...");
                    Thread.sleep(1000);// pausa o comando por 0.5s
                    if (!atendeu) {
                        quantidadeTentativa ++;
                        atendeu = atender();
                        System.out.println("Chamada não atendida!");
                    } 
                } while(quantidadeTentativa <= 3 && atendeu == false);
                if (atendeu) {
                    System.out.println("Entramos em contato!");
                }
                else {
                    System.out.println("Não conseguimos entrar em contato!");
                }
                System.out.println();
                quantidadeTentativa = 0;
            }
        }
    }

    // verifica se o candidato irá atender o telefone
    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static void selecaoCandidatos(String[] candidatos, double[] salarios ){
        // formata o salario double em apenas 2 casas depois do .
        DecimalFormat df = new DecimalFormat("#,##0.00");

          // adciona o salario pretendido para os demais candidatos
        for (int i = 0; i < candidatos.length; i++) {
            salarios[i] = salarioPretendido();
        }
        
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("Candidato n°"+ i +": "+ candidatos[i] + "       | Salário pretendido: R$"+ df.format( salarios[i]));
        }
    }
    // Gera um valor de salario pretendido aleatorio para o candidato
    static double salarioPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static String[] analisarCandidato(String[] candidatos, double[] salario){
        int salarioBase = 2000;
        int index = 0;
        String[] aprovados = new String[candidatos.length];
        for (int i = 0; i < salario.length; i++) {
            if (salario[i] <= salarioBase) 
            {
                System.out.println("O candidato aprovado foi: "+ candidatos[i]);
                aprovados[index++] = candidatos[i];
            }
            else 
            {
                System.out.println("O candidato desaprovado foi: "+ candidatos[i]);
            }
        } return aprovados;
    }
}