package com.taobao.accs.internal;

import androidx.annotation.Keep;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.InterfaceC2977c;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.data.Message;
import com.taobao.accs.net.AbstractC3001a;
import com.taobao.accs.net.C3011k;

/* compiled from: Taobao */
@Keep
/* renamed from: com.taobao.accs.internal.c */
/* loaded from: classes2.dex */
public class C2998c implements InterfaceC2977c {

    /* renamed from: a */
    private AbstractC3001a f9514a;

    public C2998c(String str) {
        this.f9514a = new C3011k(GlobalClientInfo.f9386a, 1, str);
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: a */
    public void mo8956a() {
        this.f9514a.mo9082a();
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: b */
    public void mo8965b() {
        this.f9514a.m9107k();
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: c */
    public String mo8967c() {
        return this.f9514a.m9105i();
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: d */
    public String mo8969d() {
        return this.f9514a.f9529i.getAppSecret();
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: e */
    public boolean mo8972e(String str) {
        return this.f9514a.m9106j().m8986c(str);
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: f */
    public boolean mo8974f(String str) {
        return this.f9514a.m9106j().m8987d(str);
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: a */
    public void mo8961a(boolean z, boolean z2) {
        this.f9514a.mo9088a(z, z2);
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: b */
    public String mo8964b(String str) {
        return this.f9514a.mo9091b(str);
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: c */
    public void mo8968c(String str) {
        this.f9514a.f9521a = str;
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: d */
    public void mo8970d(String str) {
        this.f9514a.f9522b = str;
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: e */
    public String mo8971e() {
        return this.f9514a.f9529i.getStoreId();
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: f */
    public boolean mo8973f() {
        return this.f9514a.mo9109m();
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: a */
    public boolean mo8962a(String str) {
        return this.f9514a.mo9090a(str);
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: b */
    public void mo8966b(AccsConnectStateListener accsConnectStateListener) {
        this.f9514a.m9094b(accsConnectStateListener);
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: a */
    public void mo8959a(Message message, int i2) {
        this.f9514a.m9095b(message, i2);
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: a */
    public void mo8960a(Message message, boolean z) {
        this.f9514a.m9096b(message, z);
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: a */
    public void mo8957a(AccsClientConfig accsClientConfig) {
        AbstractC3001a abstractC3001a = this.f9514a;
        if (abstractC3001a instanceof C3011k) {
            ((C3011k) abstractC3001a).m9131a(accsClientConfig);
        }
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: a */
    public boolean mo8963a(String str, String str2) {
        return this.f9514a.m9106j().m8985b(str, str2);
    }

    @Override // com.taobao.accs.InterfaceC2977c
    /* renamed from: a */
    public void mo8958a(AccsConnectStateListener accsConnectStateListener) {
        this.f9514a.m9084a(accsConnectStateListener);
    }
}
