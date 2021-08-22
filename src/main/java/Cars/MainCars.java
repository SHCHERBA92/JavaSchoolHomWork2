package Cars;

import java.util.ArrayList;
import java.util.Arrays;


public class MainCars {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>(Arrays.asList(new Car("Лада","Седан"),
                new Car("Лада", "хэтчбек"),
                new Car("Мерседес", "седан"),
                new Car("БМВ", "кросовер"),
                new Car("Форд", "хэтчбек"),
                new Car("Пежо", "кросовер"),
                new Car("Тойота", "седан")
                ));
        ArrayList<Car> carsHatchback = new ArrayList<>();
        ArrayList<Car> carsSedan = new ArrayList<>();
        ArrayList<Car> carsCross = new ArrayList<>();

        cars.forEach(car -> {
            switch (car.getType()){
                case "хэтчбек" -> carsHatchback.add(car);
                case "седан" -> carsSedan.add(car);
                case "кросовер" -> carsCross.add(car);
            }

        });
        System.out.println("========--Кроссовер--==========");
        carsCross.forEach(System.out::println);
        System.out.println("========--Седан--==========");
        for (Car car : carsSedan) {
            System.out.println(car);
        }
        System.out.println("========--хэтчбек--==========");
        carsHatchback.forEach(System.out::println);

    }
}
