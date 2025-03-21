package p358k.p359a.p360a.p361a;

import android.content.Context;

/* compiled from: HonorPackageManager.java */
/* renamed from: k.a.a.a.e */
/* loaded from: classes2.dex */
public class C5851e {

    /* renamed from: a */
    private static volatile C5851e f21136a;

    /* renamed from: b */
    private static final Object f21137b = new Object();

    private C5851e(Context context) {
        new C5852f(context);
    }

    /* renamed from: a */
    public static C5851e m24637a(Context context) {
        synchronized (f21137b) {
            if (f21136a == null) {
                if (context.getApplicationContext() != null) {
                    f21136a = new C5851e(context.getApplicationContext());
                } else {
                    f21136a = new C5851e(context);
                }
            }
        }
        return f21136a;
    }

    /* renamed from: a */
    public String m24638a() {
        return "com.hihonor.id";
    }
}
