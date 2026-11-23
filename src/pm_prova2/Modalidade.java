package pm_prova2;

public enum Modalidade {
    INDIVIDUAL("Individual"),
    COLETIVA("Coletiva");

    private final String descricao;

    Modalidade(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
