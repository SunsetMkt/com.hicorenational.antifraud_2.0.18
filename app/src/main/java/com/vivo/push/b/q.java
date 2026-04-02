package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* JADX INFO: compiled from: OnNotifyArrivedReceiveCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends v {
    protected InsideNotificationItem a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8468b;

    public q() {
        super(4);
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        this.f8468b = com.vivo.push.util.v.b(this.a);
        dVar.a("notification_v1", this.f8468b);
    }

    public final InsideNotificationItem d() {
        return this.a;
    }

    public final String e() {
        if (!TextUtils.isEmpty(this.f8468b)) {
            return this.f8468b;
        }
        InsideNotificationItem insideNotificationItem = this.a;
        if (insideNotificationItem == null) {
            return null;
        }
        return com.vivo.push.util.v.b(insideNotificationItem);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f8468b = dVar.a("notification_v1");
        if (TextUtils.isEmpty(this.f8468b)) {
            return;
        }
        this.a = com.vivo.push.util.v.a(this.f8468b);
        InsideNotificationItem insideNotificationItem = this.a;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(f());
        }
    }
}
