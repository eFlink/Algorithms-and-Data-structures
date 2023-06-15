public class LoginSystem extends LoginSystemBase {

    public int size;
    public int entries;
    public static final int INITIAL_CAPACITY = 101;
    private String[] emails;
    private String[] passwords;

    public LoginSystem() {
        /* Add your code here! */
        entries = 0;
        size = INITIAL_CAPACITY;
        emails = new String[INITIAL_CAPACITY];
        passwords = new String[INITIAL_CAPACITY];
    }

    @Override
    public int size() {
        /* Add your code here! */
        return size;
    }

    @Override
    public int getNumUsers() {
        /* Add your code here! */
        return entries;
    }

    @Override
    public int hashCode(String key) {
        /* Add your code here! */
        int c = 31;
        int code = 0;

        for (int i = 0; i < key.length(); i++) {
            int ascii = (int) key.charAt(i);
            code *= c;
            code += ascii;
        }
        return code;
    }



    @Override
    public boolean addUser(String email, String password) {
        /* Add your code here! */
        int startLocation = hashFunction(email);
        int i = startLocation;

        if (size == entries) {
            reSize();
        }

        do {
                if (emails[i] == null) {
                    emails[i] = email;
                    passwords[i] = password;
                    return true;
                }

                if (emails[i].equals(email)) {
                    return false;
                }

                i = (i + 1) % size;
            }
            while (i != startLocation);
        return false;
    }

    @Override
    public boolean removeUser(String email, String password) {
        /* Add your code here! */
        int idx = get(email);

        if (idx < 0) {
            return false;
        }
        // Set to null and decrement entries.
        emails[idx] = null;
        passwords[idx] = null;
        entries--;

        // rehash users after current idx
        for (idx = (idx + 1) % size; emails[idx] != null;
             idx = (idx + 1) % size) {
            String emailTmp = emails[idx];
            String passwordTmp = passwords[idx];
            emails[idx] = null;
            passwords[idx] = null;
            addUser(emailTmp, passwordTmp);
        }
        return false;
    }

    @Override
    public int checkPassword(String email, String password) {
        /* Add your code here! */
        int idx = get(email);
        if (idx < 0) {
            return -1;
        }
        if (!passwords[idx].equals(password)) {
            return -2;
        }
        return idx;
    }

    @Override
    public boolean changePassword(String email, String oldPassword, String newPassword) {
        /* Add your code here! */
        int idx = get(email);
        if (idx < 0) {
            return false;
        }
        if (passwords[idx].equals(oldPassword)) {
            passwords[idx] = newPassword;
            return true;
        }
        return false;
    }

    /* Add any extra functions below */

    public int hashFunction(String key) {
        int compress = hashCode(key);
        // Compression function
        compress = compress % size;
        return compress;
    }

    /*
    Returns index of key
     */
    public int get(String key)
    {
        int i = hashFunction(key);
        while (emails[i] != null) {
            if (emails[i].equals(key))
                return i;
            i = (i + 1) % size;
        }
        return -1;
    }

    public void reSize() {
        int newSize = size * 3;
        String[] oldEmails = emails;
        String[] oldPasswords = passwords;
        emails = new String[newSize];
        passwords = new String[newSize];
        for (int i = 0; i < size; i++) {
            addUser(oldEmails[i], oldPasswords[i]);
        }
        size *= 3;
    }

    public static void main(String[] args) {
        /*
         * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         * REMOVE THE MAIN METHOD BEFORE SUBMITTING TO THE AUTOGRADER
         * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         * The following main method is provided for simple debugging only
         */
        LoginSystem loginSystem = new LoginSystem();
        assert loginSystem.hashCode("GQHTMP") == loginSystem.hashCode("H2HTN1");
        if (loginSystem.hashCode("GQHTMP") == loginSystem.hashCode("H2HTN1")) {
            System.out.println("true");
        }
        if (loginSystem.size() == 101) {
            System.out.println("true");
        }
        if (loginSystem.checkPassword("a@b.c", "L6ZS9") == -1) {
            System.out.println("true -1");
        }
        loginSystem.addUser("a@b.c", "L6ZS9");
        if(loginSystem.checkPassword("a@b.c", "ZZZZZZ") == -2) {
            System.out.println("true -2");
        }
        if(loginSystem.checkPassword("a@b.c", "L6ZS9") == 94) {
            System.out.println("true 94");
        }
        loginSystem.removeUser("a@b.c", "L6ZS9");
        if(loginSystem.checkPassword("a@b.c", "L6ZS9") == -1) {
            System.out.println("true -1 again");
        }
    }
}
