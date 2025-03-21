package com.huawei.hms.p182ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.UIUtil;

/* loaded from: classes.dex */
public abstract class AbstractDialog {

    /* renamed from: a */
    private Activity f7896a;

    /* renamed from: b */
    private AlertDialog f7897b;

    /* renamed from: c */
    private Callback f7898c;

    public interface Callback {
        void onCancel(AbstractDialog abstractDialog);

        void onDoWork(AbstractDialog abstractDialog);
    }

    /* renamed from: com.huawei.hms.ui.AbstractDialog$a */
    class DialogInterfaceOnClickListenerC2530a implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC2530a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            AbstractDialog.this.fireDoWork();
        }
    }

    /* renamed from: com.huawei.hms.ui.AbstractDialog$b */
    class DialogInterfaceOnClickListenerC2531b implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC2531b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            AbstractDialog.this.cancel();
        }
    }

    /* renamed from: com.huawei.hms.ui.AbstractDialog$c */
    class DialogInterfaceOnCancelListenerC2532c implements DialogInterface.OnCancelListener {
        DialogInterfaceOnCancelListenerC2532c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            AbstractDialog.this.fireCancel();
        }
    }

    /* renamed from: com.huawei.hms.ui.AbstractDialog$d */
    class DialogInterfaceOnKeyListenerC2533d implements DialogInterface.OnKeyListener {
        DialogInterfaceOnKeyListenerC2533d() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            if (4 != i2 || keyEvent.getAction() != 1) {
                return false;
            }
            AbstractDialog.this.cancel();
            return true;
        }
    }

    public void cancel() {
        AlertDialog alertDialog = this.f7897b;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    public void dismiss() {
        AlertDialog alertDialog = this.f7897b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    protected void fireCancel() {
        Callback callback = this.f7898c;
        if (callback != null) {
            callback.onCancel(this);
        }
    }

    protected void fireDoWork() {
        Callback callback = this.f7898c;
        if (callback != null) {
            callback.onDoWork(this);
        }
    }

    protected Activity getActivity() {
        return this.f7896a;
    }

    protected int getDialogThemeId() {
        return UIUtil.getDialogThemeId(getActivity());
    }

    protected AlertDialog onCreateDialog(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), getDialogThemeId());
        String onGetTitleString = onGetTitleString(activity);
        if (onGetTitleString != null) {
            builder.setTitle(onGetTitleString);
        }
        String onGetMessageString = onGetMessageString(activity);
        if (onGetMessageString != null) {
            builder.setMessage(onGetMessageString);
        }
        String onGetPositiveButtonString = onGetPositiveButtonString(activity);
        if (onGetPositiveButtonString != null) {
            builder.setPositiveButton(onGetPositiveButtonString, new DialogInterfaceOnClickListenerC2530a());
        }
        String onGetNegativeButtonString = onGetNegativeButtonString(activity);
        if (onGetNegativeButtonString != null) {
            builder.setNegativeButton(onGetNegativeButtonString, new DialogInterfaceOnClickListenerC2531b());
        }
        return builder.create();
    }

    protected abstract String onGetMessageString(Context context);

    protected abstract String onGetNegativeButtonString(Context context);

    protected abstract String onGetPositiveButtonString(Context context);

    protected abstract String onGetTitleString(Context context);

    public void setMessage(CharSequence charSequence) {
        AlertDialog alertDialog = this.f7897b;
        if (alertDialog != null) {
            alertDialog.setMessage(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        AlertDialog alertDialog = this.f7897b;
        if (alertDialog != null) {
            alertDialog.setTitle(charSequence);
        }
    }

    public void show(Activity activity, Callback callback) {
        this.f7896a = activity;
        this.f7898c = callback;
        if (activity == null || activity.isFinishing()) {
            HMSLog.m7715e("AbstractDialog", "In show, The activity is null or finishing.");
            return;
        }
        AlertDialog onCreateDialog = onCreateDialog(this.f7896a);
        this.f7897b = onCreateDialog;
        onCreateDialog.setCanceledOnTouchOutside(false);
        this.f7897b.setOnCancelListener(new DialogInterfaceOnCancelListenerC2532c());
        this.f7897b.setOnKeyListener(new DialogInterfaceOnKeyListenerC2533d());
        this.f7897b.show();
    }
}
