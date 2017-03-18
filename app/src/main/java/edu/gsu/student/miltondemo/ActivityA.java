package edu.gsu.student.miltondemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityA extends BaseActivity {

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
        setContentView(R.layout.activity_a);
        ButterKnife.bind(this);
        toastShort("activity A");
    }

}
