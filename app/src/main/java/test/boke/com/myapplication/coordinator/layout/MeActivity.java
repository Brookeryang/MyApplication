package test.boke.com.myapplication.coordinator.layout;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.boke.com.myapplication.R;

public class MeActivity extends AppCompatActivity {

    @BindView(R.id.coll_toolable)
    CollapsingToolbarLayout collToolable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        ButterKnife.bind(this);
        collToolable.setTitle("个人主页");
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        //编辑的点击事件
        
    }
}
