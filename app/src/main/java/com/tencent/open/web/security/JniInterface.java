package com.tencent.open.web.security;

import android.content.Context;
import com.tencent.connect.auth.AuthAgent;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C3289g;
import java.io.File;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class JniInterface {
    public static boolean isJniOk = false;

    public static native boolean BackSpaceChar(boolean z, int i2);

    public static native boolean clearAllPWD();

    /* renamed from: d1 */
    public static native String m10723d1(String str);

    /* renamed from: d2 */
    public static native String m10724d2(String str);

    public static native String getPWDKeyToMD5(String str);

    public static native boolean insetTextToArray(int i2, String str, int i3);

    public static void loadSo() {
        if (isJniOk) {
            return;
        }
        try {
            Context m10603a = C3289g.m10603a();
            if (m10603a != null) {
                if (new File(m10603a.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME).exists()) {
                    System.load(m10603a.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME);
                    isJniOk = true;
                    SLog.m10502i("openSDK_LOG.JniInterface", "-->load lib success:" + AuthAgent.SECURE_LIB_NAME);
                } else {
                    SLog.m10502i("openSDK_LOG.JniInterface", "-->fail, because so is not exists:" + AuthAgent.SECURE_LIB_NAME);
                }
            } else {
                SLog.m10502i("openSDK_LOG.JniInterface", "-->load lib fail, because context is null:" + AuthAgent.SECURE_LIB_NAME);
            }
        } catch (Throwable th) {
            SLog.m10501e("openSDK_LOG.JniInterface", "-->load lib error:" + AuthAgent.SECURE_LIB_NAME, th);
        }
    }
}
