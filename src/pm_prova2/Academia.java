package pm_prova2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Academia {

    private List<Atividade> atividades = new ArrayList<>();
    // cada plano mantém sua lista de atividades associadas
    private Map<Plano, List<Atividade>> planos = new LinkedHashMap<>();

    public void adicionarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public void adicionarPlano(Plano plano) {
        planos.put(plano, new ArrayList<>());
    }

    public List<Atividade> getAtividades() {
        return Collections.unmodifiableList(atividades);
    }

    public List<Plano> getPlanos() {
        return new ArrayList<>(planos.keySet());
    }

    public List<Atividade> getAtividadesDoPlano(Plano plano) {
        return Collections.unmodifiableList(planos.get(plano));
    }

    /** Retorna a mensagem de erro, ou null se a associação foi feita. */
    public String associarAtividadeAoPlano(Plano plano, Atividade atividade) {
        List<Atividade> associadas = planos.get(plano);
        if (plano.getStatus() != StatusPlano.ATIVO) {
            return "Plano não está ativo.";
        }
        if (atividade.getStatus() == StatusAtividade.INATIVA) {
            return "Atividade inativa não pode ser associada.";
        }
        if (associadas.contains(atividade)) {
            return "Atividade já associada ao plano.";
        }
        if (atividade.atividadeColetiva() && !plano.permiteAtividadeColetiva()) {
            return "Este plano não permite atividades coletivas.";
        }
        if (associadas.size() >= plano.getQuantidadeMaximaAtividades()) {
            return "Plano atingiu a quantidade máxima de atividades.";
        }
        associadas.add(atividade);
        return null;
    }

    public List<Plano> getPlanosAtivos() {
        List<Plano> ativos = new ArrayList<>();
        for (Plano p : planos.keySet()) {
            if (p.getStatus() == StatusPlano.ATIVO) {
                ativos.add(p);
            }
        }
        return ativos;
    }

    public List<Certificavel> getCertificaveis() {
        List<Certificavel> lista = new ArrayList<>();
        for (Atividade a : atividades) {
            if (a instanceof Certificavel) {
                lista.add((Certificavel) a);
            }
        }
        return lista;
    }

    /** Atividades e planos que controlam frequência. */
    public List<ControladorPresenca> getControladores() {
        List<ControladorPresenca> lista = new ArrayList<>();
        for (Atividade a : atividades) {
            if (a instanceof ControladorPresenca) {
                lista.add((ControladorPresenca) a);
            }
        }
        for (Plano p : planos.keySet()) {
            if (p instanceof ControladorPresenca) {
                lista.add((ControladorPresenca) p);
            }
        }
        return lista;
    }

    /** Remove atividades inativas do sistema e dos planos. Retorna quantas foram removidas. */
    public int removerAtividadesInativas() {
        List<Atividade> inativas = new ArrayList<>();
        for (Atividade a : atividades) {
            if (a.getStatus() == StatusAtividade.INATIVA) {
                inativas.add(a);
            }
        }
        for (List<Atividade> associadas : planos.values()) {
            associadas.removeAll(inativas);
        }
        atividades.removeAll(inativas);
        return inativas.size();
    }
}
