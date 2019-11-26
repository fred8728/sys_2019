/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author fskn
 */
@Entity
public class CustomRecipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customR")
    private Integer id;
    @Column(name = "name_customR")
    private String name;
    @Column(name = "portion_customR")
    private int portion_size;
    @Column(name = "time_customR")
    private int cooking_time;
    @Column(name = "ingredients_customR")
    private String ingredients;
    @Column(name = "description_customR")
    private String description;
    
    @ManyToOne
    private User user;

    public CustomRecipe(String name, int portion_size, int cooking_time, String ingredients, String description) {
        this.name = name;
        this.portion_size = portion_size;
        this.cooking_time = cooking_time;
        this.ingredients = ingredients;
        this.description = description;
    }

    public CustomRecipe() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPortion_size() {
        return portion_size;
    }

    public void setPortion_size(int portion_size) {
        this.portion_size = portion_size;
    }

    public int getCooking_time() {
        return cooking_time;
    }

    public void setCooking_time(int cooking_time) {
        this.cooking_time = cooking_time;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    

    @Override
    public String toString() {
        return "Custom_recipe{" + "name=" + name + ", portion_size=" + portion_size + ", cooking_time=" + cooking_time + ", ingredients=" + ingredients + ", description=" + description + ", user=" + user + '}';
    }

}