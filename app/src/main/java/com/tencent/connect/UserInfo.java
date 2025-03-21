package com.tencent.connect;

import android.content.Context;
import com.tencent.connect.auth.C3211c;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.utils.C3289g;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IUiListener;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class UserInfo extends BaseApi {
    public static final String GRAPH_OPEN_ID = "oauth2.0/m_me";

    public UserInfo(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void getOpenId(IUiListener iUiListener) {
        HttpUtils.requestAsync(this.f11013c, C3289g.m10603a(), GRAPH_OPEN_ID, m10308a(), "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public void getUserInfo(IUiListener iUiListener) {
        HttpUtils.requestAsync(this.f11013c, C3289g.m10603a(), "user/get_simple_userinfo", m10308a(), "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public UserInfo(Context context, C3211c c3211c, QQToken qQToken) {
        super(c3211c, qQToken);
    }
}
