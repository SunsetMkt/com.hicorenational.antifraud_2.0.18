package com.taobao.accs.net;

import com.taobao.accs.data.Message;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class w implements Runnable {
    final /* synthetic */ Message a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f5842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ v f5843c;

    w(v vVar, Message message, boolean z) {
        this.f5843c = vVar;
        this.a = message;
        this.f5842b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f5843c.u) {
            this.f5843c.a(this.a);
            if (this.f5843c.u.size() == 0) {
                this.f5843c.u.add(this.a);
            } else {
                Message message = (Message) this.f5843c.u.getFirst();
                if (this.a.getType() == 1 || this.a.getType() == 0) {
                    this.f5843c.u.addLast(this.a);
                    if (message.getType() == 2) {
                        this.f5843c.u.removeFirst();
                    }
                } else if (this.a.getType() != 2 || message.getType() != 2) {
                    this.f5843c.u.addLast(this.a);
                } else if (!message.force && this.a.force) {
                    this.f5843c.u.removeFirst();
                    this.f5843c.u.addFirst(this.a);
                }
            }
            if (this.f5842b || this.f5843c.t == 3) {
                try {
                    this.f5843c.u.notifyAll();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
