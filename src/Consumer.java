public class Consumer implements Runnable {
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (TestPC.queue){

                if(!TestPC.queue.isEmpty()){
                    TestPC.queue.poll();
                    System.out.println(Thread.currentThread().getName()+"消费商品");
                }
                else {
                    TestPC.queue.notify();
                }
            }
        }
    }
}
