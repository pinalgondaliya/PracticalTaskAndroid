package com.pinal.practicaltaskandroid.Model;

public class ShopByCategory {
   public String category_id;
   public String name;
   public String tint_color;
   public String image;
   public String sort_order;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTint_color() {
        return tint_color;
    }

    public void setTint_color(String tint_color) {
        this.tint_color = tint_color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSort_order() {
        return sort_order;
    }

    public void setSort_order(String sort_order) {
        this.sort_order = sort_order;
    }
}
