package com.tencent.p208mm.opensdk.diffdev.p210a;

import android.os.AsyncTask;
import com.tencent.p208mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p208mm.opensdk.diffdev.OAuthListener;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.c */
/* loaded from: classes2.dex */
class AsyncTaskC3235c extends AsyncTask<Void, Void, a> {

    /* renamed from: a */
    private String f11074a;

    /* renamed from: b */
    private String f11075b;

    /* renamed from: c */
    private OAuthListener f11076c;

    /* renamed from: d */
    private int f11077d;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.c$a */
    static class a {

        /* renamed from: a */
        public OAuthErrCode f11078a;

        /* renamed from: b */
        public String f11079b;

        /* renamed from: c */
        public int f11080c;

        a() {
        }
    }

    public AsyncTaskC3235c(String str, OAuthListener oAuthListener) {
        this.f11074a = str;
        this.f11076c = oAuthListener;
        this.f11075b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0168 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.tencent.p208mm.opensdk.diffdev.p210a.AsyncTaskC3235c.a doInBackground(java.lang.Void[] r14) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p208mm.opensdk.diffdev.p210a.AsyncTaskC3235c.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.f11076c.onAuthFinish(aVar2.f11078a, aVar2.f11079b);
    }
}
