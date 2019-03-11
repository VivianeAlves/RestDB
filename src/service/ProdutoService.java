package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Produto;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ProdutoService {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Produto> getProdutoByDescricao(String desc) {
		Query qr = em
				.createQuery("select prod from Produto prod where prod.descricao like ?1");
		qr.setParameter(1, "%" + desc + "%");
		return qr.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> getProdutoByNome(String nome) {
		Query qr = em
				.createQuery("select prod from Produto prod where prod.nome like ?1");
		qr.setParameter(1, "%" + nome + "%");
		return qr.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> getAll() {
		return em.createQuery("SELECT p FROM Produto p").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> getProdutoByCategoriaDescricao(String categoria,
			String desc) {
		Query qr = em
				.createQuery("select prod from Produto prod where prod.descricao like ?1 and prod.categoriaBean.nome =?2");
		qr.setParameter(1, "%" + desc + "%");
		qr.setParameter(2, "%" + categoria + "%");
		return qr.getResultList();
	}

}
