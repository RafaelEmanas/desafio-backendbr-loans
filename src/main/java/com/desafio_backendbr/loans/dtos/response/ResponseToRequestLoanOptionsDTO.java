package com.desafio_backendbr.loans.dtos.response;

import com.desafio_backendbr.loans.domain.enums.LoanTypes;
import com.desafio_backendbr.loans.domain.types.LoanOffer;
import com.desafio_backendbr.loans.dtos.request.RequestLoanOptionsDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record ResponseToRequestLoanOptionsDTO(
    String customer,
    List<LoanOffer> loans
) {

    public ResponseToRequestLoanOptionsDTO(
        RequestLoanOptionsDTO requestLoanOptionsDto
    ){
        this(
            requestLoanOptionsDto.name(),
            createLoanOffers(requestLoanOptionsDto)
        );
    }

    private static final BigDecimal INCOME_THRESHOLD_1 = new BigDecimal("3000");
    private static final BigDecimal INCOME_THRESHOLD_2 = new BigDecimal("5000");
    private static final String LOCATION_SP = "SP";

    //define loan possibilities
    private static List<LoanOffer> createLoanOffers(
        RequestLoanOptionsDTO requestLoanOptionsDTO
    ){

        Set<LoanOffer> loanOfferSet = new HashSet<>();

        BigDecimal income = requestLoanOptionsDTO.income();
        int age = requestLoanOptionsDTO.age();
        String location = requestLoanOptionsDTO.location();

        LoanOffer guaranteedLoanOffer = new LoanOffer(LoanTypes.GUARANTEED);
        LoanOffer personalLoanOffer = new LoanOffer(LoanTypes.PERSONAL);
        LoanOffer consignmentLoanOffer = new LoanOffer(LoanTypes.CONSIGNMENT);

        //income <= 3000
        if(
            income.compareTo(INCOME_THRESHOLD_1) <= 0
        ){
            loanOfferSet.add(personalLoanOffer);
            loanOfferSet.add(guaranteedLoanOffer);
        }

        // 3000 < income < 5000, age < 30, lives in são paulo
        if(
            income.compareTo(INCOME_THRESHOLD_1) > 0 &&
            income.compareTo(INCOME_THRESHOLD_2) < 0 &&
            age < 30 &&
            location.equals(LOCATION_SP)
        ){
            loanOfferSet.add(personalLoanOffer);
            loanOfferSet.add(guaranteedLoanOffer);
        }

        //income >= 5000
        if(
            income.compareTo(INCOME_THRESHOLD_2) >= 0
        ){
            loanOfferSet.add(consignmentLoanOffer);
        }

        return new ArrayList<>(loanOfferSet);
    }
}
