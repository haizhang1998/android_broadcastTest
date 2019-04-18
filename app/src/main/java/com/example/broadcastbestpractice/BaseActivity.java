package com.example.broadcastbestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 咯还长 on 2019/4/18.
 */

public class BaseActivity extends AppCompatActivity {

    ForceBreakoutReceiver forceBreakoutReceiver;
    IntentFilter intentFilter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.addActivity(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.broadcastbestPractice.FORCE_OFFLINE");
        forceBreakoutReceiver=new ForceBreakoutReceiver();
        registerReceiver(forceBreakoutReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(forceBreakoutReceiver!=null){
        unregisterReceiver(forceBreakoutReceiver);
        forceBreakoutReceiver=null;
        }
    }

    class ForceBreakoutReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder dialog=new AlertDialog.Builder(context);
            dialog.setTitle("ForceBreakout Mention");
            dialog.setCancelable(false);
            dialog.setMessage("please check your connection and login agian!");
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityController.finishAll();
                    Intent i=new Intent(context,LoginActivity.class);
                    context.startActivity(i);
                }
            });
            dialog.show();
        }
    }


}
