package com.br.diogenes.pelando.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Promocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String titulo;
    private String imagem;
    private Double preco;
    private String descricao;
    private String Url;
    @Basic(optional = false)
    @Column(name = "LastTouched", insertable = false, updatable = false)
    private Instant lastAdd;
}
