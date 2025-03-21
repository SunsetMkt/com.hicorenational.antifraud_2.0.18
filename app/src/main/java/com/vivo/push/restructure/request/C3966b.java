package com.vivo.push.restructure.request;

import com.heytap.mcssdk.constant.C2084a;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.vivo.push.restructure.request.p243a.p244a.InterfaceC3961b;
import com.vivo.push.util.C4010u;

/* compiled from: CommandRequest.java */
/* renamed from: com.vivo.push.restructure.request.b */
/* loaded from: classes2.dex */
public final class C3966b<I extends InterfaceC3961b, O extends InterfaceC3961b> {

    /* renamed from: a */
    private AbstractC3958a<I, O> f14175a;

    /* renamed from: b */
    private InterfaceC3967c<O> f14176b;

    /* renamed from: c */
    private long f14177c;

    private C3966b(AbstractC3958a<I, O> abstractC3958a) {
        this.f14177c = C2084a.f6136r;
        this.f14175a = abstractC3958a;
        if (this.f14175a == null) {
            C4010u.m13296a(JosStatusCodes.RTN_CODE_PARAMS_ERROR, "Command object is null, please construct command first");
        }
    }

    /* renamed from: a */
    public final AbstractC3958a m13151a() {
        return this.f14175a;
    }

    /* renamed from: b */
    public final InterfaceC3967c m13152b() {
        return this.f14176b;
    }

    /* renamed from: c */
    public final long m13153c() {
        return this.f14177c;
    }

    private C3966b(AbstractC3958a<I, O> abstractC3958a, InterfaceC3967c<O> interfaceC3967c) {
        this(abstractC3958a);
        this.f14176b = interfaceC3967c;
    }

    public C3966b(AbstractC3958a<I, O> abstractC3958a, InterfaceC3967c<O> interfaceC3967c, byte b2) {
        this(abstractC3958a, interfaceC3967c);
        this.f14177c = 20000L;
    }
}
