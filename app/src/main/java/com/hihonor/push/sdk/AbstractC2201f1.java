package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.common.data.ApiException;

/* renamed from: com.hihonor.push.sdk.f1 */
/* loaded from: classes.dex */
public abstract class AbstractC2201f1<TResult> {

    /* renamed from: a */
    public C2219n0<TResult> f6775a;

    /* renamed from: b */
    public final String f6776b;

    /* renamed from: c */
    public final IMessageEntity f6777c;

    /* renamed from: d */
    public final C2236w f6778d;

    /* renamed from: e */
    public RequestHeader f6779e;

    public AbstractC2201f1(String str, IMessageEntity iMessageEntity) {
        this.f6776b = str;
        this.f6777c = iMessageEntity;
        this.f6778d = C2236w.m6402a(str);
    }

    /* renamed from: a */
    public abstract void mo6378a(ApiException apiException, Object obj);

    /* renamed from: b */
    public final void m6387b(ApiException apiException, Object obj) {
        if (this.f6775a != null) {
            mo6378a(apiException, obj);
            return;
        }
        String str = "This Task has been canceled, uri:" + this.f6776b;
    }
}
