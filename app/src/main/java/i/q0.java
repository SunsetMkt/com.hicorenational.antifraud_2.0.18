package i;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import java.io.Serializable;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.3")
@y(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 \u001e*\u0006\b\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002\u001e\u001fB\u0016\b\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00d6\u0003J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\u0087\b\u00a2\u0006\u0004\b\u0017\u0010\u0007J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\u000f\u0010\u001a\u001a\u00020\u001bH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lkotlin/Result;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", SurveyH5Bean.VALUE, "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", d.c.a.b.a.a.k0, "isSuccess-impl", "value$annotations", "()V", "equals", DispatchConstants.OTHER, "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public final class q0<T> implements Serializable {
    public static final a Companion = new a(null);

    @j.c.a.e
    private final Object value;

    /* JADX INFO: compiled from: Result.kt */
    public static final class a {
        private a() {
        }

        @i.m2.f
        private final <T> Object a(T t) {
            return q0.m772constructorimpl(t);
        }

        public /* synthetic */ a(i.q2.t.v vVar) {
            this();
        }

        @i.m2.f
        private final <T> Object a(Throwable th) {
            return q0.m772constructorimpl(r0.a(th));
        }
    }

    /* JADX INFO: compiled from: Result.kt */
    public static final class b implements Serializable {

        @i.q2.c
        @j.c.a.d
        public final Throwable exception;

        public b(@j.c.a.d Throwable th) {
            i.q2.t.i0.f(th, "exception");
            this.exception = th;
        }

        public boolean equals(@j.c.a.e Object obj) {
            return (obj instanceof b) && i.q2.t.i0.a(this.exception, ((b) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @j.c.a.d
        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    @n0
    private /* synthetic */ q0(@j.c.a.e Object obj) {
        this.value = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.m2.f
    private static final T a(Object obj) {
        if (m777isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    @j.c.a.d
    /* JADX INFO: renamed from: box-impl */
    public static final /* synthetic */ q0 m771boximpl(@j.c.a.e Object obj) {
        return new q0(obj);
    }

    @n0
    @j.c.a.d
    /* JADX INFO: renamed from: constructor-impl */
    public static Object m772constructorimpl(@j.c.a.e Object obj) {
        return obj;
    }

    /* JADX INFO: renamed from: equals-impl */
    public static boolean m773equalsimpl(Object obj, @j.c.a.e Object obj2) {
        return (obj2 instanceof q0) && i.q2.t.i0.a(obj, ((q0) obj2).m780unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0 */
    public static final boolean m774equalsimpl0(@j.c.a.e Object obj, @j.c.a.e Object obj2) {
        return i.q2.t.i0.a(obj, obj2);
    }

    @j.c.a.e
    /* JADX INFO: renamed from: exceptionOrNull-impl */
    public static final Throwable m775exceptionOrNullimpl(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).exception;
        }
        return null;
    }

    /* JADX INFO: renamed from: hashCode-impl */
    public static int m776hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* JADX INFO: renamed from: isFailure-impl */
    public static final boolean m777isFailureimpl(Object obj) {
        return obj instanceof b;
    }

    /* JADX INFO: renamed from: isSuccess-impl */
    public static final boolean m778isSuccessimpl(Object obj) {
        return !(obj instanceof b);
    }

    @j.c.a.d
    /* JADX INFO: renamed from: toString-impl */
    public static String m779toStringimpl(Object obj) {
        if (obj instanceof b) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    @n0
    public static /* synthetic */ void value$annotations() {
    }

    public boolean equals(Object obj) {
        return m773equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m776hashCodeimpl(this.value);
    }

    @j.c.a.d
    public String toString() {
        return m779toStringimpl(this.value);
    }

    @j.c.a.e
    /* JADX INFO: renamed from: unbox-impl */
    public final /* synthetic */ Object m780unboximpl() {
        return this.value;
    }
}
