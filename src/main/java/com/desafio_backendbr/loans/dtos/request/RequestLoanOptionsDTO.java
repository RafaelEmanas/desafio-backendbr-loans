package com.desafio_backendbr.loans.dtos.request;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public record RequestLoanOptionsDTO(
        @NotNull
        Integer age,

        @NotNull
        @CPF
        String cpf,

        @NotNull
        String name,

        @NotNull
        BigDecimal income,

        @NotNull
        String location
) {
}