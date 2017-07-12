package com.example.a13522.liaotian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
        initMsgs();

        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        //LinearLayoutManager 线性布局的意思
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //setLayoutManager 显示上面上面的线性布局效果
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString().intern();
                if (!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);//有新消息时刷新
                    msgRecyclerView.scrollToPosition(msgList.size()-1);//将listView定位在最后
                    inputText.setText("");//清空输入内容

                }else if ("".equals(content)){
                    Toast.makeText(getApplicationContext(),"请输入内容",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initMsgs(){
      Msg msg1=  new Msg("Hello World",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2=  new Msg("What's your name?",Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3=  new Msg("My name is Tom",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
