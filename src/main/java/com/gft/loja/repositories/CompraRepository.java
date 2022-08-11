package com.gft.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.loja.entities.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

}
