package greet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Greet {
    private final HashMap<String, Integer> usersGreeted = new HashMap<>();
    private int iCount = 0;

    public Map<String, Integer> greetedUsers() {
        return usersGreeted;
    }

    public void bread() {




    }

    public String selectLanguage(int userInput, String user) {
        String msg = "";
        switch (userInput) {
            case 1:
                msg = "Hello " + user;
                break;
            case 2:
                msg = "Olá " + user;
                break;
            case 3:
                msg = "こんにちは " + user;
                break;

        }
        return msg;
    }

//    public String greetUser(String username) {
//        username = "";
//        String msg = "";
//        if (username.equals("")) {
//            msg = "Hello !";
//
//        } else if (!username.equals("")) {
//            msg = "Hello " + username;
//        }
//        return msg;
//    }


    public int greetedUser(String userName) {
        String lowerName = userName.toLowerCase();
        return usersGreeted.get(lowerName);
    }

    public void greet(String name, int language) {

        String lowerName = name.toLowerCase();
        if (!usersGreeted.containsKey(lowerName)) {
            iCount = 1;
            usersGreeted.put(lowerName, iCount);
        } else if (usersGreeted.containsKey(lowerName) && language <= 3) {

            for (int i = 0; i < usersGreeted.size(); i++) {

                iCount++;
                usersGreeted.put(lowerName, iCount);

            }

        }
    }
}
