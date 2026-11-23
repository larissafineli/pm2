package pm_prova2;

import java.util.ArrayList;
import java.util.List;

public class Spinning extends Atividade implements ControladorPresenca {

    private int quantidadeBicicletas;
    private List<String> presencas = new ArrayList<>();

    public Spinning(String nome, int duracaoAula, int quantidadeMaximaParticipantes,
                    double valorMensal, StatusAtividade status, int quantidadeBicicletas) {
        super(nome, duracaoAula, quantidadeMaximaParticipantes, valorMensal, status);
        this.quantidadeBicicletas = quantidadeBicicletas;
    }

    public int getQuantidadeBicicletas() {
        return quantidadeBicicletas;
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
        System.out.println("Spinning - " + getNome()
                + " | Duração: " + getDuracaoAula() + " min"
                + " | Máx. participantes: " + getQuantidadeMaximaParticipantes()
                + " | R$ " + String.format("%.2f", getValorMensal())
                + " | " + getStatus()
                + " | Bicicletas: " + quantidadeBicicletas
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
