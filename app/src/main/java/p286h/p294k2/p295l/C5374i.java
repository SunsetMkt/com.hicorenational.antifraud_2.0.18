package p286h.p294k2.p295l;

import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import com.umeng.analytics.pro.C3397d;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5713y;
import p286h.p294k2.p295l.p296n.C5380b;
import p286h.p309q2.InterfaceC5484h;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: SafeContinuationJvm.kt */
@InterfaceC5440n0
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0001\u0018\u0000 \u0015*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u0015\u0016B\u0015\b\u0011\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004B\u001f\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0001J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m23546d2 = {"Lkotlin/coroutines/experimental/SafeContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/experimental/Continuation;", "delegate", "(Lkotlin/coroutines/experimental/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/experimental/Continuation;Ljava/lang/Object;)V", C3397d.f11892R, "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "result", "getResult", "resume", "", SurveyH5Bean.VALUE, "(Ljava/lang/Object;)V", "resumeWithException", "exception", "", "Companion", "Fail", "kotlin-stdlib-coroutines"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.k2.l.i */
/* loaded from: classes2.dex */
public final class C5374i<T> implements InterfaceC5368c<T> {

    /* renamed from: a */
    private volatile Object f20250a;

    /* renamed from: b */
    private final InterfaceC5368c<T> f20251b;

    /* renamed from: f */
    public static final a f20249f = new a(null);

    /* renamed from: c */
    private static final Object f20246c = new Object();

    /* renamed from: d */
    private static final Object f20247d = new Object();

    /* renamed from: e */
    private static final AtomicReferenceFieldUpdater<C5374i<?>, Object> f20248e = AtomicReferenceFieldUpdater.newUpdater(C5374i.class, Object.class, "a");

    /* compiled from: SafeContinuationJvm.kt */
    /* renamed from: h.k2.l.i$a */
    public static final class a {
        private a() {
        }

        @InterfaceC5484h
        /* renamed from: a */
        private static /* synthetic */ void m22054a() {
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    /* compiled from: SafeContinuationJvm.kt */
    /* renamed from: h.k2.l.i$b */
    private static final class b {

        /* renamed from: a */
        @InterfaceC5816d
        private final Throwable f20252a;

        public b(@InterfaceC5816d Throwable th) {
            C5544i0.m22546f(th, "exception");
            this.f20252a = th;
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final Throwable m22055a() {
            return this.f20252a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5374i(@InterfaceC5816d InterfaceC5368c<? super T> interfaceC5368c, @InterfaceC5817e Object obj) {
        C5544i0.m22546f(interfaceC5368c, "delegate");
        this.f20251b = interfaceC5368c;
        this.f20250a = obj;
    }

    @InterfaceC5440n0
    @InterfaceC5817e
    /* renamed from: a */
    public final Object m22053a() {
        Object m22074b;
        Object m22074b2;
        Object m22074b3;
        Object obj = this.f20250a;
        Object obj2 = f20246c;
        if (obj == obj2) {
            AtomicReferenceFieldUpdater<C5374i<?>, Object> atomicReferenceFieldUpdater = f20248e;
            m22074b2 = C5380b.m22074b();
            if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, m22074b2)) {
                m22074b3 = C5380b.m22074b();
                return m22074b3;
            }
            obj = this.f20250a;
        }
        if (obj == f20247d) {
            m22074b = C5380b.m22074b();
            return m22074b;
        }
        if (obj instanceof b) {
            throw ((b) obj).m22055a();
        }
        return obj;
    }

    @Override // p286h.p294k2.p295l.InterfaceC5368c
    @InterfaceC5816d
    public InterfaceC5370e getContext() {
        return this.f20251b.getContext();
    }

    @Override // p286h.p294k2.p295l.InterfaceC5368c
    public void resume(T t) {
        Object m22074b;
        Object m22074b2;
        while (true) {
            Object obj = this.f20250a;
            Object obj2 = f20246c;
            if (obj != obj2) {
                m22074b = C5380b.m22074b();
                if (obj != m22074b) {
                    throw new IllegalStateException("Already resumed");
                }
                AtomicReferenceFieldUpdater<C5374i<?>, Object> atomicReferenceFieldUpdater = f20248e;
                m22074b2 = C5380b.m22074b();
                if (atomicReferenceFieldUpdater.compareAndSet(this, m22074b2, f20247d)) {
                    this.f20251b.resume(t);
                    return;
                }
            } else if (f20248e.compareAndSet(this, obj2, t)) {
                return;
            }
        }
    }

    @Override // p286h.p294k2.p295l.InterfaceC5368c
    public void resumeWithException(@InterfaceC5816d Throwable th) {
        Object m22074b;
        Object m22074b2;
        C5544i0.m22546f(th, "exception");
        while (true) {
            Object obj = this.f20250a;
            Object obj2 = f20246c;
            if (obj != obj2) {
                m22074b = C5380b.m22074b();
                if (obj != m22074b) {
                    throw new IllegalStateException("Already resumed");
                }
                AtomicReferenceFieldUpdater<C5374i<?>, Object> atomicReferenceFieldUpdater = f20248e;
                m22074b2 = C5380b.m22074b();
                if (atomicReferenceFieldUpdater.compareAndSet(this, m22074b2, f20247d)) {
                    this.f20251b.resumeWithException(th);
                    return;
                }
            } else if (f20248e.compareAndSet(this, obj2, new b(th))) {
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @InterfaceC5440n0
    public C5374i(@InterfaceC5816d InterfaceC5368c<? super T> interfaceC5368c) {
        this(interfaceC5368c, f20246c);
        C5544i0.m22546f(interfaceC5368c, "delegate");
    }
}
