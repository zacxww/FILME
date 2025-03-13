package entity.genero;

public enum TipoGenero {
    ACAO("Ação"),
    COMEDIA("Comédia"),
    DRAMA("Drama"),
    FANTASIA("Fantasia"),
    ROMANCE("Romance"),
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
