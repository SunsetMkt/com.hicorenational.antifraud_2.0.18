package p286h.p306n2;

import java.io.Closeable;
import p286h.C5237g;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5610t0;
import p286h.p304m2.C5432l;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5535f0;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Closeable.kt */
@InterfaceC5481e(name = "CloseableKt")
/* renamed from: h.n2.c */
/* loaded from: classes2.dex */
public final class C5444c {
    @InterfaceC5426f
    /* renamed from: a */
    private static final <T extends Closeable, R> R m22274a(T t, InterfaceC5506l<? super T, ? extends R> interfaceC5506l) {
        try {
            R invoke = interfaceC5506l.invoke(t);
            C5535f0.m22474b(1);
            if (C5432l.m22181a(1, 1, 0)) {
                m22275a(t, (Throwable) null);
            } else if (t != null) {
                t.close();
            }
            C5535f0.m22471a(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                C5535f0.m22474b(1);
                if (C5432l.m22181a(1, 1, 0)) {
                    m22275a(t, th);
                } else if (t != null) {
                    try {
                        t.close();
                    } catch (Throwable unused) {
                    }
                }
                C5535f0.m22471a(1);
                throw th2;
            }
        }
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5440n0
    /* renamed from: a */
    public static final void m22275a(@InterfaceC5817e Closeable closeable, @InterfaceC5817e Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            C5237g.m18969a(th, th2);
        }
    }
}
