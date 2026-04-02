package i.k2;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.bh;
import i.n0;
import i.q0;
import i.q2.t.i0;
import i.q2.t.v;
import i.t0;
import i.y;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: SafeContinuationJvm.kt */
/* JADX INFO: loaded from: classes2.dex */
@n0
@t0(version = "1.3")
@y(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001a*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u001aB\u0015\b\u0011\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u00a2\u0006\u0002\u0010\u0005B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0001J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001e\u0010\u0014\u001a\u00020\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lkotlin/coroutines/SafeContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", com.umeng.analytics.pro.d.R, "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public final class k<T> implements d<T>, i.k2.n.a.e {
    private volatile Object a;

    /* JADX INFO: renamed from: b */
    private final d<T> f12123b;

    /* JADX INFO: renamed from: d */
    @Deprecated
    public static final a f12122d = new a(null);

    /* JADX INFO: renamed from: c */
    private static final AtomicReferenceFieldUpdater<k<?>, Object> f12121c = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, bh.ay);

    /* JADX INFO: compiled from: SafeContinuationJvm.kt */
    private static final class a {
        private a() {
        }

        @i.q2.h
        private static /* synthetic */ void a() {
        }

        public /* synthetic */ a(v vVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@j.c.a.d d<? super T> dVar, @j.c.a.e Object obj) {
        i0.f(dVar, "delegate");
        this.f12123b = dVar;
        this.a = obj;
    }

    @j.c.a.e
    @n0
    public final Object a() throws Throwable {
        Object obj = this.a;
        i.k2.m.a aVar = i.k2.m.a.UNDECIDED;
        if (obj == aVar) {
            if (f12121c.compareAndSet(this, aVar, i.k2.m.d.b())) {
                return i.k2.m.d.b();
            }
            obj = this.a;
        }
        if (obj == i.k2.m.a.RESUMED) {
            return i.k2.m.d.b();
        }
        if (obj instanceof q0.b) {
            throw ((q0.b) obj).exception;
        }
        return obj;
    }

    @Override // i.k2.n.a.e
    @j.c.a.e
    public i.k2.n.a.e getCallerFrame() {
        d<T> dVar = this.f12123b;
        if (!(dVar instanceof i.k2.n.a.e)) {
            dVar = null;
        }
        return (i.k2.n.a.e) dVar;
    }

    @Override // i.k2.d
    @j.c.a.d
    public g getContext() {
        return this.f12123b.getContext();
    }

    @Override // i.k2.n.a.e
    @j.c.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // i.k2.d
    public void resumeWith(@j.c.a.d Object obj) {
        while (true) {
            Object obj2 = this.a;
            i.k2.m.a aVar = i.k2.m.a.UNDECIDED;
            if (obj2 == aVar) {
                if (f12121c.compareAndSet(this, aVar, obj)) {
                    return;
                }
            } else {
                if (obj2 != i.k2.m.d.b()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (f12121c.compareAndSet(this, i.k2.m.d.b(), i.k2.m.a.RESUMED)) {
                    this.f12123b.resumeWith(obj);
                    return;
                }
            }
        }
    }

    @j.c.a.d
    public String toString() {
        return "SafeContinuation for " + this.f12123b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @n0
    public k(@j.c.a.d d<? super T> dVar) {
        this(dVar, i.k2.m.a.UNDECIDED);
        i0.f(dVar, "delegate");
    }
}
