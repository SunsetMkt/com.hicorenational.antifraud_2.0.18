package p251g.p252a;

import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p284j.EnumC5177q;

/* compiled from: Notification.java */
/* renamed from: g.a.a0 */
/* loaded from: classes2.dex */
public final class C4453a0<T> {

    /* renamed from: b */
    static final C4453a0<Object> f17190b = new C4453a0<>(null);

    /* renamed from: a */
    final Object f17191a;

    private C4453a0(Object obj) {
        this.f17191a = obj;
    }

    @InterfaceC4546f
    /* renamed from: f */
    public static <T> C4453a0<T> m16437f() {
        return (C4453a0<T>) f17190b;
    }

    @InterfaceC4547g
    /* renamed from: a */
    public Throwable m16438a() {
        Object obj = this.f17191a;
        if (EnumC5177q.isError(obj)) {
            return EnumC5177q.getError(obj);
        }
        return null;
    }

    @InterfaceC4547g
    /* renamed from: b */
    public T m16439b() {
        Object obj = this.f17191a;
        if (obj == null || EnumC5177q.isError(obj)) {
            return null;
        }
        return (T) this.f17191a;
    }

    /* renamed from: c */
    public boolean m16440c() {
        return this.f17191a == null;
    }

    /* renamed from: d */
    public boolean m16441d() {
        return EnumC5177q.isError(this.f17191a);
    }

    /* renamed from: e */
    public boolean m16442e() {
        Object obj = this.f17191a;
        return (obj == null || EnumC5177q.isError(obj)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C4453a0) {
            return C4601b.m18285a(this.f17191a, ((C4453a0) obj).f17191a);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f17191a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f17191a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (EnumC5177q.isError(obj)) {
            return "OnErrorNotification[" + EnumC5177q.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.f17191a + "]";
    }

    @InterfaceC4546f
    /* renamed from: a */
    public static <T> C4453a0<T> m16435a(@InterfaceC4546f T t) {
        C4601b.m18284a((Object) t, "value is null");
        return new C4453a0<>(t);
    }

    @InterfaceC4546f
    /* renamed from: a */
    public static <T> C4453a0<T> m16436a(@InterfaceC4546f Throwable th) {
        C4601b.m18284a(th, "error is null");
        return new C4453a0<>(EnumC5177q.error(th));
    }
}
