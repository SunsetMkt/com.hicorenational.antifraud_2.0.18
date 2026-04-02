package org.android.agoo.control;

import com.taobao.accs.base.TaoBaseService;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class b implements Runnable {
    final /* synthetic */ byte[] a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ String f12875b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ TaoBaseService.ExtraInfo f12876c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ AgooFactory f12877d;

    b(AgooFactory agooFactory, byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo) {
        this.f12877d = agooFactory;
        this.a = bArr;
        this.f12875b = str;
        this.f12876c = extraInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f12877d.msgReceiverPreHandler(this.a, this.f12875b, this.f12876c, true);
    }
}
