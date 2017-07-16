package test.boke.com.myapplication.custo.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import test.boke.com.myapplication.R;

/**
 * Created by Allen on 2017/7/1.
 * <p>
 * 打造万能的TextView布局满足市面常见的布局样式
 */

public class SuperTextView2 extends RelativeLayout {

    private Context mContext;

    private BaseTextView leftView, centerView, rightView;
    private LayoutParams leftBaseViewParams, centerBaseViewParams, rightBaseViewParams;

    private ImageView leftIconIV, rightIconIV;
    private LayoutParams leftImgParams, rightImgParams;
    private int leftIconWidth;//左边图标的宽
    private int leftIconHeight;//左边图标的高

    private int rightIconWidth;//右边图标的宽
    private int rightIconHeight;//右边图标的高

    private int leftIconMarginLeft;//左边图标的左边距
    private int rightIconMarginRight;//右边图标的右边距

    private Drawable leftIconRes;//左边图标资源
    private Drawable rightIconRes;//右边图标资源


    private int defaultColor = 0xFF373737;//文字默认颜色
    private int defaultSize = 15;//默认字体大小
    private int defaultMaxEms = 10;


    private String mLeftTextString;
    private String mLeftTopTextString;
    private String mLeftBottomTextString;

    private String mRightTextString;
    private String mRightTopTextString;
    private String mRightBottomTextString;

    private String mCenterTextString;
    private String mCenterTopTextString;
    private String mCenterBottomTextString;


    private int mLeftTextColor;
    private int mLeftTopTextColor;
    private int mLeftBottomTextColor;

    private int mCenterTextColor;
    private int mCenterTopTextColor;
    private int mCenterBottomTextColor;

    private int mRightTextColor;
    private int mRightTopTextColor;
    private int mRightBottomTextColor;


    private int mLeftTextSize;
    private int mLeftTopTextSize;
    private int mLeftBottomTextSize;

    private int mRightTextSize;
    private int mRightTopTextSize;
    private int mRightBottomTextSize;

    private int mCenterTextSize;
    private int mCenterTopTextSize;
    private int mCenterBottomTextSize;

    private int mLeftTopLines;
    private int mLeftLines;
    private int mLeftBottomLines;

    private int mCenterTopLines;
    private int mCenterLines;
    private int mCenterBottomLines;

    private int mRightTopLines;
    private int mRightLines;
    private int mRightBottomLines;

    private int mLeftTopMaxEms;
    private int mLeftMaxEms;
    private int mLeftBottomMaxEms;

    private int mCenterTopMaxEms;
    private int mCenterMaxEms;
    private int mCenterBottomMaxEms;

    private int mRightTopMaxEms;
    private int mRightMaxEms;
    private int mRightBottomMaxEms;

    private boolean mLeftTopTextBold;
    private boolean mLeftTextBold;
    private boolean mLeftBottomTextBold;

    private boolean mCenterTopTextBold;
    private boolean mCenterTextBold;
    private boolean mCenterBottomTextBold;

    private boolean mRightTopTextBold;
    private boolean mRightTextBold;
    private boolean mRightBottomTextBold;

    private Drawable mLeftTvDrawableLeft;
    private Drawable mLeftTvDrawableRight;

    private Drawable mCenterTvDrawableLeft;
    private Drawable mCenterTvDrawableRight;

    private Drawable mRightTvDrawableLeft;
    private Drawable mRightTvDrawableRight;

    private int mTextViewDrawablePadding;

    private static final int gravity_Left_Center = 0;
    private static final int gravity_Center = 1;
    private static final int gravity_Right_Center = 2;

    private static final int default_Gravity = 1;

    private int mLeftGravity;
    private int mCenterGravity;
    private int mRightGravity;


    private int mLeftViewWidth;

    private View topDividerLineView, bottomDividerLineView;

    private LayoutParams topDividerLineParams, bottomDividerLineParams;
    private int mTopDividerLineMarginLR;
    private int mTopDividerLineMarginLeft;
    private int mTopDividerLineMarginRight;

    private int mBottomDividerLineMarginLR;
    private int mBottomDividerLineMarginLeft;
    private int mBottomDividerLineMarginRight;

    private int mDividerLineType;
    private int mDividerLineColor;
    private int mDividerLineHeight;

    private int mDefaultDividerLineColor = 0xFFE8E8E8;//分割线默认颜色

    /**
     * 分割线的类型
     */
    private static final int NONE = 0;
    private static final int TOP = 1;
    private static final int BOTTOM = 2;
    private static final int BOTH = 3;
    private static final int default_Divider = BOTTOM;

    private int default_Margin = 10;

    private int mLeftViewMarginLeft;
    private int mLeftViewMarginRight;

    private int mCenterViewMarginLeft;
    private int mCenterViewMarginRight;

    private int mRightViewMarginLeft;
    private int mRightViewMarginRight;


    private boolean useRipple;
    private Drawable mBackground_drawable;

    private OnSuperTextViewClickListener onSuperTextViewClickListener;

//    private OnLeftTopTvClickListener leftTopTvClickListener;
//    private OnLeftTvClickListener leftTvClickListener;
//    private OnLeftBottomTvClickListener leftBottomTvClickListener;
//
//    private OnCenterTopTvClickListener centerTopTvClickListener;
//    private OnCenterTvClickListener centerTvClickListener;
//    private OnCenterBottomTvClickListener centerBottomTvClickListener;
//
//    private OnRightTopTvClickListener rightTopTvClickListener;
//    private OnRightTvClickListener rightTvClickListener;
//    private OnRightBottomTvClickListener rightBottomTvClickListener;

    private static final int TYPE_CHECKBOX = 0;
    private static final int TYPE_SWITCH = 1;

    private static int mRightViewType;

    private CheckBox rightCheckBox;//右边checkbox
    private LayoutParams rightCheckBoxParams;//右边checkbox
    private Drawable rightCheckBoxBg;//checkBox的背景
    private int rightCheckBoxMarginRight;//右边checkBox的右边距
    private boolean isChecked;//是否默认选中


    private int centerSpaceHeight;//中间空间的高度


    private Switch mSwitch;
    private LayoutParams mSwitchParams;//右边switch
    private int rightSwitchMarginRight;
    private boolean switchIsChecked = true;

    private String mTextOff;
    private String mTextOn;

    private int mSwitchMinWidth;
    private int mSwitchPadding;

    private int mThumbTextPadding;

    private Drawable mThumbResource;
    private Drawable mTrackResource;

    public SuperTextView2(Context context) {
        this(context, null);
    }

    public SuperTextView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SuperTextView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;
        defaultSize = sp2px(context, defaultSize);
        default_Margin = dip2px(context, default_Margin);

        getAttr(attrs);
        initView();
    }

    private void getAttr(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.SuperTextView);

        /////////////////////////////////////////////////
        mLeftTextString = typedArray.getString(R.styleable.SuperTextView_sLeftTextString);
        mLeftTopTextString = typedArray.getString(R.styleable.SuperTextView_sLeftTopTextString);
        mLeftBottomTextString = typedArray.getString(R.styleable.SuperTextView_sLeftBottomTextString);

        mCenterTextString = typedArray.getString(R.styleable.SuperTextView_sCenterTextString);
        mCenterTopTextString = typedArray.getString(R.styleable.SuperTextView_sCenterTopTextString);
        mCenterBottomTextString = typedArray.getString(R.styleable.SuperTextView_sCenterBottomTextString);

        mRightTextString = typedArray.getString(R.styleable.SuperTextView_sRightTextString);
        mRightTopTextString = typedArray.getString(R.styleable.SuperTextView_sRightTopTextString);
        mRightBottomTextString = typedArray.getString(R.styleable.SuperTextView_sRightBottomTextString);

        //////////////////////////////////////////////////

        mLeftTextColor = typedArray.getColor(R.styleable.SuperTextView_sLeftTextColor, defaultColor);
        mLeftTopTextColor = typedArray.getColor(R.styleable.SuperTextView_sLeftTopTextColor, defaultColor);
        mLeftBottomTextColor = typedArray.getColor(R.styleable.SuperTextView_sLeftBottomTextColor, defaultColor);

        mCenterTextColor = typedArray.getColor(R.styleable.SuperTextView_sCenterTextColor, defaultColor);
        mCenterTopTextColor = typedArray.getColor(R.styleable.SuperTextView_sCenterTopTextColor, defaultColor);
        mCenterBottomTextColor = typedArray.getColor(R.styleable.SuperTextView_sCenterBottomTextColor, defaultColor);

        mRightTextColor = typedArray.getColor(R.styleable.SuperTextView_sRightTextColor, defaultColor);
        mRightTopTextColor = typedArray.getColor(R.styleable.SuperTextView_sRightTopTextColor, defaultColor);
        mRightBottomTextColor = typedArray.getColor(R.styleable.SuperTextView_sRightBottomTextColor, defaultColor);

        //////////////////////////////////////////////////


        mLeftTextSize = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sLeftTextSize, defaultSize);
        mLeftTopTextSize = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sLeftTopTextSize, defaultSize);
        mLeftBottomTextSize = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sLeftBottomTextSize, defaultSize);

        mCenterTextSize = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sCenterTextSize, defaultSize);
        mCenterTopTextSize = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sCenterTopTextSize, defaultSize);
        mCenterBottomTextSize = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sCenterBottomTextSize, defaultSize);

        mRightTextSize = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sRightTextSize, defaultSize);
        mRightTopTextSize = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sRightTopTextSize, defaultSize);
        mRightBottomTextSize = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sRightBottomTextSize, defaultSize);

        //////////////////////////////////////////////////
        mLeftTopLines = typedArray.getInt(R.styleable.SuperTextView_sLeftTopLines, 1);
        mLeftLines = typedArray.getInt(R.styleable.SuperTextView_sLeftLines, 1);
        mLeftBottomLines = typedArray.getInt(R.styleable.SuperTextView_sLeftBottomLines, 1);

        mCenterTopLines = typedArray.getInt(R.styleable.SuperTextView_sCenterTopLines, 1);
        mCenterLines = typedArray.getInt(R.styleable.SuperTextView_sCenterLines, 1);
        mCenterBottomLines = typedArray.getInt(R.styleable.SuperTextView_sCenterBottomLines, 1);

        mRightTopLines = typedArray.getInt(R.styleable.SuperTextView_sRightTopLines, 1);
        mRightLines = typedArray.getInt(R.styleable.SuperTextView_sRightLines, 1);
        mRightBottomLines = typedArray.getInt(R.styleable.SuperTextView_sRightBottomLines, 1);

        //////////////////////////////////////////////////

        mLeftTopMaxEms = typedArray.getInt(R.styleable.SuperTextView_sLeftTopMaxEms, defaultMaxEms);
        mLeftMaxEms = typedArray.getInt(R.styleable.SuperTextView_sLeftMaxEms, defaultMaxEms);
        mLeftBottomMaxEms = typedArray.getInt(R.styleable.SuperTextView_sLeftBottomMaxEms, defaultMaxEms);

        mCenterTopMaxEms = typedArray.getInt(R.styleable.SuperTextView_sCenterTopMaxEms, defaultMaxEms);
        mCenterMaxEms = typedArray.getInt(R.styleable.SuperTextView_sCenterMaxEms, defaultMaxEms);
        mCenterBottomMaxEms = typedArray.getInt(R.styleable.SuperTextView_sCenterBottomMaxEms, defaultMaxEms);

        mRightTopMaxEms = typedArray.getInt(R.styleable.SuperTextView_sRightTopMaxEms, defaultMaxEms);
        mRightMaxEms = typedArray.getInt(R.styleable.SuperTextView_sRightMaxEms, defaultMaxEms);
        mRightBottomMaxEms = typedArray.getInt(R.styleable.SuperTextView_sRightBottomMaxEms, defaultMaxEms);

        ////////////////////////////////////////////////

        mLeftGravity = typedArray.getInt(R.styleable.SuperTextView_sLeftViewGravity, default_Gravity);
        mCenterGravity = typedArray.getInt(R.styleable.SuperTextView_sCenterViewGravity, default_Gravity);
        mRightGravity = typedArray.getInt(R.styleable.SuperTextView_sRightViewGravity, default_Gravity);

        ////////////////////////////////////////////////

        mLeftTvDrawableLeft = typedArray.getDrawable(R.styleable.SuperTextView_sLeftTvDrawableLeft);
        mLeftTvDrawableRight = typedArray.getDrawable(R.styleable.SuperTextView_sLeftTvDrawableRight);
        mCenterTvDrawableLeft = typedArray.getDrawable(R.styleable.SuperTextView_sCenterTvDrawableLeft);
        mCenterTvDrawableRight = typedArray.getDrawable(R.styleable.SuperTextView_sCenterTvDrawableRight);
        mRightTvDrawableLeft = typedArray.getDrawable(R.styleable.SuperTextView_sRightTvDrawableLeft);
        mRightTvDrawableRight = typedArray.getDrawable(R.styleable.SuperTextView_sRightTvDrawableRight);

        mTextViewDrawablePadding = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sTextViewDrawablePadding, default_Margin);
        ////////////////////////////////////////////////
        mLeftViewWidth = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_mLeftViewWidth, 0);
        ///////////////////////////////////////////////
        mTopDividerLineMarginLR = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sTopDividerLineMarginLR, 0);
        mTopDividerLineMarginLeft = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sTopDividerLineMarginLeft, 0);
        mTopDividerLineMarginRight = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sTopDividerLineMarginRight, 0);

        mBottomDividerLineMarginLR = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sBottomDividerLineMarginLR, 0);
        mBottomDividerLineMarginLeft = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sBottomDividerLineMarginLeft, 0);
        mBottomDividerLineMarginRight = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sBottomDividerLineMarginRight, 0);
        ///////////////////////////////////////////////
        mDividerLineType = typedArray.getInt(R.styleable.SuperTextView_sDividerLineType, default_Divider);
        mDividerLineColor = typedArray.getColor(R.styleable.SuperTextView_sDividerLineColor, mDefaultDividerLineColor);

        mDividerLineHeight = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sDividerLineHeight, dip2px(mContext, 0.5f));
        ////////////////////////////////////////////////
        mLeftViewMarginLeft = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sLeftViewMarginLeft, default_Margin);
        mLeftViewMarginRight = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sLeftViewMarginRight, default_Margin);
        mCenterViewMarginLeft = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sCenterViewMarginLeft, 0);
        mCenterViewMarginRight = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sCenterViewMarginRight, 0);
        mRightViewMarginLeft = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sRightViewMarginLeft, default_Margin);
        mRightViewMarginRight = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sRightViewMarginRight, default_Margin);
        ///////////////////////////////////////////////
        leftIconWidth = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sLeftIconWidth, 0);
        leftIconHeight = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sLeftIconHeight, 0);

        rightIconWidth = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sRightIconWidth, 0);
        rightIconHeight = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sRightIconHeight, 0);

        leftIconMarginLeft = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sLeftIconMarginLeft, default_Margin);
        rightIconMarginRight = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sRightIconMarginRight, default_Margin);

        leftIconRes = typedArray.getDrawable(R.styleable.SuperTextView_sLeftIconRes);
        rightIconRes = typedArray.getDrawable(R.styleable.SuperTextView_sRightIconRes);
        //////////////////////////////////////////////
        mLeftTopTextBold = typedArray.getBoolean(R.styleable.SuperTextView_sLeftTopTextIsBold, false);
        mLeftTextBold = typedArray.getBoolean(R.styleable.SuperTextView_sLeftTextIsBold, false);
        mLeftBottomTextBold = typedArray.getBoolean(R.styleable.SuperTextView_sLeftBottomTextIsBold, false);

        mCenterTopTextBold = typedArray.getBoolean(R.styleable.SuperTextView_sCenterTopTextIsBold, false);
        mCenterTextBold = typedArray.getBoolean(R.styleable.SuperTextView_sCenterTextIsBold, false);
        mCenterBottomTextBold = typedArray.getBoolean(R.styleable.SuperTextView_sCenterBottomTextIsBold, false);

        mRightTopTextBold = typedArray.getBoolean(R.styleable.SuperTextView_sRightTopTextIsBold, false);
        mRightTextBold = typedArray.getBoolean(R.styleable.SuperTextView_sRightTextIsBold, false);
        mRightBottomTextBold = typedArray.getBoolean(R.styleable.SuperTextView_sRightBottomTextIsBold, false);
        //////////////////////////////////////////////
        useRipple = typedArray.getBoolean(R.styleable.SuperTextView_sUseRipple, true);
        mBackground_drawable = typedArray.getDrawable(R.styleable.SuperTextView_sBackgroundDrawableRes);
        ///////////////////////////////////////////////
        mRightViewType = typedArray.getInt(R.styleable.SuperTextView_sRightViewType, -1);
        ////////////////////////////////////////////////
        isChecked = typedArray.getBoolean(R.styleable.SuperTextView_sIsChecked, false);
        rightCheckBoxMarginRight = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sRightCheckBoxMarginRight, default_Margin);
        rightCheckBoxBg = typedArray.getDrawable(R.styleable.SuperTextView_sRightCheckBoxRes);
        //////////////////////////////////////////////////
        rightSwitchMarginRight = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sRightSwitchMarginRight, default_Margin);
        switchIsChecked = typedArray.getBoolean(R.styleable.SuperTextView_sSwitchIsChecked, false);
        mTextOff = typedArray.getString(R.styleable.SuperTextView_sTextOff);
        mTextOn = typedArray.getString(R.styleable.SuperTextView_sTextOn);

        mSwitchMinWidth = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sSwitchMinWidth, 0);
        mSwitchPadding = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sSwitchPadding, 0);
        mThumbTextPadding = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sThumbTextPadding, 0);

        mThumbResource = typedArray.getDrawable(R.styleable.SuperTextView_sThumbResource);
        mTrackResource = typedArray.getDrawable(R.styleable.SuperTextView_sTrackResource);

        centerSpaceHeight = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sCenterSpaceHeight, dip2px(mContext, 5));


        typedArray.recycle();
    }

    /**
     * 初始化Params
     *
     * @param params params
     * @return params
     */
    private LayoutParams getParams(LayoutParams params) {
        if (params == null) {
            params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        }
        return params;
    }

    /**
     * 初始化View
     */
    private void initView() {

        initSuperTextView();

        initLeftIcon();

        switch (mRightViewType) {
            case TYPE_CHECKBOX:
                initRightCheckBox();
                break;
            case TYPE_SWITCH:
                initRightSwitch();
                break;
        }

        initRightIcon();

        initLeftTextView();
        initCenterTextView();
        initRightTextView();

        initDividerLineView();

    }


    private void initSuperTextView() {
        if (useRipple) {
            this.setBackgroundResource(R.drawable.selector_white);
        }
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSuperTextViewClickListener != null) {
                    onSuperTextViewClickListener.onClickListener();
                }
            }
        });

        if (mBackground_drawable != null) {
            this.setBackgroundDrawable(mBackground_drawable);
        }
    }

    /**
     * 初始化左边图标
     */
    private void initLeftIcon() {
        if (leftIconIV == null) {
            leftIconIV = new ImageView(mContext);
        }
        leftImgParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftImgParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        leftImgParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        if (leftIconHeight != 0 && leftIconWidth != 0) {
            leftImgParams.width = leftIconWidth;
            leftImgParams.height = leftIconHeight;
        }
        leftIconIV.setScaleType(ImageView.ScaleType.FIT_CENTER);
        leftIconIV.setId(R.id.sLeftImgId);
        leftIconIV.setLayoutParams(leftImgParams);
        if (leftIconRes != null) {
            leftImgParams.setMargins(leftIconMarginLeft, 0, 0, 0);
            leftIconIV.setImageDrawable(leftIconRes);
        }
        addView(leftIconIV);
    }

    /**
     * 初始化右边图标
     */
    private void initRightIcon() {
        if (rightIconIV == null) {
            rightIconIV = new ImageView(mContext);
        }
        rightImgParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightImgParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);

        switch (mRightViewType) {
            case TYPE_CHECKBOX:
                rightImgParams.addRule(RelativeLayout.LEFT_OF, R.id.sRightCheckBoxId);
                break;
            case TYPE_SWITCH:
                rightImgParams.addRule(RelativeLayout.LEFT_OF, R.id.sRightSwitchId);
                break;
            default:
                rightImgParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);

        }

        if (rightIconHeight != 0 && rightIconWidth != 0) {
            rightImgParams.width = rightIconWidth;
            rightImgParams.height = rightIconHeight;
        }

        rightIconIV.setScaleType(ImageView.ScaleType.FIT_CENTER);
        rightIconIV.setId(R.id.sRightImgId);
        rightIconIV.setLayoutParams(rightImgParams);
        if (rightIconRes != null) {
            rightImgParams.setMargins(0, 0, rightIconMarginRight, 0);
            rightIconIV.setImageDrawable(rightIconRes);
        }
        addView(rightIconIV);
    }

    /**
     * 初始化LeftTextView
     */
    private void initLeftTextView() {
        if (leftView == null) {
            leftView = initBaseView(R.id.sLeftViewId);
        }
        leftBaseViewParams = getParams(leftBaseViewParams);
        leftBaseViewParams.addRule(RelativeLayout.RIGHT_OF, R.id.sLeftImgId);
        leftBaseViewParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        if (mLeftViewWidth != 0) {
            leftBaseViewParams.width = dip2px(mContext, mLeftViewWidth);
        }
        leftBaseViewParams.setMargins(mLeftViewMarginLeft, 0, mLeftViewMarginRight, 0);

        leftView.setLayoutParams(leftBaseViewParams);

        leftView.setCenterSpaceHeight(centerSpaceHeight);
        setDefaultString(leftView, mLeftTopTextString, mLeftTextString, mLeftBottomTextString);
        setDefaultColor(leftView, mLeftTopTextColor, mLeftTextColor, mLeftBottomTextColor);
        setDefaultSize(leftView, mLeftTopTextSize, mLeftTextSize, mLeftBottomTextSize);
        setDefaultLines(leftView, mLeftTopLines, mLeftLines, mLeftBottomLines);
        setDefaultMaxEms(leftView, mLeftTopMaxEms, mLeftMaxEms, mLeftBottomMaxEms);
        setDefaultTextIsBold(leftView, mLeftTopTextBold, mLeftTextBold, mLeftBottomTextBold);
        setDefaultGravity(leftView, mLeftGravity);
        setDefaultDrawable(leftView.getCenterTextView(), mLeftTvDrawableLeft, mLeftTvDrawableRight, mTextViewDrawablePadding);

        addView(leftView);
    }

    /**
     * 初始化CenterTextView
     */
    private void initCenterTextView() {
        if (centerView == null) {
            centerView = initBaseView(R.id.sCenterViewId);
        }
        centerBaseViewParams = getParams(centerBaseViewParams);
        centerBaseViewParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        centerBaseViewParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);

        //默认情况下  中间的View整体剧中显示，设置左对齐或者右对齐的话使用下边属性
        if (mCenterGravity != gravity_Center) {
            centerBaseViewParams.addRule(RIGHT_OF, R.id.sLeftViewId);
            centerBaseViewParams.addRule(LEFT_OF, R.id.sRightViewId);
        }

        centerBaseViewParams.setMargins(mCenterViewMarginLeft, 0, mCenterViewMarginRight, 0);

        centerView.setLayoutParams(centerBaseViewParams);
        centerView.setCenterSpaceHeight(centerSpaceHeight);

        setDefaultString(centerView, mCenterTopTextString, mCenterTextString, mCenterBottomTextString);
        setDefaultColor(centerView, mCenterTopTextColor, mCenterTextColor, mCenterBottomTextColor);
        setDefaultSize(centerView, mCenterTopTextSize, mCenterTextSize, mCenterBottomTextSize);
        setDefaultLines(centerView, mCenterTopLines, mCenterLines, mCenterBottomLines);
        setDefaultMaxEms(centerView, mCenterTopMaxEms, mCenterMaxEms, mCenterBottomMaxEms);
        setDefaultTextIsBold(centerView, mCenterTopTextBold, mCenterTextBold, mCenterBottomTextBold);
        setDefaultGravity(centerView, mCenterGravity);
        setDefaultDrawable(centerView.getCenterTextView(), mCenterTvDrawableLeft, mCenterTvDrawableRight, mTextViewDrawablePadding);
//        setDefaultCenterViewClickListener(centerView);

        addView(centerView);
    }

    /**
     * 初始化RightTextView
     */
    private void initRightTextView() {
        if (rightView == null) {
            rightView = initBaseView(R.id.sRightViewId);
        }
        rightBaseViewParams = getParams(rightBaseViewParams);
        rightBaseViewParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);

        rightBaseViewParams.addRule(RelativeLayout.LEFT_OF, R.id.sRightImgId);
        rightBaseViewParams.setMargins(mRightViewMarginLeft, 0, mRightViewMarginRight, 0);

        rightView.setLayoutParams(rightBaseViewParams);
        rightView.setCenterSpaceHeight(centerSpaceHeight);

        setDefaultString(rightView, mRightTopTextString, mRightTextString, mRightBottomTextString);
        setDefaultColor(rightView, mRightTopTextColor, mRightTextColor, mRightBottomTextColor);
        setDefaultSize(rightView, mRightTopTextSize, mRightTextSize, mRightBottomTextSize);
        setDefaultLines(rightView, mRightTopLines, mRightLines, mRightBottomLines);
        setDefaultMaxEms(rightView, mRightTopMaxEms, mRightMaxEms, mRightBottomMaxEms);
        setDefaultTextIsBold(rightView, mRightTopTextBold, mRightTextBold, mRightBottomTextBold);
        setDefaultGravity(rightView, mRightGravity);
        setDefaultDrawable(rightView.getCenterTextView(), mRightTvDrawableLeft, mRightTvDrawableRight, mTextViewDrawablePadding);
//        setDefaultRightViewClickListener(rightView);

        addView(rightView);
    }


    /**
     * 初始化RightCheckBox
     */
    private void initRightCheckBox() {
        if (rightCheckBox == null) {
            rightCheckBox = new CheckBox(mContext);
            rightCheckBoxParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

            rightCheckBoxParams.addRule(ALIGN_PARENT_RIGHT, TRUE);
            rightCheckBoxParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
            rightCheckBoxParams.setMargins(0, 0, rightCheckBoxMarginRight, 0);
            rightCheckBox.setId(R.id.sRightCheckBoxId);
            rightCheckBox.setLayoutParams(rightCheckBoxParams);
            if (rightCheckBoxBg != null) {
                rightCheckBox.setGravity(CENTER_IN_PARENT);
                rightCheckBox.setButtonDrawable(rightCheckBoxBg);
            }
            rightCheckBox.setChecked(isChecked);
        }
        addView(rightCheckBox);
    }

    /**
     * 初始化RightSwitch
     */
    private void initRightSwitch() {
        if (mSwitch == null) {
            mSwitch = new Switch(mContext);
        }
        mSwitchParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        mSwitchParams.addRule(ALIGN_PARENT_RIGHT, TRUE);
        mSwitchParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        mSwitchParams.setMargins(0, 0, rightSwitchMarginRight, 0);
        mSwitch.setId(R.id.sRightSwitchId);
        mSwitch.setLayoutParams(mSwitchParams);

        mSwitch.setChecked(switchIsChecked);
        if (!TextUtils.isEmpty(mTextOff)){
            mSwitch.setTextOff(mTextOff);
        }
        if (!TextUtils.isEmpty(mTextOn)){
            mSwitch.setTextOn(mTextOn);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            if (mSwitchMinWidth != 0) {
                mSwitch.setSwitchMinWidth(mSwitchMinWidth);
            }
            if (mSwitchPadding != 0) {
                mSwitch.setSwitchPadding(mSwitchPadding);
            }
            if (mThumbResource != null) {
                mSwitch.setThumbDrawable(mThumbResource);
            }
            if (mThumbResource != null) {
                mSwitch.setTrackDrawable(mTrackResource);
            }
            if (mThumbTextPadding != 0) {
                mSwitch.setThumbTextPadding(mThumbTextPadding);
            }

        }

        addView(mSwitch);
    }

    /////////////////////////////////////默认属性设置----begin/////////////////////////////////

    /**
     * 初始化BaseTextView
     *
     * @param id id
     * @return baseTextView
     */
    private BaseTextView initBaseView(int id) {
        BaseTextView baseTextView = new BaseTextView(mContext);
        baseTextView.setId(id);
        return baseTextView;
    }

    /**
     * 设置默认值
     *
     * @param baseTextView     baseTextView
     * @param topTextString    topTextString
     * @param leftTextString   leftTextString
     * @param bottomTextString bottomTextString
     */
    private void setDefaultString(BaseTextView baseTextView, String topTextString, String leftTextString, String bottomTextString) {
        if (baseTextView != null) {
            baseTextView.setTopTextString(topTextString);
            baseTextView.setCenterTextString(leftTextString);
            baseTextView.setBottomTextString(bottomTextString);
        }
    }

    /**
     * 设置默认
     *
     * @param baseTextView    baseTextView
     * @param topTextColor    topTextColor
     * @param textColor       textColor
     * @param bottomTextColor bottomTextColor
     */
    private void setDefaultColor(BaseTextView baseTextView, int topTextColor, int textColor, int bottomTextColor) {
        if (baseTextView != null) {
            baseTextView.getTopTextView().setTextColor(topTextColor);
            baseTextView.getCenterTextView().setTextColor(textColor);
            baseTextView.getBottomTextView().setTextColor(bottomTextColor);
        }
    }

    /**
     * 设置默认字体大小
     *
     * @param baseTextView   baseTextView
     * @param leftTextSize   leftTextSize
     * @param topTextSize    topTextSize
     * @param bottomTextSize bottomTextSize
     */
    private void setDefaultSize(BaseTextView baseTextView, int topTextSize, int leftTextSize, int bottomTextSize) {
        if (baseTextView != null) {
            baseTextView.getTopTextView().setTextSize(TypedValue.COMPLEX_UNIT_PX, topTextSize);
            baseTextView.getCenterTextView().setTextSize(TypedValue.COMPLEX_UNIT_PX, leftTextSize);
            baseTextView.getBottomTextView().setTextSize(TypedValue.COMPLEX_UNIT_PX, bottomTextSize);
        }
    }

    /**
     * 设置默认maxEms
     *
     * @param baseTextView baseTextView
     * @param topMaxEms    topMaxEms
     * @param centerMaxEms centerMaxEms
     * @param bottomMaxEms bottomMaxEms
     */
    private void setDefaultMaxEms(BaseTextView baseTextView, int topMaxEms, int centerMaxEms, int bottomMaxEms) {
        if (baseTextView != null) {
            baseTextView.setMaxEms(topMaxEms, centerMaxEms, bottomMaxEms);
        }

    }

    /**
     * 设置默认lines
     *
     * @param baseTextView baseTextView
     * @param leftTopLines leftTopLines
     * @param leftLines    leftLines
     * @param bottomLines  bottomLines
     */
    private void setDefaultLines(BaseTextView baseTextView, int leftTopLines, int leftLines, int bottomLines) {
        if (baseTextView != null) {
            baseTextView.getTopTextView().setLines(leftTopLines);
            baseTextView.getCenterTextView().setLines(leftLines);
            baseTextView.getBottomTextView().setLines(bottomLines);
        }

    }

    /**
     * 设置文字对其方式
     *
     * @param baseTextView baseTextView
     * @param gravity      对其方式
     */
    private void setDefaultGravity(BaseTextView baseTextView, int gravity) {
        if (baseTextView != null) {
            setGravity(baseTextView.getTopTextView(), gravity);
            setGravity(baseTextView.getCenterTextView(), gravity);
            setGravity(baseTextView.getBottomTextView(), gravity);
        }
    }

    /**
     * 文字对其方式
     *
     * @param textView textView
     * @param gravity  对其方式
     */
    private void setGravity(TextView textView, int gravity) {
        switch (gravity) {
            case gravity_Left_Center:
                textView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                break;
            case gravity_Center:
                textView.setGravity(Gravity.CENTER);
                break;
            case gravity_Right_Center:
                textView.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                break;
        }
    }

    /**
     * 设置textView的drawable
     *
     * @param textView        对象
     * @param drawableLeft    左边图标
     * @param drawableRight   右边图标
     * @param drawablePadding 图标距离文字的间距
     */
    public void setDefaultDrawable(TextView textView, Drawable drawableLeft, Drawable drawableRight, int drawablePadding) {
        if (drawableLeft != null || drawableRight != null) {
            textView.setVisibility(VISIBLE);
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, null, drawableRight, null);
        textView.setCompoundDrawablePadding(drawablePadding);
    }

    /**
     * 初始化分割线
     */
    private void initDividerLineView() {
        switch (mDividerLineType) {
            case NONE:
                break;
            case TOP:
                setTopDividerLineView();
                break;
            case BOTTOM:
                setTBottomDividerLineView();
                break;
            case BOTH:
                setTopDividerLineView();
                setTBottomDividerLineView();
                break;
        }

    }

    /**
     * 设置上边的分割线
     */
    private void setTopDividerLineView() {
        if (mTopDividerLineMarginLR != 0) {
            initTopDividerLineView(mTopDividerLineMarginLR, mTopDividerLineMarginLR);
        } else {
            initTopDividerLineView(mTopDividerLineMarginLeft, mTopDividerLineMarginRight);
        }
    }

    /**
     * 设置下边的分割线
     */
    private void setTBottomDividerLineView() {
        if (mBottomDividerLineMarginLR != 0) {
            initBottomDividerLineView(mBottomDividerLineMarginLR, mBottomDividerLineMarginLR);
        } else {
            initBottomDividerLineView(mBottomDividerLineMarginLeft, mBottomDividerLineMarginRight);
        }
    }


    /**
     * 初始化上边分割线view
     *
     * @param marginLeft  左间距
     * @param marginRight 右间距
     */
    private void initTopDividerLineView(int marginLeft, int marginRight) {
        if (topDividerLineView == null) {
            if (topDividerLineParams == null) {
                topDividerLineParams = new LayoutParams(LayoutParams.MATCH_PARENT, mDividerLineHeight);
            }
            topDividerLineParams.addRule(ALIGN_PARENT_TOP, TRUE);
            topDividerLineParams.setMargins(marginLeft, 0, marginRight, 0);
            topDividerLineView = new View(mContext);
            topDividerLineView.setLayoutParams(topDividerLineParams);
            topDividerLineView.setBackgroundColor(mDividerLineColor);
        }
        addView(topDividerLineView);
    }

    /**
     * 初始化底部分割线view
     *
     * @param marginLeft  左间距
     * @param marginRight 右间距
     */
    private void initBottomDividerLineView(int marginLeft, int marginRight) {
        if (bottomDividerLineView == null) {
            if (bottomDividerLineParams == null) {
                bottomDividerLineParams = new LayoutParams(LayoutParams.MATCH_PARENT, mDividerLineHeight);
            }
            bottomDividerLineParams.addRule(ALIGN_PARENT_BOTTOM, TRUE);
            bottomDividerLineParams.setMargins(marginLeft, 0, marginRight, 0);

            bottomDividerLineView = new View(mContext);
            bottomDividerLineView.setLayoutParams(bottomDividerLineParams);
            bottomDividerLineView.setBackgroundColor(mDividerLineColor);
        }
        addView(bottomDividerLineView);
    }


    /**
     * 左边点击事件
     *
     * @param baseTextView baseTextView
     */
//    private void setDefaultLeftViewClickListener(BaseTextView baseTextView) {
//        if (baseTextView != null) {
//            if (leftTopTvClickListener != null) {
//                baseTextView.getTopTextView().setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        leftTopTvClickListener.onClickListener();
//                    }
//                });
//            }
//
//            if (leftTvClickListener != null) {
//                baseTextView.getCenterTextView().setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        leftTvClickListener.onClickListener();
//                    }
//                });
//            }
//            if (leftBottomTvClickListener != null) {
//                baseTextView.getBottomTextView().setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        leftBottomTvClickListener.onClickListener();
//                    }
//                });
//            }
//        }
//
//    }

    /**
     * 中间点击事件
     *
     * @param baseTextView baseTextView
     */
//    private void setDefaultCenterViewClickListener(BaseTextView baseTextView) {
//        if (baseTextView != null) {
//            if (centerTopTvClickListener != null) {
//                baseTextView.getTopTextView().setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        centerTopTvClickListener.onClickListener();
//                    }
//                });
//            }
//
//            if (centerTvClickListener != null) {
//                baseTextView.getCenterTextView().setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        centerTvClickListener.onClickListener();
//                    }
//                });
//            }
//            if (centerBottomTvClickListener != null) {
//                baseTextView.getBottomTextView().setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        centerBottomTvClickListener.onClickListener();
//                    }
//                });
//            }
//        }
//
//    }


    /**
     * 右边点击事件
     *
     * @param baseTextView baseTextView
     */
//    private void setDefaultRightViewClickListener(BaseTextView baseTextView) {
//        if (baseTextView != null) {
//            if (rightTopTvClickListener != null) {
//                baseTextView.getTopTextView().setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        rightTopTvClickListener.onClickListener();
//                    }
//                });
//            }
//
//            if (rightTvClickListener != null) {
//                baseTextView.getCenterTextView().setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        rightTvClickListener.onClickListener();
//                    }
//                });
//            }
//            if (rightBottomTvClickListener != null) {
//                baseTextView.getBottomTextView().setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        rightBottomTvClickListener.onClickListener();
//                    }
//                });
//            }
//        }
//
//    }


    /**
     * 字体是否加粗
     *
     * @param baseTextView   baseTextView
     * @param topTextBold    上边字体加粗
     * @param centerTextBold 中间字体加粗
     * @param bottomTextBold 下边字体加粗
     */
    private void setDefaultTextIsBold(BaseTextView baseTextView, boolean topTextBold, boolean centerTextBold, boolean bottomTextBold) {
        if (baseTextView != null) {
            baseTextView.getTopTextView().getPaint().setFakeBoldText(topTextBold);
            baseTextView.getCenterTextView().getPaint().setFakeBoldText(centerTextBold);
            baseTextView.getBottomTextView().getPaint().setFakeBoldText(bottomTextBold);
        }
    }


    /////////////////////////////////////默认属性设置----end/////////////////////////////////


    /////////////////////////////////////对外暴露的方法---begin/////////////////////////////////

    /**
     * 设置左上字符串
     *
     * @param string 字符串
     * @return 方便链式调用
     */
    public SuperTextView2 setLeftTopString(String string) {
        if (leftView != null) {
            leftView.setTopTextString(string);
        }
        return this;
    }

    /**
     * 设置左中字符串
     *
     * @param string 字符串
     * @return 方便链式调用
     */
    public SuperTextView2 setLeftString(String string) {
        if (leftView != null) {
            leftView.setCenterTextString(string);
        }
        return this;
    }

    /**
     * 设置左下字符串
     *
     * @param string 字符串
     * @return 方便链式调用
     */
    public SuperTextView2 setLeftBottomString(String string) {
        if (leftView != null) {
            leftView.setBottomTextString(string);
        }
        return this;
    }


    /**
     * 设置中上字符串
     *
     * @param string 字符串
     * @return 方便链式调用
     */
    public SuperTextView2 setCenterTopString(String string) {
        if (centerView != null) {
            centerView.setTopTextString(string);
        }
        return this;
    }

    /**
     * 设置中间字符串
     *
     * @param string 字符串
     * @return 方便链式调用
     */
    public SuperTextView2 setCenterString(String string) {
        if (centerView != null) {
            centerView.setCenterTextString(string);
        }
        return this;
    }

    /**
     * 设置中下字符串
     *
     * @param string 字符串
     * @return 方便链式调用
     */
    public SuperTextView2 setCenterBottomString(String string) {
        if (centerView != null) {
            centerView.setBottomTextString(string);
        }
        return this;
    }

    /**
     * 设置右上字符串
     *
     * @param string 字符串
     * @return 方便链式调用
     */
    public SuperTextView2 setRightTopString(String string) {
        if (rightView != null) {
            rightView.setTopTextString(string);
        }
        return this;
    }

    /**
     * 设置右中字符串
     *
     * @param string 字符串
     * @return 方便链式调用
     */
    public SuperTextView2 setRightString(String string) {
        if (rightView != null) {
            rightView.setCenterTextString(string);
        }
        return this;
    }

    /**
     * 设置右下字符串
     *
     * @param string 字符串
     * @return 方便链式调用
     */
    public SuperTextView2 setRightBottomString(String string) {
        if (rightView != null) {
            rightView.setBottomTextString(string);
        }
        return this;
    }


    /**
     * 获取左上字符串
     *
     * @return 返回字符串
     */
    public String getLeftTopString() {
        return leftView != null ? leftView.getTopTextView().getText().toString().trim() : "";
    }

    /**
     * 获取左中字符串
     *
     * @return 返回字符串
     */
    public String getLeftString() {
        return leftView != null ? leftView.getCenterTextView().getText().toString().trim() : "";
    }

    /**
     * 获取左下字符串
     *
     * @return 返回字符串
     */
    public String getLeftBottomString() {
        return leftView != null ? leftView.getBottomTextView().getText().toString().trim() : "";
    }

    ////////////////////////////////////////////

    /**
     * 获取中上字符串
     *
     * @return 返回字符串
     */
    public String getCenterTopString() {
        return centerView != null ? centerView.getTopTextView().getText().toString().trim() : "";
    }

    /**
     * 获取中间字符串
     *
     * @return 返回字符串
     */

    public String getCenterString() {
        return centerView != null ? centerView.getCenterTextView().getText().toString().trim() : "";
    }

    /**
     * 获取中下字符串
     *
     * @return 返回字符串
     */
    public String getCenterBottomString() {
        return centerView != null ? centerView.getBottomTextView().getText().toString().trim() : "";
    }

    /**
     * 获取右上字符串
     *
     * @return 返回字符串
     */
    public String getRightTopString() {
        return rightView != null ? rightView.getTopTextView().getText().toString().trim() : "";
    }

    /**
     * 获取右中字符串
     *
     * @return 返回字符串
     */
    public String getRightString() {
        return rightView != null ? rightView.getCenterTextView().getText().toString().trim() : "";
    }

    /**
     * 获取右下字符串
     *
     * @return 返回字符串
     */
    public String getRightBottomString() {
        return rightView != null ? rightView.getBottomTextView().getText().toString().trim() : "";
    }

    /**
     * 获取左边ImageView
     *
     * @return ImageView
     */
    public ImageView getLeftIconIV() {
        leftImgParams.setMargins(leftIconMarginLeft, 0, 0, 0);
        return leftIconIV;
    }

    /**
     * 获取右边ImageView
     *
     * @return ImageView
     */
    public ImageView getRightIconIV() {
        rightImgParams.setMargins(0, 0, rightIconMarginRight, 0);
        return rightIconIV;
    }


    /**
     * @param checked 是否选中
     * @return 返回值
     */
    public SuperTextView2 setCbChecked(boolean checked) {
        isChecked = checked;
        if (rightCheckBox != null) {
            rightCheckBox.setChecked(checked);
        }
        return this;
    }

    /**
     * 设置checkbox的背景图
     *
     * @param drawable drawable对象
     * @return 返回对象
     */
    public SuperTextView2 setCbBackground(Drawable drawable) {
        rightCheckBoxBg = drawable;
        if (rightCheckBox != null) {
            rightCheckBox.setBackgroundDrawable(drawable);
        }
        return this;
    }

    /**
     * 获取checkbox状态
     *
     * @return 返回选择框当前选中状态
     */
    public boolean getCbisChecked() {
        boolean isChecked = false;
        if (rightCheckBox != null) {
            isChecked = rightCheckBox.isChecked();
        }
        return isChecked;
    }

    /**
     * @param checked Switch是否选中
     * @return 返回值
     */
    public SuperTextView2 setSwitchIsChecked(boolean checked) {
        switchIsChecked = checked;
        if (mSwitch != null) {
            mSwitch.setChecked(checked);
        }
        return this;
    }


    /**
     * 设置右边tv的右侧图片
     *
     * @param drawableRight
     */
    public SuperTextView2 setRightTvDrawableRight(Drawable drawableRight) {
        setDefaultDrawable(rightView.getCenterTextView(), null, drawableRight, mTextViewDrawablePadding);
        return this;
    }

    /**
     * 设置右边tv的左侧图片
     *
     * @param drawableLeft
     */
    public SuperTextView2 setRightTvDrawableLeft(Drawable drawableLeft) {
        setDefaultDrawable(rightView.getCenterTextView(), drawableLeft, null, mTextViewDrawablePadding);
        return this;
    }

    /**
     * 设置左边图标
     *
     * @param leftIcon 左边图标
     * @return 返回对象
     */
    public SuperTextView2 setLeftIcon(Drawable leftIcon) {
        if (leftIconIV != null) {
            leftImgParams.setMargins(leftIconMarginLeft, 0, 0, 0);
            leftIconIV.setImageDrawable(leftIcon);
        }
        return this;
    }

    /**
     * 设置左边图标
     *
     * @param resId 左边图标资源id
     * @return 返回对象
     */
    public SuperTextView2 setLeftIcon(int resId) {
        if (leftIconIV != null) {
            leftImgParams.setMargins(leftIconMarginLeft, 0, 0, 0);
            leftIconIV.setImageResource(resId);
        }
        return this;
    }

    /**
     * 设置右边图标
     *
     * @param rightIcon 右边图标
     * @return 返回对象
     */
    public SuperTextView2 setRightIcon(Drawable rightIcon) {
        if (rightIconIV != null) {
            rightImgParams.setMargins(0, 0, rightIconMarginRight, 0);
            rightIconIV.setImageDrawable(rightIcon);
        }
        return this;
    }

    /**
     * 设置右边图标资源Id
     *
     * @param resId 右边图标
     * @return 返回对象
     */
    public SuperTextView2 setRightIcon(int resId) {
        if (rightIconIV != null) {
            rightImgParams.setMargins(0, 0, rightIconMarginRight, 0);
            rightIconIV.setImageResource(resId);
        }
        return this;
    }

    /////////////////////////////////////对外暴露的方法---begin/////////////////////////////////

    /**
     * 单位转换工具类
     *
     * @param context 上下文对象
     * @param spValue 值
     * @return 返回值
     */
    private int sp2px(Context context, float spValue) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * scale + 0.5f);
    }

    /**
     * 单位转换工具类
     *
     * @param context  上下文对象
     * @param dipValue 值
     * @return 返回值
     */
    private int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 点击事件
     *
     * @param onSuperTextViewClickListener ClickListener
     * @return SuperTextView
     */
    public SuperTextView2 setOnSuperTextViewClickListener(OnSuperTextViewClickListener onSuperTextViewClickListener) {
        this.onSuperTextViewClickListener = onSuperTextViewClickListener;
        return this;
    }

//    public SuperTextView2 setLeftTopTvClickListener(OnLeftTopTvClickListener leftTopTvClickListener) {
//        this.leftTopTvClickListener = leftTopTvClickListener;
//        setDefaultLeftViewClickListener(leftView);
//        return this;
//    }
//
//    public SuperTextView2 setLeftTvClickListener(OnLeftTvClickListener leftTvClickListener) {
//        this.leftTvClickListener = leftTvClickListener;
//        setDefaultLeftViewClickListener(leftView);
//        return this;
//    }
//
//    public SuperTextView2 setLeftBottomTvClickListener(OnLeftBottomTvClickListener leftBottomTvClickListener) {
//        this.leftBottomTvClickListener = leftBottomTvClickListener;
//        setDefaultLeftViewClickListener(leftView);
//        return this;
//    }
//
//    public SuperTextView2 setCenterTopTvClickListener(OnCenterTopTvClickListener centerTopTvClickListener) {
//        this.centerTopTvClickListener = centerTopTvClickListener;
//        setDefaultCenterViewClickListener(centerView);
//        return this;
//    }
//
//    public SuperTextView2 setCenterTvClickListener(OnCenterTvClickListener centerTvClickListener) {
//        this.centerTvClickListener = centerTvClickListener;
//        setDefaultCenterViewClickListener(centerView);
//        return this;
//    }
//
//    public SuperTextView2 setCenterBottomTvClickListener(OnCenterBottomTvClickListener centerBottomTvClickListener) {
//        this.centerBottomTvClickListener = centerBottomTvClickListener;
//        setDefaultCenterViewClickListener(centerView);
//        return this;
//    }
//
//    public SuperTextView2 setRightTopTvClickListener(OnRightTopTvClickListener rightTopTvClickListener) {
//        this.rightTopTvClickListener = rightTopTvClickListener;
//        setDefaultRightViewClickListener(rightView);
//        return this;
//    }
//
//    public SuperTextView2 setRightTvClickListener(OnRightTvClickListener rightTvClickListener) {
//        this.rightTvClickListener = rightTvClickListener;
//        setDefaultRightViewClickListener(rightView);
//        return this;
//    }
//
//    public SuperTextView2 setRightBottomTvClickListener(OnRightBottomTvClickListener rightBottomTvClickListener) {
//        this.rightBottomTvClickListener = rightBottomTvClickListener;
//        setDefaultRightViewClickListener(rightView);
//        return this;
//    }
//
//    ////////////////////////////////////////////////////////////////////////////////////
    public interface OnSuperTextViewClickListener {
        void onClickListener();
    }
//
//    public interface OnLeftTopTvClickListener {
//        void onClickListener();
//    }
//
//    public interface OnLeftTvClickListener {
//        void onClickListener();
//    }
//
//    public interface OnLeftBottomTvClickListener {
//        void onClickListener();
//    }
//
//    public interface OnCenterTopTvClickListener {
//        void onClickListener();
//    }
//
//    public interface OnCenterTvClickListener {
//        void onClickListener();
//    }
//
//    public interface OnCenterBottomTvClickListener {
//        void onClickListener();
//    }
//
//    public interface OnRightTopTvClickListener {
//        void onClickListener();
//    }
//
//    public interface OnRightTvClickListener {
//        void onClickListener();
//    }
//
//    public interface OnRightBottomTvClickListener {
//        void onClickListener();
//    }
}