package com.eldar.service;

import com.eldar.model.CreditCard;
import com.eldar.repository.CreditCardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class CreditCardServiceImpl implements CreditCardService{

    @Autowired
    private CreditCardRepository CreditCardRepository;

    @Override
    public Optional<CreditCard> getCreditCardByNumber(Long numberCard) {
        return CreditCardRepository.findById(numberCard);
    }

    @Override
    public CreditCard saveCreditCard(Long numberCard, String cardType, String cardHolderName, Date expirationDate) {
        return CreditCardRepository.save(new CreditCard(numberCard, cardType, cardHolderName, expirationDate));
    }

    @Override
    public Boolean isValidOperation(Double amount) {
        return amount < 1000.0;
    }

    @Override
    public Boolean isValidCreditCard(Date expirationDate) {
        Date currentDate = new Date();
        return expirationDate.after(currentDate);
    }

    @Override
    public Boolean compareCards(Long numberCard1, Long numberCard2) {
        return numberCard1.equals(numberCard2);
    }

}
