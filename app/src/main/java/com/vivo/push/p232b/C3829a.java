package com.vivo.push.p232b;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.vivo.push.C3862d;
import java.util.ArrayList;
import p388ui.activity.BaseProgressUploadActivity;

/* compiled from: AliasCommand.java */
/* renamed from: com.vivo.push.b.a */
/* loaded from: classes2.dex */
public final class C3829a extends C3831c {

    /* renamed from: a */
    private ArrayList<String> f13906a;

    public C3829a(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2 : 2003, str);
        this.f13906a = arrayList;
    }

    @Override // com.vivo.push.p232b.C3831c, com.vivo.push.AbstractC4016v
    /* renamed from: c */
    public final void mo12833c(C3862d c3862d) {
        super.mo12833c(c3862d);
        c3862d.m12918a(SocializeProtocolConstants.TAGS, this.f13906a);
    }

    @Override // com.vivo.push.p232b.C3831c, com.vivo.push.AbstractC4016v
    /* renamed from: d */
    public final void mo12834d(C3862d c3862d) {
        super.mo12834d(c3862d);
        this.f13906a = c3862d.m12925c(SocializeProtocolConstants.TAGS);
    }

    @Override // com.vivo.push.p232b.C3831c, com.vivo.push.AbstractC4016v
    public final String toString() {
        return "AliasCommand:" + m13325b();
    }
}
