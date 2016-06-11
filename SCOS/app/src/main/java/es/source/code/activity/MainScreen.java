package es.source.code.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by wangliqiang on 16/6/9.
 */

public class MainScreen extends Activity implements View.OnClickListener{
    private LinearLayout ordermeal_layout;
    private LinearLayout viewmenu_layout;
    private LinearLayout login_register_layout;
    private LinearLayout sys_help_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.search_line);
        ordermeal_layout=(LinearLayout)findViewById(R.id.ordermeal_layout);
        viewmenu_layout =(LinearLayout)findViewById(R.id.viewmenu_layout);
        login_register_layout=(LinearLayout)findViewById(R.id.login_register_layout);
        sys_help_layout=(LinearLayout)findViewById(R.id.sys_help_layout);

        ordermeal_layout.setOnClickListener(this);
        viewmenu_layout.setOnClickListener(this);
        login_register_layout.setOnClickListener(this);
        sys_help_layout.setOnClickListener(this);

        Intent intent =getIntent();
        String EntryValue = intent.getStringExtra("EntryValue");
        String LoginValue =intent.getStringExtra("LoginValue");

       if (!("FromEntry".equals(EntryValue)))
       {
            ordermeal_layout.setVisibility(View.INVISIBLE);
             viewmenu_layout.setVisibility(View.INVISIBLE);
       }
        if ("LoginSuccess".equals(LoginValue))
        {
            if(ordermeal_layout.getVisibility()==View.INVISIBLE)
            {
                ordermeal_layout.setVisibility(View.VISIBLE);
            }
            if (viewmenu_layout.getVisibility()==View.INVISIBLE)
            {
                viewmenu_layout.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onClick(View v) {
        int viewId =v.getId();
        switch (viewId){
            case R.id.ordermeal_layout:
                Toast.makeText(MainScreen.this,"you just clicked order meal！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.viewmenu_layout:
                Toast.makeText(MainScreen.this,"you just clicked viewmenu",Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_register_layout:
                Toast.makeText(MainScreen.this,"you just clicked loginregister",Toast.LENGTH_SHORT).show();
                Intent login_intent = new Intent(MainScreen.this,LoginOrRegister.class);
                startActivity(login_intent);
                break;
            case R.id.sys_help_layout:
                Toast.makeText(MainScreen.this,"you just clicked syshelp",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
