package p286h.p317t2;

import bean.SurveyH5Bean;
import p286h.p309q2.p311t.C5544i0;
import p286h.p320w2.InterfaceC5672m;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Delegates.kt */
/* renamed from: h.t2.b */
/* loaded from: classes2.dex */
final class C5613b<T> implements InterfaceC5616e<Object, T> {

    /* renamed from: a */
    private T f20477a;

    @Override // p286h.p317t2.InterfaceC5616e
    @InterfaceC5816d
    /* renamed from: a */
    public T mo22919a(@InterfaceC5817e Object obj, @InterfaceC5816d InterfaceC5672m<?> interfaceC5672m) {
        C5544i0.m22546f(interfaceC5672m, "property");
        T t = this.f20477a;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Property " + interfaceC5672m.getName() + " should be initialized before get.");
    }

    @Override // p286h.p317t2.InterfaceC5616e
    /* renamed from: a */
    public void mo22920a(@InterfaceC5817e Object obj, @InterfaceC5816d InterfaceC5672m<?> interfaceC5672m, @InterfaceC5816d T t) {
        C5544i0.m22546f(interfaceC5672m, "property");
        C5544i0.m22546f(t, SurveyH5Bean.VALUE);
        this.f20477a = t;
    }
}
