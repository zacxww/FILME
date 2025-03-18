package dao.genero;

import entity.filme.Filme;
import entity.genero.Genero;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class GeneroDAO implements Serializable {

    private static final long serialVersionUID = 3573251214183465317L;

    @Inject
    private EntityManager manager;

    public GeneroDAO(){}

    public GeneroDAO(EntityManager manager){
        this.manager = manager;
    }

    public Genero porId(Long id) {
        return manager.find(Genero.class, id);
    }

    public List<Genero> pesquisar(String tipoGenero) {
        String jpql = "from GENERO where TIPO_GENERO like :TIPO_GENERO";
        TypedQuery<Genero> query = manager.createQuery(jpql, Genero.class);
        query.setParameter("TIPO_GENERO", tipoGenero + "%");

        return query.getResultList();
    }

    public Genero guardar(Genero genero) {
        return manager.merge(genero);
    }

    public void remover(Genero genero) {
        genero = porId(genero.getId());
        manager.remove(genero);
    }
}
