package com.umeng.ccg;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

/* compiled from: Dispatch.java */
/* renamed from: com.umeng.ccg.c */
/* loaded from: classes2.dex */
public class C3440c {

    /* renamed from: a */
    public static final int f12354a = 101;

    /* renamed from: b */
    public static final int f12355b = 102;

    /* renamed from: c */
    public static final int f12356c = 103;

    /* renamed from: d */
    public static final int f12357d = 104;

    /* renamed from: e */
    public static final int f12358e = 105;

    /* renamed from: f */
    public static final int f12359f = 106;

    /* renamed from: g */
    public static final int f12360g = 107;

    /* renamed from: h */
    public static final int f12361h = 0;

    /* renamed from: i */
    public static final int f12362i = 1;

    /* renamed from: j */
    public static final int f12363j = 2;

    /* renamed from: k */
    public static final int f12364k = 201;

    /* renamed from: l */
    public static final int f12365l = 202;

    /* renamed from: m */
    public static final int f12366m = 203;

    /* renamed from: n */
    public static final int f12367n = 301;

    /* renamed from: o */
    public static final int f12368o = 302;

    /* renamed from: p */
    public static final int f12369p = 303;

    /* renamed from: q */
    private static HandlerThread f12370q = null;

    /* renamed from: r */
    private static Handler f12371r = null;

    /* renamed from: s */
    private static HashMap<Integer, a> f12372s = null;

    /* renamed from: t */
    private static final int f12373t = 256;

    /* compiled from: Dispatch.java */
    /* renamed from: com.umeng.ccg.c$a */
    public interface a {
        /* renamed from: a */
        void mo11469a(Object obj, int i2);
    }

    private C3440c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m11468b(Message message) {
        int i2 = message.arg1;
        Object obj = message.obj;
        Integer valueOf = Integer.valueOf(i2 / 100);
        HashMap<Integer, a> hashMap = f12372s;
        if (hashMap == null) {
            return;
        }
        a aVar = hashMap.containsKey(valueOf) ? f12372s.get(valueOf) : null;
        if (aVar != null) {
            aVar.mo11469a(obj, i2);
        }
    }

    /* renamed from: a */
    public static void m11464a(Context context, int i2, int i3, a aVar, Object obj, long j2) {
        if (context == null || aVar == null) {
            return;
        }
        if (f12372s == null) {
            f12372s = new HashMap<>();
        }
        Integer valueOf = Integer.valueOf(i3 / 100);
        if (!f12372s.containsKey(valueOf)) {
            f12372s.put(valueOf, aVar);
        }
        if (f12370q == null || f12371r == null) {
            m11463a();
        }
        try {
            if (f12371r != null) {
                Message obtainMessage = f12371r.obtainMessage();
                obtainMessage.what = i2;
                obtainMessage.arg1 = i3;
                obtainMessage.obj = obj;
                f12371r.sendMessageDelayed(obtainMessage, j2);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m11465a(Context context, int i2, a aVar, Object obj) {
        m11464a(context, 256, i2, aVar, obj, 0L);
    }

    /* renamed from: a */
    public static void m11466a(Context context, int i2, a aVar, Object obj, long j2) {
        m11464a(context, 256, i2, aVar, obj, j2);
    }

    /* renamed from: a */
    private static synchronized void m11463a() {
        synchronized (C3440c.class) {
            try {
                if (f12370q == null) {
                    f12370q = new HandlerThread("ccg_dispatch");
                    f12370q.start();
                    if (f12371r == null) {
                        f12371r = new Handler(f12370q.getLooper()) { // from class: com.umeng.ccg.c.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (message.what != 256) {
                                    return;
                                }
                                C3440c.m11468b(message);
                            }
                        };
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
