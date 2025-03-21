package com.vivo.push.p232b;

import com.vivo.push.AbstractC4016v;
import com.vivo.push.C3862d;

/* compiled from: OnReceiveCommand.java */
/* renamed from: com.vivo.push.b.s */
/* loaded from: classes2.dex */
public class C3847s extends AbstractC4016v {

    /* renamed from: a */
    private String f13948a;

    /* renamed from: b */
    private int f13949b;

    public C3847s(int i2) {
        super(i2);
        this.f13948a = null;
        this.f13949b = 0;
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected void mo12833c(C3862d c3862d) {
        c3862d.m12917a("req_id", this.f13948a);
        c3862d.m12914a("status_msg_code", this.f13949b);
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected void mo12834d(C3862d c3862d) {
        this.f13948a = c3862d.m12913a("req_id");
        this.f13949b = c3862d.m12921b("status_msg_code", this.f13949b);
    }

    /* renamed from: h */
    public final String m12876h() {
        return this.f13948a;
    }

    /* renamed from: i */
    public final int m12877i() {
        return this.f13949b;
    }

    @Override // com.vivo.push.AbstractC4016v
    public String toString() {
        return "OnReceiveCommand";
    }
}
