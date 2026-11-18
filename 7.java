class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try { Thread.sleep(100); } catch (Exception e) {}
        }
    }
}

class AlphabetThread extends Thread {
    public void run() {
        for (char c = 'A'; c <= 'J'; c++) {
            System.out.println(Thread.currentThread().getName() + ": " + c);
            try { Thread.sleep(100); } catch (Exception e) {}
        }
    }
}

public class ThreadTask {
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread();
        AlphabetThread t2 = new AlphabetThread();

        t1.setName("NumberThread");
        t2.setName("AlphabetThread");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}