package pm_prova2;

import java.util.ArrayList;
import java.util.List;

public class Academia {
    private List<Atividade> atividades = new ArrayList<>();
    private List<Plano> planos = new ArrayList<>();

    public void adicionarAtividade(Atividade a) { atividades.add(a); }
    public void adicionarPlano(Plano p) { planos.add(p); }

    public List<Atividade> getAtividades() { return atividades; }
    public List<Plano> getPlanos() { return planos; }

    public boolean associarAtividadeAoPlano(Plano plano, Atividade atividade) {
        return plano.associarAtividade(atividade);
    }

    public List<Plano> getPlanosAtivos() {
        List<Plano> ativos = new ArrayList<>();
        for (Plano p : planos) {
            if (p.isAtivo()) ativos.add(p);
        }
        return ativos;
    }

    public List<Certificavel> getCertificaveis() {
        List<Certificavel> lista = new ArrayList<>();
        for (Atividade a : atividades) {
            if (a instanceof Certificavel) lista.add((Certificavel) a);
        }
        return lista;
    }

    /** Atividades e planos que controlam frequência. */
    public List<ControladorPresenca> getControladores() {
        List<ControladorPresenca> lista = new ArrayList<>();
        for (Atividade a : atividades) {
            if (a instanceof ControladorPresenca) lista.add((ControladorPresenca) a);
        }
        for (Plano p : planos) {
            if (p instanceof ControladorPresenca) lista.add((ControladorPresenca) p);
        }
        return lista;
    }

    /** Remove atividades inativas do sistema (e dos planos). Retorna quantas foram removidas. */
    public int removerAtividadesInativas() {
        List<Atividade> inativas = new ArrayList<>();
        for (Atividade a : atividades) {
            if (!a.isAtiva()) inativas.add(a);
        }
        for (Atividade a : inativas) {
            for (Plano p : planos) p.removerAtividade(a);
        }
        atividades.removeAll(inativas);
        return inativas.size();
    }
}
