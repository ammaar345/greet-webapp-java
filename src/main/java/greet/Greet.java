package greet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Greet {
    private final HashMap<String, Integer> usersGreeted = new HashMap<>();
    private int iCount = 0;
    ArrayList<String> names = new ArrayList();
    public Map<String, Integer> greetedUsers() {

        return usersGreeted;
    }

    public ArrayList<Integer> eachUsersCount() {
        ArrayList<Integer> countForEachUser = new ArrayList<>();
        for (String user : usersGreeted.keySet()) {
            countForEachUser.add(usersGreeted.get(user));

        }
        return countForEachUser;
    }


    public String languageSelection(String userInput, String user) {
        String msg = "";
        switch (userInput) {
            case "Eng":
                msg = "Hello " + user;
                break;
            case "Span":
                msg = "Olá " + user;
                break;
            case "Jap":
                msg = "こんにちは " + user;
                break;

        }
        return msg;
    }

    public ArrayList userNames() {
//        ArrayList<String> names = new ArrayList();
        for (String user : usersGreeted.keySet()) {
            names.add(user);
            System.out.println(user);
        }

        return names;
//           names.add(usersGreeted.get(i));
//          names.add(greetedUsers().keySet().toArray()[i]);
//          String msg = (names.get(i) + " has been greeted " + greetedUsers().get(names.get(i)) + " time(s)");
//           map.put("count", msg);

    }
//for (Map.Entry  entry:usersGreeted.entrySet()){
//names.add(entry);
//}


    public int greetedUserCount(String userName) {
        String lowerName = userName.toLowerCase();
        return usersGreeted.get(lowerName);
    }

    public void greet(String name) {

        String lowerName = name.toLowerCase();

        if (!usersGreeted.containsKey(lowerName)) {
            iCount = 1;
            usersGreeted.put(lowerName, iCount);
        } else if (usersGreeted.containsKey(lowerName)) {

            for (int i = 0; i < usersGreeted.size(); i++) {

                iCount++;
                usersGreeted.put(lowerName, iCount);

            }

        }
        // insert if statement for if the language and username is blank


    }
}
