package com.br.diogenes.pelando.repository;

import com.br.diogenes.pelando.model.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Integer > {

}
