package pm_prova2;

public class PlanoPremium extends Plano {

    public PlanoPremium(String nome, double valorMensal) {
        super(nome, valorMensal);
    }

    @Override
    public boolean permiteAtividade(Atividade atividade) {
        return true;
    }

    @Override
    protected String detalhes() {
        return "Qualquer atividade | Acesso ilimitado";
    }
}
