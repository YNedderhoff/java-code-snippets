package xyz.nedderhoff.javacodesnippets.springapi.transactional;


public class TransactionalEntity {

    private final String firstName;
    private final String lastName;

    public TransactionalEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
