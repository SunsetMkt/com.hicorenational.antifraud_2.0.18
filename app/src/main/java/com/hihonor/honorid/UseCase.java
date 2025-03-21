package com.hihonor.honorid;

import android.os.Parcelable;
import com.hihonor.honorid.UseCase.RequestValues;

/* loaded from: classes.dex */
public abstract class UseCase<Q extends RequestValues> {

    /* renamed from: a */
    private Q f6487a;

    public static abstract class RequestValues implements Parcelable {
    }

    /* renamed from: com.hihonor.honorid.UseCase$a */
    public interface InterfaceC2150a {
    }

    /* renamed from: a */
    void m6089a() {
        mo6090a((UseCase<Q>) this.f6487a);
    }

    /* renamed from: a */
    protected abstract void mo6090a(Q q);

    /* renamed from: a */
    public void m6091a(InterfaceC2150a interfaceC2150a) {
    }

    /* renamed from: b */
    public void m6092b(Q q) {
        this.f6487a = q;
    }
}
