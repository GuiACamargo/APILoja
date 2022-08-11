package com.gft.loja.dto.usuario;

import com.gft.loja.dto.filial.ConsultaFilialDTO;

public class ConsultaUsuarioDTO {
	
	private String email;
	private String nomePerfil;
	private ConsultaFilialDTO filial;
	
	
	public ConsultaUsuarioDTO(String email, String nomePerfil, ConsultaFilialDTO filial) {
		this.email = email;
		this.nomePerfil = nomePerfil;
		this.filial = filial;
	}

	public ConsultaUsuarioDTO() {

	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomePerfil() {
		return nomePerfil;
	}
	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}
	public ConsultaFilialDTO getFilial() {
		return filial;
	}
	public void setFilial(ConsultaFilialDTO filial) {
		this.filial = filial;
	}
	
}
