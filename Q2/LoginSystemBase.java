public abstract class LoginSystemBase {

    /**
     * Returns the actual size of the data structure, including empty elements
     * @return the size of the data structure
     */
    public abstract int size();

    /**
     * Returns the number of users currently in the system
     * @return number of users in the system
     */
    public abstract int getNumUsers();

    /**
     * Calculates the hashcode based on the key
     * @param key key to calculate hash code
     * @return hash code of key
     */
    public abstract int hashCode(String key);

    /**
     * Adds a new user to the system
     * @param email new user's email
     * @param password new user's password
     * @return true if the user was not in the system and has been successfully added;
     *         false if the user was already in the system
     */
    public abstract boolean addUser(String email, String password);

    /**
     * Removes a user from the system
     * @param email email of user to remove
     * @param password password of user to remove
     * @return true if the user was successfully removed;
     *         false if the user was not in the system OR the user is in the system, but the
     *         password is incorrect
     */
    public abstract boolean removeUser(String email, String password);

    /**
     * Checks if the user is in the system.
     * Returns the bucket index of the user in the hash table.
     * @param email email of user to check
     * @param password password of user to check
     * @return if the user is not in the system
     *         -> return -1
     *         if the user is in the system, but the password is incorrect
     *         -> return -2
     *         the user is in the system and the password is correct
     *         -> return the bucket index of the user in the hash table
     */
    public abstract int checkPassword(String email, String password);

    /**
     * Changes the user's password in the system to 'new_password'.
     * @param email user's email
     * @param oldPassword user's current password
     * @param newPassword user's new password
     * @return true if the user's password was changed successfully;
     *         false if the user could not be found or if 'old_password' is incorrect
     */
    public abstract boolean changePassword(String email, String oldPassword, String newPassword);
}
