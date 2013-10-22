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
package eu.agilejava.design4cd.dao.websocket.json;

import eu.agilejava.design4cd.entities.CookBookUser;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

/**
 * JSON Utilities for CookBookuser.
 * 
 * @author Ivar Grimstad <ivar.grimstad@gmail.com>
 */
public class CookBookUserUtil {

   private CookBookUserUtil() {
   }

   /**
    * Creates a JSON builder from CookBookUser.
    * 
    * @param user The user
    * @return A builder
    */
   public static JsonObjectBuilder cookBookUserBuilder(CookBookUser user) {

      JsonObjectBuilder builder = Json.createObjectBuilder();

      if (user.getId() != null) {
         builder.add("id", user.getId());
      }

      builder.add("firstName", user.getFirstName())
              .add("lastName", user.getLastName())
              .add("email", user.getEmail())
              .add("password", user.getPassword());

      return builder;
   }

   /**
    * Creates a list of CookBookUser from JSON string.
    * 
    * @param message The JSON representing a list of users
    * @return A list of users
    */
   public static List<CookBookUser> cookBookUserListFromJson(String message) {
      List<CookBookUser> returnValue = new ArrayList<>();

      if (message != null) {
         try (JsonReader reader = Json.createReader(new StringReader(message))) {
            JsonArray array = reader.readArray();
            for (int i = 0; i < array.size(); i++) {
               JsonObject model = array.getJsonObject(i);
               returnValue.add(cookBookUserFromJsonObject(model));
            }
         }
      }
      return returnValue;
   }

   /**
    * Creates a CookBookUser from JSON object.
    * 
    * @param model The JSON object
    * @return The user
    */
   public static CookBookUser cookBookUserFromJsonObject(JsonObject model) {

      CookBookUser user = new CookBookUser();
      user.setId(Long.valueOf((long) model.getInt("id")));
      user.setFirstName(model.getString("firstName"));
      user.setLastName(model.getString("lastName"));
      user.setEmail(model.getString("email"));
      user.setPassword(model.getString("password"));

      return user;
   }

   /**
    * Creates a CookBookUser from JSON string.
    * 
    * @param message The JSON string
    * @return The user
    */
   public static CookBookUser cookBookUserFromJson(String message) {

      try (JsonReader reader = Json.createReader(new StringReader(message))) {
         return cookBookUserFromJsonObject(reader.readObject());
      }
   }

   /**
    * Creates JSON object from CookBookUser.
    * 
    * @param user The user
    * @return The JSON object
    */
   public static JsonObject createCookBookUserJson(CookBookUser user) {
      return cookBookUserBuilder(user).build();
   }
}
