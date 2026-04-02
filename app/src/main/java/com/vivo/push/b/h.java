package com.vivo.push.b;

import android.text.TextUtils;

/* JADX INFO: compiled from: MsgArriveCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends com.vivo.push.v {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8451b;

    public h() {
        super(2013);
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("MsgArriveCommand.MSG_TAG", this.a);
        if (TextUtils.isEmpty(this.f8451b)) {
            return;
        }
        dVar.a("MsgArriveCommand.NODE_INFO", this.f8451b);
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.a = dVar.a("MsgArriveCommand.MSG_TAG");
        this.f8451b = dVar.a("MsgArriveCommand.NODE_INFO");
    }

    public h(String str) {
        this();
        this.a = str;
    }

    public h(String str, String str2) {
        this(str);
        this.f8451b = str2;
    }
}
