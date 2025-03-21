package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.c */
/* loaded from: classes2.dex */
public abstract class AbstractDialogC3267c extends Dialog {

    /* renamed from: a */
    protected C3258b f11200a;

    /* renamed from: b */
    @SuppressLint({"NewApi"})
    protected final WebChromeClient f11201b;

    public AbstractDialogC3267c(Context context, int i2) {
        super(context, i2);
        this.f11201b = new WebChromeClient() { // from class: com.tencent.open.c.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (consoleMessage == null) {
                    return false;
                }
                SLog.m10502i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
                if (Build.VERSION.SDK_INT <= 7) {
                    return true;
                }
                AbstractDialogC3267c.this.mo10395a(consoleMessage == null ? "" : consoleMessage.message());
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i3, String str2) {
                SLog.m10502i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i3 + " of " + str2);
                if (Build.VERSION.SDK_INT == 7) {
                    AbstractDialogC3267c.this.mo10395a(str);
                }
            }
        };
    }

    /* renamed from: a */
    protected abstract void mo10395a(String str);

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11200a = new C3258b();
    }
}
