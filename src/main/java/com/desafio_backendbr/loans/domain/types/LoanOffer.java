package com.desafio_backendbr.loans.domain.types;

import com.desafio_backendbr.loans.domain.enums.LoanTypes;

public record LoanOffer(
        LoanTypes type,
        double interest_rate
) {

    public LoanOffer(
        LoanTypes loanType
    ){
        this(
            loanType,
            determineInterestRate(loanType)
        );
    }

    private static double determineInterestRate(
        LoanTypes loanType
    ){
        return switch (loanType){
            case PERSONAL -> 4.0;
            case GUARANTEED -> 3.0;
            case CONSIGNMENT -> 2.0;
        };
    }
}
