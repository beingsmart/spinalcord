package store;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import io.dropwizard.lifecycle.Managed;
import io.dropwizard.setup.Environment;
import org.jongo.Jongo;

import java.io.IOException;

/**
 * Created by sharath on 26/1/16.
 *
 * Generic Class to initialize a mongo com.park.store given the MongoClientURI
 */
public class GenericMongoStore {

    /**
     * Mongo URL to connect.
     * Example: mongodb://userName:password@hsot:port/dbName
     */
    @JsonProperty("mongoURL")
    private String mongoURL;
    /**
     * MongoClientURI formed out of #mongoURL
     */
    private final MongoClientURI mongoURI;

    /**
     * MongoClient
     */
    private final MongoClient mongo;

    public GenericMongoStore(String mongoURL) throws IOException {

        this.mongoURL = mongoURL.replace("OPENSHIFT_MONGODB_DB_HOST", System.getProperty("OPENSHIFT_MONGODB_DB_HOST"))
                .replace("OPENSHIFT_MONGODB_DB_PORT", System.getProperty("OPENSHIFT_MONGODB_DB_PORT"));
        this.mongoURI = new MongoClientURI(this.mongoURL);
        this.mongo = new MongoClient(mongoURI);
    }

    public GenericMongoStore() throws IOException {
        this("mongodb://admin:3dJ-b35LBuqC@"
                + System.getenv("OPENSHIFT_MONGODB_DB_HOST")
                + ":" + System.getenv("OPENSHIFT_MONGODB_DB_PORT")
                + "/spaces");
    }

    /**
     * Builds jongo object with the db specified in the config.
     *
     * @param environment Dropwizard Environment
     * @return jongo Jongo object created out of @this
     * @see Jongo
     */
    public Jongo build(Environment environment) {
        final Jongo jongo = createJongo();
        environment.lifecycle().manage(new Managed() {
            @Override
            public void start() {
              /*  Set<String> collectionNames = new DB(mongo, mongoURI.getDatabase()).getCollectionNames();
                collectionNames.remove("system.indexes");
                collectionNames.remove("objectlabs-system");
                for (String collName : collectionNames) {
                    jongo.getCollection(collName).ensureIndex(MongoFields._2D_SPHERE);
                }*/
                jongo.getCollection(MongoFields.PARKED_NOW).ensureIndex("{\"user_id\": 1}", "{unique: true}");
            }

            @Override
            public void stop() {
                mongo.close();
            }
        });
        return jongo;
    }

    public Jongo createJongo() {
        DB mongoDB = new DB(mongo, mongoURI.getDatabase());
        return new Jongo(mongoDB);
    }

    public void closeMongo() {
        mongo.close();
    }

    @Override
    public String toString() {
        return mongoURL;
    }

}
