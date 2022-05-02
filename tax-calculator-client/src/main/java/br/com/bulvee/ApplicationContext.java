package br.com.bulvee;

import br.com.bulvee.calculator.TaxCalculator;
import br.com.bulvee.infraestructure.mongodb.MongoDbConnection;
import br.com.bulvee.logger.Logger;
import br.com.bulvee.logger.impl.LoggerFile;
import br.com.bulvee.logger.impl.LoggerMongoDB;

public class ApplicationContext {

    public static void main(String[] args) {
        // Logger for console
        //Logger logger = new LoggerConsole();
        //Logger for file
        //Logger logger = new LoggerFile("tax-calculator");
        LoggerMongoDB loggerMongoDB = new LoggerMongoDB();
        TaxCalculator taxCalculator = new TaxCalculator(loggerMongoDB);
        taxCalculator.compute(2134);
    }
}
