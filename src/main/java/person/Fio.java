package person;

public class Fio {
    private final String lastName;
    private final String firstName;
    private final String middleName;


    public Fio(final String lastName, final String firstName, final String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
    @Override
    public final String toString() {
        return String.format("%s %s %s", lastName, firstName, middleName);
    }
}

