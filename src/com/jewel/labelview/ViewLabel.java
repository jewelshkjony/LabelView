package com.jewel.labelview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

public class ViewLabel extends View {

    Paint mTextPaint;
    int mTextColor;
    float mTextSize;
    float mTextHeight;
    float mTextWidth;
    int mTextStyle;

    Paint mNumPaint;
    int mNumColor;
    float mNumSize;
    float mNumHeight;
    float mNumWidth;
    int mNumStyle;

    float mTopPadding;
    float mBottomPadding;
    float mCenterPadding;

    Paint mTrianglePaint;
    int mBackGroundColor;

    float mDegrees;

    String mText = "Top";
    String mNum = "01";

    int width;
    int height;

    public static final int DEGREES_LEFT = -45;
    public static final int DEGREES_RIGHT = 45;

    public ViewLabel(Context context) {
        super(context);

        mTopPadding = dp2px(7);
        mCenterPadding = dp2px(3);
        mBottomPadding = dp2px(3);

        mBackGroundColor = Color.parseColor("#66000000");
        mTextColor = Color.WHITE;
        mNumColor = Color.WHITE;

        mTextSize = sp2px(8);
        mNumSize = sp2px(11);

        mTextStyle = 0;
        mNumStyle = 2;

        mDegrees = 45;

        initTextPaint();
        initNumPaint();
        initTrianglePaint();

        initTextPaint();
        initNumPaint();
        initTrianglePaint();
    }

    public void setText(String text) {
        mText = text;
        resetTextStatus();
        invalidate();
    }

    public void setTextSize(float size) {
        mTextSize = sp2px(size);
        invalidate();
    }

    public void setTextStyle(int style) {
        mTextStyle = style;
        invalidate();
    }

    public void setTextColor(int color) {
        mTextColor = color;
        invalidate();
    }

    public void setNum(String num) {
        mNum = num;
        resetNumStatus();
        invalidate();
    }

    public void setNumSize(float size) {
        mNumSize = sp2px(size);
        invalidate();
    }

    public void setNumStyle(int style) {
        mNumStyle = style;
        invalidate();
    }

    public void setNumberColor(int color) {
        mNumColor = color;
        invalidate();
    }

    public void setBackGroundColor(int color) {
        mTrianglePaint.setColor(color);
        invalidate();
    }

    public void setDirection(int direction) {
        mDegrees = direction;
        invalidate();
    }

    public void setTopPadding(float padding) {
        mTopPadding = dp2px(padding);
        invalidate();
    }

    public void setCenterPadding(float padding) {
        mCenterPadding = dp2px(padding);
        invalidate();
    }

    public void setBottomPadding(float padding) {
        mBottomPadding = dp2px(padding);
        invalidate();
    }

    private void initTextPaint() {
        // Initializes a brush for drawing decorative text
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextSize(mTextSize);
        if (mTextStyle == 1) {
            mTextPaint.setTypeface(Typeface.SANS_SERIF);
        } else if (mTextStyle == 2) {
            mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    private void initNumPaint() {
        // Initialize a brush for drawing numeric text
        mNumPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mNumPaint.setColor(mNumColor);
        mNumPaint.setTextAlign(Paint.Align.CENTER);
        mNumPaint.setTextSize(mNumSize);
        if (mNumStyle == 1) {
            mNumPaint.setTypeface(Typeface.SANS_SERIF);
        } else if (mNumStyle == 2) {
            mNumPaint.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    private void initTrianglePaint() {
        // Initialize the brush for drawing the triangle background
        mTrianglePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTrianglePaint.setColor(mBackGroundColor);
    }

    private void resetTextStatus() {
        // measure text height
        Rect rectText = new Rect();
        mTextPaint.getTextBounds(mText, 0, mText.length(), rectText);
        mTextWidth = rectText.width();
        mTextHeight = rectText.height();
    }

    private void resetNumStatus() {
        // measure digital height
        Rect rectNum = new Rect();
        mNumPaint.getTextBounds(mNum, 0, mNum.length(), rectNum);
        mNumWidth = rectNum.width();
        mNumHeight = rectNum.height();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        canvas.save();

        // Displace and rotate canvas
        canvas.translate(0, (float) ((height * Math.sqrt(2)) - height));
        if (mDegrees == DEGREES_LEFT) {
            canvas.rotate(mDegrees, 0, height);
        } else if (mDegrees == DEGREES_RIGHT) {
            canvas.rotate(mDegrees, width, height);
        }

        // draw triangle background
        Path path = new Path();
        path.moveTo(0, height);
        path.lineTo(width / 2, 0);
        path.lineTo(width, height);
        path.close();
        canvas.drawPath(path, mTrianglePaint);
        // draw decorative text
        canvas.drawText(mText, (width) / 2, mTopPadding + mTextHeight, mTextPaint);
        // draw numeric text
        canvas.drawText(mNum, (width) / 2, (mTopPadding + mTextHeight + mCenterPadding + mNumHeight), mNumPaint);

        canvas.restore();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        height = (int) (mTopPadding + mCenterPadding + mBottomPadding + mTextHeight + mNumHeight);
        width = 2 * height;
        // The true height of the controls, the Pythagorean theorem...
        int realHeight = (int) (height * Math.sqrt(2));
        setMeasuredDimension(width, realHeight);
    }

    public int dp2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public float sp2px(float spValue) {
        final float scale = getContext().getResources().getDisplayMetrics().scaledDensity;
        return spValue * scale;
    }
}
