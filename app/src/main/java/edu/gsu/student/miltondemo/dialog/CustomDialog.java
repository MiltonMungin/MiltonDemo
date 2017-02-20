package edu.gsu.student.miltondemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;

import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.student.miltondemo.R;

/**
 * Created by miltonm on 2/15/17.
 */

public class CustomDialog extends Dialog {

    @OnClick(R.id.dialog_ok)
    public void okClick(){

        listener.onClickListener();
        dismiss();
    }

    private ICustomeDialogEventListener listener;

    public interface ICustomeDialogEventListener {
        public void onClickListener();
    }

    public CustomDialog(@NonNull Context context, ICustomeDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);
        ButterKnife.bind(this);
    }
}
