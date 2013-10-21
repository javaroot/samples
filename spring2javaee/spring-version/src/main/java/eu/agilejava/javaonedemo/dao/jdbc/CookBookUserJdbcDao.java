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

import eu.agilejava.javaonedemo.dao.CookBookUserDao;
import eu.agilejava.javaonedemo.entities.CookBookUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * spring JDBC implementation of CookBookUserDao
 *
 * @see CookBookUserDao
 *
 * @author Ivar Grimstad <ivar.grimstad@gmail.com>
 */
@Repository
public class CookBookUserJdbcDao extends AbstractJdbcDao implements CookBookUserDao {

   @Override
   public int count() {
      return jdbcTemplate.queryForInt("select count(*) from COOKBOOKUSER");
   }

   @Override
   public void create(CookBookUser user) {
      user.setId(generateId("COOKBOOKUSER"));
      jdbcTemplate.update("insert into COOKBOOKUSER (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD) values (?, ?, ?, ?, ?)", user.getId() , user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
   }

   @Override
   public void edit(CookBookUser user) {
      jdbcTemplate.update("update COOKBOOKUSER set FIRSTNAME = ?, LASTNAME = ?, EMAIL = ?, PASSWORD = ? where ID = ?", user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getId());
   }

   @Override
   public CookBookUser find(Object id) {

      try {
         return jdbcTemplate.queryForObject("select * from COOKBOOKUSER where ID = ?", new Object[]{id}, new CookBookUserMapper());
      } catch (EmptyResultDataAccessException e) {
         throw new NotFoundException();
      }
   }

   @Override
   public List<CookBookUser> findAll() {
      return jdbcTemplate.query("select * from COOKBOOKUSER", new CookBookUserMapper());
   }

   @Override
   public void remove(CookBookUser user) {
      jdbcTemplate.update("delete from COOKBOOKUSER where id = ?", user.getId());
   }

   private static final class CookBookUserMapper implements RowMapper<CookBookUser> {

      @Override
      public CookBookUser mapRow(ResultSet rs, int i) throws SQLException {
         CookBookUser user = new CookBookUser();
         user.setId(rs.getLong("ID"));
         user.setFirstName(rs.getString("FIRSTNAME"));
         user.setLastName(rs.getString("LASTNAME"));
         user.setEmail(rs.getString("EMAIL"));
         user.setPassword(rs.getString("PASSWORD"));
         return user;
      }
   }
}
