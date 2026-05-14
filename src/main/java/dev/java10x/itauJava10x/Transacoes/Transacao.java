package dev.java10x.itauJava10x.Transacoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

    private BigDecimal valor; // BigDecimal  - Usado para lidar com precisão
    private OffsetDateTime dataHora; // O OffsetDateTime e Usado para trabalhar com fuso horarios.

}
