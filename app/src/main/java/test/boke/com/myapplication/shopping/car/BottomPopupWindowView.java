//package test.boke.com.myapplication.shopping.car;
//
//import android.animation.Animator;
//import android.animation.ValueAnimator;
//import android.content.Context;
//import android.support.annotation.Nullable;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewConfiguration;
//import android.widget.FrameLayout;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//
//import test.boke.com.myapplication.R;
//
///**
// * <pre>
// *     author : yyh
// *     time :  2017/7/13 16:03
// *     version: 1.0
// *     desc   : 自定义底部弹出
// * </pre>
// */
//public class BottomPopupWindowView extends LinearLayout implements View.OnClickListener {
//    private Animator.AnimatorListener animatorListener;
//    //底部内容的View
//    private FrameLayout base_view;
//    //内容的View
//    private FrameLayout content_view;
//    //背景的View
//    private RelativeLayout popup_bg;
//    //xml加载的View
//    private View bottomPopopView;
//    //外部加载的内容View
//    private View contentView;
//    //外部加载的底部内容View
//    private View baseView;
//    //手势的最小值
//    private float minVelocity = 0;
//    //加载一次的判断值
//    private boolean mDrawable = true;
//
//    public void setAnimatorListener(Animator.AnimatorListener animatorListener) {
//        this.animatorListener = animatorListener;
//    }
//
//    public void setBaseView(View baseView) {
//        this.baseView = baseView;
//    }
//
//    public void setContentView(int id) {
//        this.contentView = LayoutInflater.from(getContext()).inflate(id, null);
//    }
//
//    public BottomPopupWindowView(Context context) {
//        this(context, null);
//    }
//
//    public BottomPopupWindowView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs, 0);
//    }
//
//    public BottomPopupWindowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        //初始化各种数值
//        minVelocity = ViewConfiguration.get(getContext()).getScaledTouchSlop();
//        bottomPopopView = LayoutInflater.from(getContext()).inflate(R.layout.layout_bottom_popup, null);
//        base_view = (FrameLayout) bottomPopopView.findViewById(R.id.bottom_view);
//        base_view.setOnClickListener(this);
//        content_view = (FrameLayout) bottomPopopView.findViewById(R.id.content_view);
//        popup_bg = (RelativeLayout) bottomPopopView.findViewById(R.id.popup_bg);
//        popup_bg.setOnClickListener(this);
//        //把整个View都加载在LinearLayout里显示出来
//        addView(bottomPopopView);
//        //内容区域判断是否向下,就关闭弹框
//        content_view.setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                float y1 = 0, y2 = 0;
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    y1 = event.getY();
//                }
//                if (event.getAction() == MotionEvent.ACTION_UP) {
//                    y2 = event.getY();
//                    if ((y2 - y1) > minVelocity) {
//                        disMissPopupView();
//                    }
//                }
//                return false;
//            }
//        });
//    }
//
//    private void disMissPopupView() {
//        //开始关闭动画数据
//        endAnimation();
//    }
//
//
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            //背景颜色监听
//            case R.id.popup_bg:
//                disMissPopupView();
//                break;
//            //屏蔽内容区域的点击事件
//            case R.id.bottom_view:
//                //
//                break;
//        }
//    }
//    //结束动画数值变化
//    private void endAnimation() {
//        ValueAnimator valueAnimator = ValueAnimator.ofInt(40,0);
//        valueAnimator.setDuration(250);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                if (animatorListener != null){
//                    animatorListener.onAnimationEnd((int) valueAnimator.getAnimatedValue());
//                }
//            }
//        });
//    }
//}
