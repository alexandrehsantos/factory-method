package br.com.bulvee.logger.impl;

import br.com.bulvee.infraestructure.mongodb.MongoDbConnection;
import br.com.bulvee.logger.Logger;
import br.com.bulvee.logger.output.MongoDBLogOutput;
import br.com.bulvee.printer.LogOutput;
import com.mongodb.client.MongoClient;

public class LoggerMongoDB extends Logger {
    @Override
    protected LogOutput createLogger() {
        return new MongoDBLogOutput(null);
    }
}
