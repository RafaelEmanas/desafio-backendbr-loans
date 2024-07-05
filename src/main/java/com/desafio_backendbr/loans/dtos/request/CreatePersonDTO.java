package com.desafio_backendbr.loans.dtos.request;

import java.math.BigDecimal;

public record CreatePersonDTO(
        String age,
        String cpf,
        String name,
        BigDecimal income,
        String location
) {
}
