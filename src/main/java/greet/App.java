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
        Greet greet = new Greet();
        // String name = "";
//        get("/greeted", (req, res) -> {
//
//            Map<String, Object> users = new HashMap<>();
//            users.put("user", greet.names);
//            return new ModelAndView(users, "greeted.handlebars");
//        }, new HandlebarsTemplateEngine());

        get("/", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            res.redirect("/hello");
            return new ModelAndView(map, "greeted.handlebars");
        }, new HandlebarsTemplateEngine());


        get("/greeted", (req, res) -> {
//            Greet greet = new Greet();
            Map<String, Object> map = new HashMap<>();
//            if (map.containsValue(req.queryParams("username"))) {
            map.put("user", greet.userNames());

//            }

            //  greet.greetedUsers();
            return new ModelAndView(map, "greeted.handlebars");
        }, new HandlebarsTemplateEngine());


        get("/hello", (req, res) -> {

            Map<String, Object> map = new HashMap<>();

            String userCount = "Users greeted : " + greet.userCount();
            map.put("count", userCount);
            return new ModelAndView(map, "hello.handlebars");

        }, new HandlebarsTemplateEngine());
        post("/hello", (req, res) -> {
//            Greet greet = new Greet();
            Map<String, Object> map = new HashMap<>();
            Map<String, Object> newMap = new HashMap<>();

            String language = req.queryParams("language");
            String name = req.queryParams("username");
            greet.greet(name);
            greet.greetedUsers();
            // create the greeting message

            String greeting = greet.languageSelection(language, name);
            // put it in the map which is passed to the template - the value will be merged into the template
            map.put("greeting", greeting);

            return new ModelAndView(map, "hello.handlebars");

        }, new HandlebarsTemplateEngine());
        get("/countAll", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "hello.handlebars");
        }, new HandlebarsTemplateEngine());
//        get("/greet", (req, res) -> {
//
//                String user = req.queryParams("username");
//        Greet greet = new Greet();
//        return greet.greetUser(user);}
//        );
        get("/hello/:username", (req, res) -> {

                    Map<String, Object> map = new HashMap<>();
                    String user = req.params("username");
                    String msg = user + " has been greeted " + greet.greetedUserCount(user) + " time(s)";
                    map.put("msg", msg);
                    return new ModelAndView(map, "greetCount.handlebars");
                }, new HandlebarsTemplateEngine()


        );
    }
}
