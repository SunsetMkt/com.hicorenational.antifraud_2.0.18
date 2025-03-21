package com.tencent.p208mm.opensdk.diffdev.p210a;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.p208mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.p208mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p208mm.opensdk.diffdev.OAuthListener;
import com.tencent.p208mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.a */
/* loaded from: classes2.dex */
public class C3233a implements IDiffDevOAuth {

    /* renamed from: c */
    private AsyncTaskC3234b f11058c;

    /* renamed from: a */
    private Handler f11056a = null;

    /* renamed from: b */
    private List<OAuthListener> f11057b = new ArrayList();

    /* renamed from: d */
    private OAuthListener f11059d = new a();

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.a$a */
    class a implements OAuthListener {

        /* renamed from: com.tencent.mm.opensdk.diffdev.a.a$a$a, reason: collision with other inner class name */
        class RunnableC7373a implements Runnable {
            RunnableC7373a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(C3233a.this.f11057b);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((OAuthListener) it.next()).onQrcodeScanned();
                }
            }
        }

        a() {
        }

        @Override // com.tencent.p208mm.opensdk.diffdev.OAuthListener
        public void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
            Log.m10363d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
            C3233a.this.f11058c = null;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(C3233a.this.f11057b);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OAuthListener) it.next()).onAuthFinish(oAuthErrCode, str);
            }
        }

        @Override // com.tencent.p208mm.opensdk.diffdev.OAuthListener
        public void onAuthGotQrcode(String str, byte[] bArr) {
            Log.m10363d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + str);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(C3233a.this.f11057b);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OAuthListener) it.next()).onAuthGotQrcode(str, bArr);
            }
        }

        @Override // com.tencent.p208mm.opensdk.diffdev.OAuthListener
        public void onQrcodeScanned() {
            Log.m10363d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
            if (C3233a.this.f11056a != null) {
                C3233a.this.f11056a.post(new RunnableC7373a());
            }
        }
    }

    @Override // com.tencent.p208mm.opensdk.diffdev.IDiffDevOAuth
    public void addListener(OAuthListener oAuthListener) {
        if (this.f11057b.contains(oAuthListener)) {
            return;
        }
        this.f11057b.add(oAuthListener);
    }

    @Override // com.tencent.p208mm.opensdk.diffdev.IDiffDevOAuth
    public boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        Log.m10365i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = " + str);
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            Log.m10363d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", str, str2));
            return false;
        }
        if (this.f11056a == null) {
            this.f11056a = new Handler(Looper.getMainLooper());
        }
        if (!this.f11057b.contains(oAuthListener)) {
            this.f11057b.add(oAuthListener);
        }
        if (this.f11058c != null) {
            Log.m10363d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
            return true;
        }
        AsyncTaskC3234b asyncTaskC3234b = new AsyncTaskC3234b(str, str2, str3, str4, str5, this.f11059d);
        this.f11058c = asyncTaskC3234b;
        if (Build.VERSION.SDK_INT >= 11) {
            asyncTaskC3234b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            asyncTaskC3234b.execute(new Void[0]);
        }
        return true;
    }

    @Override // com.tencent.p208mm.opensdk.diffdev.IDiffDevOAuth
    public void detach() {
        Log.m10365i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.f11057b.clear();
        stopAuth();
    }

    @Override // com.tencent.p208mm.opensdk.diffdev.IDiffDevOAuth
    public void removeAllListeners() {
        this.f11057b.clear();
    }

    @Override // com.tencent.p208mm.opensdk.diffdev.IDiffDevOAuth
    public void removeListener(OAuthListener oAuthListener) {
        this.f11057b.remove(oAuthListener);
    }

    @Override // com.tencent.p208mm.opensdk.diffdev.IDiffDevOAuth
    public boolean stopAuth() {
        boolean z;
        Log.m10365i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            z = this.f11058c == null ? true : this.f11058c.m10355a();
        } catch (Exception e2) {
            Log.m10367w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e2.getMessage());
            z = false;
        }
        this.f11058c = null;
        return z;
    }
}
