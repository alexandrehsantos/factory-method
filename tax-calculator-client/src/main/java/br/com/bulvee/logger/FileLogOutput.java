package br.com.bulvee.logger;

import br.com.bulvee.printer.LogOutput;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class FileLogOutput implements LogOutput {

    private String logName;
    private boolean newFile;

    public FileLogOutput(String logName) {
        this.logName = logName;
    }

    @Override
    public void print(String message) {

        String applicationPath = this.getClass().getClassLoader().getResource("").getPath().split("target/classes/")[0];

        StringBuilder fileName = buildFilename();

        File file = new File(applicationPath + fileName.toString());
        newFile = isNewFile(file);

        if (newFile) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Is not possible create the new file log. See the error on creation: " + e.toString());
            }
        }

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

    private StringBuilder buildFilename() {
        String nameSeparator = "-";
        String defaultExtension = ".log";

        LocalDate date = LocalDate.now();

        StringBuilder fileName = new StringBuilder();
        fileName.append(date);
        fileName.append(nameSeparator);
        fileName.append(logName);
        fileName.append(defaultExtension);
        return fileName;
    }

    private boolean isNewFile(File file) {
        return !file.exists();
    }
}
