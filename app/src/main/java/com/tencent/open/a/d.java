package com.tencent.open.a;

import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
class d implements g {
    private Response a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6805b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6808e;

    d(Response response, int i2) {
        this.a = response;
        this.f6807d = i2;
        this.f6806c = response.code();
        ResponseBody responseBodyBody = this.a.body();
        if (responseBodyBody != null) {
            this.f6808e = (int) responseBodyBody.contentLength();
        } else {
            this.f6808e = 0;
        }
    }

    @Override // com.tencent.open.a.g
    public String a() throws IOException {
        if (this.f6805b == null) {
            ResponseBody responseBodyBody = this.a.body();
            if (responseBodyBody != null) {
                this.f6805b = responseBodyBody.string();
            }
            if (this.f6805b == null) {
                this.f6805b = "";
            }
        }
        return this.f6805b;
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.f6808e;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.f6807d;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.f6806c;
    }

    public String toString() {
        return d.class.getSimpleName() + '@' + hashCode() + this.f6805b + this.f6806c + this.f6807d + this.f6808e;
    }
}
