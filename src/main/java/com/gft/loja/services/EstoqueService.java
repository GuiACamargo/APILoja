package com.gft.loja.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gft.loja.entities.Estoque;
import com.gft.loja.entities.Filial;
import com.gft.loja.entities.Produto;
import com.gft.loja.repositories.EstoqueRepository;

@Service
public class EstoqueService {

	private final EstoqueRepository estoqueRepository;

	public EstoqueService(EstoqueRepository estoqueRepository) {
		this.estoqueRepository = estoqueRepository;
	}
	
	public Integer acrescentaQuantidadeEstoque(Long produtoId, Long filialId, Integer quantidade) {
		
		Optional<Estoque> estoqueOp = estoqueRepository.findByProduto_IdAndFilial_Id(produtoId, filialId);
		
		if(estoqueOp.isPresent()) {
			Estoque estoque = estoqueOp.get();
			estoque.setQuantidade(estoque.getQuantidade() + quantidade);
			
			return estoqueRepository.save(estoque).getQuantidade();
		}
		
		Estoque estoque = new Estoque();
		estoque.setProduto(new Produto(produtoId));
		estoque.setFilial(new Filial(filialId));
		estoque.setQuantidade(quantidade);
		
		return estoqueRepository.save(estoque).getQuantidade();
	}
	
}
