import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        String [] candidatos = {"FELIPE", "RUAN", "PAULO", "MARIO", "PEDRO"};
        for(String candidato: candidatos) {
			entrandoEmContato(candidato);
		}
    }
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu=false;

        do{
            atendeu= atender();
			continuarTentando = !atendeu;
			if(continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("CONTATO REALIZADO COM SUCESSO");

        }while(continuarTentando && tentativasRealizadas<3);
    
        if(atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato +" NA " + tentativasRealizadas + " TENTATIVA");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato +", NÚMERO MAXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");
    
    }
        

    // metodo auxiliar
    static boolean atender() {
		return new Random().nextInt(3)==1;	
	}
    
    static void imprimirSelecionados() {
        String [] candidatos = {"FELIPE", "RUAN", "PAULO", "MARIO", "PEDRO"};
        System.out.println("Imprimindo a lista de candidatos com o índice do elemento.");

        for(int indice=0; indice < candidatos.length; indice++){
            System.out.println("O candidato de n°" + (indice+1) + "é " + candidatos[indice]);
        }
    }
    
    static void selecaoCandidatos() {
        String [] candidatos = {"FELIPE", "RUAN", "PAULO", "MARIO", "PEDRO", "BATISTA", "CASTELA", "FERREIRA", "JONES", "WALTER"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);

            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
   }
    
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato.");
        }else if(salarioBase == salarioPretendido)
            System.out.println("Ligar para o candidato com contra proposta.");
        else {
            System.out.println("Aguardando resultados dos demais candidatos.");
        }
    }

}
