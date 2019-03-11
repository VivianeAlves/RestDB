package model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	@Lob
	@Column(nullable = false)
	private String descricao;

	@Lob
	@XmlTransient
	private byte[] foto;

	@Column(nullable = false, length = 45)
	private String nome;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valor;

	// bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name = "categoria", nullable = false)
	@XmlTransient
	private Categoria categoriaBean;

	public Produto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Categoria getCategoriaBean() {
		return this.categoriaBean;
	}

	public void setCategoriaBean(Categoria categoriaBean) {
		this.categoriaBean = categoriaBean;
	}

}