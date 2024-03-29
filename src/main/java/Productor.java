import rpc.IMQ;
import rpc.MQ;
import rpc.Message;
import rpc.RpcFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-7-2
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
public class Productor {

    private static ExecutorService pool = Executors.newFixedThreadPool(2);

    public static void produce(){
        //提交两个任务给线程池
        pool.submit(new Task());
        pool.submit(new Task());
    }

    static class Task implements Runnable {

        private Boolean isStop = false;
        private IMQ mq;

        public Task(){
            try {
                mq = RpcFramework.refer(IMQ.class, "127.0.0.1", 1234);
            } catch (Exception e) {
                System.out.print("Rpc Exception Happened!");
                this.isStop = true;
            }
        }

        @Override
        public void run() {
            while (!isStop){
                Message m = new Message(Thread.currentThread().getName() + " send message...");
                if(mq.sendMessage(m) ){
                    System.out.println("【" + Thread.currentThread().getName() +"】send message to mq --> " + m.getM());
                }else {
                    Threads.sleep(2 * 1000L);
                    System.out.println("【" + Thread.currentThread().getName() +"】mq is full...again! ");
                }
            }
        }
    }

    public static void main(String[] args){
        Productor.produce();
    }
}
