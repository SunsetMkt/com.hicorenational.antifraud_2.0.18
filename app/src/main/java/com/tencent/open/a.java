package com.tencent.open;

import android.app.Dialog;
import android.os.Build;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.open.log.SLog;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void a(Window window) {
        if (window == null) {
            return;
        }
        window.setFlags(1024, 1024);
        if (Build.VERSION.SDK_INT >= 16) {
            window.getDecorView().setSystemUiVisibility(1280);
        }
        if (Build.VERSION.SDK_INT < 21) {
            window.addFlags(d.c.a.b.a.a.B1);
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
    }

    public static void a(final Dialog dialog, Handler handler) {
        if (dialog == null || dialog.getContext() == null || handler == null) {
            return;
        }
        Toast.makeText(dialog.getContext(), "\u7f51\u9875\u52a0\u8f7d\u5f02\u5e38\uff0c\u8bf7\u81ea\u884c\u4e0b\u8f7d\u5e76\u5b89\u88c5QQ\u540e\uff0c\u518d\u91cd\u65b0\u767b\u5f55\u3002", 0).show();
        handler.postDelayed(new Runnable() { // from class: com.tencent.open.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    dialog.dismiss();
                } catch (Exception e2) {
                    SLog.e("openSDK_LOG.DialogUtils", "dismiss dialog exception", e2);
                }
            }
        }, 100L);
    }
}
