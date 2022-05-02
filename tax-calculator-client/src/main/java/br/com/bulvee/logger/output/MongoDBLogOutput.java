package br.com.bulvee.logger.output;

import br.com.bulvee.printer.LogOutput;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.w3c.dom.DocumentType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MongoDBLogOutput implements LogOutput {


    private MongoClient mongoClient;

    public MongoDBLogOutput(MongoClient mongoClient){
        this.mongoClient = mongoClient;
    }

    @Override
    public void print(String message) {

        String[] fullLog = message.split(" - ");
        String dateTime = fullLog[0];
        String log = fullLog[1];


        String connectionString = System.getProperty("mongodb.uri");
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println("Showing your databases ..." + db.toJson()));

        MongoDatabase database = mongoClient.getDatabase("study_project");
        MongoCollection<Document> loggerCollection = database.getCollection("logger");
        Document logDocument = new Document("_date_time", dateTime);
            logDocument.append("message", log);
        loggerCollection.insertOne(logDocument);
        }
    }
}
