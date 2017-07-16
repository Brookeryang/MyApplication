package test.boke.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.boke.com.myapplication.bk.im.IMStartActivity;
import test.boke.com.myapplication.coordinator.layout.CoordinatorLayoutActivity;
import test.boke.com.myapplication.coordinator.layout.MeActivity;
import test.boke.com.myapplication.custo.textview.SuperTextViewActivity;
import test.boke.com.myapplication.custom.widget.TopBar;
import test.boke.com.myapplication.custom.widget.topbarClickListener;
import test.boke.com.myapplication.shopping.car.ShoppingCartActivity;

/**
 * <pre>
 *     author : 杨永红
 *     e-mail : 1355857303@qq.com
 *     time   : 2017/6/26/23:23
 *     version: 1.0
 *     desc   : xxxx描述
 * </pre>
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.but_coordinator_layout)
    Button butCoordinatorLayout;
    @BindView(R.id.but_me)
    Button butMe;
    @BindView(R.id.but_shopping_cart)
    Button butShoppingCart;
    @BindView(R.id.but_start_im)
    Button butStartIm;
    private TopBar mTopBar;
    private Button but_SuperTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topbar);
        ButterKnife.bind(this);
        initView();
        initEvent();


    }

    private void initEvent() {
        mTopBar.setOnTopbarClickListener(new topbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this, "左边的返回键", Toast.LENGTH_LONG).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this, "右边的按钮", Toast.LENGTH_LONG).show();
            }
        });
        //显示左边
        //mTopBar.setButtonVisable(0, true);
        //mTopBar.setButtonVisable(1, false);
        //显示右边
//        mTopBar.setButtonVisable(1, true);
//        mTopBar.setButtonVisable(0, false);
    }

    private void initView() {
        mTopBar = (TopBar) findViewById(R.id.topbar);
        but_SuperTextView = (Button) findViewById(R.id.super_tv);
        but_SuperTextView.setOnClickListener(this);
        butCoordinatorLayout.setOnClickListener(this);
        butMe.setOnClickListener(this);
        butShoppingCart.setOnClickListener(this);
        butStartIm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.super_tv:
                startActivity(new Intent(this, SuperTextViewActivity.class));
                break;
            case R.id.but_coordinator_layout:
                startActivity(new Intent(this, CoordinatorLayoutActivity.class));
                break;
            case R.id.but_me:
                startActivity(new Intent(this, MeActivity.class));
                break;
            case R.id.but_shopping_cart:
                startActivity(new Intent(this, ShoppingCartActivity.class));
                break;
            //启动IM
            case R.id.but_start_im:
                startActivity(new Intent(this, IMStartActivity.class));
                break;
        }
    }
}
