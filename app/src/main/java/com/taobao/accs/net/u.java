package com.taobao.accs.net;

import android.text.TextUtils;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.net.k;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class u implements RequestCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IAuth.AuthCallback f8557a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ k.a f8558b;

    u(k.a aVar, IAuth.AuthCallback authCallback) {
        this.f8558b = aVar;
        this.f8557a = authCallback;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        String str2;
        if (i2 < 0) {
            str2 = this.f8558b.f8535c;
            ALog.e(str2, "auth onFinish", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i2));
            this.f8557a.onAuthFail(i2, "onFinish auth fail");
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        String str;
        String str2;
        a aVar;
        a aVar2;
        a aVar3;
        str = this.f8558b.f8535c;
        ALog.e(str, "auth", "httpStatusCode", Integer.valueOf(i2));
        if (i2 == 200) {
            this.f8557a.onAuthSuccess();
            aVar2 = this.f8558b.f8536d;
            if (aVar2 instanceof k) {
                aVar3 = this.f8558b.f8536d;
                ((k) aVar3).o();
            }
        } else {
            this.f8557a.onAuthFail(i2, "auth fail");
        }
        Map<String, String> a2 = UtilityImpl.a(map);
        str2 = this.f8558b.f8535c;
        ALog.d(str2, "auth", "header", a2);
        String str3 = a2.get("x-at");
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        aVar = this.f8558b.f8536d;
        aVar.f8510k = str3;
    }
}
