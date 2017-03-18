package edu.gsu.student.miltondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.student.miltondemo.bean.Book;
import edu.gsu.student.miltondemo.dialog.CustomDialog;
import edu.gsu.student.miltondemo.dialog.QuizDialog;
import util.UtilLog;

public class MainActivity extends BaseActivity implements View.OnTouchListener {

    private ImageButton bt1;
    private ImageButton bt3;
    private GestureDetector mGestureDetector;

    @BindView(R.id.main_fl) FrameLayout fl;

    @OnClick(R.id.bt2)
    public void button2Click(){
        Intent intent = new Intent(this, DialogActivity.class);
        //toActivity(DialogActivity.class);
        startActivityForResult(intent,2);
    }

    @OnClick(R.id.img_bt_right)
    public void imgButtonRightClick(){
        toActivity(ActivityA.class);
    }

    @OnClick(R.id.main_animation_bt)
    public void toAnimationActivity(){
        toActivity(AnimationActivity.class);
    }

    @OnClick(R.id.main_timer_bt)
    public void toTimerActivity(){
        toActivity(TimerActivity.class);
    }

    @OnClick(R.id.main_animator_bt)
    public void toAnimatorActivity(){
        toActivity(AnimatorActivity.class);
    }

    @OnClick(R.id.main_quiz4_bt)
    public void quiz4Dialog() {
        quizDialog();
    }

    private void quizDialog() {

        final QuizDialog dialog = new QuizDialog(this, new QuizDialog.ICustomeDialogEventListener() {
            @Override
            public void onClickListener () {
                Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent);
            }
            public void onClickListener2 () {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
            public void onClickListener3 () {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });

        //dialog.setTitle("TestTitle");
        dialog.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialView();
        initialListener();
        ButterKnife.bind(this);
        mGestureDetector = new GestureDetector(this, new simpleGestureListener());
        fl.setOnTouchListener(this);
    }

    private void initialView() {

        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.bt3);
    }

    private void initialListener() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Button1 was clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(), ViewPagerActivity.class);
                intent.putExtra("key", "value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Milton");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                //startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });



        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListViewActivity.class);
                startActivityForResult(intent,3);

                //toActivity(ListViewActivity.class);
//                Intent intent = new Intent(v.getContext(), ListViewActivity.class);
//                startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                String message = data.getStringExtra("message");
                toastShort(message);
                break;
            case 2:
                toastShort("Dialog");
                break;
            case 3:
                toastShort("ListView");
                break;
            default:
        }
    }

    public void onClick(View v) {
        toastLong("Button2 was Clicked");

        //Toast.makeText(v.getContext(), "Button2 was clicked", Toast.LENGTH_LONG).show();

        UtilLog.logD("testD", "onClick");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        public boolean onDown(MotionEvent e) {
            UtilLog.logD("MyGesture", "onDown");
            toastShort("onDown");
            return true;
        }

        public void onShowPress(MotionEvent e) {
            UtilLog.logD("MyGesture", "onShowPress");
            toastShort("onShowPress");
        }

        public void onLongPress(MotionEvent e) {
            UtilLog.logD("MyGesture", "onLongPress");
            toastShort("onLongPress");
        }

        public boolean onSingleTapUp(MotionEvent e) {
            UtilLog.logD("MyGesture", "onSingleTapUp");
            toastShort("onSingleTapUp");
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent e) {
            UtilLog.logD("MyGesture", "onSingleTapCpnfirmed");
            toastShort("onSingleTapCpnfirmed");
            return true;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            UtilLog.logD("MyGesture", "onScroll:" + (e2.getY() - e1.getY()) + " " + distanceX);
            toastShort("onScroll");
            return true;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            UtilLog.logD("MyGesture", "onFling");
            toastShort("onFling");
            return true;
        }

        public boolean onDoubleTap(MotionEvent e) {
            UtilLog.logD("MyGesture", "onDoubleTap");
            toastShort("onDoubleTap");
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent e) {
            UtilLog.logD("MyGesture", "onDoubleTapEvent");
            toastShort("onDoubleTapEvent");
            return true;
        }
    }

}
