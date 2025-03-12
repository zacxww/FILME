package entity.genero;

public enum TipoGenero {
    ACAO("Ação"),
    COMEDIA("Comédia"),
    DRAMA("Drama"),
    FANTASIA("Fantasia"),
    ROMANCE("Romance"),
    TERROR("Terror");

    private String nomeGenero;

    TipoGenero(String nomeGenero){
        this.nomeGenero = nomeGenero;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public void setNomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }
}
