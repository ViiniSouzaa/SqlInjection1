package com.example.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Long>{}
