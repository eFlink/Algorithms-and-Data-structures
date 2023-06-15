public class AlertSystem extends AlertSystemBase {

    @Override
    public boolean addPerson(User person) {
        /* Add your code here! */
        return false;
    }

    @Override
    public boolean removePerson(User person) {
        /* Add your code here! */
        return false;
    }

    @Override
    public boolean addContact(User person1, User person2) {
        /* Add your code here! */
        return false;
    }

    @Override
    public int countContacts(User person) {
        /* Add your code here! */
        return 0;
    }

    @Override
    public boolean removeContact(User person1, User person2) {
        /* Add your code here! */
        return false;
    }

    @Override
    public void markInfected(User infectedPerson, int virusDegree) {
        /* Add your code here! */
    }

    /* Add any extra functions below */

    public static void main(String[] args) {
        /*
         * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         * REMOVE THE MAIN METHOD BEFORE SUBMITTING TO THE AUTOGRADER
         * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         * The following main method is provided for simple debugging only
         */
        AlertSystem alertSystem = new AlertSystem();
        User u1 = new User("Alex");
        User u2 = new User("Max");
        User u3 = new User("Nick");
        User u4 = new User("Bing");
        User[] users = new User[] { u1, u2, u3, u4 };
        for (User user : users) {
            alertSystem.addPerson(user);
        }
        alertSystem.addContact(u1, u2);
        alertSystem.addContact(u1, u3);
        alertSystem.addContact(u2, u4);
        assert alertSystem.countContacts(u1) == 2;
        alertSystem.markInfected(u1, 1);
        assert u1.isInfected();
        assert u2.isInfected();
        assert !u4.isInfected();
    }
}
