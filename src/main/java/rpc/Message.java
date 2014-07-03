package rpc;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-7-2
 * Time: 下午4:40
 * To change this template use File | Settings | File Templates.
 */
public class Message implements Serializable{
    private String m;

    public Message(String m) {
        this.m = m;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
}
