package network;

import p375l.C5884m;
import p375l.InterfaceC5873b;
import p375l.InterfaceC5875d;

/* loaded from: classes2.dex */
public abstract class RetrofitCallback<T> implements InterfaceC5875d<T> {
    public abstract void onLoading(long j2, long j3);

    @Override // p375l.InterfaceC5875d
    public void onResponse(InterfaceC5873b<T> interfaceC5873b, C5884m<T> c5884m) {
        if (c5884m.m24795e()) {
            onSuccess(interfaceC5873b, c5884m);
        } else {
            onFailure(interfaceC5873b, new Throwable(c5884m.m24796f()));
        }
    }

    public abstract void onSuccess(InterfaceC5873b<T> interfaceC5873b, C5884m<T> c5884m);
}
