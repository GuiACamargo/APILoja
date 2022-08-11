package com.gft.loja.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.gft.loja.entities.Compra;
import com.gft.loja.entities.Usuario;
import com.gft.loja.repositories.CompraRepository;

@Service
public class CompraService {
	
	private final CompraRepository compraRepository;
	
	private final EstoqueService estoqueService;
	
	public CompraService(CompraRepository compraRepository, EstoqueService estoqueService) {
		this.compraRepository = compraRepository;
		this.estoqueService = estoqueService;
	}

	public Compra salvarCompra(Compra compra) {
		Usuario usuario = (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		compra.setFilial(usuario.getFilial());
		
		compra.getItens().stream().forEach(i -> estoqueService.acrescentaQuantidadeEstoque(i.getProduto().getId(), compra.getFilial().getId(), i.getQuantidade()));
		
		return compraRepository.save(compra);
	}
	
	

}
