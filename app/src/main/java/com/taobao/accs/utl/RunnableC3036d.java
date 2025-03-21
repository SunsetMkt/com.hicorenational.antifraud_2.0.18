package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.vivo.push.PushClientConstants;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.d */
/* loaded from: classes2.dex */
class RunnableC3036d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f9711a;

    /* renamed from: b */
    final /* synthetic */ String f9712b;

    /* renamed from: c */
    final /* synthetic */ int f9713c;

    /* renamed from: d */
    final /* synthetic */ AccsDataListener f9714d;

    /* renamed from: e */
    final /* synthetic */ String f9715e;

    /* renamed from: f */
    final /* synthetic */ byte[] f9716f;

    /* renamed from: g */
    final /* synthetic */ TaoBaseService.ExtraInfo f9717g;

    RunnableC3036d(String str, String str2, int i2, AccsDataListener accsDataListener, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        this.f9711a = str;
        this.f9712b = str2;
        this.f9713c = i2;
        this.f9714d = accsDataListener;
        this.f9715e = str3;
        this.f9716f = bArr;
        this.f9717g = extraInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f9711a)) {
            ALog.m9182e(C3033a.TAG, "onData start", Constants.KEY_DATA_ID, this.f9712b, Constants.KEY_SERVICE_ID, this.f9711a, "command", Integer.valueOf(this.f9713c), PushClientConstants.TAG_CLASS_NAME, this.f9714d.getClass().getName());
        }
        this.f9714d.onData(this.f9711a, this.f9715e, this.f9712b, this.f9716f, this.f9717g);
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f9711a)) {
            ALog.m9182e(C3033a.TAG, "onData end", Constants.KEY_DATA_ID, this.f9712b);
        }
    }
}
