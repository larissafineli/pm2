package pm_prova2;

import java.util.ArrayList;
import java.util.List;

public class Natacao extends Atividade implements Certificavel, ControladorPresenca {
    private double profundidadePiscina;
    private List<String> presencas = new ArrayList<>();

    public Natacao(String nome, String horario, int duracaoMinutos,
                   int maxParticipantes, double profundidadePiscina) {
        super(nome, horario, duracaoMinutos, maxParticipantes, Modalidade.COLETIVA);
        this.profundidadePiscina = profundidadePiscina;
    }

    public double getProfundidadePiscina() { return profundidadePiscina; }

    @Override
    public void emitirCertificado(String nomeParticipante) {
        System.out.println("Certificado emitido: " + nomeParticipante
                + " concluiu a atividade de natação \"" + getNome() + "\".");
    }

    @Override
    public void registrarPresenca(String nomeParticipante) {
        if (presencas.size() >= getMaxParticipantes()) {
            System.out.println("Turma lotada. Presença não registrada.");
            return;
        }
        presencas.add(nomeParticipante);
        System.out.println("Presença de " + nomeParticipante + " registrada em " + getNome() + ".");
    }

    @Override
    protected String detalhes() {
        return "Profundidade: " + profundidadePiscina + " m | Certificado: sim | Presenças: " + presencas.size();
    }
}
