package es.source.code.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by wangliqiang on 16/6/9.
 */

public class LoginOrRegister extends Activity implements View.OnClickListener{
    private EditText login_name;
    private EditText login_pwd;
    private Button login;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_register);

        login_name=(EditText)findViewById(R.id.login_name);
        login_pwd=(EditText)findViewById(R.id.login_pwd);
        login=(Button)findViewById(R.id.login);
        back=(Button)findViewById(R.id.back);

        login.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId=v.getId();
        switch (viewId)
        {
            case R.id.login:
                if (EmptyEditText(login_name))
                {
                    login_name.setError("输入内容不符合规则");
                }
                else
                {
                    login_name.setError(null);
                }
                if (EmptyEditText(login_pwd))
                {
                    login_pwd.setError("输入内容不符合规则");
                }
                else
                {
                    login_pwd.setError(null);
                }
                if((!EmptyEditText(login_name))&&(!EmptyEditText(login_pwd)))
                {
                    Intent login_intent =new Intent(LoginOrRegister.this,MainScreen.class);
                    login_intent.putExtra("LoginValue","LoginSuccess");
                    startActivity(login_intent);
                }
                break;
            case R.id.back:
                Intent back_intent = new Intent(LoginOrRegister.this,MainScreen.class);
                back_intent.putExtra("BackValue","Return");
                startActivity(back_intent);
                break;
            default:
        }

    }
    public boolean EmptyEditText(EditText...editTexts)
    {
       for (EditText et:editTexts)
       {
           if (et.getText()==null)
               return true;
           if (et.getText().toString().trim().equals(""))
               return true;
           if (!isLetterDigit(et.getText().toString()))
               return true;
       }
        return false;
    }
    public  boolean isLetterDigit(String str) {
        String regex = "^[a-z0-9A-Z]+$";
        return str.matches(regex);
    }
}
