package br.com.bulvee.logger.impl;

import br.com.bulvee.logger.Logger;
import br.com.bulvee.logger.output.FileLogOutput;
import br.com.bulvee.printer.LogOutput;

public class LoggerFile extends Logger {

    private String logName;

    public LoggerFile(String logName){
        this.logName = logName;
    }


    @Override
    protected LogOutput createLogger() {
        return new FileLogOutput(logName);
    }
}
