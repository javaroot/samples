package eu.agilejava.javaonedemo.ui;

import eu.agilejava.javaonedemo.entities.Recipe;
import eu.agilejava.javaonedemo.service.CookBookService;
import eu.agilejava.javaonedemo.service.RecipeService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller for recipes.
 * @author Ivar Grimstad (ivar.grimstad@gmail.com)
 */
@Controller
@RequestMapping("/recipe")
public class RecipeController {

   @Autowired
   private RecipeService recipeService;
   @Autowired
   private CookBookService cookBookService;

   @RequestMapping("/List.htm")
   public ModelAndView prepareList() {

      Map<String, Object> listModel = new HashMap<>();
      listModel.put("recipes", recipeService.findAll());

      ModelAndView mv = new ModelAndView("recipe/List", listModel);

      return mv;
   }

   @RequestMapping("/Edit.htm")
   public ModelAndView prepareEdit(@RequestParam("id") Long id) {

      Map<String, Object> listModel = new HashMap<>();
      listModel.put("cookBooks", cookBookService.findAll());
      listModel.put("recipe", recipeService.find(id));

      ModelAndView mv = new ModelAndView("recipe/Edit", listModel);

      return mv;
   }

   @RequestMapping(value = "/Edit.htm", method = RequestMethod.POST)
   public ModelAndView edit(@ModelAttribute("recipe") Recipe recipe) {

      recipeService.edit(recipe);

      Map<String, Object> listModel = new HashMap<>();
      listModel.put("recipes", recipeService.findAll());

      return new ModelAndView("recipe/List", listModel);
   }

   @RequestMapping("/View.htm")
   public ModelAndView prepareView(@RequestParam("id") Long id) {

      ModelAndView mv = new ModelAndView("recipe/View");
      mv.addObject("recipe", recipeService.find(id));

      return mv;
   }

   @RequestMapping(value = "/List.htm", method = RequestMethod.POST)
   public ModelAndView delete(@ModelAttribute("recipe") Recipe recipe) {

      recipeService.remove(recipe);

      Map<String, Object> listModel = new HashMap<>();
      listModel.put("recipes", recipeService.findAll());

      return new ModelAndView("recipe/List", listModel);
   }

   @RequestMapping("/Create.htm")
   public ModelAndView prepareCreate() {

      Map<String, Object> listModel = new HashMap<>();
      listModel.put("cookBooks", cookBookService.findAll());

      return new ModelAndView("recipe/Create", listModel);
   }

   @RequestMapping(value = "/Create.htm", method = RequestMethod.POST)
   public ModelAndView create(@ModelAttribute("recipe") Recipe recipe) {

      recipeService.create(recipe);

      Map<String, Object> listModel = new HashMap<>();
      listModel.put("recipes", recipeService.findAll());

      return new ModelAndView("recipe/List", listModel);
   }
}
