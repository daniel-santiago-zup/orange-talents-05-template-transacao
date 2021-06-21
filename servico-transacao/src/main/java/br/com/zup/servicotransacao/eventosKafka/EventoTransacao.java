package br.com.zup.servicotransacao.eventosKafka;

import br.com.zup.servicotransacao.domain.cartao.Cartao;
import br.com.zup.servicotransacao.domain.estabelecimento.Estabelecimento;
import br.com.zup.servicotransacao.domain.transacao.Transacao;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoTransacao {

    @NotBlank
    private String id;
    @Positive
    private BigDecimal valor;
    @NotNull
    private EstabelecimentoEventoTransacao estabelecimento;
    @NotNull
    private CartaoEventoTransacao cartao;
    @NotNull
    private LocalDateTime efetivadaEm;

    public EventoTransacao(@JsonProperty("id") String id,
                           @JsonProperty("valor") BigDecimal valor,
                           @JsonProperty("estabelecimento") EstabelecimentoEventoTransacao estabelecimento,
                           @JsonProperty("cartao") CartaoEventoTransacao cartao,
                           @JsonProperty("efetivadaEm") LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    @Override
    public String toString() {
        return "EventoTransacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimentoEventoTransacao=" + estabelecimento +
                ", cartaoEventoTransacao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }

    private static class EstabelecimentoEventoTransacao {
        @NotBlank
        private String nome;
        @NotBlank
        private String cidade;
        @NotBlank
        private String endereco;

        public EstabelecimentoEventoTransacao(@JsonProperty("nome") String nome,
                                              @JsonProperty("cidade") String cidade,
                                              @JsonProperty("endereco") String endereco) {
            this.nome = nome;
            this.cidade = cidade;
            this.endereco = endereco;
        }

        @Override
        public String toString() {
            return "EstabelecimentoEventoTransacao{\n" +
                    "nome='" + nome + '\'' +
                    ", cidade='" + cidade + '\'' +
                    ", endereco='" + endereco + "' \n" +
                    "}\n";
        }

        @Validated
        public Estabelecimento converte() {
            return new Estabelecimento(this.nome,this.cidade,this.endereco);
        }
    }

    private static class CartaoEventoTransacao {
        @NotBlank
        private String id;
        @NotBlank
        private String email;

        @Deprecated
        public CartaoEventoTransacao() {}

        public CartaoEventoTransacao(@JsonProperty("id") String id,
                                     @JsonProperty("email") String email) {
            this.id = id;
            this.email = email;
        }

        @Override
        public String toString() {
            return "CartaoEventoTransacao{\n" +
                    "id='" + id + '\'' +
                    ", email='" + email + "'\n" +
                    "}\n";
        }

        @Validated
        public Cartao converte() {
            return new Cartao(this.id,this.email);
        }

    }

    @Validated
    public Transacao converte() {
        return new Transacao(this.id,this.valor,this.estabelecimento.converte(),this.cartao.converte(), this.efetivadaEm);
    }
}
