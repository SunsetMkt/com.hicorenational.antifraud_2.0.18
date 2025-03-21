package p286h.p294k2.p295l;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.analytics.pro.C3397d;
import p286h.C5226e1;
import p286h.InterfaceC5713y;
import p286h.p294k2.p295l.InterfaceC5370e;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: CoroutineContextImpl.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0000H\u0002J\u0013\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J5\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u0002H\u00122\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00120\u0015H\u0016¢\u0006\u0002\u0010\u0016J(\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001aH\u0096\u0002¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0014\u0010\u001e\u001a\u00020\u00012\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020!H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\""}, m23546d2 = {"Lkotlin/coroutines/experimental/CombinedContext;", "Lkotlin/coroutines/experimental/CoroutineContext;", "left", "element", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/coroutines/experimental/CoroutineContext$Element;)V", "getElement", "()Lkotlin/coroutines/experimental/CoroutineContext$Element;", "getLeft", "()Lkotlin/coroutines/experimental/CoroutineContext;", "contains", "", "containsAll", C3397d.f11892R, "equals", DispatchConstants.OTHER, "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)Lkotlin/coroutines/experimental/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "kotlin-stdlib-coroutines"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.k2.l.b */
/* loaded from: classes2.dex */
public final class C5367b implements InterfaceC5370e {

    /* renamed from: b */
    @InterfaceC5816d
    private final InterfaceC5370e f20241b;

    /* renamed from: c */
    @InterfaceC5816d
    private final InterfaceC5370e.b f20242c;

    /* compiled from: CoroutineContextImpl.kt */
    /* renamed from: h.k2.l.b$a */
    static final class a extends AbstractC5547j0 implements InterfaceC5510p<String, InterfaceC5370e.b, String> {
        public static final a INSTANCE = new a();

        a() {
            super(2);
        }

        @Override // p286h.p309q2.p310s.InterfaceC5510p
        @InterfaceC5816d
        public final String invoke(@InterfaceC5816d String str, @InterfaceC5816d InterfaceC5370e.b bVar) {
            C5544i0.m22546f(str, "acc");
            C5544i0.m22546f(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public C5367b(@InterfaceC5816d InterfaceC5370e interfaceC5370e, @InterfaceC5816d InterfaceC5370e.b bVar) {
        C5544i0.m22546f(interfaceC5370e, "left");
        C5544i0.m22546f(bVar, "element");
        this.f20241b = interfaceC5370e;
        this.f20242c = bVar;
    }

    /* renamed from: c */
    private final int m22031c() {
        InterfaceC5370e interfaceC5370e = this.f20241b;
        if (interfaceC5370e instanceof C5367b) {
            return ((C5367b) interfaceC5370e).m22031c() + 1;
        }
        return 2;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final InterfaceC5370e.b m22032a() {
        return this.f20242c;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public final InterfaceC5370e m22033b() {
        return this.f20241b;
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (this != obj) {
            if (obj instanceof C5367b) {
                C5367b c5367b = (C5367b) obj;
                if (c5367b.m22031c() != m22031c() || !c5367b.m22029a(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e
    public <R> R fold(R r, @InterfaceC5816d InterfaceC5510p<? super R, ? super InterfaceC5370e.b, ? extends R> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5510p, "operation");
        return interfaceC5510p.invoke((Object) this.f20241b.fold(r, interfaceC5510p), this.f20242c);
    }

    public int hashCode() {
        return this.f20241b.hashCode() + this.f20242c.hashCode();
    }

    @InterfaceC5816d
    public String toString() {
        return "[" + ((String) fold("", a.INSTANCE)) + "]";
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e
    @InterfaceC5816d
    /* renamed from: a */
    public InterfaceC5370e mo22027a(@InterfaceC5816d InterfaceC5370e interfaceC5370e) {
        C5544i0.m22546f(interfaceC5370e, C3397d.f11892R);
        return InterfaceC5370e.a.m22039a(this, interfaceC5370e);
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e
    @InterfaceC5816d
    /* renamed from: b */
    public InterfaceC5370e mo22028b(@InterfaceC5816d InterfaceC5370e.c<?> cVar) {
        C5544i0.m22546f(cVar, "key");
        if (this.f20242c.mo22026a(cVar) != null) {
            return this.f20241b;
        }
        InterfaceC5370e mo22028b = this.f20241b.mo22028b(cVar);
        return mo22028b == this.f20241b ? this : mo22028b == C5372g.f20245b ? this.f20242c : new C5367b(mo22028b, this.f20242c);
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e
    @InterfaceC5817e
    /* renamed from: a */
    public <E extends InterfaceC5370e.b> E mo22026a(@InterfaceC5816d InterfaceC5370e.c<E> cVar) {
        C5544i0.m22546f(cVar, "key");
        C5367b c5367b = this;
        while (true) {
            E e2 = (E) c5367b.f20242c.mo22026a(cVar);
            if (e2 != null) {
                return e2;
            }
            InterfaceC5370e interfaceC5370e = c5367b.f20241b;
            if (interfaceC5370e instanceof C5367b) {
                c5367b = (C5367b) interfaceC5370e;
            } else {
                return (E) interfaceC5370e.mo22026a(cVar);
            }
        }
    }

    /* renamed from: a */
    private final boolean m22030a(InterfaceC5370e.b bVar) {
        return C5544i0.m22531a(mo22026a(bVar.getKey()), bVar);
    }

    /* renamed from: a */
    private final boolean m22029a(C5367b c5367b) {
        while (m22030a(c5367b.f20242c)) {
            InterfaceC5370e interfaceC5370e = c5367b.f20241b;
            if (!(interfaceC5370e instanceof C5367b)) {
                if (interfaceC5370e != null) {
                    return m22030a((InterfaceC5370e.b) interfaceC5370e);
                }
                throw new C5226e1("null cannot be cast to non-null type kotlin.coroutines.experimental.CoroutineContext.Element");
            }
            c5367b = (C5367b) interfaceC5370e;
        }
        return false;
    }
}
