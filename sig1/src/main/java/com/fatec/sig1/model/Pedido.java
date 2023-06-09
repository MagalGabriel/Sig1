package com.fatec.sig1.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.br.CPF;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // manipula - lazy loadedproperties
@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // número do pedido
	@CPF
	private String cpf;
	private String dataEmissao;
	@OneToMany
	private List<ItemDePedido> itens = new ArrayList<>();

	public Pedido(String cpf) {
		this.cpf = cpf;
	}

	public Pedido() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValorTotal() {
		double soma = 0.0;
		for (ItemDePedido ip : itens) {
			soma = soma + ip.getSubTotal();
		}
		return soma;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public List<ItemDePedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemDePedido> itens) {
		this.itens = itens;
	}

	// equals e toString omitidos
}