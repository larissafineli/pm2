package pm_prova2;

public enum Status {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
