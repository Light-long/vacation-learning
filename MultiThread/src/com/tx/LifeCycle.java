package com.tx;

/**
 * 线程的生命周期：
 * 新建（new）：new Thread(Runnable)
 * 就绪：thread.start()
 * 运行：获取到CPU执行权
 * 阻塞：
 * 死亡：
 *
 * 线程生命周期过程：
 * 就绪-->运行：获取到cpu执行权
 * 运行-->就绪：失去cpu执行权
 * 运行-->阻塞：1. sleep(long millis)
 *            2. join()
 *            3. 线程同步锁
 *            4. wait()
 *            5. suspend()
 * 阻塞-->就绪：1. sleep时间到了
 *            2. join()的线程结束
 *            3. 获取到同步锁
 *            4. notify()/notifyAll()
 *            5. resume()
 * 运行-->死亡：1. 线程运行结束
 *            2. stop()
 *            3. 出现异常
 */
public class LifeCycle {
}
