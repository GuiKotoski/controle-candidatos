package candidatura;

import java.util.Random;

// Classe principal que simula um processo seletivo
public class ProcessoSeletivo {

    public static void main(String[] args) {
        // Mensagem inicial do processo
        System.out.println("Início do processo seletivo");

        // Lista de candidatos disponíveis
        String[] candidatos = {
            "Maria", "Pedro", "José", "João", "Ana",
            "Carla", "Juliana", "Paula", "Adriana", "Amanda"
        };

        // Para cada candidato, tenta realizar contato
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }

        // Executa a seleção com base na pretensão salarial
        selecaoCandidatos();

        // Imprime os candidatos selecionados
        imprimirSelecionados();
    }

    // Método que simula tentativas de contato com o candidato
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        // Tenta contato até que o candidato atenda ou sejam feitas 3 tentativas
        do {
            atendeu = atender(); // Simula se o candidato atendeu
            continuarTentando = !atendeu;

            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso");
            }
        } while (continuarTentando && tentativasRealizadas < 3);

        // Imprime o resultado da tentativa de contato
        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato +
                " em " + tentativasRealizadas + " tentativas");
        } else {
            System.out.println("Não conseguimos contato com " + candidato +
                ", número máximo de tentativas: " + tentativasRealizadas);
        }
    }

    // Método que simula se o candidato atendeu o telefone
    static boolean atender() {
        // Retorna true com probabilidade de 1/3
        return new Random().nextInt(3) == 1;
    }

    // Método que imprime os candidatos selecionados com seus índices
    static void imprimirSelecionados() {
        String[] candidatos = {"Maria", "Pedro", "José", "João", "Ana"};

        System.out.println("\nImprimindo a lista de candidatos selecionados:");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de número " + (indice + 1) +
                " é " + candidatos[indice]);
        }
    }

    // Método que realiza a seleção de candidatos com base na pretensão salarial
    static void selecaoCandidatos() {
        String[] candidatos = {
            "Maria", "Pedro", "José", "João", "Ana",
            "Carla", "Juliana", "Paula", "Adriana", "Amanda"
        };

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        // Seleciona até 5 candidatos que pedem salário dentro do orçamento
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido(); // Corrigido aqui

            System.out.println("\nO candidato " + candidato +
                " solicitou este valor de salário: R$" + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato +
                    " foi selecionado para a vaga");
                candidatosSelecionados++;
            }

            candidatosAtual++;
        }
    }

    // Método que simula o valor de salário pretendido pelo candidato
    static double valorPretendido() {
        // Gera valor entre R$1800 e R$2999
        return 1800 + new Random().nextInt(1200);
    }

    // Método que analisa se o salário pretendido está dentro do orçamento
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para candidato com contra proposta");
        } else {
            System.out.println("Aguardar o resultado dos demais candidatos");
        }
    }
}
