package br.com.zup.servicotransacao.domain.transacao;

import br.com.zup.servicotransacao.domain.cartao.CartaoResponse;
import br.com.zup.servicotransacao.domain.estabelecimento.EstabelecimentoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {
    private String id;
    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private CartaoResponse cartao;
    private LocalDateTime efetivadaEm;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
        this.cartao = new CartaoResponse(transacao.getCartao());
        this.efetivadaEm = transacao.getEfetivadoEm();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
