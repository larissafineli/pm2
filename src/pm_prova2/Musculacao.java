package pm_prova2;

public class Musculacao extends Atividade {

    private int quantidadeAparelhos;

    public Musculacao(String nome, int duracaoAula, int quantidadeMaximaParticipantes,
                      double valorMensal, StatusAtividade status, int quantidadeAparelhos) {
        super(nome, duracaoAula, quantidadeMaximaParticipantes, valorMensal, status);
        this.quantidadeAparelhos = quantidadeAparelhos;
    }

    public int getQuantidadeAparelhos() {
        return quantidadeAparelhos;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Musculação - " + getNome()
                + " | Duração: " + getDuracaoAula() + " min"
                + " | Máx. participantes: " + getQuantidadeMaximaParticipantes()
                + " | R$ " + String.format("%.2f", getValorMensal())
                + " | " + getStatus()
                + " | Aparelhos: " + quantidadeAparelhos);
    }

    @Override
    public boolean atividadeColetiva() {
        return false;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
