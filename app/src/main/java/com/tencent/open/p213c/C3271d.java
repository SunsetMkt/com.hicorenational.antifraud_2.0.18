package com.tencent.open.p213c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.log.SLog;
import com.tencent.open.web.security.C3299a;
import com.tencent.open.web.security.SecureJsInterface;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.c.d */
/* loaded from: classes2.dex */
public class C3271d extends C3269b {

    /* renamed from: a */
    public static boolean f11207a;

    /* renamed from: b */
    private KeyEvent f11208b;

    /* renamed from: c */
    private C3299a f11209c;

    public C3271d(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int unicodeChar;
        SLog.m10498d("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + f11207a);
        if (!f11207a) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyCode == 66) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyCode == 67) {
            C3299a.f11337b = true;
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getUnicodeChar() == 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.f11208b = new KeyEvent(0, 17);
        return super.dispatchKeyEvent(this.f11208b);
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        SLog.m10502i("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + SecureJsInterface.isPWDEdit);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        SLog.m10506v("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + onCreateInputConnection);
        if (onCreateInputConnection == null) {
            f11207a = false;
            return onCreateInputConnection;
        }
        f11207a = true;
        this.f11209c = new C3299a(super.onCreateInputConnection(editorInfo), false);
        return this.f11209c;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        int unicodeChar;
        SLog.m10498d("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + f11207a);
        if (!f11207a) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (keyCode == 66) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (keyCode == 67) {
            C3299a.f11337b = true;
            return super.onKeyDown(i2, keyEvent);
        }
        if (keyEvent.getUnicodeChar() == 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (!SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
            return super.onKeyDown(i2, keyEvent);
        }
        this.f11208b = new KeyEvent(0, 17);
        return super.onKeyDown(this.f11208b.getKeyCode(), this.f11208b);
    }
}
