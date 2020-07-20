package com.example.finaltest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //    static final String mFILENAME="myUsers.txt";
    ListView mListView;
    MyAdapter mAdapter=null;
    ArrayList<SiteInfo> mData=null;
    AlertDialog dialog;
    final static int ACTIVITY_EDIT=0;
    DialogInterface.OnClickListener mDlgListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.Init();
        mAdapter=new MyAdapter(this,mData);
        mListView=(ListView)findViewById(R.id.user_list);



        mListView.setAdapter(mAdapter);

        Intent intent=getIntent();

        //한번 눌렀을 때
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast비밀번호
//                String str=(String)parent.getAdapter().getItem(position);
                String str=mData.get(position).getmPassword();
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
            }
        });
//
//        //아이템 길게 눌렀을 때
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, final long id) {
                dialog=new AlertDialog.Builder(MainActivity.this).setTitle("이 사이트에 대해")
                        .setIcon(R.drawable.android_icon)
                        .setItems(new String[]{"수정하기","삭제하기"},new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which){
                                    case 0:
                                        //전달할 값 작성-putExtra사용..
                                        Intent intent=new Intent(MainActivity.this,Edit_Page.class);

                                        intent.putExtra("TextIn1",mData.get(position).getmName());
                                        intent.putExtra("TextIn2",mData.get(position).getmUrl());
                                        intent.putExtra("TextIn3",mData.get(position).getmUser());
                                        startActivity(intent);
                                        break;
                                    case 1:
                                        //삭제하기
                                        mData.remove(position);
                                        mAdapter.notifyDataSetChanged();
                                        break;
//                                    case AlertDialog.BUTTON_NEGATIVE:
//                                        break;
                                }
                            }
                        })
                        .setNegativeButton("취소",mDlgListener)
                        .show();

                return true;

            }
        });



    }
    public void Init(){

        mData=new ArrayList<SiteInfo>();
        mData.add(new SiteInfo("Google","www.google.com","bogyung","1111"));
        mData.add(new SiteInfo("naver","www.naver.com","bogyung2","2222"));

    }
    //다이얼로그 창 선택


    //새 계정 등록하기 버튼
    public void mOnRegisterClick(View v){

        Intent intent=new Intent(this,Edit_Page.class);
        startActivity(intent);
//        startActivityForResult(intent,ACTIVITY_EDIT);

    }
    //Edit_Page의 응답 처리
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode) {
//            case ACTIVITY_EDIT:
//                if (resultCode == RESULT_OK) {
//
//                    mData.add(new SiteInfo(data.getStringExtra("SITE"),
//                            data.getStringExtra("URL"),
//                            data.getStringExtra("NAME"),
//                            data.getStringExtra("PASSWORD")));
//
//                    mAdapter.notifyDataSetChanged();
//
//                }
//                else{
//                    Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
//                }
//                break;
//        }
//    }

    public void mOnExitClick(View v){

        finish();

    }
}
