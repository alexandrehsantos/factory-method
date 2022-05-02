package br.com.bulvee.logger.output;

import br.com.bulvee.printer.LogOutput;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class FileLogOutput implements LogOutput {

    public static final String NAME_SEPARATOR = "-";
    public static final String DEFAULT_EXTENSION = ".log";
    private String logName;
    private boolean newFile;

    public FileLogOutput(String logName) {
        this.logName = logName;
    }

    @Override
    public void print(String message) {

        String applicationPath = this.getClass().getClassLoader().getResource("").getPath().split("target/classes/")[0];

        StringBuilder fileName = buildFilename();

        File file = fileCreator(applicationPath, fileName);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            if (newFile) {
                bufferedWriter.append(message);
            } else {
                bufferedWriter.newLine();
                bufferedWriter.append(message);
            }

        } catch (IOException e) {
            System.out.println("It's not possible to write in te file log see the error: " + e.toString());
        }
    }

    private File fileCreator(String applicationPath, StringBuilder fileName) {
        File file = new File(applicationPath + fileName.toString());
        isNewFile(file);
        if (newFile) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Is not possible create the new file log. See the error on creation: " + e.toString());
            }
        }
        return file;
    }

    private StringBuilder buildFilename() {

        LocalDate date = LocalDate.now();

        StringBuilder fileName = new StringBuilder();
        fileName.append(date);
        fileName.append(NAME_SEPARATOR);
        fileName.append(logName);
        fileName.append(DEFAULT_EXTENSION);
        return fileName;
    }

    private void isNewFile(File file) {
        newFile = !file.exists();
    }
}
