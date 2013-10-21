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
package eu.agilejava.javaonedemo.service;

import eu.agilejava.javaonedemo.dao.CookBookDao;
import eu.agilejava.javaonedemo.entities.CookBook;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Java EE implementation of CookBookService.
 *
 * @see CookBookService
 *
 * @author Ivar Grimstad <ivar.grimstad@gmail.com>
 */
@Stateless
public class CookBookServiceBean implements CookBookService {

   @Inject
   private CookBookDao cookBookDao;

   @Override
   public int count() {
      return cookBookDao.count();
   }

   @Override
   public void create(CookBook cookBook) {
      cookBookDao.create(cookBook);
   }

   @Override
   public void edit(CookBook cookBook) {
      cookBookDao.edit(cookBook);
   }

   @Override
   public void remove(CookBook cookBook) {
      cookBookDao.remove(cookBook);
   }

   @Override
   public List<CookBook> findAll() {
      return cookBookDao.findAll();
   }

   @Override
   public CookBook find(Object id) {
      return cookBookDao.find(id);
   }
}
