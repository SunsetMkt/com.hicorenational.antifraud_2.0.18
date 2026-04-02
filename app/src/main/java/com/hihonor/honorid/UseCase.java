package com.hihonor.honorid;

import android.os.Parcelable;
import com.hihonor.honorid.UseCase.RequestValues;

/* JADX INFO: loaded from: classes.dex */
public abstract class UseCase<Q extends RequestValues> {
    private Q a;

    public static abstract class RequestValues implements Parcelable {
    }

    public interface a {
    }

    void a() {
        a(this.a);
    }

    protected abstract void a(Q q);

    public void a(a aVar) {
    }

    public void b(Q q) {
        this.a = q;
    }
}
