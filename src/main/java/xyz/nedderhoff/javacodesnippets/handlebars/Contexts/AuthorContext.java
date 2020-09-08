package xyz.nedderhoff.javacodesnippets.handlebars.Contexts;

public class AuthorContext {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public AuthorContext setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AuthorContext setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
