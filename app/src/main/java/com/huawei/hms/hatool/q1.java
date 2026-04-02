package com.huawei.hms.hatool;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import com.umeng.analytics.pro.at;

/* JADX INFO: loaded from: classes.dex */
public class q1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static q1 f4795c = new q1();
    private boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f4796b = q0.i();

    private q1() {
    }

    public static q1 b() {
        return f4795c;
    }

    @TargetApi(24)
    public boolean a() {
        boolean zIsUserUnlocked;
        if (!this.a) {
            Context context = this.f4796b;
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) context.getSystemService(at.f7027m);
                if (userManager != null) {
                    zIsUserUnlocked = userManager.isUserUnlocked();
                } else {
                    this.a = false;
                }
            } else {
                zIsUserUnlocked = true;
            }
            this.a = zIsUserUnlocked;
        }
        return this.a;
    }
}
