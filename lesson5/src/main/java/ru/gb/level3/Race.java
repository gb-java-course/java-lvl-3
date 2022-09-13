package ru.gb.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class Race {

    private final CountDownLatch readyCountDownLatch = new CountDownLatch(Lesson5.CARS_COUNT);
    private final CountDownLatch finishCountDownLatch = new CountDownLatch(Lesson5.CARS_COUNT);

    private final ArrayList<Stage> stages;

    private volatile Car winner;

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public void readyAwait() throws InterruptedException {
        readyCountDownLatch.await();
    }

    public void readyCountDown() {
        readyCountDownLatch.countDown();
    }

    public void finishAwait() throws InterruptedException {
        finishCountDownLatch.await();
    }

    public void finishCountDown() {
        finishCountDownLatch.countDown();
    }

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public synchronized void setWinner(Car car) {
        winner = car;
    }

    public Car getWinner() {
        return winner;
    }
}
