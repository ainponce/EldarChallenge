package com.eldar.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_card")
    @NotBlank
    private Long numberCard;

    @Column(name = "card_type")
    @NotBlank
    private String cardType;

    @Column(name = "card_holder_name")
    @NotBlank
    private String cardHolderName;

    @Column(name = "expiration_date")
    @Future
    private Date expirationDate;

    @Transient
    private Double tasa;

    public CreditCard(Long numberCard, String cardType, String cardHolderName, Date expirationDate) {
        this.numberCard = numberCard;
        this.cardType = cardType;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
    }

    public CreditCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(Long numberCard) {
        this.numberCard = numberCard;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Double getTasa() {
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear() % 100;

        if ("VISA".equals(cardType)) {
            int month = currentDate.getMonthValue();
            return (double) (year / month) % 100;
        } else if ("NARA".equals(cardType)) {
            int dayOfMonth = currentDate.getDayOfMonth();
            return (double) dayOfMonth * 0.5;
        } else if ("AMEX".equals(cardType)) {
            int month = currentDate.getMonthValue();
            return (double) month * 0.1;
        } else {
            return null;
        }
    }


}
