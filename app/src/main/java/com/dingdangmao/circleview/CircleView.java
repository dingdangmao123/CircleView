package com.dingdangmao.circleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by suxiaohui on 2017/8/12.
 */

public class CircleView extends View {

    private String mTitle;
    private String subTitle;
    private int mColor;
    private float mSize;
    private float subSize;
    private int subColor;
    private float outRadius;
    private float innerRadius;
    private float strokeWidth;
    private int outColor;
    private int innerColor;
    private Paint p;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context,attrs,defStyle);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);
        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
        // Log.i("Unit","measure "+String.valueOf(widthSize)+" "+String.valueOf(heightSize));
        if(widthMode==MeasureSpec.AT_MOST&&heightMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(200,200);
        }else if(widthMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(200,heightSize);
        }else if(heightMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSize,200);
        }
    }

    private void init(Context context, AttributeSet attrs, int defStyle){

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleView, defStyle, 0);
        mTitle=a.getString(R.styleable.CircleView_mTitle);
        if(mTitle==null)
            mTitle="25%";
        subTitle=a.getString(R.styleable.CircleView_subTitle);
        if(subTitle==null)
            subTitle="hello";

        mColor=a.getColor(R.styleable.CircleView_mColor, Color.BLUE);
        subColor=a.getColor(R.styleable.CircleView_subColor,Color.GRAY);
        outRadius=a.getDimension(R.styleable.CircleView_outRadius,100);
        innerRadius=a.getDimension(R.styleable.CircleView_innerRadius,80);
        mSize=a.getDimension(R.styleable.CircleView_mSize,16);
        subSize=a.getDimension(R.styleable.CircleView_subSize,10);
        outColor=a.getColor(R.styleable.CircleView_outColor,Color.GRAY);
        innerColor=a.getColor(R.styleable.CircleView_innerColor,Color.CYAN);
        strokeWidth=a.getDimension(R.styleable.CircleView_width,5);

        a.recycle();
        p=new Paint();
        p.setAntiAlias(true);

    }
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        int width=getWidth();
        int height=getHeight();
        //Log.i("Unit","draw "+String.valueOf(width)+" "+String.valueOf(height));
        p.setColor(outColor);
        p.setStrokeWidth(this.strokeWidth);
        p.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(width/2,height/2,outRadius,p);

        p.setColor(innerColor);
        p.setStyle(Paint.Style.FILL);
        canvas.drawCircle(width/2,height/2,innerRadius,p);

        p.setColor(mColor);
        p.setTextSize(mSize);
        p.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(mTitle,width/2,height/2,p);

        Paint.FontMetrics m=p.getFontMetrics();
        p.setColor(subColor);
        p.setTextSize(subSize);
        p.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(subTitle,width/2,height/2+m.bottom-m.top,p);

    }
    public int getInnerColor() {
        return innerColor;
    }

    public void setInnerColor(int innerColor) {
        this.innerColor = innerColor;
    }

    public float getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(float innerRadius) {
        this.innerRadius = innerRadius;
    }

    public int getmColor() {
        return mColor;
    }

    public void setmColor(int mColor) {
        this.mColor = mColor;
    }

    public float getmSize() {
        return mSize;
    }

    public void setmSize(float mSize) {
        this.mSize = mSize;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getOutColor() {
        return outColor;
    }

    public void setOutColor(int outColor) {
        this.outColor = outColor;
    }

    public float getOutRadius() {
        return outRadius;
    }

    public void setOutRadius(float outRadius) {
        this.outRadius = outRadius;
    }

    public int getSubColor() {
        return subColor;
    }

    public void setSubColor(int subColor) {
        this.subColor = subColor;
    }

    public float getSubSize() {
        return subSize;
    }

    public void setSubSize(float subSize) {
        this.subSize = subSize;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
