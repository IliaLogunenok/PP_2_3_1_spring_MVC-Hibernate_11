package web.model;

public class Car {
    private final String model;
    private final int releaseYear;
    private final int id;

    public Car(String model, int releaseYear, int id) {
        this.model = model;
        this.releaseYear = releaseYear;
        this.id = id;
    }


    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", releaseYear=" + releaseYear +
                ", cost=" + id +
                '}';
    }
}
