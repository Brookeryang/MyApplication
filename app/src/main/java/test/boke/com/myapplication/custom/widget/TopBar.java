package test.boke.com.myapplication.custom.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import test.boke.com.myapplication.R;

/**
 * <pre>
 *     author : 杨永红
 *     time   : 2017/07/02
 *     version: 1.0
 *     desc   : 自定义导航
 * </pre>
 */
public class TopBar extends RelativeLayout {

    private int mLeftTextColor;
    private Drawable mLeftBackground;
    private String mLeftText;
    private int mRighTextColor;
    private Drawable mRightBackground;
    private String mRightText;
    private float mTitlTextSize;
    private int mTitleTextColor;
    private String mTitle;
    private Button mLeftButton;
    private Button mRightButton;
    private TextView mTextView;
    private LayoutParams mLeftParams;
    private LayoutParams mRightParams;
    private LayoutParams mTitlepParams;
    private topbarClickListener mListener;//声明接口

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initResView(context, attrs);
    }

//    public TopBar(Context context) {
//        super(context);
//        initResView(context);
//    }

    private void initResView(Context context, AttributeSet attrs) {
        //获取所有属性的值
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        //从TypeArray中获取对应的值来设置的属性值
        mLeftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
        mLeftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText = ta.getString(R.styleable.TopBar_leftText);

        mRighTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
        mRightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
        mRightText = ta.getString(R.styleable.TopBar_rightText);

        mTitlTextSize = ta.getDimension(R.styleable.TopBar_titleTestSize, 10);
        mTitleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor, 0);
        mTitle = ta.getString(R.styleable.TopBar_title);
        //获取完后用recyle方法来避免重新创造的时候的错误
        ta.recycle();

        //创建元素
        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTextView = new TextView(context);
        //为左边创建的button元素赋值
        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);//sdk 版本大于15
        mLeftButton.setText(mLeftText);
        //为右边的Button元素赋值
        mRightButton.setTextColor(mRighTextColor);
        mRightButton.setBackground(mRightBackground);
        mRightButton.setText(mRightText);
        //为Title的元素赋值
        mTextView.setText(mTitle);
        mTextView.setTextColor(mTitleTextColor);
        mTextView.setTextSize(mTitlTextSize);
        mTextView.setGravity(Gravity.CENTER);

        //为组件元素创建布局
//        mLeftParams = new LayoutParams(
//                LayoutParams.WRAP_CONTENT,
//                LayoutParams.MATCH_PARENT);
        mLeftParams = new LayoutParams(
                45,
                45);
        mLeftParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        //添加到ViewGroup
        addView(mLeftButton, mLeftParams);

        mRightParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButton, mRightParams);

        mTitlepParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mTitlepParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTextView, mTitlepParams);


        //按钮的点击事件
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.rightClick();
            }
        });
        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.leftClick();
            }
        });


    }

    /**
     * 爆露一个方法给调用者来注册这个回调
     * 通过接口来获得回调者对接口方法的实现
     */
    public void setOnTopbarClickListener(topbarClickListener mListener) {
        this.mListener = mListener;
    }

    /**
     * 设置按钮是否需要显示
     * 通过ID和flag区分是否显示
     */
    public void setButtonVisable(int id, boolean flage) {
        if (flage) {
            if (id == 0) {
                mLeftButton.setVisibility(View.VISIBLE);
            } else {
                mRightButton.setVisibility(View.VISIBLE);
            }
        } else {
            if (id == 0) {
                mLeftButton.setVisibility(View.GONE);
            } else {
                mRightButton.setVisibility(View.GONE);
            }

        }
    }

}
