package ui.view;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;
import com.hicorenational.antifraud.R;

/* JADX INFO: compiled from: ProgressDialogBar.java */
/* JADX INFO: loaded from: classes2.dex */
public class u extends Dialog {
    public static u a;

    public u(Context context) {
        super(context);
    }

    public static u a(Context context) {
        a = new u(context, R.style.CustomProgressDialog);
        a.setContentView(R.layout.progress_layout);
        return a;
    }

    public u b(String str) {
        return a;
    }

    public u(Context context, int i2) {
        super(context, i2);
    }

    public void a(String str) {
        TextView textView = (TextView) a.findViewById(R.id.text_progress);
        if (textView != null) {
            textView.setText(str);
        }
    }
}
