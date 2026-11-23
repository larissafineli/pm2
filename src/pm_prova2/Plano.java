package pm_prova2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Plano {
    private String nome;
    private double valorMensal;
    private Status status;
    private List<Atividade> atividades = new ArrayList<>();

    protected Plano(String nome, double valorMensal) {
        this.nome = nome;
        this.valorMensal = valorMensal;
        this.status = Status.ATIVO;
    }

    public String getNome() { return nome; }
    public double getValorMensal() { return valorMensal; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public boolean isAtivo() {
        return status == Status.ATIVO;
    }

    public List<Atividade> getAtividades() {
        return Collections.unmodifiableList(atividades);
    }

    /** Regra do plano: define se uma atividade pode ser associada. */
    public abstract boolean permiteAtividade(Atividade atividade);

    protected abstract String detalhes();

    public boolean associarAtividade(Atividade atividade) {
        if (!permiteAtividade(atividade) || atividades.contains(atividade)) {
            return false;
        }
        atividades.add(atividade);
        return true;
    }

    public void removerAtividade(Atividade atividade) {
        atividades.remove(atividade);
    }

    public void exibir() {
        System.out.println(getClass().getSimpleName() + " - " + nome
                + " | R$ " + String.format("%.2f", valorMensal)
                + " | " + status
                + " | " + detalhes());
        if (atividades.isEmpty()) {
            System.out.println("    (sem atividades associadas)");
        }
        for (Atividade a : atividades) {
            System.out.println("    - " + a);
        }
    }
}
