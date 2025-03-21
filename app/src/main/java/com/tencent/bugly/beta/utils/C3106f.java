package com.tencent.bugly.beta.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.utils.f */
/* loaded from: classes2.dex */
public class C3106f {

    /* renamed from: a */
    private static Toast f10076a;

    /* renamed from: a */
    public static void m9464a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = f10076a;
        if (toast == null) {
            f10076a = Toast.makeText(context, str, 0);
        } else {
            toast.setText(str);
        }
        f10076a.show();
    }
}
