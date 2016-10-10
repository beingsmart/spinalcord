package events;

/**
 * Created by sarath on 24/09/16.
 */
public enum EventType {
    UNIQUE_PARKING_LOCATIONS("UNIQUE_PARKING_LOCATIONS"),
    USER_ACTIVITY("user_activity"),
    PARKING("DEETS"),
    VACATING("DEETS"),
    AD_CLICK("DEETS"),
    APP_OPEN("DEETS");

    private final String collection;

    EventType(String type) {
        this.collection = type;
    }

    public String get() {
        return collection;
    }
}
