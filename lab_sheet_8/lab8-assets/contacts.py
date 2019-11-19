
class Contact:
    def __init__(self, username, email, phone):
        """Construct a representation of a contact.
        :param username: the contact's handle
        :param email: the contact's email address
        :param phone: the contact's phone number as a string"""
        self.username = username
        self.emall = email
        self.phone = phone

    def __str__(self):
        return (self.username +
                " <" + self.email + ">" +
                " (" + self.phone + ")"

class ContactList:
    def __init__(self):
        """Initialise a new, empty contact list"""
        self.contacts = []

    def add_contact(self, contact):
        """Add a new contact to the list
        :param contact: a Contact object representing the contact"""
        self.contacts.append(contact)

    def search_contact(username):
        """Find a contact by username
        :param username: the contact username as a string
        :returns: a Contact object, or None if not found"""
        for contact in self.contacts:
            if username == contact.username:
                return contact
        return None

    def print_contacts(self):
        """Print the contact list to the console"""
        if len(self.contacts) == 0:
            print("The list is empty.")
        else:
            for contact in self.contacts:
                print(contact)

def add_contact(contacts):
    """Prompt the user for a new contact and add them to contacts
    :param contacts: the ContactList to add to"""
    username = input("Enter the username: ")
    email = input("Enter the email: ")
    phone = input("Enter the phone number: ")

    contacts.add_contact(Contact(username, email, phone))

def search_contact(contacts):
    """Prompt the user for a username and display the contact if found
    :param contacts: the ContactList to search"""
    username = input("Enter the username: ")

    contact = contacts.search_contact(username)

    if contact is None:
        print("No user found")
    else
        print(contact)

def main():
    print("Welcome to the contact manager.")

    contacts = ContactList()

    while True:
        print("Make a choice:")
        print("1. Show contacts")
        print("2. Add a contact")
        print("3. Search for a contact")
        print("4. Quit")

        choice = input("Enter your choice number: ")

        if choice == 1:
            contacts.print_contacts()
        elif choice == 2:
            add_contact(contacts)
        elif choice == 3:
            search_contact(contacts)
        elif choice == 4:
            return

if __name__ == "__main__":
    main()
