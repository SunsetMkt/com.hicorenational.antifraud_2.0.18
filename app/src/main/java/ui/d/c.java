package ui.d;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import com.hicorenational.antifraud.R;

/* JADX INFO: compiled from: RecordFinishDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends d {
    public c(Context context) {
        super(context, R.style.SmsIntercepteDilog);
    }

    @Override // ui.d.d, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 26) {
            window.setType(2038);
        } else {
            window.setType(2003);
        }
        this.a.setText("\u901a\u8bdd\u5f55\u97f3\u5df2\u5b8c\u6210");
        this.f14090c.setVisibility(8);
        c("\u4e3e\u62a5\u5f55\u97f3");
        setCanceledOnTouchOutside(false);
    }
}
