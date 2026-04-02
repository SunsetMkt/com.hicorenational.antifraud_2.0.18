package com.taobao.accs.internal;

import androidx.annotation.Keep;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.data.Message;
import com.taobao.accs.net.k;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
@Keep
public class c implements com.taobao.accs.c {
    private com.taobao.accs.net.a a;

    public c(String str) {
        this.a = new k(GlobalClientInfo.a, 1, str);
    }

    @Override // com.taobao.accs.c
    public void a() {
        this.a.a();
    }

    @Override // com.taobao.accs.c
    public void b() {
        this.a.k();
    }

    @Override // com.taobao.accs.c
    public String c() {
        return this.a.i();
    }

    @Override // com.taobao.accs.c
    public String d() {
        return this.a.f5806i.getAppSecret();
    }

    @Override // com.taobao.accs.c
    public boolean e(String str) {
        return this.a.j().c(str);
    }

    @Override // com.taobao.accs.c
    public boolean f(String str) {
        return this.a.j().d(str);
    }

    @Override // com.taobao.accs.c
    public void a(boolean z, boolean z2) {
        this.a.a(z, z2);
    }

    @Override // com.taobao.accs.c
    public String b(String str) {
        return this.a.b(str);
    }

    @Override // com.taobao.accs.c
    public void c(String str) {
        this.a.a = str;
    }

    @Override // com.taobao.accs.c
    public void d(String str) {
        this.a.f5799b = str;
    }

    @Override // com.taobao.accs.c
    public String e() {
        return this.a.f5806i.getStoreId();
    }

    @Override // com.taobao.accs.c
    public boolean f() {
        return this.a.m();
    }

    @Override // com.taobao.accs.c
    public boolean a(String str) {
        return this.a.a(str);
    }

    @Override // com.taobao.accs.c
    public void b(AccsConnectStateListener accsConnectStateListener) {
        this.a.b(accsConnectStateListener);
    }

    @Override // com.taobao.accs.c
    public void a(Message message, int i2) {
        this.a.b(message, i2);
    }

    @Override // com.taobao.accs.c
    public void a(Message message, boolean z) {
        this.a.b(message, z);
    }

    @Override // com.taobao.accs.c
    public void a(AccsClientConfig accsClientConfig) {
        com.taobao.accs.net.a aVar = this.a;
        if (aVar instanceof k) {
            ((k) aVar).a(accsClientConfig);
        }
    }

    @Override // com.taobao.accs.c
    public boolean a(String str, String str2) {
        return this.a.j().b(str, str2);
    }

    @Override // com.taobao.accs.c
    public void a(AccsConnectStateListener accsConnectStateListener) {
        this.a.a(accsConnectStateListener);
    }
}
