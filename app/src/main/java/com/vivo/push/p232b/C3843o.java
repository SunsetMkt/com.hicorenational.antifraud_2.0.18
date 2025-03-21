package com.vivo.push.p232b;

import android.text.TextUtils;
import com.vivo.push.C3862d;
import com.vivo.push.model.UnvarnishedMessage;

/* compiled from: OnMessageReceiveCommand.java */
/* renamed from: com.vivo.push.b.o */
/* loaded from: classes2.dex */
public final class C3843o extends AbstractC3850v {

    /* renamed from: a */
    protected UnvarnishedMessage f13935a;

    public C3843o() {
        super(3);
    }

    @Override // com.vivo.push.p232b.AbstractC3850v, com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected final void mo12833c(C3862d c3862d) {
        super.mo12833c(c3862d);
        c3862d.m12917a("msg_v1", this.f13935a.unpackToJson());
    }

    @Override // com.vivo.push.p232b.AbstractC3850v, com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected final void mo12834d(C3862d c3862d) {
        super.mo12834d(c3862d);
        String m12913a = c3862d.m12913a("msg_v1");
        if (TextUtils.isEmpty(m12913a)) {
            return;
        }
        this.f13935a = new UnvarnishedMessage(m12913a);
        this.f13935a.setMsgId(m12882f());
    }

    /* renamed from: e */
    public final UnvarnishedMessage m12860e() {
        return this.f13935a;
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    public final String toString() {
        return "OnMessageCommand";
    }

    /* renamed from: d */
    public final String m12859d() {
        UnvarnishedMessage unvarnishedMessage = this.f13935a;
        if (unvarnishedMessage == null) {
            return null;
        }
        return unvarnishedMessage.unpackToJson();
    }
}
