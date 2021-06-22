package br.com.zup.servicotransacao.domain.estabelecimento;

public class EstabelecimentoResponse {
    private Long id;
    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoResponse(Estabelecimento estabelecimento) {
        this.id = estabelecimento.getId();
        this.nome = estabelecimento.getNome();
        this.cidade = estabelecimento.getCidade();
        this.endereco = estabelecimento.getEndereco();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
