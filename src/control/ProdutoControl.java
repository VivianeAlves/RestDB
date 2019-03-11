package control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.Categoria;
import service.CategoriaService;
//TODO SessionScoped do cdi beans e Named tmb
@SessionScoped
@Named
public class ProdutoControl implements Serializable{
	private static final long serialVersionUID = -2148370829457801546L;
	
	@EJB
	private CategoriaService categoriaService;
	
	public List<Categoria> getCategorias(){
		return categoriaService.getCategorias();
	}

}
