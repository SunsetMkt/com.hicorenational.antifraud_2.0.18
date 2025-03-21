package p286h.p294k2;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.C3397d;
import p286h.C5226e1;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: CoroutineContext.kt */
@InterfaceC5610t0(version = "1.3")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH¦\u0002¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH&J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002¨\u0006\u0013"}, m23546d2 = {"Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", C3397d.f11892R, "Element", "Key", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.k2.g */
/* loaded from: classes2.dex */
public interface InterfaceC5361g {

    /* compiled from: CoroutineContext.kt */
    /* renamed from: h.k2.g$a */
    public static final class a {

        /* compiled from: CoroutineContext.kt */
        /* renamed from: h.k2.g$a$a, reason: collision with other inner class name */
        static final class C7429a extends AbstractC5547j0 implements InterfaceC5510p<InterfaceC5361g, b, InterfaceC5361g> {
            public static final C7429a INSTANCE = new C7429a();

            C7429a() {
                super(2);
            }

            @Override // p286h.p309q2.p310s.InterfaceC5510p
            @InterfaceC5816d
            public final InterfaceC5361g invoke(@InterfaceC5816d InterfaceC5361g interfaceC5361g, @InterfaceC5816d b bVar) {
                C5544i0.m22546f(interfaceC5361g, "acc");
                C5544i0.m22546f(bVar, "element");
                InterfaceC5361g minusKey = interfaceC5361g.minusKey(bVar.getKey());
                if (minusKey == C5363i.INSTANCE) {
                    return bVar;
                }
                InterfaceC5359e interfaceC5359e = (InterfaceC5359e) minusKey.get(InterfaceC5359e.f20232V);
                if (interfaceC5359e == null) {
                    return new C5357c(minusKey, bVar);
                }
                InterfaceC5361g minusKey2 = minusKey.minusKey(InterfaceC5359e.f20232V);
                return minusKey2 == C5363i.INSTANCE ? new C5357c(bVar, interfaceC5359e) : new C5357c(new C5357c(minusKey2, bVar), interfaceC5359e);
            }
        }

        @InterfaceC5816d
        /* renamed from: a */
        public static InterfaceC5361g m22017a(InterfaceC5361g interfaceC5361g, @InterfaceC5816d InterfaceC5361g interfaceC5361g2) {
            C5544i0.m22546f(interfaceC5361g2, C3397d.f11892R);
            return interfaceC5361g2 == C5363i.INSTANCE ? interfaceC5361g : (InterfaceC5361g) interfaceC5361g2.fold(interfaceC5361g, C7429a.INSTANCE);
        }
    }

    /* compiled from: CoroutineContext.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J5\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, m23546d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", ExifInterface.LONGITUDE_EAST, "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
    /* renamed from: h.k2.g$b */
    public interface b extends InterfaceC5361g {

        /* compiled from: CoroutineContext.kt */
        /* renamed from: h.k2.g$b$a */
        public static final class a {
            /* JADX WARN: Multi-variable type inference failed */
            @InterfaceC5817e
            /* renamed from: a */
            public static <E extends b> E m22018a(b bVar, @InterfaceC5816d c<E> cVar) {
                C5544i0.m22546f(cVar, "key");
                if (!C5544i0.m22531a(bVar.getKey(), cVar)) {
                    return null;
                }
                if (bVar != 0) {
                    return bVar;
                }
                throw new C5226e1("null cannot be cast to non-null type E");
            }

            @InterfaceC5816d
            /* renamed from: a */
            public static InterfaceC5361g m22019a(b bVar, @InterfaceC5816d InterfaceC5361g interfaceC5361g) {
                C5544i0.m22546f(interfaceC5361g, C3397d.f11892R);
                return a.m22017a(bVar, interfaceC5361g);
            }

            @InterfaceC5816d
            /* renamed from: b */
            public static InterfaceC5361g m22021b(b bVar, @InterfaceC5816d c<?> cVar) {
                C5544i0.m22546f(cVar, "key");
                return C5544i0.m22531a(bVar.getKey(), cVar) ? C5363i.INSTANCE : bVar;
            }

            /* renamed from: a */
            public static <R> R m22020a(b bVar, R r, @InterfaceC5816d InterfaceC5510p<? super R, ? super b, ? extends R> interfaceC5510p) {
                C5544i0.m22546f(interfaceC5510p, "operation");
                return interfaceC5510p.invoke(r, bVar);
            }
        }

        @Override // p286h.p294k2.InterfaceC5361g
        <R> R fold(R r, @InterfaceC5816d InterfaceC5510p<? super R, ? super b, ? extends R> interfaceC5510p);

        @Override // p286h.p294k2.InterfaceC5361g
        @InterfaceC5817e
        <E extends b> E get(@InterfaceC5816d c<E> cVar);

        @InterfaceC5816d
        c<?> getKey();

        @Override // p286h.p294k2.InterfaceC5361g
        @InterfaceC5816d
        InterfaceC5361g minusKey(@InterfaceC5816d c<?> cVar);
    }

    /* compiled from: CoroutineContext.kt */
    /* renamed from: h.k2.g$c */
    public interface c<E extends b> {
    }

    <R> R fold(R r, @InterfaceC5816d InterfaceC5510p<? super R, ? super b, ? extends R> interfaceC5510p);

    @InterfaceC5817e
    <E extends b> E get(@InterfaceC5816d c<E> cVar);

    @InterfaceC5816d
    InterfaceC5361g minusKey(@InterfaceC5816d c<?> cVar);

    @InterfaceC5816d
    InterfaceC5361g plus(@InterfaceC5816d InterfaceC5361g interfaceC5361g);
}
