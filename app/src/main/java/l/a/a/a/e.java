package l.a.a.a;

import android.content.Context;

/* JADX INFO: compiled from: HonorPackageManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static volatile e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f12668b = new Object();

    private e(Context context) {
        new f(context);
    }

    public static e a(Context context) {
        synchronized (f12668b) {
            if (a == null) {
                if (context.getApplicationContext() != null) {
                    a = new e(context.getApplicationContext());
                } else {
                    a = new e(context);
                }
            }
        }
        return a;
    }

    public String a() {
        return "com.hihonor.id";
    }
}
