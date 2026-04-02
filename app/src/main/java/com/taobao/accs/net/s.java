package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.BaseMonitor;
import java.util.Iterator;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class s implements Runnable {
    final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f5835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f5836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ k f5837d;

    s(k kVar, int i2, boolean z, int i3) {
        this.f5837d = kVar;
        this.a = i2;
        this.f5835b = z;
        this.f5836c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message messageB;
        int i2 = this.a;
        if (i2 > 0) {
            Message.Id id = new Message.Id(i2, "");
            Message.Id id2 = null;
            Iterator<Message.Id> it = this.f5837d.f5802e.f().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Message.Id next = it.next();
                if (next.equals(id)) {
                    id2 = next;
                    break;
                }
            }
            if (id2 != null && (messageB = this.f5837d.f5802e.b(id2.getDataId())) != null) {
                if (this.f5835b) {
                    if (!this.f5837d.a(messageB, 2000)) {
                        this.f5837d.f5802e.a(messageB, this.f5836c);
                    }
                    if (messageB.getNetPermanceMonitor() != null) {
                        com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "total_tnet", 0.0d);
                    }
                } else {
                    this.f5837d.f5802e.a(messageB, this.f5836c);
                }
            }
        }
        int i3 = this.a;
        if (i3 >= 0 || !this.f5835b) {
            return;
        }
        this.f5837d.b(i3);
    }
}
