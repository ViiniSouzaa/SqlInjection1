package com.example.DAO;

import com.example.Dto.ProdutoDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Venda implements Serializable {
    
    @Id @GeneratedValue
    private int id;
    @OneToMany
    private List<ProdutoDTO> produtos;
    private double precoTotal;
}
