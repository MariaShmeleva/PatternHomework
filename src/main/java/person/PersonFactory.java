package person;

import generators.*;



import person.appearance.Appearance;

public class PersonFactory {

    public  static Person createPerson(final int intCode) {
        final FioGeneratorAdapter fioGeneratorAdapter = new FioGeneratorAdapter(new FioGenerator());
        fioGeneratorAdapter.generateParams(intCode);
        final Fio fio = fioGeneratorAdapter.buildResponse();

        final PhysGenerator physGenerator = new PhysGenerator();
        physGenerator.generateParams(intCode);
        final Physical physical = physGenerator.buildResponse();

        final AppearanceGenerator appearanceGenerator = new AppearanceGenerator();
        appearanceGenerator.generateParams(intCode);
        final Appearance appearance = appearanceGenerator.buildResponse();

        Person.PersonBuilder personBuilder = new Person.PersonBuilder(intCode,
                fio,
                physical,
                appearance);
        // добавляем телефон, только если введённый код не палиндром
        if (!String.valueOf(intCode).equals(new StringBuilder(String.valueOf(intCode)).reverse().toString())) {
            final PhoneGenerator phoneGenerator = new PhoneGenerator();
            phoneGenerator.generateParams(intCode);
            personBuilder.withPhone(phoneGenerator.buildResponse());
        }

        return personBuilder.build();
    }
}
