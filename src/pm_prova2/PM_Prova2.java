package pm_prova2;

import java.util.List;
import java.util.Scanner;

public class PM_Prova2 {

    private static final Scanner sc = new Scanner(System.in);
    private static final Academia academia = new Academia();

    public static void main(String[] args) {
        carregarDadosIniciais();
        int op;
        do {
            exibirMenu();
            op = lerInt("Opção: ");
            switch (op) {
                case 1: associarAtividade(); break;
                case 2: listarAtividades(); break;
                case 3: listarPlanos(academia.getPlanos()); break;
                case 4: listarPlanos(academia.getPlanosAtivos()); break;
                case 5: emitirCertificado(); break;
                case 6: registrarPresenca(); break;
                case 7:
                    int n = academia.removerAtividadesInativas();
                    System.out.println(n + " atividade(s) inativa(s) removida(s).");
                    break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (op != 0);
    }

    private static void carregarDadosIniciais() {
        Atividade musc = new Musculacao("Musculação Manhã", "07:00", 60, 20, 15);
        Atividade nat = new Natacao("Natação Iniciante", "09:00", 45, 10, 1.5);
        Atividade spin = new Spinning("Spinning Noite", "19:00", 50, 12, 12);
        spin.setStatus(Status.INATIVO);
        academia.adicionarAtividade(musc);
        academia.adicionarAtividade(nat);
        academia.adicionarAtividade(spin);

        academia.adicionarPlano(new PlanoBasico("Básico", 89.90));
        academia.adicionarPlano(new PlanoPremium("Premium", 199.90));
    }

    private static void exibirMenu() {
        System.out.println("\n===== ACADEMIA =====");
        System.out.println("1 - Associar atividade a um plano");
        System.out.println("2 - Exibir atividades");
        System.out.println("3 - Exibir planos");
        System.out.println("4 - Exibir planos ativos");
        System.out.println("5 - Emitir certificado");
        System.out.println("6 - Registrar presença");
        System.out.println("7 - Remover atividades inativas");
        System.out.println("0 - Sair");
    }

    private static void associarAtividade() {
        List<Plano> planos = academia.getPlanos();
        List<Atividade> atividades = academia.getAtividades();
        if (planos.isEmpty() || atividades.isEmpty()) {
            System.out.println("Cadastre planos e atividades primeiro.");
            return;
        }
        for (int i = 0; i < planos.size(); i++) {
            System.out.println((i + 1) + " - " + planos.get(i).getNome());
        }
        int ip = lerInt("Plano: ") - 1;
        for (int i = 0; i < atividades.size(); i++) {
            System.out.println((i + 1) + " - " + atividades.get(i));
        }
        int ia = lerInt("Atividade: ") - 1;
        if (ip < 0 || ip >= planos.size() || ia < 0 || ia >= atividades.size()) {
            System.out.println("Seleção inválida.");
            return;
        }
        if (academia.associarAtividadeAoPlano(planos.get(ip), atividades.get(ia))) {
            System.out.println("Atividade associada com sucesso.");
        } else {
            System.out.println("Não foi possível associar (plano não permite ou já associada).");
        }
    }

    private static void listarAtividades() {
        if (academia.getAtividades().isEmpty()) {
            System.out.println("Nenhuma atividade cadastrada.");
        }
        for (Atividade a : academia.getAtividades()) a.exibir();
    }

    private static void listarPlanos(List<Plano> planos) {
        if (planos.isEmpty()) {
            System.out.println("Nenhum plano encontrado.");
        }
        for (Plano p : planos) p.exibir();
    }

    private static void emitirCertificado() {
        List<Certificavel> lista = academia.getCertificaveis();
        if (lista.isEmpty()) {
            System.out.println("Nenhuma atividade certificável.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + " - " + lista.get(i));
        }
        int i = lerInt("Escolha: ") - 1;
        if (i < 0 || i >= lista.size()) {
            System.out.println("Seleção inválida.");
            return;
        }
        System.out.print("Nome do participante: ");
        lista.get(i).emitirCertificado(sc.nextLine());
    }

    private static void registrarPresenca() {
        List<ControladorPresenca> lista = academia.getControladores();
        if (lista.isEmpty()) {
            System.out.println("Nada com controle de frequência.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            Object o = lista.get(i);
            String tipo = (o instanceof Plano) ? "Plano " : "Atividade ";
            String nome = (o instanceof Plano) ? ((Plano) o).getNome() : o.toString();
            System.out.println((i + 1) + " - " + tipo + nome);
        }
        int i = lerInt("Escolha: ") - 1;
        if (i < 0 || i >= lista.size()) {
            System.out.println("Seleção inválida.");
            return;
        }
        System.out.print("Nome do participante: ");
        lista.get(i).registrarPresenca(sc.nextLine());
    }

    private static int lerInt(String msg) {
        System.out.print(msg);
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
