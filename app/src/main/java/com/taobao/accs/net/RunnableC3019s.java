package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C3043k;
import java.util.Iterator;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.s */
/* loaded from: classes2.dex */
class RunnableC3019s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f9586a;

    /* renamed from: b */
    final /* synthetic */ boolean f9587b;

    /* renamed from: c */
    final /* synthetic */ int f9588c;

    /* renamed from: d */
    final /* synthetic */ C3011k f9589d;

    RunnableC3019s(C3011k c3011k, int i2, boolean z, int i3) {
        this.f9589d = c3011k;
        this.f9586a = i2;
        this.f9587b = z;
        this.f9588c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message m9032b;
        int i2 = this.f9586a;
        if (i2 > 0) {
            Message.C2982Id c2982Id = new Message.C2982Id(i2, "");
            Message.C2982Id c2982Id2 = null;
            Iterator<Message.C2982Id> it = this.f9589d.f9525e.m9038f().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Message.C2982Id next = it.next();
                if (next.equals(c2982Id)) {
                    c2982Id2 = next;
                    break;
                }
            }
            if (c2982Id2 != null && (m9032b = this.f9589d.f9525e.m9032b(c2982Id2.getDataId())) != null) {
                if (this.f9587b) {
                    if (!this.f9589d.m9089a(m9032b, 2000)) {
                        this.f9589d.f9525e.m9026a(m9032b, this.f9588c);
                    }
                    if (m9032b.getNetPermanceMonitor() != null) {
                        C3043k.m9250a("accs", BaseMonitor.COUNT_POINT_RESEND, "total_tnet", 0.0d);
                    }
                } else {
                    this.f9589d.f9525e.m9026a(m9032b, this.f9588c);
                }
            }
        }
        int i3 = this.f9586a;
        if (i3 >= 0 || !this.f9587b) {
            return;
        }
        this.f9589d.m9093b(i3);
    }
}
