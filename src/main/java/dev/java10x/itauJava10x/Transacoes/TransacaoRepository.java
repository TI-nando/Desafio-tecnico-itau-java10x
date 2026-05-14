package dev.java10x.itauJava10x.Transacoes;

import dev.java10x.itauJava10x.Estatisticas.EstatisticaDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoRequest> listaDeTransacoes = new ArrayList<>();

    // salvar os dados em uma lista
    public void salvarDados(TransacaoRequest transacaoRequest) {
        listaDeTransacoes.add(transacaoRequest);
    }

    // APAGAR ESSA LISTA DEPOIS DE 60 SEGUNDOS
    public void limparDados(TransacaoRequest transacaoRequest) {
    }

    // APAGAR TODOAS AS TRANSAÇOES DA LISTA
    public void deletarDados() {
        listaDeTransacoes.clear();
    }

    // GERAR ESTATISTICAS
    public EstatisticaDTO estatistica (OffsetDateTime horaInicial) {

        if (listaDeTransacoes.isEmpty()) {
            return new EstatisticaDTO(0, 0.0, 0.0, 0.0, 0.0);
        }

        // TRANSFORMAR A LISTA DE TRANSACOES EM NUMEROS PARA FAZER UMA OPERACAO
        final var summary = listaDeTransacoes.stream()
                .filter(t ->
                        t.getDataHora().isAfter(horaInicial) || t.getDataHora().isEqual(horaInicial)
                )
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();

        return new EstatisticaDTO(
                summary.getCount(),
                summary.getAverage(),
                summary.getMax(),
                summary.getMin(),
                summary.getSum());

    }

}

