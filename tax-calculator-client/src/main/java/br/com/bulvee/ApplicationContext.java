package br.com.bulvee;

import br.com.bulvee.calculator.TaxCalculator;
import br.com.bulvee.logger.Logger;
import br.com.bulvee.logger.LoggerConsole;

public class ApplicationContext {

    public static void main(String[] args) {
        Logger logger = new LoggerConsole();
        TaxCalculator taxCalculator = new TaxCalculator(logger);

        taxCalculator.compute(2134);
    }
}
