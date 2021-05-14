package dev.design.patterns.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Website {

    protected List<Page> pages = new ArrayList<>();

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public List<Page> getPages() {
        return pages;
    }

    public Website() {
        this.createWebsite();
    }

    protected abstract void createWebsite();

}
