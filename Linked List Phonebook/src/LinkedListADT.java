public class LinkedListADT<T> {

	private Node<T> Head;
	private Node<T> Current;

	// Constructor to initialize the linked list
	public LinkedListADT() {
		// Initialize the Head and Current pointers to null as the list is initially
		// empty
		Head = Current = null;
	}

	public void adding(T data) {
		// Create a new Node with the provided data
		Node<T> NewNode = new Node<T>(data);

		// Check if the linked list is empty
		if (Head == null) {
			// If it's empty, set the new node as both the Head and Current node
			Head = NewNode;
			Current = Head;
		}

		else {
			// If the list is not empty, insert the new node after the Current node
			// Adjust the Next pointers to insert the new node into the list
			NewNode.Next = Current.Next;
			Current.Next = NewNode;
			// Move the Current node to the new node
			Current = NewNode;
		}
	}

	public boolean RemoveContact(String name) {
		// Initialize a reference to the node before the current node
		Node<T> beforeCurrent = null;
		// Start at the head of the list
		Node<T> current = Head;

		// Iterate through the linked list
		while (current != null) {
			// Check if the name of the current contact matches the provided name
			// (case-insensitive)
			if (((Contact) current.data).getName().equalsIgnoreCase(name)) {
				// Check if the current node is the head node
				if (beforeCurrent == null) {
					// If it's the head node, update the Head to point to the next node
					Head = current.Next;
				} else {
					// If it's not the head node, remove the current node by adjusting the "next"
					// reference
					beforeCurrent.Next = current.Next;
				}
				// Contact found and removed successfully
				return true;
			}
			// Move the "beforeCurrent" and "current" references to the next nodes in the
			// list
			beforeCurrent = current;
			current = current.Next;
		}

		// If the loop completes without finding the contact, it means the contact was
		// not found in the list
		return false;
	}

	public boolean RemoveEvents(String name) {
		// Initialize a reference to the node before the current node
		Node<T> beforeCurrent = null;
		// Start at the head of the list
		Node<T> current = Head;
		// Flag to track whether any events were removed
		boolean removed = false;

		// Iterate through the linked list
		while (current != null) {
			// Check if the title of the current event matches the provided title
			// (case-insensitive)
			if (((Event) current.data).getName().equalsIgnoreCase(name)) {
				// Check if the current node is the head node
				if (beforeCurrent == null) {
					// If it's the head node, update the Head to point to the next node
					Head = current.Next;
				} else {
					// If it's not the head node, remove the current node by adjusting the "next"
					// reference
					beforeCurrent.Next = current.Next;
				}
				current = current.Next; // Move to the next node after removal
				removed = true;
			} else {
				beforeCurrent = current;
				current = current.Next;
			}
		}

		return removed; // Return true if at least one event was removed, false otherwise

	}

	public Contact SearchByNameOrNumber(String type, String data) {
		// Check if the linked list is empty
		if (Head == null)
			return null;

		// Start at the head of the list
		Node<T> SearchCurrent = Head;
		// Iterate through the linked list
		while (SearchCurrent != null) {
			// Check if the search type is "Name"
			if (type.equals("Name")) {
				// Compare the name of the current contact (case-insensitive) with the provided
				// data
				if (((Contact) SearchCurrent.data).getName().equalsIgnoreCase(data)) {
					// Return the contact when a matching name is found
					return (Contact) SearchCurrent.data;
				}
				// Move to the next node in the list
				SearchCurrent = SearchCurrent.Next;
			}
			// Check if the search type is "Number"
			else if (type.equals("Number")) {
				// Compare the phone number of the current contact (case-insensitive) with the
				// provided data
				if (((Contact) SearchCurrent.data).getPhoneNumber().equalsIgnoreCase(data)) {
					// Return the contact when a matching phone number is found
					return (Contact) SearchCurrent.data;
				}
				// Move to the next node in the list
				SearchCurrent = SearchCurrent.Next;
			}

		}
		// If no matching contact is found, return null
		return null;
	}

	public void sortEventsByTitle() {
        // Check if the linked list is empty or has only one element; no sorting needed
        if (Head == null || Head.Next == null) {
            return;
        }

        // Start at the head of the list
        Node<T> current = Head;

        // Initialize the sorted part of the list
        Node<T> sorted = null;

        while (current != null) {
            Node<T> next = current.Next;
            if (current.data instanceof Event) {
                // Cast the data to Event
                Event currentEvent = (Event) current.data;

                // Insert currentEvent into the sorted part of the list
                if (sorted == null || currentEvent.getEventTitle().compareTo(((Event) sorted.data).getEventTitle()) < 0) {
                    // If the sorted list is empty or currentEvent should be at the beginning
                    current.Next = sorted;
                    sorted = current;
                } else {
                    // Find the position to insert currentEvent
                    Node<T> search = sorted;
                    while (search.Next != null && currentEvent.getEventTitle().compareTo(((Event) search.Next.data).getEventTitle()) >= 0) {
                        search = search.Next;
                    }
                    current.Next = search.Next;
                    search.Next = current;
                }
            }

            // Move to the next node
            current = next;
        }

        // Update the Head with the sorted part
        Head = sorted;
    }

	public void sortContactsByName() {
		// Check if the linked list is empty or has only one element; no sorting needed
		if (Head == null || Head.Next == null) {
			return;
		}
		// Save the current position in the linked list
		Node<T> SaveCurrent = Current;
		// Start at the head of the list
		Current = Head;
		// Initialize a reference to the next node
		Node<T> NextCurrent;

		// Iterate through the linked list
		while (Current != null) {
			// Set the reference to the next node
			NextCurrent = Current.Next;

			// Iterate through the linked list
			while (NextCurrent != null) {
				// Extract contact details from the current and next nodes
				Contact contact1 = (Contact) Current.data;
				Contact contact2 = (Contact) NextCurrent.data;
				// Compare the contact names and perform a swap if necessary
				if (contact1.getName().compareTo(contact2.getName()) > 0) {
					// Swap the contact names
					String temp = contact1.getName();
					contact1.setName(contact2.getName());
					contact2.setName(temp);
				}
				// Move to the next node in the list
				NextCurrent = NextCurrent.Next;
			}
			// Move the current position to the next node in the list
			Current = Current.Next;
		}
		// Restore the original current position
		Current = SaveCurrent;
	}

	public void printAllEventNames() {
		// Check if the linked list is empty
		if (Head == null) {
			System.out.println("There's no events found.");
			// Exit the method if the list is empty
			return;
		}
		// Save the current position in the linked list
		Node<T> SaveCurrent = Current;
		// Start at the head of the list
		Current = Head;

		System.out.println("Events Alphabetically:");

		// Iterate through the linked list and print event titles
		while (Current != null) {
			// Extract event details from the current node
			Event event = (Event) Current.data;
			System.out.println(event.getEventTitle());
			// Move to the next node in the list
			Current = Current.Next;
		}
		// Restore the original current position
		Current = SaveCurrent;
	}

	public void SearchByPrintAll(String type, String data) {
		// Initialize counters for contacts, events, and print by first name
		int countContact, countEvent, countPrint;
		countContact = countEvent = countPrint = 0;

		// Start searching from the beginning of the linked list
		Node<T> SearchCurrent = Head;

		// Iterate through the linked list
		while (SearchCurrent != null) {
			// Check the search type
			if (type.equals("Email")) {
				// Check if the email address matches the search data
				if (((Contact) SearchCurrent.data).getEmailAddress().equalsIgnoreCase(data)) {
					if (countContact == 0)
						System.out.println("Contacts found!");
					// Display the contact's details
					((Contact) SearchCurrent.data).display();
					// Set count variables for contacts
					countContact = 1;
					// Move to the next
					SearchCurrent = SearchCurrent.Next;
				} else
					// Move to the next
					SearchCurrent = SearchCurrent.Next;
				// Set count variables for events and print by first name
				countEvent = 1;
				countPrint = 1;
			}
			// Check the search type
			else if (type.equals("Address")) {
				// Check if the contact's address matches the search data (similar logic as
				// above)
				if (((Contact) SearchCurrent.data).getAddress().equalsIgnoreCase(data)) {
					if (countContact == 0)
						System.out.println("Contacts found!");
					((Contact) SearchCurrent.data).display();
					// Set count variables for contacts
					countContact = 1;
					// Move to the next
					SearchCurrent = SearchCurrent.Next;

				} else
					// Move to the next
					SearchCurrent = SearchCurrent.Next;
				// Set count variables for events and print by first name
				countEvent = 1;
				countPrint = 1;
			}
			// Check the search type
			else if (type.equals("Birthday")) {
				// Check if the contact's birthday matches the search data (similar logic as
				// above)
				if (((Contact) SearchCurrent.data).getBirthday().equalsIgnoreCase(data)) {
					if (countContact == 0)
						System.out.println("Contacts found!");
					((Contact) SearchCurrent.data).display();
					// Set count variables for contacts
					countContact = 1;
					// Move to the next
					SearchCurrent = SearchCurrent.Next;
				} else
					// Move to the next
					SearchCurrent = SearchCurrent.Next;
				// Set count variables for events and print by first name
				countEvent = 1;
				countPrint = 1;
			}
			// Check the search type
			else if (type.equals("EventName")) {
				// Check if the event's name matches the search data (similar logic as above)
				if (((Event) SearchCurrent.data).getName().equalsIgnoreCase(data)) {
					if (countEvent == 0)
						System.out.println("Event found!");
					((Event) SearchCurrent.data).display();
					// Set count variables for events
					countEvent = 1;
					// Move to the next
					SearchCurrent = SearchCurrent.Next;
				} else
					// Move to the next
					SearchCurrent = SearchCurrent.Next;
				// Set count variables for contacts and print by first name
				countContact = 1;
				countPrint = 1;
			}
			// Check the search type
			else if (type.equals("EventTitle")) {
				// Check if the event's title matches the search data (similar logic as above)
				if (((Event) SearchCurrent.data).getEventTitle().equalsIgnoreCase(data)) {
					if (countEvent == 0) 
						System.out.println("Event found!");
					((Event) SearchCurrent.data).display();
					// Set count variables for events
					countEvent = 1;
					// Move to the next
					SearchCurrent = SearchCurrent.Next;
					

				} else
					// Move to the next
					SearchCurrent = SearchCurrent.Next;
				// Set count variables for contacts and print by first name
				countContact = 1;
				countPrint = 1;
			}
			// Check the search type
			else if (type.equals("PrintByFirstName")) {
				// Check if the first name of the contact matches the search data (similar logic
				// as above)
				if (((Contact) SearchCurrent.data).getName().substring(0, data.length()).equalsIgnoreCase(data)) {
					if (countPrint == 0)
						System.out.println("Contacts found!");
					((Contact) SearchCurrent.data).display();
					// Set count variables for print by first name
					countPrint = 1;
					// Move to the next
					SearchCurrent = SearchCurrent.Next;
				} else
					// Move to the next
					SearchCurrent = SearchCurrent.Next;
				// Set count variables for contacts and events
				countContact = 1;
				countEvent = 1;
			}

		}
		// Display appropriate messages based on search results
		if (countContact == 0) {
			System.out.println("Sorry Contact is not found!");
			System.out.println("Because Your Contact is not exsest");
			System.out.println();
		}

		else if (countEvent == 0) {
			System.out.println("Sorry Event is not found!");
			System.out.println("Because Your Event is not exsest");
			System.out.println();
		}

		else if (countPrint == 0) {
			System.out.println("Sorry Contacts is not found!");
			System.out.println("Because there is no one with this name");
			System.out.println();
		}
	}

	public boolean SearchByDateAndTime(String Date, String Time) {
		// Check if the linked list is empty
		if (Head == null)
			return false;

		// Start from the beginning of the linked list
		Node<T> SearchCurrent = Head;

		// Iterate through the linked list
		while (SearchCurrent != null) {
			// Check if the event's date and time match the search criteria
			if (((Event) SearchCurrent.data).getDate().equalsIgnoreCase(Date)
					&& ((Event) SearchCurrent.data).getTime().equalsIgnoreCase(Time)) {
				// Event found with the specified date and time
				return true;
			}
			// Move to the next
			SearchCurrent = SearchCurrent.Next;
		}
		// Event not found with the specified date and time
		return false;
	}
	public boolean SearchByName(String name) {
		// Check if the linked list is empty
		if (Head == null)
			return false;

		// Start from the beginning of the linked list
		Node<T> SearchCurrent = Head;

		// Iterate through the linked list
		while (SearchCurrent != null) {
			// Check if the event's name match the search criteria
			if (((Event) SearchCurrent.data).getName().equalsIgnoreCase(name)) {
				// Event found with the specified date and time
				return true;
			}
			// Move to the next
			SearchCurrent = SearchCurrent.Next;
		}
		// Event not found with the specified date and time
		return false;
	}
}