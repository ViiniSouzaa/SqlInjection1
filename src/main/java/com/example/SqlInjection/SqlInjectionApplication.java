package com.example.SqlInjection;

import com.example.DAO.ProdutoDAO;
import com.example.DAO.UsuarioDAO;
import com.example.DAO.VendaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqlInjectionApplication implements CommandLineRunner{
    
    private final UsuarioDAO usuarioDAO;
    private final VendaDAO vendaDAO;
    private final ProdutoDAO produtoDAO;

    @Autowired
    public SqlInjectionApplication(UsuarioDAO usuarioDAO, VendaDAO vendaDAO, ProdutoDAO produtoDAO) {
        this.usuarioDAO = usuarioDAO;
        this.vendaDAO = vendaDAO;
        this.produtoDAO = produtoDAO;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(SqlInjectionApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        /*usuarioDAO.save(Usuario.builder()
                        .user("abc")
                        .senha("teste123")
                        .build());*/
    }

}
