package com.vivo.push.restructure.request;

import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.vivo.push.restructure.request.a.a.b;
import com.vivo.push.util.u;

/* JADX INFO: compiled from: CommandRequest.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<I extends com.vivo.push.restructure.request.a.a.b, O extends com.vivo.push.restructure.request.a.a.b> {
    private a<I, O> a;

    /* JADX INFO: renamed from: b */
    private c<O> f8623b;

    /* JADX INFO: renamed from: c */
    private long f8624c;

    private b(a<I, O> aVar) {
        this.f8624c = com.heytap.mcssdk.constant.a.r;
        this.a = aVar;
        if (this.a == null) {
            u.a(JosStatusCodes.RTN_CODE_PARAMS_ERROR, "Command object is null, please construct command first");
        }
    }

    public final a a() {
        return this.a;
    }

    public final c b() {
        return this.f8623b;
    }

    public final long c() {
        return this.f8624c;
    }

    private b(a<I, O> aVar, c<O> cVar) {
        this(aVar);
        this.f8623b = cVar;
    }

    public b(a<I, O> aVar, c<O> cVar, byte b2) {
        this(aVar, cVar);
        this.f8624c = 20000L;
    }
}
