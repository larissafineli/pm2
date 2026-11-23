package pm_prova2;

import java.util.ArrayList;
import java.util.List;

public class Natacao extends Atividade implements Certificavel, ControladorPresenca {

    private double profundidadePiscina;
    private List<String> presencas = new ArrayList<>();

    public Natacao(String nome, int duracaoAula, int quantidadeMaximaParticipantes,
                   double valorMensal, StatusAtividade status, double profundidadePiscina) {
        super(nome, duracaoAula, quantidadeMaximaParticipantes, valorMensal, status);
        this.profundidadePiscina = profundidadePiscina;
    }

    public double getProfundidadePiscina() {
        return profundidadePiscina;
    }

    @Override
    public void emitirCertificado(String nomeParticipante) {
        System.out.println("Certificado emitido: " + nomeParticipante
                + " concluiu a atividade de natação \"" + getNome() + "\".");
    }

    @Override
    public void registrarPresenca(String nomeParticipante) {
        if (getStatus() != StatusAtividade.ATIVA) {
            System.out.println("Atividade " + getStatus() + ". Presença não registrada.");
            return;
        }
        presencas.add(nomeParticipante);
        System.out.println("Presença de " + nomeParticipante + " registrada em " + getNome() + ".");
        if (presencas.size() >= getQuantidadeMaximaParticipantes()) {
            setStatus(StatusAtividade.LOTADA);
        }
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Natação - " + getNome()
                + " | Duração: " + getDuracaoAula() + " min"
                + " | Máx. participantes: " + getQuantidadeMaximaParticipantes()
                + " | R$ " + String.format("%.2f", getValorMensal())
                + " | " + getStatus()
                + " | Profundidade: " + profundidadePiscina + " m"
                + " | Certificado: sim"
                + " | Presenças: " + presencas.size());
    }

    @Override
    public boolean atividadeColetiva() {
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
