package com.eldar.service;

import com.eldar.model.CreditCard;

import java.util.Date;
import java.util.Optional;

public interface CreditCardService {

    Optional<CreditCard> getCreditCardByNumber(Long numberCard);
    CreditCard saveCreditCard(Long numberCard, String cardType, String cardHolderName, Date expirationDate);
    Boolean isValidOperation(Double amount);
    Boolean isValidCreditCard(Date expirationDate);
    Boolean compareCards(Long numberCard1, Long numberCard2);

}
