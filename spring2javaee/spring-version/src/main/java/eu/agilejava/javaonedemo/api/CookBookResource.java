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
package eu.agilejava.javaonedemo.api;

import eu.agilejava.javaonedemo.entities.CookBook;
import eu.agilejava.javaonedemo.service.CookBookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Spring implementation of cookbooks REST API.
 *
 * @author Ivar Grimstad <ivar.grimstad@gmail.com>
 */
@Controller
@RequestMapping("cookbooks")
public class CookBookResource {

   @Autowired
   private CookBookService cookBookService;

   @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
   @ResponseBody
   public CookBook find(@PathVariable("id") Long id) {
      return cookBookService.find(id);
   }

   @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
   @ResponseBody
   public List<CookBook> findAll() {
      return cookBookService.findAll();
   }

   @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
   public ResponseEntity<CookBook> create(@RequestBody CookBook cookBook) {
      cookBookService.create(cookBook);

      HttpHeaders responseHeaders = new HttpHeaders();
      responseHeaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequestUri().pathSegment(String.valueOf(cookBook.getId())).build().toUriString());
      return new ResponseEntity<>(responseHeaders, HttpStatus.CREATED);

   }

   @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = APPLICATION_JSON_VALUE)
   @ResponseStatus(HttpStatus.OK)
   public void edit(@PathVariable("id") Long id, @RequestBody CookBook cookBook) {
      cookBook.setId(id);
      cookBookService.edit(cookBook);
   }

   @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
   @ResponseStatus(HttpStatus.OK)
   public void remove(@PathVariable("id") Long id) {
      cookBookService.remove(cookBookService.find(id));
   }
}
