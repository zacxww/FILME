package entity.filme;

import entity.genero.TipoGenero;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "FILME")
public class Filme implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "NOME")
    private String nome;

    @NotNull
    @Size(max = 255)
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_lancamento")
    private Date dataLancamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Collection<TipoGenero> generos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<TipoGenero> getGeneros() {
        return generos;
    }

    public void setGeneros(Collection<TipoGenero> generos) {
        this.generos = generos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return Objects.equals(id, filme.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                '}';
    }
}
