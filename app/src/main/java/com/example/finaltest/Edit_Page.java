package com.example.finaltest;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class Edit_Page extends AppCompatActivity {



    static final String mFILENAME="myusers.db";

    EditText et_site;
    EditText et_url;
    EditText et_user;
    EditText password;


    UsersDBHelper mHelper;




    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.edit_page);

        et_site=(EditText)findViewById(R.id.et_site);
        et_url=(EditText)findViewById(R.id.et_url);
        et_user=(EditText)findViewById(R.id.et_user);
        password=(EditText)findViewById(R.id.password);

        Intent intent=getIntent();
        String text1=intent.getStringExtra("TextIn1");
        String text2=intent.getStringExtra("TextIn2");
        String text3=intent.getStringExtra("TextIn3");

        if(text1!=null&&text2!=null&&text3!=null){
            et_site.setText(text1);
            et_url.setText(text2);
            et_user.setText(text3);

        }

        mHelper=new UsersDBHelper(this,mFILENAME,null,2);

//        display();
    }

    //취소, 등록x, 뒤로가기
    public void exit(){
        setResult(RESULT_CANCELED);
        finish();


    }

    //등록 버튼
    public void register(){

        //파일에 등록 후 리스트 초기화

        String et_site_=et_site.getText().toString();
        String et_url_=et_url.getText().toString();
        String et_name_=et_user.getText().toString();
        String et_password_=password.getText().toString();

        String sql="";
        sql+="insert into myusers values ( ";
        sql+="'"+et_site_+"',";
        sql+="'"+et_url_+"',";
        sql+="'"+et_name_+"'";
        sql+="'"+et_password_+"'";
        sql+=" )";

        Log.i("Edit_Page",sql);

        SQLiteDatabase db=mHelper.getWritableDatabase();
        db.execSQL(sql);

        display();


    }
    public void display() {
        SQLiteDatabase db = mHelper.getReadableDatabase();

        String sql = "select * from myusers";
        Cursor cursor = db.rawQuery(sql, null);


        while (cursor.moveToNext()) {
            String site = cursor.getString(0);
            String url = cursor.getString(1);
            String name = cursor.getString(2);
            String password1 = cursor.getString(3);

            //MainPage에게 EditText값 보내기
//            Intent intent = new Intent();
//            intent.putExtra("SITE", site);
//            intent.putExtra("URL", url);
//            intent.putExtra("NAME", name);
//            intent.putExtra("PASSWORD", password1);
//
//            setResult(RESULT_OK, intent);



        }


        finish();


    }

}
