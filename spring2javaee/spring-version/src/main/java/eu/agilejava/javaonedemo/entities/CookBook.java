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
package eu.agilejava.javaonedemo.entities;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Ivar Grimstad (ivar.grimstad@gmail.com)
 */
public class CookBook implements Serializable {

   private static final long serialVersionUID = 15464814545856L;
   private Long id;
   private String name;
   // one-to-many, mapped-by-cookbook
   private List<Recipe> recipes;
   private CookBookUser owner;
   // many-to-one relationship mapping id
   private Long ownerId;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @JsonIgnore
   public List<Recipe> getRecipes() {
      return recipes;
   }

   public void setRecipes(List<Recipe> recipes) {
      this.recipes = recipes;
   }

   public CookBookUser getOwner() {
      return owner;
   }

   public void setOwner(CookBookUser owner) {
      this.owner = owner;
   }

   @JsonIgnore
   public Long getOwnerId() {
      return ownerId;
   }

   public void setOwnerId(Long ownerId) {
      this.ownerId = ownerId;
   }
   
   @Override
   public int hashCode() {
      int hash = 0;
      hash += (id != null ? id.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof CookBook)) {
         return false;
      }
      CookBook other = (CookBook) object;
      if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return name;
   }
}
