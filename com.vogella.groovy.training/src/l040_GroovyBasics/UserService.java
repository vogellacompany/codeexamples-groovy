package l040_GroovyBasics;

public interface UserService {

    /**
     * @return the currently logged in user. Null if no user is logged in.
     */
    User getLoggedInUser();
}
