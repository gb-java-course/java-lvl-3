package ru.gb.level3;

public class ABCPrinter {

    private volatile char curChar = 'A';

    public static void main(String[] args) {
        var abc = new ABCPrinter();

        new Thread(abc::printA).start();
        new Thread(abc::printB).start();
        new Thread(abc::printC).start();
    }

    public synchronized void printA() {
        try {
            for (int i = 0; i < 5; i++) {
                while (curChar != 'A') {
                    wait();
                }
                System.out.print('A');
                curChar = 'B';
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printB() {
        try {
            for (int i = 0; i < 5; i++) {
                while (curChar != 'B') {
                    wait();
                }
                System.out.print('B');
                curChar = 'C';
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printC() {
        try {
            for (int i = 0; i < 5; i++) {
                while (curChar != 'C') {
                    wait();
                }
                System.out.print('C');
                curChar = 'A';
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
