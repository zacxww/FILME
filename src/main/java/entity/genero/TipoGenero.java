package entity.genero;

public enum TipoGenero {
    ACAO("Ação"),
    AVENTURA("Aventura"),
    COMEDIA("Comédia"),
    CRIME("Crime"),
    DOCUMENTARIO("Documentário"),
    DRAMA("Drama"),
    FANTASIA("Fantasia"),
    FICCAO_CIENTIFICA("Ficção Científica"),
    MUSICAL("Musical"),
    ROMANCE("Romance"),
    SUSPENSE("Suspense"),
    TERROR("Terror");

    private String label;

    TipoGenero(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
