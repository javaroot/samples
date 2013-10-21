/*
 * The MIT License
 *
 * Copyright 2013 Ivar Grimstad <ivar.grimstad@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package eu.agilejava.javaonedemo.ui;

import eu.agilejava.javaonedemo.entities.CookBook;
import eu.agilejava.javaonedemo.service.CookBookService;
import eu.agilejava.javaonedemo.service.CookBookUserService;
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
 * Spring MVC Controller for cookbooks.
 * 
 * @author Ivar Grimstad <ivar.grimstad@gmail.com>
 */
@Controller
@RequestMapping("/cookBook")
public class CookBookController {

   @Autowired
   private CookBookService cookBookService;
   
   @Autowired
   private CookBookUserService cookBookUserService;

   @RequestMapping("/List.htm")
   public ModelAndView prepareList() {

      Map<String, Object> listModel = new HashMap<>();
      listModel.put("cookBooks", cookBookService.findAll());

      ModelAndView mv = new ModelAndView("cookBook/List", listModel);

      return mv;
   }

   @RequestMapping("/Edit.htm")
   public ModelAndView prepareEdit(@RequestParam("id") Long id) {

      Map<String, Object> listModel = new HashMap<>();
      listModel.put("users", cookBookUserService.findAll());
      listModel.put("cookBook", cookBookService.find(id));

      ModelAndView mv = new ModelAndView("cookBook/Edit", listModel);

      return mv;
   }

   @RequestMapping(value = "/Edit.htm", method = RequestMethod.POST)
   public ModelAndView edit(@ModelAttribute("cookBook") CookBook cookBook) {

      cookBookService.edit(cookBook);

      Map<String, Object> listModel = new HashMap<>();
      listModel.put("cookBooks", cookBookService.findAll());

      return new ModelAndView("cookBook/List", listModel);
   }

   @RequestMapping("/View.htm")
   public ModelAndView prepareView(@RequestParam("id") Long id) {

      Map<String, Object> listModel = new HashMap<>();
      listModel.put("users", cookBookUserService.findAll());
      listModel.put("cookBook", cookBookService.find(id));

      ModelAndView mv = new ModelAndView("cookBook/View", listModel);

      return mv;
   }

   @RequestMapping(value = "/List.htm", method = RequestMethod.POST)
   public ModelAndView delete(@ModelAttribute("cookBook") CookBook cookBook) {

      cookBookService.remove(cookBook);

      Map<String, Object> listModel = new HashMap<>();
      listModel.put("cookBooks", cookBookService.findAll());

      return new ModelAndView("cookBook/List", listModel);
   }

   @RequestMapping("/Create.htm")
   public ModelAndView prepareCreate() {

      Map<String, Object> listModel = new HashMap<>();
      listModel.put("users", cookBookUserService.findAll());

      return new ModelAndView("cookBook/Create", listModel);
   }

   @RequestMapping(value = "/Create.htm", method = RequestMethod.POST)
   public ModelAndView create(@ModelAttribute("cookBook") CookBook cookBook) {

      cookBookService.create(cookBook);

      Map<String, Object> listModel = new HashMap<>();
      listModel.put("cookBooks", cookBookService.findAll());

      return new ModelAndView("cookBook/List", listModel);
   }
}
