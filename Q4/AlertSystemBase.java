import java.util.Objects;

class User {
    private final String name;
    private boolean infected;

    User(String name) {
        this.name = name;
        this.infected = false;
    }

    public boolean isInfected() {
        return infected;
    }

    public void gotVirus() {
        infected = true;
    }

    public void gotHealed() {
        infected = false;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", name, infected);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return infected == user.infected && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

abstract class AlertSystemBase {

    /**
     * Adds a person to the system.
     * @param person person to add
     * @return true if the person was successfully added, false if they are already in the system
     */
    public abstract boolean addPerson(User person);

    /**
     * Removes a person from the system.
     * @param person person to remove
     * @return true if the person is successfully removed, false if they were not in the system
     */
    public abstract boolean removePerson(User person);

    /**
     * Adds a contact between two people.
     * @param person1 first person in contact
     * @param person2 second person in contact
     * @return true if a contact was successfully added, false otherwise
     */
    public abstract boolean addContact(User person1, User person2);

    /**
     * Counts how many contacts the person has.
     * @param person person to count contacts for
     * @return the number of contacts the person has, or -1 if the person is not in the system
     */
    public abstract int countContacts(User person);

    /**
     * Removes a contact between two people.
     * @param person1 first person in contact to remove
     * @param person2 second person in contact to remove
     * @return true if the contact was successfully removed, false otherwise
     */
    public abstract boolean removeContact(User person1, User person2);

    /**
     * Marks a person as infected.
     * Based on the virus degree, marks infected:
     *   virusDegree = 1: the infected person's contacts,
     *   virusDegree = 2: the infected person's contacts and the contacts of the contacts,
     *   virusDegree = 3: the infected person's contacts, the contacts of the contacts, and
     *                    the contacts of the contacts of the contacts,
     *   and so on.
     * @param infectedPerson person to mark as infected
     * @param virusDegree degree of virus infecting the person
     */
    public abstract void markInfected(User infectedPerson, int virusDegree);

    /**
     * Marks a person as healed.
     * Only the given person is marked as healed, not their contacts.
     * @param person person to mark as healed
     */
    public void markHealed(User person) {
        person.gotHealed();
    }
}
