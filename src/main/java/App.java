import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {//show homw page
            Map<String, Object> model = new HashMap<>();
            List<EndangeredAnimal> animals = EndangeredAnimal.all();
            model.put("animals",animals);
            model.put("sightings",Sightings.all());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        //get all animals
        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<EndangeredAnimal> animals = EndangeredAnimal.all();
            model.put("animals",animals);
            model.put("sightings",Sightings.all());
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());
        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sightings> sightings = Sightings.all();
            model.put("animals", EndangeredAnimal.all());
            model.put("sightings", sightings);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());
        //get animal by id
        get("/animal-details/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfEndangeredAnimal=Integer.parseInt(req.params("id"));
            EndangeredAnimal foundAnimal=EndangeredAnimal.find(idOfEndangeredAnimal);
            model.put("animals",foundAnimal);
            model.put("sightings",Sightings.all());
            return new ModelAndView(model, "animal-details.hbs");
        }, new HandlebarsTemplateEngine());
        //show new animal form
        get("/posts/animals/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            model.put("animals",EndangeredAnimal.all());
            model.put("sightings",Sightings.all());
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());


    }

}
