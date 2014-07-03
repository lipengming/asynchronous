/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-7-2
 * Time: 下午5:33
 * To change this template use File | Settings | File Templates.
 */
public class Threads {
    public static void sleep(Long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
