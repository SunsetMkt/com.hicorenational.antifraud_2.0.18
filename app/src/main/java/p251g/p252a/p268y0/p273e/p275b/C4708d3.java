package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.Callable;
import p000a.p001a.InterfaceC0000a;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.C5158h;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableScalarXMap.java */
/* renamed from: g.a.y0.e.b.d3 */
/* loaded from: classes2.dex */
public final class C4708d3 {

    /* compiled from: FlowableScalarXMap.java */
    /* renamed from: g.a.y0.e.b.d3$a */
    static final class a<T, R> extends AbstractC4519l<R> {

        /* renamed from: b */
        final T f17831b;

        /* renamed from: c */
        final InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> f17832c;

        a(T t, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o) {
            this.f17831b = t;
            this.f17832c = interfaceC4584o;
        }

        @Override // p251g.p252a.AbstractC4519l
        /* renamed from: d */
        public void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
            try {
                InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.f17832c.apply(this.f17831b), "The mapper returned a null Publisher");
                if (!(interfaceC5821b instanceof Callable)) {
                    interfaceC5821b.subscribe(interfaceC5822c);
                    return;
                }
                try {
                    Object call = ((Callable) interfaceC5821b).call();
                    if (call == null) {
                        EnumC5157g.complete(interfaceC5822c);
                    } else {
                        interfaceC5822c.onSubscribe(new C5158h(interfaceC5822c, call));
                    }
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    EnumC5157g.error(th, interfaceC5822c);
                }
            } catch (Throwable th2) {
                EnumC5157g.error(th2, interfaceC5822c);
            }
        }
    }

    private C4708d3() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T, R> boolean m18317a(InterfaceC5821b<T> interfaceC5821b, InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o) {
        if (!(interfaceC5821b instanceof Callable)) {
            return false;
        }
        try {
            InterfaceC0000a interfaceC0000a = (Object) ((Callable) interfaceC5821b).call();
            if (interfaceC0000a == null) {
                EnumC5157g.complete(interfaceC5822c);
                return true;
            }
            try {
                InterfaceC5821b interfaceC5821b2 = (InterfaceC5821b) C4601b.m18284a(interfaceC4584o.apply(interfaceC0000a), "The mapper returned a null Publisher");
                if (interfaceC5821b2 instanceof Callable) {
                    try {
                        Object call = ((Callable) interfaceC5821b2).call();
                        if (call == null) {
                            EnumC5157g.complete(interfaceC5822c);
                            return true;
                        }
                        interfaceC5822c.onSubscribe(new C5158h(interfaceC5822c, call));
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        EnumC5157g.error(th, interfaceC5822c);
                        return true;
                    }
                } else {
                    interfaceC5821b2.subscribe(interfaceC5822c);
                }
                return true;
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                EnumC5157g.error(th2, interfaceC5822c);
                return true;
            }
        } catch (Throwable th3) {
            C4561b.m18199b(th3);
            EnumC5157g.error(th3, interfaceC5822c);
            return true;
        }
    }

    /* renamed from: a */
    public static <T, U> AbstractC4519l<U> m18316a(T t, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends U>> interfaceC4584o) {
        return C4476a.m17129a(new a(t, interfaceC4584o));
    }
}
