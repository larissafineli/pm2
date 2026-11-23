package pm_prova2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PlanoBasico extends Plano implements ControladorPresenca {

    // cliente -> data do último acesso (limite de 1 acesso ao dia)
    private Map<String, LocalDate> acessos = new HashMap<>();

    public PlanoBasico(String nome, double valorMensal,
                       int quantidadeMaximaAtividades, StatusPlano status) {
        super(nome, valorMensal, quantidadeMaximaAtividades, status);
    }

    @Override
    public void registrarPresenca(String nomeCliente) {
        LocalDate hoje = LocalDate.now();
        if (hoje.equals(acessos.get(nomeCliente))) {
            System.out.println("Acesso negado: " + nomeCliente
                    + " já utilizou o acesso diário do plano " + getNome() + ".");
            return;
        }
        acessos.put(nomeCliente, hoje);
        System.out.println("Acesso de " + nomeCliente + " registrado no plano " + getNome() + ".");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Plano Básico - " + getNome()
                + " | R$ " + String.format("%.2f", getValorMensal())
                + " | Máx. atividades: " + getQuantidadeMaximaAtividades()
                + " | " + getStatus()
                + " | Apenas atividades individuais | 1 acesso/dia (com controle de frequência)");
    }

    @Override
    public boolean permiteAtividadeColetiva() {
        return false;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
