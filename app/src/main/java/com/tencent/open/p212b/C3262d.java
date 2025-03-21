package com.tencent.open.p212b;

import android.content.Context;
import android.text.TextUtils;
import android.view.WindowManager;
import java.util.Locale;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.b.d */
/* loaded from: classes2.dex */
public class C3262d {

    /* renamed from: a */
    private static String f11181a;

    /* renamed from: b */
    private static String f11182b;

    /* renamed from: a */
    public static String m10456a(Context context) {
        if (!TextUtils.isEmpty(f11181a)) {
            return f11181a;
        }
        if (context == null) {
            return "";
        }
        f11181a = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            f11181a = windowManager.getDefaultDisplay().getWidth() + "x" + windowManager.getDefaultDisplay().getHeight();
        }
        return f11181a;
    }

    /* renamed from: a */
    public static String m10455a() {
        return Locale.getDefault().getLanguage();
    }
}
