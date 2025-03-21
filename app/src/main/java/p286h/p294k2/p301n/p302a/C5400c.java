package p286h.p294k2.p301n.p302a;

import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.InterfaceC5361g;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ContinuationImpl.kt */
/* renamed from: h.k2.n.a.c */
/* loaded from: classes2.dex */
public final class C5400c implements InterfaceC5358d<Object> {

    /* renamed from: a */
    public static final C5400c f20287a = new C5400c();

    private C5400c() {
    }

    @Override // p286h.p294k2.InterfaceC5358d
    @InterfaceC5816d
    public InterfaceC5361g getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // p286h.p294k2.InterfaceC5358d
    public void resumeWith(@InterfaceC5816d Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @InterfaceC5816d
    public String toString() {
        return "This continuation is already complete";
    }
}
