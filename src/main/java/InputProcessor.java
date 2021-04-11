import person.*;

public class InputProcessor {

    public final String processInput(final String input) {
        String result;

        if (input.trim().matches("\\d{4}")) {
            // Создаём Person
            final int intCode = Integer.parseInt(input);
            Person person = PersonFactory.createPerson(intCode);

            result = person.toString();
        } else {
            result = "Неверный ввод.";
        }
        return result;
    }
}
