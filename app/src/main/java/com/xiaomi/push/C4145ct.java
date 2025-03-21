package com.xiaomi.push;

import android.content.Context;

/* renamed from: com.xiaomi.push.ct */
/* loaded from: classes2.dex */
public class C4145ct {

    /* renamed from: a */
    private static C4137cl f14791a;

    /* renamed from: a */
    private static C4138cm f14792a;

    /* renamed from: a */
    public static void m14185a(Context context, AbstractC4207fa abstractC4207fa) {
        if (m14190b(context)) {
            if (f14791a == null) {
                f14791a = new C4137cl(context);
            }
            if (f14792a == null) {
                f14792a = new C4138cm(context);
            }
            C4137cl c4137cl = f14791a;
            abstractC4207fa.m14767a(c4137cl, c4137cl);
            C4138cm c4138cm = f14792a;
            abstractC4207fa.m14776b(c4138cm, c4138cm);
            m14186a("startStats");
        }
    }

    /* renamed from: b */
    public static void m14189b(Context context, AbstractC4207fa abstractC4207fa) {
        C4137cl c4137cl = f14791a;
        if (c4137cl != null) {
            abstractC4207fa.m14766a(c4137cl);
            f14791a = null;
        }
        C4138cm c4138cm = f14792a;
        if (c4138cm != null) {
            abstractC4207fa.m14775b(c4138cm);
            f14792a = null;
        }
        m14186a("stopStats");
    }

    /* renamed from: c */
    public static void m14191c(Context context) {
        m14186a("onPing");
        if (m14190b(context)) {
            C4148cw.m14233c(context, System.currentTimeMillis(), m14187a(context));
        }
    }

    /* renamed from: d */
    public static void m14192d(Context context) {
        m14186a("onPong");
        if (m14190b(context)) {
            C4148cw.m14234d(context, System.currentTimeMillis(), m14187a(context));
        }
    }

    /* renamed from: b */
    private static boolean m14190b(Context context) {
        return C4136ck.m14115a(context);
    }

    /* renamed from: a */
    public static void m14184a(Context context) {
        m14186a("onSendMsg");
        if (m14190b(context)) {
            C4148cw.m14228a(context, System.currentTimeMillis(), m14187a(context));
        }
    }

    /* renamed from: b */
    public static void m14188b(Context context) {
        m14186a("onReceiveMsg");
        if (m14190b(context)) {
            C4148cw.m14232b(context, System.currentTimeMillis(), m14187a(context));
        }
    }

    /* renamed from: a */
    public static boolean m14187a(Context context) {
        return C4287i.m15644b(context);
    }

    /* renamed from: a */
    static void m14186a(String str) {
        C4136ck.m14114a("Push-PowerStats", str);
    }
}
