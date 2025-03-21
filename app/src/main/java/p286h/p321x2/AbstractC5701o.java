package p286h.p321x2;

import java.util.Collection;
import java.util.Iterator;
import p286h.C5715y1;
import p286h.InterfaceC5610t0;
import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.InterfaceC5364j;
import p286h.p294k2.p300m.C5397d;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: SequenceBuilder.kt */
@InterfaceC5610t0(version = "1.3")
@InterfaceC5364j
/* renamed from: h.x2.o */
/* loaded from: classes2.dex */
public abstract class AbstractC5701o<T> {
    @InterfaceC5817e
    /* renamed from: a */
    public final Object m23336a(@InterfaceC5816d Iterable<? extends T> iterable, @InterfaceC5816d InterfaceC5358d<? super C5715y1> interfaceC5358d) {
        Object m22117b;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return C5715y1.f20665a;
        }
        Object mo23332a = mo23332a((Iterator) iterable.iterator(), interfaceC5358d);
        m22117b = C5397d.m22117b();
        return mo23332a == m22117b ? mo23332a : C5715y1.f20665a;
    }

    @InterfaceC5817e
    /* renamed from: a */
    public abstract Object mo23331a(T t, @InterfaceC5816d InterfaceC5358d<? super C5715y1> interfaceC5358d);

    @InterfaceC5817e
    /* renamed from: a */
    public abstract Object mo23332a(@InterfaceC5816d Iterator<? extends T> it, @InterfaceC5816d InterfaceC5358d<? super C5715y1> interfaceC5358d);

    @InterfaceC5817e
    /* renamed from: a */
    public final Object m23335a(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m, @InterfaceC5816d InterfaceC5358d<? super C5715y1> interfaceC5358d) {
        Object m22117b;
        Object mo23332a = mo23332a((Iterator) interfaceC5699m.iterator(), interfaceC5358d);
        m22117b = C5397d.m22117b();
        return mo23332a == m22117b ? mo23332a : C5715y1.f20665a;
    }
}
