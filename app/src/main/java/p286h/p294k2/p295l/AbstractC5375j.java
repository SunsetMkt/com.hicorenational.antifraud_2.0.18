package p286h.p294k2.p295l;

import java.util.Collection;
import java.util.Iterator;
import p286h.C5715y1;
import p286h.InterfaceC5610t0;
import p286h.p294k2.p295l.p296n.C5380b;
import p286h.p321x2.InterfaceC5699m;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: SequenceBuilder.kt */
@InterfaceC5373h
@InterfaceC5610t0(version = "1.1")
/* renamed from: h.k2.l.j */
/* loaded from: classes2.dex */
public abstract class AbstractC5375j<T> {
    @InterfaceC5817e
    /* renamed from: a */
    public final Object m22057a(@InterfaceC5816d Iterable<? extends T> iterable, @InterfaceC5816d InterfaceC5368c<? super C5715y1> interfaceC5368c) {
        Object m22074b;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return C5715y1.f20665a;
        }
        Object mo22059a = mo22059a((Iterator) iterable.iterator(), interfaceC5368c);
        m22074b = C5380b.m22074b();
        return mo22059a == m22074b ? mo22059a : C5715y1.f20665a;
    }

    @InterfaceC5817e
    /* renamed from: a */
    public abstract Object mo22058a(T t, @InterfaceC5816d InterfaceC5368c<? super C5715y1> interfaceC5368c);

    @InterfaceC5817e
    /* renamed from: a */
    public abstract Object mo22059a(@InterfaceC5816d Iterator<? extends T> it, @InterfaceC5816d InterfaceC5368c<? super C5715y1> interfaceC5368c);

    @InterfaceC5817e
    /* renamed from: a */
    public final Object m22056a(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m, @InterfaceC5816d InterfaceC5368c<? super C5715y1> interfaceC5368c) {
        Object m22074b;
        Object mo22059a = mo22059a((Iterator) interfaceC5699m.iterator(), interfaceC5368c);
        m22074b = C5380b.m22074b();
        return mo22059a == m22074b ? mo22059a : C5715y1.f20665a;
    }
}
