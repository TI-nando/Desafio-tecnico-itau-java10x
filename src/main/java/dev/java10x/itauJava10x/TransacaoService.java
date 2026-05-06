package dev.java10x.itauJava10x;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTransacao(TransacaoRequest transacaoRequest){

        // VALOR MAIOR OU IGUAL A ZERO
        if (transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0 ){
            // transacao nao e valida. Valor menor ou ibgual a zero.
            throw new IllegalArgumentException ("Erro: Isso nao e uma transacao valida, transacoes devem ter valor maior do que zero.");
        }

        // DATA MENOR OU IGUAL A DATA DE HOJE
        if (transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException ("Erro: Verificar data da Transação.");
        }

        // DATA PRESENTE (BODY NAO PODE SER VAZIO)
        // HORA PRESENTE
    }
}
