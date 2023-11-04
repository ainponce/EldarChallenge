package com.eldar.controller;

import com.eldar.model.CreditCard;
import com.eldar.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Optional;

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

    /*Valida que el monto sea menor 1000*/
    @GetMapping("/validarOperacion")
    public ResponseEntity<Boolean> isValidOperation(
            @RequestParam("monto") Double amount
    ) {
        Boolean result = creditCardService.isValidOperation(amount);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*Se obtiene por ID no por numero de tarjeta*/
    @GetMapping("/obtenerTarjeta")
    public ResponseEntity<Object> getCreditCard(@RequestParam("numeroTarjeta") Long numberCard) {
        Optional<CreditCard> optionalCreditCard = creditCardService.getCreditCardByNumber(numberCard);

        if (optionalCreditCard.isPresent()) {
            CreditCard creditCard = optionalCreditCard.get();
            return ResponseEntity.ok(creditCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*Valida que la expirationDate de la tarjeta no sea mayor a la fecha actual*/
    @GetMapping("/validarTarjeta/{id}")
    public ResponseEntity<Boolean> isValidCreditCard(@RequestParam("fechaExpiracion") String fechaExpiracion) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date expirationDate = dateFormat.parse(fechaExpiracion);

            Boolean result = creditCardService.isValidCreditCard(expirationDate);

            if (result != null) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (ParseException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    /*Calcula la taza con las fechas de hoy*/
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

    /*Compara si 2 numeros de tarjeta son iguales*/
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

    /*Podemos agregar tarjetas a la base de datos*/
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
