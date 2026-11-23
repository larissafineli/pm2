package pm_prova2;

public class Musculacao extends Atividade {
    private int quantidadeAparelhos;

    public Musculacao(String nome, String horario, int duracaoMinutos,
                      int maxParticipantes, int quantidadeAparelhos) {
        super(nome, horario, duracaoMinutos, maxParticipantes, Modalidade.INDIVIDUAL);
        this.quantidadeAparelhos = quantidadeAparelhos;
    }

    public int getQuantidadeAparelhos() { return quantidadeAparelhos; }

    @Override
    protected String detalhes() {
        return "Aparelhos: " + quantidadeAparelhos;
    }
}
