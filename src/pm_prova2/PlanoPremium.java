package pm_prova2;

public class PlanoPremium extends Plano {

    public PlanoPremium(String nome, double valorMensal,
                        int quantidadeMaximaAtividades, StatusPlano status) {
        super(nome, valorMensal, quantidadeMaximaAtividades, status);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Plano Premium - " + getNome()
                + " | R$ " + String.format("%.2f", getValorMensal())
                + " | Máx. atividades: " + getQuantidadeMaximaAtividades()
                + " | " + getStatus()
                + " | Qualquer atividade | Acesso ilimitado");
    }

    @Override
    public boolean permiteAtividadeColetiva() {
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
