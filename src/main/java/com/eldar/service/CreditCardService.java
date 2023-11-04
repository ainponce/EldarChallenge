package com.eldar.service;

import com.eldar.model.CreditCard;

import java.util.Date;
import java.util.Optional;

public interface CreditCardService {

    Optional<CreditCard> getCreditCard(Long numberCard);
    CreditCard saveCreditCard(Long numberCard, String cardType, String cardHolderName, Date expirationDate, Double tasa);
    Boolean isValidOperation(Double amount);
    Boolean isValidCreditCard(Date expirationDate);
    Boolean compareCards(Long numberCard1, Long numberCard2);
    Double getTasaByBrandAndAmount(String cardType, Double amount);

}
