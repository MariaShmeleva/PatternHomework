package person;

import person.appearance.Appearance;

public final class Person {

    private int id;
    private Fio fio;
    private Physical phys;
    private Appearance appearance;
    private Phone phone;

    private Person() { }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder()
                .append(String.format("%04d", id)).append("\n")
                .append(fio).append("\n")
                .append(phys).append("\n")
                .append(appearance).append("\n");
        if (phone != null) {
            sb.append(phone);
        } else {
            sb.append("Телефона нет");
        }
        return sb.toString();
    }

    public static class PersonBuilder {
        private final int id;
        private final Fio fio;
        private final Physical phys;
        private final Appearance appearance;
        private Phone phone;

        public PersonBuilder(final int id,
                             final Fio fio,
                             final Physical phys,
                             final Appearance appearance) {
            this.id = id;
            this.fio = fio;
            this.phys = phys;
            this.appearance = appearance;
        }
        public PersonBuilder withPhone(final Phone phone) {
            this.phone = phone;
            return this;
        }
        public Person build() {
            final Person person = new Person();
            person.id = this.id;
            person.fio = this.fio;
            person.appearance = this.appearance;
            person.phys = this.phys;
            person.phone = this.phone;
            return person;
        }

    }
}

