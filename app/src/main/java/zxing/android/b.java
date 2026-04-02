package zxing.android;

import android.app.Activity;
import android.content.DialogInterface;

/* JADX INFO: compiled from: FinishListener.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
    private final Activity a;

    public b(Activity activity) {
        this.a = activity;
    }

    private void a() {
        this.a.finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        a();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        a();
    }
}
