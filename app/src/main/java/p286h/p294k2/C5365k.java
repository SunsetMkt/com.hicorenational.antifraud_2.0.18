package p286h.p294k2;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.C3397d;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p286h.C5475q0;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p294k2.p300m.C5397d;
import p286h.p294k2.p300m.EnumC5394a;
import p286h.p294k2.p301n.p302a.InterfaceC5402e;
import p286h.p309q2.InterfaceC5484h;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: SafeContinuationJvm.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001a*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u001aB\u0015\b\u0011\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0001J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001e\u0010\u0014\u001a\u00020\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, m23546d2 = {"Lkotlin/coroutines/SafeContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", C3397d.f11892R, "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5610t0(version = "1.3")
@InterfaceC5440n0
/* renamed from: h.k2.k */
/* loaded from: classes2.dex */
public final class C5365k<T> implements InterfaceC5358d<T>, InterfaceC5402e {

    /* renamed from: a */
    private volatile Object f20238a;

    /* renamed from: b */
    private final InterfaceC5358d<T> f20239b;

    /* renamed from: d */
    @Deprecated
    public static final a f20237d = new a(null);

    /* renamed from: c */
    private static final AtomicReferenceFieldUpdater<C5365k<?>, Object> f20236c = AtomicReferenceFieldUpdater.newUpdater(C5365k.class, Object.class, "a");

    /* compiled from: SafeContinuationJvm.kt */
    /* renamed from: h.k2.k$a */
    private static final class a {
        private a() {
        }

        @InterfaceC5484h
        /* renamed from: a */
        private static /* synthetic */ void m22025a() {
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5365k(@InterfaceC5816d InterfaceC5358d<? super T> interfaceC5358d, @InterfaceC5817e Object obj) {
        C5544i0.m22546f(interfaceC5358d, "delegate");
        this.f20239b = interfaceC5358d;
        this.f20238a = obj;
    }

    @InterfaceC5440n0
    @InterfaceC5817e
    /* renamed from: a */
    public final Object m22024a() {
        Object m22117b;
        Object m22117b2;
        Object m22117b3;
        Object obj = this.f20238a;
        EnumC5394a enumC5394a = EnumC5394a.UNDECIDED;
        if (obj == enumC5394a) {
            AtomicReferenceFieldUpdater<C5365k<?>, Object> atomicReferenceFieldUpdater = f20236c;
            m22117b2 = C5397d.m22117b();
            if (atomicReferenceFieldUpdater.compareAndSet(this, enumC5394a, m22117b2)) {
                m22117b3 = C5397d.m22117b();
                return m22117b3;
            }
            obj = this.f20238a;
        }
        if (obj == EnumC5394a.RESUMED) {
            m22117b = C5397d.m22117b();
            return m22117b;
        }
        if (obj instanceof C5475q0.b) {
            throw ((C5475q0.b) obj).exception;
        }
        return obj;
    }

    @Override // p286h.p294k2.p301n.p302a.InterfaceC5402e
    @InterfaceC5817e
    public InterfaceC5402e getCallerFrame() {
        InterfaceC5358d<T> interfaceC5358d = this.f20239b;
        if (!(interfaceC5358d instanceof InterfaceC5402e)) {
            interfaceC5358d = null;
        }
        return (InterfaceC5402e) interfaceC5358d;
    }

    @Override // p286h.p294k2.InterfaceC5358d
    @InterfaceC5816d
    public InterfaceC5361g getContext() {
        return this.f20239b.getContext();
    }

    @Override // p286h.p294k2.p301n.p302a.InterfaceC5402e
    @InterfaceC5817e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // p286h.p294k2.InterfaceC5358d
    public void resumeWith(@InterfaceC5816d Object obj) {
        Object m22117b;
        Object m22117b2;
        while (true) {
            Object obj2 = this.f20238a;
            EnumC5394a enumC5394a = EnumC5394a.UNDECIDED;
            if (obj2 != enumC5394a) {
                m22117b = C5397d.m22117b();
                if (obj2 != m22117b) {
                    throw new IllegalStateException("Already resumed");
                }
                AtomicReferenceFieldUpdater<C5365k<?>, Object> atomicReferenceFieldUpdater = f20236c;
                m22117b2 = C5397d.m22117b();
                if (atomicReferenceFieldUpdater.compareAndSet(this, m22117b2, EnumC5394a.RESUMED)) {
                    this.f20239b.resumeWith(obj);
                    return;
                }
            } else if (f20236c.compareAndSet(this, enumC5394a, obj)) {
                return;
            }
        }
    }

    @InterfaceC5816d
    public String toString() {
        return "SafeContinuation for " + this.f20239b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @InterfaceC5440n0
    public C5365k(@InterfaceC5816d InterfaceC5358d<? super T> interfaceC5358d) {
        this(interfaceC5358d, EnumC5394a.UNDECIDED);
        C5544i0.m22546f(interfaceC5358d, "delegate");
    }
}
