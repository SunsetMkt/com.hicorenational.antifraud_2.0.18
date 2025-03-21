package zxing.android;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: FinishListener.java */
/* renamed from: zxing.android.b */
/* loaded from: classes2.dex */
public final class DialogInterfaceOnClickListenerC7343b implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {

    /* renamed from: a */
    private final Activity f25812a;

    public DialogInterfaceOnClickListenerC7343b(Activity activity) {
        this.f25812a = activity;
    }

    /* renamed from: a */
    private void m26826a() {
        this.f25812a.finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        m26826a();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        m26826a();
    }
}
