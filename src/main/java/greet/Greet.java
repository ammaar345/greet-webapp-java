package greet;

public class Greet {
    public String greetUser(String username) {
        username = "";
        String msg = "";
        if (username.equals("")) {
            msg = "Hello !";

        } else if (!username.equals("")) {
            msg = "Hello " + username;
        }
        return msg;
    }
}
