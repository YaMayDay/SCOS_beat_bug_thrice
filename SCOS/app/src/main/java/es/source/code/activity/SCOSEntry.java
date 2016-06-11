package es.source.code.activity;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class SCOSEntry extends Activity {
    float x1=0;
    float x2=0;
    float y1=0;
    float y2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.entry);
    }

    public boolean onTouchEvent( MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //当手指按下的时候
            x1 = event.getX();
            y1 = event.getY();
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            //当手指抬起的时候
            x2 = event.getX();
            y2 = event.getY();
/*
            if (y1-y2>50){
                Toast.makeText(SCOSEntry.this,"向上滑",Toast.LENGTH_SHORT).show();
            }else if (y2-y1>50){
                Toast.makeText(SCOSEntry.this,"向下滑",Toast.LENGTH_SHORT).show();
            }else if(x1-x2>50){
                Toast.makeText(SCOSEntry.this,"向左滑",Toast.LENGTH_SHORT).show();
            } else if (x2-x1>50){
                Toast.makeText(SCOSEntry.this,"向右滑",Toast.LENGTH_SHORT).show();
            }
*/
         if(x1-x2>50)
            {
                Intent intent = new Intent("scos.intent.action.SCOSMAIN");
                intent.addCategory("scos.intent.category.SCOSLAUNCHER");

//                Intent intent =new Intent();
//                intent.setClass(SCOSEntry.this,MainScreen.class);
                intent.putExtra("EntryValue","FromEntry1");
                startActivity(intent);
            }
//            else if (x2-x1>50)
//            {
//               Intent intent1 = new Intent();
//                intent1.setClass(SCOSEntry.this,LoginOrRegister.class);
//                startActivity(intent1);
//             }

        }
            return super.onTouchEvent(event);
        }
    }
