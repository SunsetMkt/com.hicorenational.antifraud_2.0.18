package p388ui.p389d;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import com.hicorenational.antifraud.C2113R;

/* compiled from: RecordFinishDialog.java */
/* renamed from: ui.d.c */
/* loaded from: classes2.dex */
public class DialogC6820c extends DialogC6821d {
    public DialogC6820c(Context context) {
        super(context, C2113R.style.SmsIntercepteDilog);
    }

    @Override // p388ui.p389d.DialogC6821d, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 26) {
            window.setType(2038);
        } else {
            window.setType(2003);
        }
        this.f23680a.setText("通话录音已完成");
        this.f23682c.setVisibility(8);
        m25489c("举报录音");
        setCanceledOnTouchOutside(false);
    }
}
