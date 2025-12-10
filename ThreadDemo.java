class Clg extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("BMS College of Engineering");
                Thread.sleep(10000); 
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}

class CSE extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("CSE");
                Thread.sleep(2000); 
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}

public class ThreadDemo {
     public static void main(String[] args) {
        Clg a = new Clg();
        CSE b = new CSE();

        a.start();
        b.start();
    }
}