package facade;

import dao.filme.FilmeDAO;
import entity.filme.Filme;
import util.Transacional;

import javax.inject.Inject;
import java.io.Serializable;

public class CadastroFilmeServiceBean implements Serializable {

  private static final long serialVersionUID = -905670798272933719L;

  @Inject
  private FilmeDAO filmeDAO;

  @Transacional
  public void salvar(Filme filme) {
    filmeDAO.guardar(filme);
  }

  @Transacional
  public void excluir(Filme filme) {
    filmeDAO.remover(filme);
  }

}
