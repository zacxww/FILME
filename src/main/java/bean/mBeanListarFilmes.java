package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleSelectEvent;
import org.primefaces.event.UnselectEvent;

import entity.filme.Filme;
import entity.genero.TipoGenero;

@Named
@SessionScoped
public class mBeanListarFilmes implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Filme filme = new Filme();
	private List<Filme> filmes = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		Filme filme1 = new Filme();
		filme1.setId(1L);
		filme1.setNome("Interestelar");
		filme1.setDiretor("Christopher Nolan");
		filme1.setAno(2014);
		filme1.setSinopse("Em um futuro próximo, a Terra está cada vez mais inabitável. Um grupo de astronautas é enviado para explorar um buraco de minhoca recém-descoberto em busca de um planeta habitável para a humanidade.");
		filme1.setPosterUrl("https://image.tmdb.org/t/p/w500/nrSaXF39nDfAAeLKksRCyvSzI2a.jpg");
		List<TipoGenero> generos1 = new ArrayList<>();
		generos1.add(TipoGenero.FICCAO_CIENTIFICA);
		generos1.add(TipoGenero.DRAMA);
		filme1.setGeneros(generos1);
		filmes.add(filme1);
		
		Filme filme2 = new Filme();
		filme2.setId(2L);
		filme2.setNome("Parasita");
		filme2.setDiretor("Bong Joon-ho");
		filme2.setAno(2019);
		filme2.setSinopse("Uma família pobre engana uma família rica para conseguir empregos em sua mansão, mas um incidente inesperado ameaça expor seu esquema.");
		filme2.setPosterUrl("https://image.tmdb.org/t/p/w500/igw938inb6Fy0YVcwIyxQ7Lu5FO.jpg");
		List<TipoGenero> generos2 = new ArrayList<>();
		generos2.add(TipoGenero.DRAMA);
		generos2.add(TipoGenero.COMEDIA);
		filme2.setGeneros(generos2);
		filmes.add(filme2);
	}
	
	public void salvar() {
		try {
			// Validação extra para o ano
			if (filme.getAno() != null) {
				Integer ano = filme.getAno();
				if (ano < 1900 || ano > 2100) {
					FacesContext.getCurrentInstance().addMessage("filmeForm:ano", 
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "O ano deve estar entre 1900 e 2100"));
					return;
				}
			}
		
			if (filme.getId() == null) {
				filme.setId(generateId());
				filmes.add(filme);
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Filme adicionado com sucesso!"));
			} else {
				for (int i = 0; i < filmes.size(); i++) {
					if (filmes.get(i).getId().equals(filme.getId())) {
						filmes.set(i, filme);
						break;
					}
				}
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Filme atualizado com sucesso!"));
			}
			
			limpar();
		} catch (NumberFormatException e) {
			FacesContext.getCurrentInstance().addMessage("filmeForm:ano", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Por favor, insira um número inteiro válido para o ano"));
		}
	}
	
	public void limpar() {
		filme = new Filme();
	}
	
	public void editar(Filme filme) {
		this.filme = new Filme();
		this.filme.setId(filme.getId());
		this.filme.setNome(filme.getNome());
		this.filme.setDescricao(filme.getDescricao());
		this.filme.setDiretor(filme.getDiretor());
		this.filme.setAno(filme.getAno());
		this.filme.setSinopse(filme.getSinopse());
		this.filme.setPosterUrl(filme.getPosterUrl());
		this.filme.setGeneros(filme.getGeneros());
	}
	
	public void excluir(Filme filme) {
		filmes.removeIf(f -> f.getId().equals(filme.getId()));
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Filme excluído", "O filme foi removido com sucesso."));
	}
	
	private Long generateId() {
		return Long.valueOf(filmes.size() + 1);
	}
	
	public TipoGenero[] getTiposGenero() {
		return TipoGenero.values();
	}
	
	public Filme getFilme() {
		return filme;
	}
	
	public List<Filme> getFilmes() {
		return filmes;
	}
	
    public void onToggleSelect(ToggleSelectEvent event) {
        FacesMessage msg = new FacesMessage();
        msg.setSummary("Todos os gêneros " + (event.isSelected() ? "selecionados" : "desmarcados"));
        msg.setSeverity(FacesMessage.SEVERITY_INFO);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onItemSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage();
        msg.setSummary("Gênero adicionado: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onItemUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage();
        msg.setSummary("Gênero removido: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
