package br.com.aobfilho.controllers;

import br.com.aobfilho.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo){

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) {
        if (!isNumeric(strNumber)) throw new UnsupportedMathOperationException("Please set a number");
        var number = strNumber.replace(",",".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if ((strNumber == null) || strNumber.isEmpty()) return false;
        var number = strNumber.replace(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
