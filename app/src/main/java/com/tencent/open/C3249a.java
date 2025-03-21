package com.tencent.open;

import android.app.Dialog;
import android.os.Build;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.open.log.SLog;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.a */
/* loaded from: classes2.dex */
public class C3249a {
    /* renamed from: a */
    public static void m10399a(Window window) {
        if (window == null) {
            return;
        }
        window.setFlags(1024, 1024);
        if (Build.VERSION.SDK_INT >= 16) {
            window.getDecorView().setSystemUiVisibility(1280);
        }
        if (Build.VERSION.SDK_INT < 21) {
            window.addFlags(AbstractC1191a.f2487B1);
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
    }

    /* renamed from: a */
    public static void m10398a(final Dialog dialog, Handler handler) {
        if (dialog == null || dialog.getContext() == null || handler == null) {
            return;
        }
        Toast.makeText(dialog.getContext(), "网页加载异常，请自行下载并安装QQ后，再重新登录。", 0).show();
        handler.postDelayed(new Runnable() { // from class: com.tencent.open.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    dialog.dismiss();
                } catch (Exception e2) {
                    SLog.m10501e("openSDK_LOG.DialogUtils", "dismiss dialog exception", e2);
                }
            }
        }, 100L);
    }
}
