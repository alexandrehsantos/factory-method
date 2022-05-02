package br.com.bulvee.logger.impl;

import br.com.bulvee.logger.Logger;
import br.com.bulvee.logger.output.ConsoleLogOutput;
import br.com.bulvee.printer.LogOutput;

public class LoggerConsole extends Logger {

    @Override
    protected LogOutput createLogger() {
        ConsoleLogOutput consoleLogOutput = new ConsoleLogOutput();
        return consoleLogOutput;
    }
}
