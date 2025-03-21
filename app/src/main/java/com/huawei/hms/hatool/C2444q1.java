package com.huawei.hms.hatool;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import com.umeng.analytics.pro.C3336at;

/* renamed from: com.huawei.hms.hatool.q1 */
/* loaded from: classes.dex */
public class C2444q1 {

    /* renamed from: c */
    private static C2444q1 f7602c = new C2444q1();

    /* renamed from: a */
    private boolean f7603a = false;

    /* renamed from: b */
    private Context f7604b = AbstractC2443q0.m7311i();

    private C2444q1() {
    }

    /* renamed from: b */
    public static C2444q1 m7318b() {
        return f7602c;
    }

    @TargetApi(24)
    /* renamed from: a */
    public boolean m7319a() {
        boolean z;
        if (!this.f7603a) {
            Context context = this.f7604b;
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) context.getSystemService(C3336at.f11499m);
                if (userManager != null) {
                    z = userManager.isUserUnlocked();
                } else {
                    this.f7603a = false;
                }
            } else {
                z = true;
            }
            this.f7603a = z;
        }
        return this.f7603a;
    }
}
