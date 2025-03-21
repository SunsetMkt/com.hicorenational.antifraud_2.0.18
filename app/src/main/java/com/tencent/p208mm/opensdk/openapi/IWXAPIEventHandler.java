package com.tencent.p208mm.opensdk.openapi;

import com.tencent.p208mm.opensdk.modelbase.BaseReq;
import com.tencent.p208mm.opensdk.modelbase.BaseResp;

/* loaded from: classes2.dex */
public interface IWXAPIEventHandler {
    void onReq(BaseReq baseReq);

    void onResp(BaseResp baseResp);
}
