package com.vivo.push.p232b;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.vivo.push.C3862d;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: TagCommand.java */
/* renamed from: com.vivo.push.b.z */
/* loaded from: classes2.dex */
public final class C3854z extends C3831c {

    /* renamed from: a */
    private ArrayList<String> f13960a;

    public C3854z(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? 2004 : 2005, str);
        this.f13960a = arrayList;
    }

    @Override // com.vivo.push.p232b.C3831c, com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected final void mo12833c(C3862d c3862d) {
        super.mo12833c(c3862d);
        c3862d.m12916a(SocializeProtocolConstants.TAGS, (Serializable) this.f13960a);
    }

    @Override // com.vivo.push.p232b.C3831c, com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected final void mo12834d(C3862d c3862d) {
        super.mo12834d(c3862d);
        this.f13960a = c3862d.m12925c(SocializeProtocolConstants.TAGS);
    }

    @Override // com.vivo.push.p232b.C3831c, com.vivo.push.AbstractC4016v
    public final String toString() {
        return "TagCommand";
    }
}
