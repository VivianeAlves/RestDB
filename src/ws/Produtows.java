package ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import model.Produto;
import service.ProdutoService;

@Path("produtoService")
public class Produtows {
	@Context
	private UriInfo context;

	@EJB
	private ProdutoService produtoService;

	public Produtows() {
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public List<Produto> returnAll() {
		return produtoService.getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{categoria}/{descricao}")
	public List<Produto> getProdutoByDescricao(
			@PathParam("categoria") String categoria,
			@PathParam("descricao") String descricao) {

		if (categoria != null && !categoria.equalsIgnoreCase("todas")) {
			return produtoService.getProdutoByCategoriaDescricao(categoria,
					descricao);
		} else {
			return produtoService.getProdutoByDescricao(descricao);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/porNome/{nome}")
	public List<Produto> porNome(@PathParam("nome") String nome) {
		return produtoService.getProdutoByNome(nome);
	}

	@PUT
	@Consumes("application/json")
	public void putJson(String content) {
	}

}