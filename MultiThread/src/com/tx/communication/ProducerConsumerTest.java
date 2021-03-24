package com.tx.communication;

/**
 * 生产者消费者问题
 * 生产者生产产品，消费者消费产品
 */

// 店员
class Clerk {
    // 产品数量
    private int productCount = 0;

    // 生产产品（因为考虑到线程安全问题，需要把此方法定义为同步方法，两个方法共用一个同步监视器this）
    public synchronized void produceProduct() {
        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName()+"生产第"+productCount+"个产品");

            // 唤醒
            this.notifyAll();
        } else {
            // 等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    // 消费产品
    public synchronized void consumeProduct() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName()+"消费第"+productCount+"个产品");
            productCount--;

            // 唤醒
            this.notifyAll();
        } else {
            // 等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 生产者
class Producer implements Runnable{
    private Clerk clerk;
    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"生产产品");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //  生产产品
            clerk.produceProduct();
        }
    }
}

// 消费者
class Consumer implements Runnable{
    private Clerk clerk;
    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"消费产品");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}
public class ProducerConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        // 共享同一个数据
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        Thread p1 = new Thread(producer);
        p1.setName("生产者1");
        Thread c1 = new Thread(consumer);
        c1.setName("消费者1");

        p1.start();
        c1.start();
    }
}
