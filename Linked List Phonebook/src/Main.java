import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int Choice = 0;
		// Create a new PhoneBook object
		PhoneBook Contacts = new PhoneBook();
		// Initialize a Scanner object named 'input' to handle user input.
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Linked Tree Phonebook!");

		// Display menu and handle user choices until the user chooses to exit (Choice =8).
		do {

			System.out.println("Please choose an option: ");
			System.out.println("1. Add a contact\r\n" + "2. Search for a contact\r\n" + "3. Delete a contact\r\n"
					+ "4. Schedule an event\r\n" + "5. Print event details\r\n" + "6. Print contacts by first name\r\n"
					+ "7. Print all events alphabetically\r\n" + "8. Exit\r\n");
			System.out.print("Enter your choice:");
			try {
				Choice = scanner.nextInt();
				if (Choice > 8 || Choice < 1) {
					System.out.println("Invalid number. Please Only enter a number from 1 to 8.");
					System.out.println();
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please only enter numbers from 1 to 8.");
				System.out.println();
				scanner.nextLine();
			}

			// Handle user's choice with switch cases.
			switch (Choice) {
			case 1:
				System.out.println();
				Contacts.AddContact();
				break;
			case 2:
				System.out.println();
				try {
					Contacts.SearchContact();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input");
					System.out.println();
				}
				break;
			case 3:
				System.out.println();
				Contacts.DeleteContact();
				break;
			case 4:
				System.out.println();
				Contacts.ScheduleEvent();
				break;
			case 5:
				System.out.println();
				try {
					Contacts.PrintEventDetails();
				} catch (Exception e) {
					System.out.println("Invalid input");
					System.out.println();
				}
				break;
			case 6:
				try {
					System.out.println();
					Contacts.PrintContactsByFirstName();
				} catch (StringIndexOutOfBoundsException e) {
				}
				
				break;
			case 7:
				System.out.println();
				Contacts.PrintEventsAlphabetically();
				System.out.println();
				break;
			}
		} while (Choice != 8);
		// Exit the loop and the program.
		System.out.println("GoodBye!");
	}

}
