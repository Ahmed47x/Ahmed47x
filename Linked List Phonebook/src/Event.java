public class Event {

	private String EventTitle;
	private String Date;
	private String Time;
	private String Location;
	private String Name;

    // Constructor to initialize event details
	public Event(String eventTitle, String name, String date, String time, String location) {
		EventTitle = eventTitle;
		Date = date;
		Time = time;
		Location = location;
		Name = name;
	}

	// Getter and Setter
	public String getEventTitle() {
		return EventTitle;
	}

	public void setEventTitle(String eventTitle) {
		EventTitle = eventTitle;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	// Display the event's information
	public void display() {
		System.out.println();
		System.out.println("The Event title is " + EventTitle);
		System.out.println("The Contact is " + Name);
		System.out.println("The Event date is " + Date);
		System.out.println("The Event time is " + Time);
		System.out.println("The Event location is " + Location);
		System.out.println();

	}

}
