package model;

import java.util.Iterator;
import java.util.List;

public class Admin extends User{
	public Admin(String id, String name) {
		super(id,name);
	}
	public void removeEvent(List<Event> events, String title) {
        Iterator<Event> iterator = events.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getTitle().equals(title)) {
                iterator.remove();
                System.out.println("Event removed: " + title);
                break;
            }
        }
    }
	@Override
    public void showProfile() {
        System.out.println("Admin ID: " + id + ", Name: " + name);
    }
}


