package com.qtec.studyboot.customer.vi;


/**
 * Created by duhc on 2017/12/5.
 *
 *  分析：
 *      入口方法main开始执行后，首先创建一个TestSync2对象和Thread对象，然后Thread对象执行start将线程状态又new装换为Runnable 交于cpu调用
 *      然后是主线程直接调用对象方法；
 *      f1和f2都是由synchronized修饰，synchronized是对象锁，没有指定时将该对象作为锁，因此f1和f2需要同一把锁，即两个线程争取同一个锁的过程，具体调用时不确定的
 *      但是可以枚举出两种情况：
 *          主线程先获取锁：
 *                  先执行f2，休眠250毫秒，然后将b赋值为2000，然后释放锁，交于thread线程执行f1，f1从等待变为Runnable状态将b赋值为1000，
 *                  此时主线程也在继续执行，此时如果是f1先执行赋值，则b值为1000，输出main的为1000，如果主线程先执行则输出f2的赋值2000
 *                  让后f1休眠500以后执行输出 必定为1000
 *           thread先获取锁
 *                      会先调用run()方法中的执行逻辑调用f1，将b1先赋值为1000，然后休眠500，休眠期间会释放cpu资源但是不会释放锁资源，因此f2继续等待，
 *                      执行下一条输出,此时b的值为1000,然后f1输出的值也是1000
 *
 */
public class TestSync implements Runnable {
    int b = 100;

    synchronized void f1() throws InterruptedException {
        //  logger.info("开始运行f1");
        b = 1000;
        Thread.sleep(500);
        System.out.println("f1=" + b);
    }

    synchronized void f2() throws InterruptedException {
        Thread.sleep(250);
        b = 2000;
    }

    public static void main(String[] args) throws InterruptedException {
        TestSync testSync = new TestSync();
        Thread thread = new Thread(testSync, "MAIN"); // 线程状态为  new

        thread.start(); // 就绪 开始可以执行 但是具体情况看底层cpu调用 runnable
        testSync.f2(); //main线程调用
        System.out.println("main thread b =" + testSync.b);
    }

    @Override
    public void run() {
        try {
            f1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
