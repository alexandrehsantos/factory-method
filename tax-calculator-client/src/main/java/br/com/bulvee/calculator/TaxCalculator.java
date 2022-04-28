package br.com.bulvee.calculator;

import br.com.bulvee.logger.Logger;

import java.util.Random;

public class TaxCalculator {

    private Logger logger;

    public TaxCalculator(Logger logger){
        this.logger = logger;
    }

    public void compute(double value){
        //Simulate de program compute

        Random random= new Random();

        double tax = random.nextDouble();

        logger.info("Tax calculated for the value $ " + value);
    }

}
