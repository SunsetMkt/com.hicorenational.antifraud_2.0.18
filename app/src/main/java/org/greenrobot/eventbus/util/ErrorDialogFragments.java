package org.greenrobot.eventbus.util;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* loaded from: classes2.dex */
public class ErrorDialogFragments {

    /* renamed from: a */
    public static int f21625a;

    /* renamed from: b */
    public static Class<?> f21626b;

    @TargetApi(11)
    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            ErrorDialogFragments.m25056a(dialogInterface, i2, getActivity(), getArguments());
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.m25055a(getActivity(), getArguments(), this);
        }
    }

    public static class Support extends androidx.fragment.app.DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            ErrorDialogFragments.m25056a(dialogInterface, i2, getActivity(), getArguments());
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.m25055a(getActivity(), getArguments(), this);
        }
    }

    /* renamed from: a */
    public static Dialog m25055a(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString(ErrorDialogManager.f21630d));
        builder.setMessage(bundle.getString(ErrorDialogManager.f21631e));
        int i2 = f21625a;
        if (i2 != 0) {
            builder.setIcon(i2);
        }
        builder.setPositiveButton(R.string.ok, onClickListener);
        return builder.create();
    }

    /* renamed from: a */
    public static void m25056a(DialogInterface dialogInterface, int i2, Activity activity, Bundle bundle) {
        Class<?> cls = f21626b;
        if (cls != null) {
            try {
                ErrorDialogManager.f21627a.f21662a.m25087b().m24999c(cls.newInstance());
            } catch (Exception e2) {
                throw new RuntimeException("Event cannot be constructed", e2);
            }
        }
        if (!bundle.getBoolean(ErrorDialogManager.f21632f, false) || activity == null) {
            return;
        }
        activity.finish();
    }
}
