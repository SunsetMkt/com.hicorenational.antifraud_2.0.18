package com.tencent.connect;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.utils.C3289g;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IUiListener;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class UnionInfo extends BaseApi {
    public static final String URL_GET_UNION_ID = "https://openmobile.qq.com/oauth2.0/me";

    public UnionInfo(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void getUnionId(IUiListener iUiListener) {
        Bundle m10308a = m10308a();
        m10308a.putString("unionid", "1");
        HttpUtils.requestAsync(this.f11013c, C3289g.m10603a(), URL_GET_UNION_ID, m10308a, "GET", new BaseApi.TempRequestListener(iUiListener));
    }
}
