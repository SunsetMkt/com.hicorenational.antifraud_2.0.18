package p286h;

import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: LazyJVM.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000 \u0013*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004:\u0001\u0013B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, m23546d2 = {"Lkotlin/SafePublicationLazyImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", SurveyH5Bean.VALUE, "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.s0 */
/* loaded from: classes2.dex */
final class C5605s0<T> implements InterfaceC5604s<T>, Serializable {
    public static final a Companion = new a(null);

    /* renamed from: a */
    private static final AtomicReferenceFieldUpdater<C5605s0<?>, Object> f20464a = AtomicReferenceFieldUpdater.newUpdater(C5605s0.class, Object.class, "_value");
    private volatile Object _value;

    /* renamed from: final, reason: not valid java name */
    private final Object f25887final;
    private volatile InterfaceC5495a<? extends T> initializer;

    /* compiled from: LazyJVM.kt */
    /* renamed from: h.s0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    public C5605s0(@InterfaceC5816d InterfaceC5495a<? extends T> interfaceC5495a) {
        C5544i0.m22546f(interfaceC5495a, "initializer");
        this.initializer = interfaceC5495a;
        C5598r1 c5598r1 = C5598r1.f20454a;
        this._value = c5598r1;
        this.f25887final = c5598r1;
    }

    private final Object writeReplace() {
        return new C5466o(getValue());
    }

    @Override // p286h.InterfaceC5604s
    public T getValue() {
        T t = (T) this._value;
        if (t != C5598r1.f20454a) {
            return t;
        }
        InterfaceC5495a<? extends T> interfaceC5495a = this.initializer;
        if (interfaceC5495a != null) {
            T invoke = interfaceC5495a.invoke();
            if (f20464a.compareAndSet(this, C5598r1.f20454a, invoke)) {
                this.initializer = null;
                return invoke;
            }
        }
        return (T) this._value;
    }

    @Override // p286h.InterfaceC5604s
    public boolean isInitialized() {
        return this._value != C5598r1.f20454a;
    }

    @InterfaceC5816d
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
