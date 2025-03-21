package p251g.p252a.p268y0.p284j;

import java.io.Serializable;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p270b.C4601b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: NotificationLite.java */
/* renamed from: g.a.y0.j.q */
/* loaded from: classes2.dex */
public enum EnumC5177q {
    COMPLETE;

    /* compiled from: NotificationLite.java */
    /* renamed from: g.a.y0.j.q$a */
    static final class a implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;

        /* renamed from: d */
        final InterfaceC4552c f20041d;

        a(InterfaceC4552c interfaceC4552c) {
            this.f20041d = interfaceC4552c;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f20041d + "]";
        }
    }

    /* compiled from: NotificationLite.java */
    /* renamed from: g.a.y0.j.q$b */
    static final class b implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e */
        final Throwable f20042e;

        b(Throwable th) {
            this.f20042e = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return C4601b.m18285a(this.f20042e, ((b) obj).f20042e);
            }
            return false;
        }

        public int hashCode() {
            return this.f20042e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f20042e + "]";
        }
    }

    /* compiled from: NotificationLite.java */
    /* renamed from: g.a.y0.j.q$c */
    static final class c implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;

        /* renamed from: s */
        final InterfaceC5823d f20043s;

        c(InterfaceC5823d interfaceC5823d) {
            this.f20043s = interfaceC5823d;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.f20043s + "]";
        }
    }

    public static <T> boolean accept(Object obj, InterfaceC5822c<? super T> interfaceC5822c) {
        if (obj == COMPLETE) {
            interfaceC5822c.onComplete();
            return true;
        }
        if (obj instanceof b) {
            interfaceC5822c.onError(((b) obj).f20042e);
            return true;
        }
        interfaceC5822c.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, InterfaceC5822c<? super T> interfaceC5822c) {
        if (obj == COMPLETE) {
            interfaceC5822c.onComplete();
            return true;
        }
        if (obj instanceof b) {
            interfaceC5822c.onError(((b) obj).f20042e);
            return true;
        }
        if (obj instanceof c) {
            interfaceC5822c.onSubscribe(((c) obj).f20043s);
            return false;
        }
        interfaceC5822c.onNext(obj);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(InterfaceC4552c interfaceC4552c) {
        return new a(interfaceC4552c);
    }

    public static Object error(Throwable th) {
        return new b(th);
    }

    public static InterfaceC4552c getDisposable(Object obj) {
        return ((a) obj).f20041d;
    }

    public static Throwable getError(Object obj) {
        return ((b) obj).f20042e;
    }

    public static InterfaceC5823d getSubscription(Object obj) {
        return ((c) obj).f20043s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof a;
    }

    public static boolean isError(Object obj) {
        return obj instanceof b;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof c;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(InterfaceC5823d interfaceC5823d) {
        return new c(interfaceC5823d);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, InterfaceC4514i0<? super T> interfaceC4514i0) {
        if (obj == COMPLETE) {
            interfaceC4514i0.onComplete();
            return true;
        }
        if (obj instanceof b) {
            interfaceC4514i0.onError(((b) obj).f20042e);
            return true;
        }
        interfaceC4514i0.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, InterfaceC4514i0<? super T> interfaceC4514i0) {
        if (obj == COMPLETE) {
            interfaceC4514i0.onComplete();
            return true;
        }
        if (obj instanceof b) {
            interfaceC4514i0.onError(((b) obj).f20042e);
            return true;
        }
        if (obj instanceof a) {
            interfaceC4514i0.onSubscribe(((a) obj).f20041d);
            return false;
        }
        interfaceC4514i0.onNext(obj);
        return false;
    }
}
