package com.vivo.push.p232b;

import android.text.TextUtils;
import com.vivo.push.C3862d;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.util.C4011v;

/* compiled from: OnNotifyArrivedReceiveCommand.java */
/* renamed from: com.vivo.push.b.q */
/* loaded from: classes2.dex */
public final class C3845q extends AbstractC3850v {

    /* renamed from: a */
    protected InsideNotificationItem f13946a;

    /* renamed from: b */
    private String f13947b;

    public C3845q() {
        super(4);
    }

    @Override // com.vivo.push.p232b.AbstractC3850v, com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected final void mo12833c(C3862d c3862d) {
        super.mo12833c(c3862d);
        this.f13947b = C4011v.m13313b(this.f13946a);
        c3862d.m12917a("notification_v1", this.f13947b);
    }

    /* renamed from: d */
    public final InsideNotificationItem m12874d() {
        return this.f13946a;
    }

    /* renamed from: e */
    public final String m12875e() {
        if (!TextUtils.isEmpty(this.f13947b)) {
            return this.f13947b;
        }
        InsideNotificationItem insideNotificationItem = this.f13946a;
        if (insideNotificationItem == null) {
            return null;
        }
        return C4011v.m13313b(insideNotificationItem);
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }

    @Override // com.vivo.push.p232b.AbstractC3850v, com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected final void mo12834d(C3862d c3862d) {
        super.mo12834d(c3862d);
        this.f13947b = c3862d.m12913a("notification_v1");
        if (TextUtils.isEmpty(this.f13947b)) {
            return;
        }
        this.f13946a = C4011v.m13311a(this.f13947b);
        InsideNotificationItem insideNotificationItem = this.f13946a;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(m12882f());
        }
    }
}
