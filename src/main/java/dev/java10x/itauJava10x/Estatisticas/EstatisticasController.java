package dev.java10x.itauJava10x.Estatisticas;

import dev.java10x.itauJava10x.Transacoes.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.OffsetDateTime;

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    @Autowired
    private EstatisticaProperties estatisticaProperties;

    @Autowired
    private TransacaoRepository transacaoRepository;

    // criar rota de estatistica e uma logica para trabalhar com os dados

    @GetMapping
    public ResponseEntity estatistica() {

        // Clacular quantas transacoes acontecem em N segundos
        final var horaInicial = OffsetDateTime
                .now()
                .minusSeconds(estatisticaProperties.segundos());


        return ResponseEntity.ok(transacaoRepository.estatistica(horaInicial));
    }


}