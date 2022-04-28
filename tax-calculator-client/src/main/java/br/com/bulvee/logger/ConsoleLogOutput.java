package br.com.bulvee.logger;

import br.com.bulvee.printer.LogOutput;

public class ConsoleLogOutput implements LogOutput {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
