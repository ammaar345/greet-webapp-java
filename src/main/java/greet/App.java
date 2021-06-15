package greet;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class App {


    public static void main(String[] args) {
        staticFiles.location("/public");
        get("/", (req, res) -> {
            Map<String, Object> users = new HashMap<>();
            return new ModelAndView(users, "index.handlebars");
        }, new HandlebarsTemplateEngine());


        post("/", (req, res) -> {
            Greet greet = new Greet();
            ArrayList<Object> names = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < greet.greetedUsers().size(); i++) {

                names.add(greet.greetedUsers().keySet().toArray()[i]);
                String msg = (names.get(i) + " has been greeted " + greet.greetedUsers().get(names.get(i)) + " time(s)");
                map.put("count", msg);

            }
            return new ModelAndView(map, "index.handlebars");
        }, new HandlebarsTemplateEngine());
        get("/hello", (req, res) -> {

            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "hello.handlebars");

        }, new HandlebarsTemplateEngine());
        post("/hello", (req, res) -> {
            Map<String, Object> map = new HashMap<>();

            // create the greeting message
            String greeting = "Hello, " + req.queryParams("username");

            // put it in the map which is passed to the template - the value will be merged into the template
            map.put("greeting", greeting);
//            System.out.println(map);
            return new ModelAndView(map, "hello.handlebars");

        }, new HandlebarsTemplateEngine());
//        get("/greet", (req, res) -> {
//
//                String user = req.queryParams("username");
//        Greet greet = new Greet();
//        return greet.greetUser(user);}
//        );
//        get("/greet/:username", (req, res) -> {
//                    String user = req.queryParams("username");
//                    Greet greet = new Greet();
//                    return greet.greetUser(user);
//                }
//

//        );

//        get("/home", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new VelocityTemplateEngine().render(
//                    new ModelAndView(model, "/index")
//);
//        });

    }
}
