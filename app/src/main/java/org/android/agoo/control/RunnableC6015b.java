package org.android.agoo.control;

import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* renamed from: org.android.agoo.control.b */
/* loaded from: classes2.dex */
class RunnableC6015b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ byte[] f21483a;

    /* renamed from: b */
    final /* synthetic */ String f21484b;

    /* renamed from: c */
    final /* synthetic */ TaoBaseService.ExtraInfo f21485c;

    /* renamed from: d */
    final /* synthetic */ AgooFactory f21486d;

    RunnableC6015b(AgooFactory agooFactory, byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo) {
        this.f21486d = agooFactory;
        this.f21483a = bArr;
        this.f21484b = str;
        this.f21485c = extraInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21486d.msgReceiverPreHandler(this.f21483a, this.f21484b, this.f21485c, true);
    }
}
