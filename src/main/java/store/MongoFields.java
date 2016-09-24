package store;

/**
 * Created by Sarath on 27/1/16.
 * Fields and Simple json structures that could be used to query MongoDB
 */
public class MongoFields {
    /**
     * Simple Key,value structure like {ping:1}
     */
    public static final String SIMPLE_KEY_VALUE = "{%s:#}";

    /**
     * loc field
     */
    public static final String LOC = "loc";
    public static final String _2D_SPHERE =  "{loc:\"2dsphere\"}";

    public static final String PARKED_NOW = "parked_now";

}
