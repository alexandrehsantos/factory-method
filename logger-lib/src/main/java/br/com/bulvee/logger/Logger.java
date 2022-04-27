package br.com.bulvee.logger;

import br.com.bulvee.printer.LogPrinter;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Logger {

    public static final String SPACE_SEPARATOR = " ";
    public static final String DASH = "-";

    protected abstract LogPrinter createLogger();

    private static final String DEBUG = "DEBUG";
    private static final String INFO = "DEBUG";
    private static final String WARN = "DEBUG";
    private static final String ERROR = "DEBUG";
    private static final String FATAL = "DEBUG";
    private static final String TRACE = "DEBUG";
    private static final String OFF = "DEBUG";

    public void debug(String message){this.log(this.DEBUG  + SPACE_SEPARATOR + message);};
    public void info(String message){this.log(this.INFO  + SPACE_SEPARATOR + message);};
    public void warn(String message){this.log(this.WARN  + SPACE_SEPARATOR + message);};
    public void error(String message){this.log(this.ERROR  + SPACE_SEPARATOR + message);};
    public void fatal(String message){this.log(this.FATAL  + SPACE_SEPARATOR + message);};
    public void trace(String message){this.log(this.TRACE  + SPACE_SEPARATOR + message);};
    public void off(String message){this.log(this.OFF  + SPACE_SEPARATOR + message);};

    private void log(String message) {
        StringBuilder logMesssage = new StringBuilder();

        logMesssage.append(LocalTime.now());
        logMesssage.append(SPACE_SEPARATOR);
        logMesssage.append(SPACE_SEPARATOR);
        logMesssage.append(LocalDate.now());
        logMesssage.append(SPACE_SEPARATOR);
        logMesssage.append(DASH);
        logMesssage.append(SPACE_SEPARATOR);
        logMesssage.append(message);
        System.out.println(logMesssage.toString());

        this.createLogger().print(message);
    }
}