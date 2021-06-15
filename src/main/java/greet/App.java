package greet;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class App {


    public static void main(String[] args) {
        staticFiles.location("/public");
        get("/hello", (req, res) -> {
            return "";
        });


        post("/hello", (req, res) -> {
            return "";
        });
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
