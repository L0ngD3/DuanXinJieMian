package com.example.a13522.liaotian;

/**
 * Created by 13522 on 2017/7/11.
 */

public class Msg {
    public static final int TYPE_RECEIVED=0;
    public static final int TYPE_SEND=1;
    private String content;
    private int type;
    public Msg(String content, int type){
        this.content = content;
        this.type = type;
    }
    public String getContent(){
        return content;
    }

    public int getType(){
        return type;
    }
}
