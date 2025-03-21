package com.luck.picture.lib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.luck.picture.lib.C2639R;

/* loaded from: classes.dex */
public class PictureLoadingDialog extends Dialog {
    public PictureLoadingDialog(Context context) {
        super(context, C2639R.style.Picture_Theme_AlertDialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        getWindow().setWindowAnimations(C2639R.style.PictureThemeDialogWindowStyle);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2639R.layout.picture_alert_dialog);
    }
}
