package entity.genero;

import entity.filme.Filme;
import jakarta.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "GENERO")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_GENERO")
    private TipoGenero tipoGenero;

    @ManyToMany
    private Collection<Filme> filmes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull TipoGenero getTipoGenero() {
        return tipoGenero;
    }

    public void setTipoGenero(@NotNull TipoGenero tipoGenero) {
        this.tipoGenero = tipoGenero;
    }

    public Collection<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(Collection<Filme> filmes) {
        this.filmes = filmes;
    }
}
