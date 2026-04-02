package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.common.data.ApiException;

/* JADX INFO: loaded from: classes.dex */
public abstract class f1<TResult> {
    public n0<TResult> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IMessageEntity f4252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f4253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RequestHeader f4254e;

    public f1(String str, IMessageEntity iMessageEntity) {
        this.f4251b = str;
        this.f4252c = iMessageEntity;
        this.f4253d = w.a(str);
    }

    public abstract void a(ApiException apiException, Object obj);

    public final void b(ApiException apiException, Object obj) {
        if (this.a != null) {
            a(apiException, obj);
            return;
        }
        String str = "This Task has been canceled, uri:" + this.f4251b;
    }
}
