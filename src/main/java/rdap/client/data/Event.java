package rdap.client.data;

/**
 * @author dzh
 * @date 2019-03-26 20:52
 */
public class Event {

    /**
     * "eventAction" -- a string denoting the reason for the event
     */
    private String eventAction;

    /**
     * "eventActor" -- an optional identifier denoting the actor
     * responsible for the event
     */
    private String eventActor;

    /**
     * "eventDate" -- a string containing the time and date the event
     * occurred.
     */
    private String eventDate;

    public String getEventAction() {
        return eventAction;
    }

    public void setEventAction(String eventAction) {
        this.eventAction = eventAction;
    }

    public String getEventActor() {
        return eventActor;
    }

    public void setEventActor(String eventActor) {
        this.eventActor = eventActor;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
}
