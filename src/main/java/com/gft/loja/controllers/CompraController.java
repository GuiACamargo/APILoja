package com.gft.loja.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.loja.dto.compra.RegistroCompraDTO;
import com.gft.loja.entities.Compra;
import com.gft.loja.entities.Fornecedor;
import com.gft.loja.entities.ItemCompra;
import com.gft.loja.entities.Produto;
import com.gft.loja.services.CompraService;

@RestController
@RequestMapping("v1/compras")
public class CompraController {

	private final CompraService compraService;

	public CompraController(CompraService compraService) {
		this.compraService = compraService;
	}
	
	@PostMapping
	public Compra salvarCompra(@RequestBody RegistroCompraDTO dto) {
		List<ItemCompra> listaItens = dto.getItens().stream().map(i -> new ItemCompra(null, new Produto(i.getProdutoId()), i.getQuantidade(), i.getValor())).collect(Collectors.toList());
		
		Compra compra = new Compra(null, null, new Fornecedor(dto.getFornecedorId()), listaItens);
		
		return compraService.salvarCompra(compra);
	}
	
}
