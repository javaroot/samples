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
import eu.agilejava.javaonedemo.dao.RecipeDao;
import eu.agilejava.javaonedemo.entities.Recipe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Spring JDBC implementation of RecipeDao.
 *
 * @see RecipeDao
 *
 * @author Ivar Grimstad <ivar.grimstad@gmail.com>
 */
@Repository
public class RecipeJdbcDao extends AbstractJdbcDao implements RecipeDao {

   @Autowired
   private CookBookDao cookBookDao;

   @Override
   public int count() {
      return jdbcTemplate.queryForInt("select count(*) from RECIPE");
   }

   @Override
   public void create(Recipe recipe) {
      recipe.setId(generateId("RECIPE"));
      jdbcTemplate.update("insert into RECIPE (ID, TITLE, DESCRIPTION, INGREDIENTS, INSTRUCTIONS, COOKBOOK_ID) values (?, ?, ?, ?, ?, ?)", recipe.getId(), recipe.getTitle(), recipe.getDescription(), recipe.getIngredients(), recipe.getInstructions(), recipe.getCookBookId());
   }

   @Override
   public void edit(Recipe recipe) {
      jdbcTemplate.update("update RECIPE set TITLE = ?, DESCRIPTION = ?, INGREDIENTS = ?, INSTRUCTIONS = ?, COOKBOOK_ID = ? where id = ?", recipe.getTitle(), recipe.getDescription(), recipe.getIngredients(), recipe.getInstructions(), recipe.getCookBookId(), recipe.getId());
   }

   @Override
   public Recipe find(Object id) {

      try {
         
         Recipe recipe = jdbcTemplate.queryForObject("select * from RECIPE where ID = ?", new Object[]{id}, new RecipeMapper());
         recipe.setCookBook(cookBookDao.find(recipe.getCookBookId()));

         return recipe;
         
      } catch (EmptyResultDataAccessException e) {
         throw new NotFoundException();
      }
   }

   @Override
   public List<Recipe> findAll() {

      List<Recipe> recipes = jdbcTemplate.query("select * from RECIPE", new RecipeMapper());

      for (Recipe recipe : recipes) {
         recipe.setCookBook(cookBookDao.find(recipe.getCookBookId()));
      }

      return recipes;
   }

   @Override
   public void remove(Recipe recipe) {
      jdbcTemplate.update("delete from RECIPE where id = ?", recipe.getId());
   }

   private static final class RecipeMapper implements RowMapper<Recipe> {

      @Override
      public Recipe mapRow(ResultSet rs, int i) throws SQLException {
         Recipe recipe = new Recipe();
         recipe.setId(rs.getLong("ID"));
         recipe.setTitle(rs.getString("TITLE"));
         recipe.setDescription(rs.getString("DESCRIPTION"));
         recipe.setIngredients(rs.getString("INGREDIENTS"));
         recipe.setInstructions(rs.getString("INSTRUCTIONS"));
         recipe.setCookBookId(rs.getLong("COOKBOOK_ID"));
         return recipe;
      }
   }
}
