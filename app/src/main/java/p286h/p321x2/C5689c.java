package p286h.p321x2;

import java.util.Iterator;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Sequences.kt */
/* renamed from: h.x2.c */
/* loaded from: classes2.dex */
public final class C5689c<T, K> implements InterfaceC5699m<T> {

    /* renamed from: a */
    private final InterfaceC5699m<T> f20563a;

    /* renamed from: b */
    private final InterfaceC5506l<T, K> f20564b;

    /* JADX WARN: Multi-variable type inference failed */
    public C5689c(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m, @InterfaceC5816d InterfaceC5506l<? super T, ? extends K> interfaceC5506l) {
        C5544i0.m22546f(interfaceC5699m, "source");
        C5544i0.m22546f(interfaceC5506l, "keySelector");
        this.f20563a = interfaceC5699m;
        this.f20564b = interfaceC5506l;
    }

    @Override // p286h.p321x2.InterfaceC5699m
    @InterfaceC5816d
    public Iterator<T> iterator() {
        return new C5687b(this.f20563a.iterator(), this.f20564b);
    }
}
