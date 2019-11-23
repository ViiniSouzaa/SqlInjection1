package com.example.servico;

import com.example.DAO.Venda;
import com.example.DAO.VendaDAO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServicoVenda {
    private List<Venda> vendas;
    private final VendaDAO vendaDAO;

    @Autowired
    public ServicoVenda(VendaDAO vendaDAO) {
        this.vendaDAO = vendaDAO;
        this.vendas = this.vendaDAO.findAll();
    }
    
    @GetMapping("/servico/venda")
    public ResponseEntity<List<Venda>> listar(){
        return ResponseEntity.ok(vendas);
    }
    
    @GetMapping ("/servico/venda/{id}")
    public ResponseEntity<Venda> listarPorId(@PathVariable int id) {
        Optional<Venda> vendaEncontrada = vendas.stream().filter(p -> p.getId() == id).findAny();
        return ResponseEntity.of(vendaEncontrada);
    }

    @PostMapping ("/servico/venda")
    public ResponseEntity<Venda> criar (@RequestBody Venda venda) {

        vendaDAO.save(venda);
        
        return ResponseEntity.status(201).body(venda);
    }

    @DeleteMapping ("/servico/venda/{id}")
    public ResponseEntity excluir (@PathVariable long id) {
        
        if (vendas.stream().filter(v -> v.getId() == id).findAny().isPresent()){
            vendaDAO.deleteById(id);
            return ResponseEntity.notFound().build();
        }
        else
            return ResponseEntity.noContent().build();
    }
}
