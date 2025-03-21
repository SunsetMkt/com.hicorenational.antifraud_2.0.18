package p286h;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import java.io.Serializable;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5479c;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Result.kt */
@InterfaceC5610t0(version = "1.3")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 \u001e*\u0006\b\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002\u001e\u001fB\u0016\b\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0007J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u000f\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, m23546d2 = {"Lkotlin/Result;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", SurveyH5Bean.VALUE, "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", AbstractC1191a.f2581k0, "isSuccess-impl", "value$annotations", "()V", "equals", DispatchConstants.OTHER, "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.q0 */
/* loaded from: classes2.dex */
public final class C5475q0<T> implements Serializable {
    public static final a Companion = new a(null);

    @InterfaceC5817e
    private final Object value;

    /* compiled from: Result.kt */
    /* renamed from: h.q0$a */
    public static final class a {
        private a() {
        }

        @InterfaceC5426f
        /* renamed from: a */
        private final <T> Object m22445a(T t) {
            return C5475q0.m26855constructorimpl(t);
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }

        @InterfaceC5426f
        /* renamed from: a */
        private final <T> Object m22446a(Throwable th) {
            return C5475q0.m26855constructorimpl(C5597r0.m22715a(th));
        }
    }

    /* compiled from: Result.kt */
    /* renamed from: h.q0$b */
    public static final class b implements Serializable {

        @InterfaceC5479c
        @InterfaceC5816d
        public final Throwable exception;

        public b(@InterfaceC5816d Throwable th) {
            C5544i0.m22546f(th, "exception");
            this.exception = th;
        }

        public boolean equals(@InterfaceC5817e Object obj) {
            return (obj instanceof b) && C5544i0.m22531a(this.exception, ((b) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @InterfaceC5816d
        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    @InterfaceC5440n0
    private /* synthetic */ C5475q0(@InterfaceC5817e Object obj) {
        this.value = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    /* renamed from: a */
    private static final T m22444a(Object obj) {
        if (m26860isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    @InterfaceC5816d
    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ C5475q0 m26854boximpl(@InterfaceC5817e Object obj) {
        return new C5475q0(obj);
    }

    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: constructor-impl, reason: not valid java name */
    public static Object m26855constructorimpl(@InterfaceC5817e Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m26856equalsimpl(Object obj, @InterfaceC5817e Object obj2) {
        return (obj2 instanceof C5475q0) && C5544i0.m22531a(obj, ((C5475q0) obj2).m26863unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m26857equalsimpl0(@InterfaceC5817e Object obj, @InterfaceC5817e Object obj2) {
        return C5544i0.m22531a(obj, obj2);
    }

    @InterfaceC5817e
    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m26858exceptionOrNullimpl(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).exception;
        }
        return null;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m26859hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m26860isFailureimpl(Object obj) {
        return obj instanceof b;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m26861isSuccessimpl(Object obj) {
        return !(obj instanceof b);
    }

    @InterfaceC5816d
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m26862toStringimpl(Object obj) {
        if (obj instanceof b) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    @InterfaceC5440n0
    public static /* synthetic */ void value$annotations() {
    }

    public boolean equals(Object obj) {
        return m26856equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m26859hashCodeimpl(this.value);
    }

    @InterfaceC5816d
    public String toString() {
        return m26862toStringimpl(this.value);
    }

    @InterfaceC5817e
    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m26863unboximpl() {
        return this.value;
    }
}
