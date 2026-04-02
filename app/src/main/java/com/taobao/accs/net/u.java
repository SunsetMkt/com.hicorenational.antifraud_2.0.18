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

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class u implements RequestCb {
    final /* synthetic */ IAuth.AuthCallback a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ k.a f5838b;

    u(k.a aVar, IAuth.AuthCallback authCallback) {
        this.f5838b = aVar;
        this.a = authCallback;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        if (i2 < 0) {
            ALog.e(this.f5838b.f5825c, "auth onFinish", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i2));
            this.a.onAuthFail(i2, "onFinish auth fail");
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        ALog.e(this.f5838b.f5825c, "auth", "httpStatusCode", Integer.valueOf(i2));
        if (i2 == 200) {
            this.a.onAuthSuccess();
            if (this.f5838b.f5826d instanceof k) {
                ((k) this.f5838b.f5826d).o();
            }
        } else {
            this.a.onAuthFail(i2, "auth fail");
        }
        Map<String, String> mapA = UtilityImpl.a(map);
        ALog.d(this.f5838b.f5825c, "auth", "header", mapA);
        String str = mapA.get("x-at");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5838b.f5826d.f5808k = str;
    }
}
