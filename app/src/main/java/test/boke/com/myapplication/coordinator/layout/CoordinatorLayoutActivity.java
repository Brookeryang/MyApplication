package test.boke.com.myapplication.coordinator.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.boke.com.myapplication.R;

//协调布局的Activity
public class CoordinatorLayoutActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    //    @BindView(R.id.view_page)
//    ViewPager mViewPage;
    private List<Fragment> mFragment;
    String[] mTitles = new String[]{
            "主页", "分类", "我的"
    };

    // android:popupTheme="@style/ThemeOverlay.AppCompat.Light"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_coordinator_layout);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        toolbar.setTitle("唐嫣");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupViewPager();
    }

    private void setupViewPager() {
        //这里添加TabLayout
    }
}
