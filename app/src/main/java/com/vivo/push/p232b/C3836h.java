package com.vivo.push.p232b;

import android.text.TextUtils;
import com.vivo.push.AbstractC4016v;
import com.vivo.push.C3862d;

/* compiled from: MsgArriveCommand.java */
/* renamed from: com.vivo.push.b.h */
/* loaded from: classes2.dex */
public final class C3836h extends AbstractC4016v {

    /* renamed from: a */
    private String f13921a;

    /* renamed from: b */
    private String f13922b;

    public C3836h() {
        super(2013);
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected final void mo12833c(C3862d c3862d) {
        c3862d.m12917a("MsgArriveCommand.MSG_TAG", this.f13921a);
        if (TextUtils.isEmpty(this.f13922b)) {
            return;
        }
        c3862d.m12917a("MsgArriveCommand.NODE_INFO", this.f13922b);
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected final void mo12834d(C3862d c3862d) {
        this.f13921a = c3862d.m12913a("MsgArriveCommand.MSG_TAG");
        this.f13922b = c3862d.m12913a("MsgArriveCommand.NODE_INFO");
    }

    public C3836h(String str) {
        this();
        this.f13921a = str;
    }

    public C3836h(String str, String str2) {
        this(str);
        this.f13922b = str2;
    }
}
