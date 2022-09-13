package ru.gb.level3;

public class Car implements Runnable {

    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }

    private final Race race;
    private final int speed;
    private final String name;

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            race.readyCountDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            race.readyAwait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        if (race.getWinner() == null) {
            race.setWinner(this);
            System.out.println(name + " - WIN");
        }

        race.finishCountDown();
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
