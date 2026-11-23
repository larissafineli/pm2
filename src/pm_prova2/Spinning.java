package pm_prova2;

import java.util.ArrayList;
import java.util.List;

public class Spinning extends Atividade implements ControladorPresenca {
    private int quantidadeBicicletas;
    private List<String> presencas = new ArrayList<>();

    public Spinning(String nome, String horario, int duracaoMinutos,
                    int maxParticipantes, int quantidadeBicicletas) {
        super(nome, horario, duracaoMinutos, maxParticipantes, Modalidade.COLETIVA);
        this.quantidadeBicicletas = quantidadeBicicletas;
    }

    public int getQuantidadeBicicletas() { return quantidadeBicicletas; }

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
        return "Bicicletas: " + quantidadeBicicletas + " | Presenças: " + presencas.size();
    }
}
