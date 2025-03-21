package com.tencent.open.web.security;

import com.tencent.open.C3258b;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class SecureJsInterface extends C3258b.b {
    public static boolean isPWDEdit = false;

    /* renamed from: a */
    private String f11335a;

    public void clearAllEdit() {
        SLog.m10502i("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Exception e2) {
            SLog.m10500e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e2.getMessage());
            throw new RuntimeException(e2);
        }
    }

    public void curPosFromJS(String str) {
        int i2;
        SLog.m10498d("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + str);
        try {
            i2 = Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            SLog.m10501e("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e2);
            i2 = -1;
        }
        if (i2 < 0) {
            throw new RuntimeException("position is illegal.");
        }
        boolean z = C3299a.f11338c;
        boolean z2 = C3299a.f11337b;
        if (z2) {
            if (Boolean.valueOf(JniInterface.BackSpaceChar(z2, i2)).booleanValue()) {
                C3299a.f11337b = false;
                return;
            }
            return;
        }
        this.f11335a = C3299a.f11336a;
        String str2 = this.f11335a;
        JniInterface.insetTextToArray(i2, str2, str2.length());
        SLog.m10506v("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.f11335a);
    }

    @Override // com.tencent.open.C3258b.b
    public boolean customCallback() {
        return true;
    }

    public String getMD5FromNative() {
        SLog.m10502i("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        try {
            String pWDKeyToMD5 = JniInterface.getPWDKeyToMD5(null);
            SLog.m10506v("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + pWDKeyToMD5);
            return pWDKeyToMD5;
        } catch (Exception e2) {
            SLog.m10500e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e2.getMessage());
            throw new RuntimeException(e2);
        }
    }

    public void isPasswordEdit(String str) {
        int i2;
        SLog.m10502i("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + str);
        try {
            i2 = Integer.parseInt(str);
        } catch (Exception e2) {
            SLog.m10500e("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e2.getMessage());
            i2 = -1;
        }
        if (i2 != 0 && i2 != 1) {
            throw new RuntimeException("is pswd edit flag is illegal.");
        }
        if (i2 == 0) {
            isPWDEdit = false;
        } else if (i2 == 1) {
            isPWDEdit = true;
        }
    }
}
