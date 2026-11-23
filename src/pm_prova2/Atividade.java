package pm_prova2;

public abstract class Atividade {
    private String nome;
    private String horario;
    private int duracaoMinutos;
    private int maxParticipantes;
    private Status status;
    private Modalidade modalidade;

    protected Atividade(String nome, String horario, int duracaoMinutos,
                        int maxParticipantes, Modalidade modalidade) {
        this.nome = nome;
        this.horario = horario;
        this.duracaoMinutos = duracaoMinutos;
        this.maxParticipantes = maxParticipantes;
        this.modalidade = modalidade;
        this.status = Status.ATIVO;
    }

    public String getNome() { return nome; }
    public String getHorario() { return horario; }
    public int getDuracaoMinutos() { return duracaoMinutos; }
    public int getMaxParticipantes() { return maxParticipantes; }
    public Status getStatus() { return status; }
    public Modalidade getModalidade() { return modalidade; }

    public void setStatus(Status status) { this.status = status; }

    public boolean isAtiva() {
        return status == Status.ATIVO;
    }

    /** Detalhes específicos de cada tipo de atividade. */
    protected abstract String detalhes();

    public void exibir() {
        System.out.println(getClass().getSimpleName() + " - " + nome
                + " | Horário: " + horario
                + " | Duração: " + duracaoMinutos + " min"
                + " | Máx. participantes: " + maxParticipantes
                + " | " + modalidade
                + " | " + status
                + " | " + detalhes());
    }

    @Override
    public String toString() {
        return nome + " (" + horario + ")";
    }
}
