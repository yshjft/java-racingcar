package step4.service;

import step4.domain.Car;
import step4.domain.Name;
import step4.domain.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private static final int RANDOM_BOUND = 10;
    public static final String NAME_SEPARATE_DELIMITER = ",";

    private List<Car> cars;

    public RacingCarGame(String name) {
        final String[] names = name.split(NAME_SEPARATE_DELIMITER);
        this.cars = initCarStatus(names);
    }

    private static List<Car> initCarStatus(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            final Car car = new Car(Position.create(), Name.from(name));
            cars.add(car);
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void playing() {
        for (Car car : cars) {
            final ForwardStrategy strategy = new RacingCarForward(new RandomNumberGenerator());
            car.forward(strategy);
        }
    }

    public List<Position> carPositions() {
        return cars.stream().map(Car::toPosition).collect(Collectors.toList());
    }

    public List<Name> carNames() {
        return cars.stream().map(Car::toName).collect(Collectors.toList());
    }

    public List<Name> winnerNames() {
        List<Name> names = new ArrayList<>();
        final Position winner = Position.winnerPosition(carPositions());

        for (Car car : cars) {
            addWinnerCarName(names, winner, car);
        }

        return names;
    }

    private static void addWinnerCarName(List<Name> names, Position winner, Car car) {
        if (car.isWinner(winner)) {
            names.add(car.toName());
        }
    }
}