package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Entity
public class Cheese {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "cheeses")
    private List<Menu> menus;

    public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Cheese() { }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static class AddMenuItemForm {

        private Menu menu;

        private Iterable<Cheese> cheeses;

        @NotNull
        private int menuId;

        @NotNull
        private int cheeseId;

        public AddMenuItemForm(Menu menu, Iterable<Cheese> cheeses) {
            this.menu = menu;
            this.cheeses = cheeses;
        }

        public AddMenuItemForm() {
        }

        public Menu getMenu() {
            return menu;
        }

        public Iterable<Cheese> getCheeses() {
            return cheeses;
        }

        public int getMenuId() {
            return menuId;
        }

        public int getCheeseId() {
            return cheeseId;
        }
    }
}
