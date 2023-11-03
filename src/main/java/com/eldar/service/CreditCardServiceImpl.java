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
    public Optional<CreditCard> getCreditCard(Long numberCard) {
        return CreditCardRepository.findById(numberCard);
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

    @Override
    public Double getTasaByBrandAndAmount(String cardType, Double amount) {
        if ("VISA".equals(cardType)) {
            String[] parts = String.valueOf(amount).split("\\.");
            if (parts.length == 2) {
                int year = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                return (double) (year) / month;
            }
        } else if ("NARA".equals(cardType)) {
            int dayOfMonth = amount.intValue();
            return (double) (dayOfMonth) * 0.5;
        } else if ("AMEX".equals(cardType)) {
            int month = amount.intValue();
            return (double) (month) * 0.1;
        }

        return null;
    }

}
