package com.example.fanzhiyong20200309.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.fanzhiyong20200309.R;

public class CustomView extends View {
    //设置画笔
    Paint paint;

    //将数据展示出来
    int[] array= new int[]{2000,4000,4500,5000,2000,2500,3000,4300,4700,5000,1500};
    private int color;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
        color = typedArray.getColor(R.styleable.CustomView_drawColor, Color.RED);

        init();
    }

    private void init() {
        paint = new Paint();

        //设置画笔颜色
        paint.setColor(color);
    }

    public void setArray(int[] arr) {
        this.array = arr;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置x轴
        int sax = 0;
        //设置y轴
        int say = 100;


        for (int i=0;i<array.length;i++){
            canvas.drawLine(sax,say,sax+550,say-array[i],paint);

            //监控x轴和y轴的变化
            sax = sax + 550;
            say = say - array[i];
        }
    }
}
