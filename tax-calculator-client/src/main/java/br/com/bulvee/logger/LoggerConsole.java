package br.com.bulvee.logger;

import br.com.bulvee.printer.LogOutput;

public class LoggerConsole extends Logger {



    @Override
    protected LogOutput createLogger() {
        ConsoleLogOutput consoleLogOutput = new ConsoleLogOutput();
        return consoleLogOutput;
    }
}
