package p286h.p317t2;

import p286h.p309q2.p311t.C5544i0;
import p286h.p320w2.InterfaceC5672m;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ObservableProperty.kt */
/* renamed from: h.t2.c */
/* loaded from: classes2.dex */
public abstract class AbstractC5614c<T> implements InterfaceC5616e<Object, T> {

    /* renamed from: a */
    private T f20478a;

    public AbstractC5614c(T t) {
        this.f20478a = t;
    }

    @Override // p286h.p317t2.InterfaceC5616e
    /* renamed from: a */
    public T mo22919a(@InterfaceC5817e Object obj, @InterfaceC5816d InterfaceC5672m<?> interfaceC5672m) {
        C5544i0.m22546f(interfaceC5672m, "property");
        return this.f20478a;
    }

    /* renamed from: a */
    protected void mo22917a(@InterfaceC5816d InterfaceC5672m<?> interfaceC5672m, T t, T t2) {
        C5544i0.m22546f(interfaceC5672m, "property");
    }

    /* renamed from: b */
    protected boolean mo22918b(@InterfaceC5816d InterfaceC5672m<?> interfaceC5672m, T t, T t2) {
        C5544i0.m22546f(interfaceC5672m, "property");
        return true;
    }

    @Override // p286h.p317t2.InterfaceC5616e
    /* renamed from: a */
    public void mo22920a(@InterfaceC5817e Object obj, @InterfaceC5816d InterfaceC5672m<?> interfaceC5672m, T t) {
        C5544i0.m22546f(interfaceC5672m, "property");
        T t2 = this.f20478a;
        if (mo22918b(interfaceC5672m, t2, t)) {
            this.f20478a = t;
            mo22917a(interfaceC5672m, t2, t);
        }
    }
}
