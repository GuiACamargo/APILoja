package com.gft.loja.dto.filial;

import com.gft.loja.dto.endereco.EnderecoDTO;

public class RegistroFilialDTO {

	private String nome;
	private EnderecoDTO endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	
	
	
}
