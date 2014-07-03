package rpc;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-7-2
 * Time: 下午5:59
 * To change this template use File | Settings | File Templates.
 */
public interface IMQ {
    public Boolean sendMessage(Message m) throws IllegalStateException;
    public Message recivedMessage() throws InterruptedException;
}
