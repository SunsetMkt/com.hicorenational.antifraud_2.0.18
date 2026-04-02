package network;

import m.d;
import m.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RetrofitCallback<T> implements d<T> {
    public abstract void onLoading(long j2, long j3);

    @Override // m.d
    public void onResponse(m.b<T> bVar, m<T> mVar) {
        if (mVar.e()) {
            onSuccess(bVar, mVar);
        } else {
            onFailure(bVar, new Throwable(mVar.f()));
        }
    }

    public abstract void onSuccess(m.b<T> bVar, m<T> mVar);
}
