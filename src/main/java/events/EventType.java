package events;

/**
 * Created by sarath on 24/09/16.
 */
public enum EventType {
    UNIQUE_PARKING_LOCATIONS("unique_parking_locations"),
    USER_ACTIVITY("user_activity"),
    DEETS("deets");

    private final String type;

    EventType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
