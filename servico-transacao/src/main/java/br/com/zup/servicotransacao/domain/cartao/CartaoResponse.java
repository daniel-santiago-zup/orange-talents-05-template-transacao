package br.com.zup.servicotransacao.domain.cartao;

public class CartaoResponse {
    private String id;

    public CartaoResponse(Cartao cartao) {
        this.id = cartao.getId();
    }

    public String getId() {
        return id;
    }
}
