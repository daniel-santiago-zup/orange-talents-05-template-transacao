package br.com.zup.servicotransacao.listenersKafka;

import br.com.zup.servicotransacao.eventosKafka.EventoTransacao;
import br.com.zup.servicotransacao.domain.transacao.Transacao;
import br.com.zup.servicotransacao.domain.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerTransacao {

    @Autowired
    public TransacaoRepository transacaoRepository;

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoTransacao eventoTransacao) {
        System.out.println(eventoTransacao.toString());
        Transacao transacao = eventoTransacao.converte();
        transacaoRepository.save(transacao);
    }
}
