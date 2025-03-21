package com.taobao.accs.net;

import com.taobao.accs.data.Message;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.w */
/* loaded from: classes2.dex */
class RunnableC3023w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Message f9624a;

    /* renamed from: b */
    final /* synthetic */ boolean f9625b;

    /* renamed from: c */
    final /* synthetic */ C3022v f9626c;

    RunnableC3023w(C3022v c3022v, Message message, boolean z) {
        this.f9626c = c3022v;
        this.f9624a = message;
        this.f9625b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f9626c.f9614u) {
            this.f9626c.m9138a(this.f9624a);
            if (this.f9626c.f9614u.size() == 0) {
                this.f9626c.f9614u.add(this.f9624a);
            } else {
                Message message = (Message) this.f9626c.f9614u.getFirst();
                if (this.f9624a.getType() != 1 && this.f9624a.getType() != 0) {
                    if (this.f9624a.getType() != 2 || message.getType() != 2) {
                        this.f9626c.f9614u.addLast(this.f9624a);
                    } else if (!message.force && this.f9624a.force) {
                        this.f9626c.f9614u.removeFirst();
                        this.f9626c.f9614u.addFirst(this.f9624a);
                    }
                }
                this.f9626c.f9614u.addLast(this.f9624a);
                if (message.getType() == 2) {
                    this.f9626c.f9614u.removeFirst();
                }
            }
            if (this.f9625b || this.f9626c.f9613t == 3) {
                try {
                    this.f9626c.f9614u.notifyAll();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
