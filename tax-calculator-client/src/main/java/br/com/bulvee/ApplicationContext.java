package br.com.bulvee;

import br.com.bulvee.calculator.TaxCalculator;
import br.com.bulvee.logger.Logger;
import br.com.bulvee.logger.LoggerConsole;
import br.com.bulvee.logger.LoggerFile;

public class ApplicationContext {

    public static void main(String[] args) {
        // Logger for console
        //Logger logger = new LoggerConsole();
        Logger logger = new LoggerFile("tax-calculator");

        TaxCalculator taxCalculator = new TaxCalculator(logger);
        taxCalculator.compute(2134);

    }
}
