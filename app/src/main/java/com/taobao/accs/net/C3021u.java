package com.taobao.accs.net;

import android.text.TextUtils;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.net.C3011k;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.u */
/* loaded from: classes2.dex */
class C3021u implements RequestCb {

    /* renamed from: a */
    final /* synthetic */ IAuth.AuthCallback f9591a;

    /* renamed from: b */
    final /* synthetic */ C3011k.a f9592b;

    C3021u(C3011k.a aVar, IAuth.AuthCallback authCallback) {
        this.f9592b = aVar;
        this.f9591a = authCallback;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        String str2;
        if (i2 < 0) {
            str2 = this.f9592b.f9569c;
            ALog.m9182e(str2, "auth onFinish", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i2));
            this.f9591a.onAuthFail(i2, "onFinish auth fail");
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        String str;
        String str2;
        AbstractC3001a abstractC3001a;
        AbstractC3001a abstractC3001a2;
        AbstractC3001a abstractC3001a3;
        str = this.f9592b.f9569c;
        ALog.m9182e(str, "auth", "httpStatusCode", Integer.valueOf(i2));
        if (i2 == 200) {
            this.f9591a.onAuthSuccess();
            abstractC3001a2 = this.f9592b.f9570d;
            if (abstractC3001a2 instanceof C3011k) {
                abstractC3001a3 = this.f9592b.f9570d;
                ((C3011k) abstractC3001a3).m9129o();
            }
        } else {
            this.f9591a.onAuthFail(i2, "auth fail");
        }
        Map<String, String> m9200a = UtilityImpl.m9200a(map);
        str2 = this.f9592b.f9569c;
        ALog.m9180d(str2, "auth", "header", m9200a);
        String str3 = m9200a.get("x-at");
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        abstractC3001a = this.f9592b.f9570d;
        abstractC3001a.f9531k = str3;
    }
}
