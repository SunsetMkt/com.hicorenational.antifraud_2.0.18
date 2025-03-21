package com.vivo.push.sdk;

import android.content.Intent;
import android.os.Message;
import com.vivo.push.AbstractC3827ab;
import com.vivo.push.restructure.p239a.C3949b;
import com.vivo.push.util.C3996g;
import com.vivo.push.util.C4010u;

/* compiled from: CommandWorker.java */
/* renamed from: com.vivo.push.sdk.a */
/* loaded from: classes2.dex */
public final class C3973a extends AbstractC3827ab {

    /* renamed from: c */
    private static C3973a f14194c;

    /* renamed from: d */
    private String f14195d = "";

    private C3973a() {
    }

    /* renamed from: b */
    public final String m13166b() {
        return this.f14195d;
    }

    /* renamed from: a */
    public static synchronized C3973a m13163a() {
        C3973a c3973a;
        synchronized (C3973a.class) {
            if (f14194c == null) {
                f14194c = new C3973a();
            }
            c3973a = f14194c;
        }
        return c3973a;
    }

    @Override // com.vivo.push.AbstractC3827ab
    /* renamed from: b */
    public final void mo12832b(Message message) {
        Intent intent = (Intent) message.obj;
        if (intent == null || this.f13900a == null) {
            C4010u.m13309d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.f13900a);
            return;
        }
        C3949b c3949b = new C3949b(intent);
        try {
            C4010u.m13309d("CommandWorker", "received msg : ".concat(String.valueOf(c3949b.mo13078a())));
            C3996g.m13250a().execute(new RunnableC3974b(this, c3949b));
        } catch (Exception e2) {
            C4010u.m13292a("CommandWorker", "handle message err : " + e2.getMessage());
        }
    }

    /* renamed from: a */
    public final void m13165a(String str) {
        this.f14195d = str;
    }

    /* renamed from: a */
    public final void m13164a(Intent intent) {
        if (intent != null && this.f13900a != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            m12831a(obtain);
        } else {
            C4010u.m13309d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.f13900a);
        }
    }
}
