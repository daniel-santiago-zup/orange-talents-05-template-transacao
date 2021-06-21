package br.com.zup.servicotransacao.domain.transacao;

import br.com.zup.servicotransacao.domain.cartao.Cartao;
import br.com.zup.servicotransacao.domain.estabelecimento.Estabelecimento;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {
    @Id
    private String id;
    @Positive
    private BigDecimal valor;
    @ManyToOne(cascade = CascadeType.MERGE)
    @NotNull
    private Estabelecimento estabelecimento;
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;
    @NotNull
    private LocalDateTime efetivadoEm;

    @Deprecated
    public Transacao() {}

    public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadoEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadoEm = efetivadoEm;
    }
}
