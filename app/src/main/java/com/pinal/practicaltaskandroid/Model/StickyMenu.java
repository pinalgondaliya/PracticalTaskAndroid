package com.pinal.practicaltaskandroid.Model;

import java.util.List;

public class StickyMenu {
    private List<Menu> main_sticky_menu;
    private String status;
    private String message;

    public List<Menu> getMainStickyMenu() {
        return main_sticky_menu;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public static class Menu {
        public String title;
        public String image;
        public String sort_order;
        public List<SliderImage> slider_images;

        public String getTitle() {
            return title;
        }

        public String getImage() {
            return image;
        }

        public String getSortOrder() {
            return sort_order;
        }

        public List<SliderImage> getSliderImages() {
            return slider_images;
        }
    }

    public static class SliderImage {
        public String title;
        public String image;
        public String sort_order;
        public String cta;

        public String getTitle() {
            return title;
        }

        public String getImage() {
            return image;
        }

        public String getSortOrder() {
            return sort_order;
        }

        public String getCta() {
            return cta;
        }
    }
}

