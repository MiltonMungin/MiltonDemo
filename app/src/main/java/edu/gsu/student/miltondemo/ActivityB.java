package edu.gsu.student.miltondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityB extends BaseActivity {

    @OnClick(R.id.a_a)
    public void toActA(){
        toActivity(ActivityA.class);
    }
    @OnClick(R.id.a_b)
    public void toActB(){
        toActivity(ActivityB.class);
    }
    @OnClick(R.id.a_c)
    public void toActC(){
        toActivity(ActivityC.class);
    }
    @OnClick(R.id.a_d)
    public void toActD(){
        toActivity(ActivityD.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        ButterKnife.bind(this);
        toastShort("activity B");
    }

}
