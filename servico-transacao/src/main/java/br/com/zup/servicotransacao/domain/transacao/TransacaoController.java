package br.com.zup.servicotransacao.domain.transacao;

import br.com.zup.servicotransacao.domain.cartao.Cartao;
import br.com.zup.servicotransacao.domain.cartao.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    TransacaoRepository transacaoRepository;
    @Autowired
    CartaoRepository cartaoRepository;

    @GetMapping("/{cartaoId}")
    public ResponseEntity<?> listaTransacao(@PathVariable String cartaoId, @PageableDefault Pageable pageable) {
        Optional<Cartao> optionalCartao = cartaoRepository.findById(cartaoId);
        if (optionalCartao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transacaoRepository.findAllByCartaoId(pageable, cartaoId).map(TransacaoResponse::new));
    }
}
