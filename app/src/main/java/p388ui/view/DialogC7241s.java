package p388ui.view;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;
import com.hicorenational.antifraud.C2113R;

/* compiled from: ProgressDialogBar.java */
/* renamed from: ui.view.s */
/* loaded from: classes2.dex */
public class DialogC7241s extends Dialog {

    /* renamed from: a */
    public static DialogC7241s f24975a;

    public DialogC7241s(Context context) {
        super(context);
    }

    /* renamed from: a */
    public static DialogC7241s m26028a(Context context) {
        f24975a = new DialogC7241s(context, C2113R.style.CustomProgressDialog);
        f24975a.setContentView(C2113R.layout.progress_layout);
        return f24975a;
    }

    /* renamed from: b */
    public DialogC7241s m26030b(String str) {
        return f24975a;
    }

    public DialogC7241s(Context context, int i2) {
        super(context, i2);
    }

    /* renamed from: a */
    public void m26029a(String str) {
        TextView textView = (TextView) f24975a.findViewById(C2113R.id.text_progress);
        if (textView != null) {
            textView.setText(str);
        }
    }
}
