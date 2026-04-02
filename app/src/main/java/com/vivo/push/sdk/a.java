package com.vivo.push.sdk;

import android.content.Intent;
import android.os.Message;
import com.vivo.push.ab;
import com.vivo.push.util.g;
import com.vivo.push.util.u;

/* JADX INFO: compiled from: CommandWorker.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends ab {

    /* JADX INFO: renamed from: c */
    private static a f8634c;

    /* JADX INFO: renamed from: d */
    private String f8635d = "";

    private a() {
    }

    public final String b() {
        return this.f8635d;
    }

    public static synchronized a a() {
        if (f8634c == null) {
            f8634c = new a();
        }
        return f8634c;
    }

    @Override // com.vivo.push.ab
    public final void b(Message message) {
        Intent intent = (Intent) message.obj;
        if (intent == null || this.a == null) {
            u.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.a);
            return;
        }
        com.vivo.push.restructure.a.b bVar = new com.vivo.push.restructure.a.b(intent);
        try {
            u.d("CommandWorker", "received msg : ".concat(String.valueOf(bVar.a())));
            g.a().execute(new b(this, bVar));
        } catch (Exception e2) {
            u.a("CommandWorker", "handle message err : " + e2.getMessage());
        }
    }

    public final void a(String str) {
        this.f8635d = str;
    }

    public final void a(Intent intent) {
        if (intent != null && this.a != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            a(messageObtain);
        } else {
            u.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.a);
        }
    }
}
