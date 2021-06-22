package br.com.zup.servicotransacao.domain.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransacaoRepository extends JpaRepository<Transacao, String> {
    Page<Transacao> findAllByCartaoId(Pageable pageable, String cartaoId);
}
