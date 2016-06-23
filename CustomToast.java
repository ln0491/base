package com.ghg.rxjavademo;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 刘楠 on 2016/6/16 0016 16:26.
 */
public class CustomToast extends Toast {



    public CustomToast(Context context) {
        super(context);

    }



    public static Toast makeText(Context context, CharSequence text,  int duration) {


        Toast result = new Toast(context);

        LayoutInflater inflate = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View     v  = inflate.inflate(R.layout.custom_toast, null);

        TextView tv = (TextView)v.findViewById(R.id.tv_toast_message);

        tv.setText(text);


        result.setView(v);

        result.setGravity(Gravity.CENTER,0,0);

        result.setDuration(duration);

        return result;


    }

}
