package xyz.nedderhoff.springbootbasic.handlebars.Contexts;

import java.util.List;

public class BookContext {
    private String title;
    private StoryContext story;
    private List<AuthorContext> authors;
    private boolean published;
    private boolean copyright;

    public String getTitle() {
        return title;
    }

    public BookContext setTitle(String title) {
        this.title = title;
        return this;
    }

    public StoryContext getStory() {
        return story;
    }

    public BookContext setStory(StoryContext story) {
        this.story = story;
        return this;
    }

    public List<AuthorContext> getAuthors() {
        return authors;
    }

    public BookContext setAuthors(List<AuthorContext> authors) {
        this.authors = authors;
        return this;
    }

    public boolean getPublished() {
        return published;
    }

    public BookContext setPublished(boolean published) {
        this.published = published;
        return this;
    }

    public boolean isCopyright() {
        return copyright;
    }

    public BookContext setCopyright(boolean copyright) {
        this.copyright = copyright;
        return this;
    }
}
