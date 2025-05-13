package system;

import java.util.*;
import model.*;
import exception.InvalidBookingException;

public class EventBookingSystem {
    private List<Attendee> attendees = new ArrayList<>();
    private List<Organizer> organizers = new ArrayList<>();
    private List<Event> events = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    public void registerUser(User user) {
        if (user instanceof Attendee) {
            attendees.add((Attendee) user);
        } else if (user instanceof Organizer) {
            organizers.add((Organizer) user);
        }
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void bookTicket(Attendee attendee, String eventTitle) throws InvalidBookingException {
        Event event = null;
        for (Event e : events) {
            if (e.getTitle().equalsIgnoreCase(eventTitle)) {
                event = e;
                break;
            }
        }

        if (event != null) {
            if (event.getAvailableTickets() > 0) {
                event.setAvailableTickets(event.getAvailableTickets() - 1);
                tickets.add(new Ticket(attendee, event, eventTitle));
                System.out.println("Booked successfully!");
            } else {
                System.out.println("No tickets available for " + eventTitle);
            }
        } else {
            throw new InvalidBookingException("Event not available");
        }
    }

    public void showEvents() {
        for (Event e : events) {
            System.out.println("Event: " + e.getTitle() + ", Tickets Available: " + e.getAvailableTickets());
        }
    }

    public Attendee findAttendeeByName(String name) {
        for (Attendee attendee : attendees) {
            if (attendee.getName().equalsIgnoreCase(name)) {
                return attendee;
            }
        }
        return null;
    }
}

