package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.web.security.a */
/* loaded from: classes2.dex */
public class C3299a extends InputConnectionWrapper {

    /* renamed from: a */
    public static String f11336a = null;

    /* renamed from: b */
    public static boolean f11337b = false;

    /* renamed from: c */
    public static boolean f11338c = false;

    public C3299a(InputConnection inputConnection, boolean z) {
        super(inputConnection, z);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i2) {
        f11338c = true;
        f11336a = charSequence.toString();
        SLog.m10506v("openSDK_LOG.CaptureInputConnection", "-->commitText: " + charSequence.toString());
        return super.commitText(charSequence, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            SLog.m10502i("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
            f11336a = String.valueOf((char) keyEvent.getUnicodeChar());
            f11338c = true;
            SLog.m10498d("openSDK_LOG.CaptureInputConnection", "s: " + f11336a);
        }
        SLog.m10498d("openSDK_LOG.CaptureInputConnection", "-->sendKeyEvent: " + f11336a);
        return super.sendKeyEvent(keyEvent);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i2) {
        f11338c = true;
        f11336a = charSequence.toString();
        SLog.m10506v("openSDK_LOG.CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
        return super.setComposingText(charSequence, i2);
    }
}
