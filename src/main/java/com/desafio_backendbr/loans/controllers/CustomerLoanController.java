package com.desafio_backendbr.loans.controllers;


import com.desafio_backendbr.loans.dtos.request.RequestLoanOptionsDTO;
import com.desafio_backendbr.loans.dtos.response.ResponseToRequestLoanOptionsDTO;
import com.desafio_backendbr.loans.sercices.CustomerLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer-loans")
public class CustomerLoanController {

    @Autowired
    CustomerLoanService customerLoanService;

    @PostMapping()
    public ResponseEntity<ResponseToRequestLoanOptionsDTO> showLoanOptions(
        @RequestBody RequestLoanOptionsDTO requestLoanOptionDto
    ){
        return customerLoanService.showAvailableLoanOffers(requestLoanOptionDto);
    }
}
