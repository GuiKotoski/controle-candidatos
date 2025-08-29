package candidatura;


public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Início do processo seletivo");    
    }

    static void selecaoCandidatos() {
        String [] candidatos = {"Maria", "Pedro", "José", "João", "Ana", "Carla", "Juliana", "Paula", "Adriana", "Amanda"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
        }
        candidatosAtual++;
    }
    static void analisarCandidato(double salarioPretendido){ 
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido){
            System.out.println("Ligar para candidato com contra proposta");
        } else {
            System.out.println("Aguardar o resultado dos demais candidatos");
        }
    }
}
