package com.eldar.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "creditCard")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numberCard;

    @Column(name = "cardType")
    private String cardType;

    @Column(name = "cardHolderName")
    private String cardHolderName;

    @Column(name = "expirationDate")
    private Date expirationDate;

    @Column(name = "tasa")
    private Double tasa;

    public CreditCard(Long numberCard, String cardType, String cardHolderName, Date expirationDate, Double tasa) {
        this.numberCard = numberCard;
        this.cardType = cardType;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.tasa = tasa;
    }

    public CreditCard() {
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
        return tasa;
    }

    public void setTasa(Double tasa) {
        this.tasa = tasa;
    }
}
