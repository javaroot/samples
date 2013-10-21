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
package eu.agilejava.javaonedemo.dao.jdbc;

import eu.agilejava.javaonedemo.dao.CookBookDao;
import eu.agilejava.javaonedemo.dao.CookBookUserDao;
import eu.agilejava.javaonedemo.entities.CookBook;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Spring JDBC implementation of CookBookDao
 *
 * @see CookBookDao
 *
 * @author Ivar Grimstad <ivar.grimstad@gmail.com>
 */
@Repository
public class CookBookJdbcDao extends AbstractJdbcDao implements CookBookDao {

   @Autowired
   private CookBookUserDao cookBookUserDao;

   @Override
   public int count() {
      return jdbcTemplate.queryForInt("select count(*) from COOKBOOK");
   }

   @Override
   public void create(CookBook cookBook) {
      cookBook.setId(generateId("COOKBOOK"));
      jdbcTemplate.update("insert into COOKBOOK (ID, NAME, OWNER_ID) values (?, ?, ?)", cookBook.getId(), cookBook.getName(), cookBook.getOwnerId());
   }

   @Override
   public void edit(CookBook cookBook) {
      jdbcTemplate.update("update COOKBOOK set NAME = ?, OWNER_ID = ? where ID = ?", cookBook.getName(), cookBook.getOwnerId(), cookBook.getId());
   }

   @Override
   public CookBook find(Object id) {

      try {

         CookBook cookBook = jdbcTemplate.queryForObject("select * from COOKBOOK where ID = ?", new Object[]{id}, new CookBookMapper());
         cookBook.setOwner(cookBookUserDao.find(cookBook.getOwnerId()));

         return cookBook;

      } catch (EmptyResultDataAccessException e) {
         throw new NotFoundException();
      }
   }

   @Override
   public List<CookBook> findAll() {

      List<CookBook> cookBooks = jdbcTemplate.query("select * from COOKBOOK", new CookBookMapper());

      for (CookBook cookBook : cookBooks) {
         cookBook.setOwner(cookBookUserDao.find(cookBook.getOwnerId()));
      }

      return cookBooks;
   }

   @Override
   public void remove(CookBook cookBook) {
      jdbcTemplate.update("delete from COOKBOOK where id = ?", cookBook.getId());
   }

   private static final class CookBookMapper implements RowMapper<CookBook> {

      @Override
      public CookBook mapRow(ResultSet rs, int i) throws SQLException {
         CookBook cookBook = new CookBook();
         cookBook.setId(rs.getLong("ID"));
         cookBook.setName(rs.getString("NAME"));
         cookBook.setOwnerId(rs.getLong("OWNER_ID"));
         return cookBook;
      }
   }
}
