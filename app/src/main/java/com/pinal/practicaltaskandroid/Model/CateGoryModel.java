package com.pinal.practicaltaskandroid.Model;


import java.util.List;

public class CateGoryModel {
    public List<Category> categories;
    public String banner_image;
    public String status;
    public String message;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getBannerImage() {
        return banner_image;
    }

    public void setBannerImage(String banner_image) {
        this.banner_image = banner_image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static class Category {
        public String category_id;
        public String category_name;
        public String parent_id;
        public List<Child> child;

        public String getCategoryId() {
            return category_id;
        }

        public void setCategoryId(String categoryId) {
            this.category_id = categoryId;
        }

        public String getCategoryName() {
            return category_name;
        }

        public void setCategoryName(String category_name) {
            this.category_name = category_name;
        }

        public String getParentId() {
            return parent_id;
        }

        public void setParentId(String parent_id) {
            this.parent_id = parent_id;
        }

        public List<Child> getChild() {
            return child;
        }

        public void setChild(List<Child> child) {
            this.child = child;
        }
    }


    public static class Child {
        public String category_id;
        public String category_name;
        public String parentId;

        public String getCategoryId() {
            return category_id;
        }

        public void setCategoryId(String category_id) {
            this.category_id = category_id;
        }

        public String getCategoryName() {
            return category_name;
        }

        public void setCategoryName(String category_name) {
            this.category_name = category_name;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

    }



}
