package edu.gsu.student.miltondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Quiz4Activity extends BaseActivity {

    @OnClick(R.id.quiz4_bt_cancel)
    public void toViewPagerActivity(){
        toActivity(ViewPagerActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        ButterKnife.bind(this);
    }
}
