package com.desafio_backendbr.loans.sercices;


import com.desafio_backendbr.loans.dtos.request.RequestLoanOptionsDTO;
import com.desafio_backendbr.loans.dtos.response.ResponseToRequestLoanOptionsDTO;
import com.desafio_backendbr.loans.models.CustomerModel;
import com.desafio_backendbr.loans.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerLoanService {

    @Autowired
    CustomerRepository customerRepository;

    public ResponseEntity<ResponseToRequestLoanOptionsDTO> showAvailableLoanOffers(
        RequestLoanOptionsDTO requestLoanOptionsDto
    ){
        //checking if this customer is already registered in the DB
        Optional<CustomerModel> customerFromRequest = customerRepository.findByCpf(requestLoanOptionsDto.cpf());
        //if the user isn't registered, register
        if(customerFromRequest.isEmpty()){
             CustomerModel customerModel = new CustomerModel(
                 requestLoanOptionsDto.cpf(),
                 requestLoanOptionsDto.age(),
                 requestLoanOptionsDto.name(),
                 requestLoanOptionsDto.income(),
                 requestLoanOptionsDto.location()
             );
            customerRepository.save(customerModel);
        }

        ResponseToRequestLoanOptionsDTO respToReqLoanOptionsDto = new ResponseToRequestLoanOptionsDTO(requestLoanOptionsDto);

        return ResponseEntity.status(HttpStatus.OK).body(respToReqLoanOptionsDto);
    }
}
