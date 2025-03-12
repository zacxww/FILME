package dao.filme;

import entity.filme.Filme;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class FilmeDAO implements Serializable {

  private static final long serialVersionUID = 1L;

  private EntityManager manager;

  public FilmeDAO() {}

  public FilmeDAO(EntityManager manager) {
    this.manager = manager;
  }

  public Filme porId(Long id) {
    return manager.find(Filme.class, id);
  }

  public List<Filme> pesquisar(String nome) {
    String jpql = "from FILME where NOME like :NOME";

    TypedQuery<Filme> query = manager.createQuery(jpql, Filme.class);
    query.setParameter("NOME", nome + "%");

    return query.getResultList();
  }

  public Filme guardar(Filme filme) {
    return manager.merge(filme);
  }

  public void remover(Filme filme) {
    filme = porId(filme.getId());
    manager.remove(filme);
  }
}
