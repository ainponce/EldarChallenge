package com.eldar.controller;
import com.eldar.model.CreditCard;
import com.eldar.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/creditcard")
public class CreditCardController {

    private final CreditCardService creditCardService;

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("/tasa")
    public ResponseEntity<Double> getTasaOperacion(
            @RequestParam("marca") String cardType
    ) {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardType(cardType);

        Double tasa = creditCard.getTasa();

        if (tasa != null) {
            return ResponseEntity.ok(tasa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/compararTarjetas")
    public ResponseEntity<Boolean> compareCards(
            @RequestParam("numeroTarjeta1") Long numberCard1,
            @RequestParam("numeroTarjeta2") Long numberCard2
    ) {
        Boolean result = creditCardService.compareCards(numberCard1, numberCard2);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/agregarTarjeta")
    public ResponseEntity<CreditCard> saveCreditCard(@RequestBody CreditCard creditCardRequest) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = creditCardRequest.getExpirationDate();

        CreditCard savedCreditCard = creditCardService.saveCreditCard(
                creditCardRequest.getNumberCard(),
                creditCardRequest.getCardType(),
                creditCardRequest.getCardHolderName(),
                date
        );

        if (savedCreditCard != null) {
            return ResponseEntity.ok(savedCreditCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
