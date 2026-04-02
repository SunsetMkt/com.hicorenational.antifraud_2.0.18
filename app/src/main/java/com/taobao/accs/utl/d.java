package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.vivo.push.PushClientConstants;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class d implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f5905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f5906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f5907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f5908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ byte[] f5909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ TaoBaseService.ExtraInfo f5910g;

    d(String str, String str2, int i2, AccsDataListener accsDataListener, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        this.a = str;
        this.f5905b = str2;
        this.f5906c = i2;
        this.f5907d = accsDataListener;
        this.f5908e = str3;
        this.f5909f = bArr;
        this.f5910g = extraInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.a)) {
            ALog.e(a.TAG, "onData start", Constants.KEY_DATA_ID, this.f5905b, Constants.KEY_SERVICE_ID, this.a, "command", Integer.valueOf(this.f5906c), PushClientConstants.TAG_CLASS_NAME, this.f5907d.getClass().getName());
        }
        this.f5907d.onData(this.a, this.f5908e, this.f5905b, this.f5909f, this.f5910g);
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.a)) {
            ALog.e(a.TAG, "onData end", Constants.KEY_DATA_ID, this.f5905b);
        }
    }
}
