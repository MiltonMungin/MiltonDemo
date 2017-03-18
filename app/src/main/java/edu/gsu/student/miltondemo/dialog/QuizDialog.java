package edu.gsu.student.miltondemo.dialog;

import android.app.Dialog;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.student.miltondemo.ActivityA;
import edu.gsu.student.miltondemo.BaseActivity;
import edu.gsu.student.miltondemo.R;
import edu.gsu.student.miltondemo.ViewPagerActivity;

/**
 * Created by miltonm on 3/8/17.
 */

public class QuizDialog extends Dialog  {

    private int checkedID;

    @BindView(R.id.quiz4_rb_group) RadioGroup radioGroup;

    @OnClick(R.id.quiz4_bt_cancel)
    public void cancelClick(){

        listener.onClickListener();
        dismiss();
    }

    @OnClick(R.id.quiz4_bt_ok)
    public void okClick(){
        switch (checkedID){
            case R.id.quiz4_rb1:
                rb1();
                break;
            case R.id.quiz4_rb2:
                rb2();
                break;
            default:
                dismiss();
                break;
        }
    }


    private void rb1() {

        listener.onClickListener2();
        dismiss();
    }

    private void rb2() {

        listener.onClickListener3();
        dismiss();
    }


    private QuizDialog.ICustomeDialogEventListener listener;


    public interface ICustomeDialogEventListener {
        public void onClickListener();
        public void onClickListener2();
        public void onClickListener3();
        //public void onClickListener4();
    }

    public QuizDialog(@NonNull Context context, QuizDialog.ICustomeDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_dialog);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkedID = checkedId;

            }


        });
    }
}
