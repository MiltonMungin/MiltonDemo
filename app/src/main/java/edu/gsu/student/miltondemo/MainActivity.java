package edu.gsu.student.miltondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.student.miltondemo.bean.Book;
import util.UtilLog;

public class MainActivity extends BaseActivity {

    private ImageButton bt1;
    private ImageButton bt3;

    @OnClick(R.id.bt2)
    public void button2Click(){
        Intent intent = new Intent(this, DialogActivity.class);
        //toActivity(DialogActivity.class);
        startActivityForResult(intent,2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialView();
        initialListener();
        ButterKnife.bind(this);
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
}
