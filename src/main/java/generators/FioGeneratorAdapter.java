package generators;

import person.Fio;

public class FioGeneratorAdapter implements Generator<Fio> {
    private final FioGenerator fioGenerator;

    public FioGeneratorAdapter(final FioGenerator fioGenerator) {
        this.fioGenerator = fioGenerator;
    }

    @Override
    public void generateParams(final int code) {
        fioGenerator.generateParams(code);
    }

    @Override
    public Fio buildResponse() {
        Fio fio = new Fio(fioGenerator.getLastName(), fioGenerator.getFirstName(), fioGenerator.getMiddleName());
        return fio;
    }
}
