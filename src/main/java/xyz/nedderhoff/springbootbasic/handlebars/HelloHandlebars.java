package xyz.nedderhoff.springbootbasic.handlebars;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;

import xyz.nedderhoff.springbootbasic.handlebars.Contexts.AuthorContext;
import xyz.nedderhoff.springbootbasic.handlebars.Contexts.BookContext;
import xyz.nedderhoff.springbootbasic.handlebars.Contexts.StoryContext;


public class HelloHandlebars {
    /*
    public static void main(String[] args) throws IOException {
        ClassPathTemplateLoader classPathTemplateLoader = new ClassPathTemplateLoader("/templates", ".template");
        Handlebars handlebars = new Handlebars(classPathTemplateLoader);

        // Inline HelloWorld
        Template template1 = handlebars.compileInline("Hello {{this}}!");
        System.out.println(template1.apply("Handlebars.java"));

        // builtin-helpers-test.template
        Template template2 = handlebars.compile("builtin-helpers-test");
        BookContext bookContext = createBookContext();
        System.out.println(template2.apply(bookContext));
    }
    */
    public static void main(String[] args) throws IOException {
        ClassPathTemplateLoader classPathTemplateLoader = new ClassPathTemplateLoader("/templates", ".template");
        Handlebars handlebars = new Handlebars(classPathTemplateLoader);
        Template template2 = handlebars.compile("simple");
        List<String> hashtags = Arrays.asList("hashtag1", "hashtag2");
        List<String> hashtags2 = Collections.emptyList();
        Map<String, Object> mymap = new HashMap<>();
        mymap.put("myarray", null);
        System.out.println(template2.apply(mymap));
    }

    private static BookContext createBookContext(){
        return new BookContext()
                .setTitle("Awesome title")
                .setStory(new StoryContext().setName("Awesome name"))
                .setAuthors(Arrays.asList(
                        new AuthorContext()
                                .setFirstName("Yanick")
                                .setLastName("Nedderhoff"),
                        new AuthorContext()
                                .setFirstName("Max")
                                .setLastName("Mustermann")
                ))
                .setPublished(false)
                .setCopyright(false);
    }
}
