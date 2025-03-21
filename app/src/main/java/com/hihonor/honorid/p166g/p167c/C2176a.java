package com.hihonor.honorid.p166g.p167c;

import android.content.Context;
import com.hihonor.honorid.C2152b;
import com.hihonor.honorid.C2170e;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.p165f.C2171a;
import com.hihonor.honorid.p166g.InterfaceC2175b;
import com.hihonor.honorid.p168h.C2178a;
import com.hihonor.honorid.usecase.WriteHnAccountUseCase;
import java.util.ArrayList;
import p358k.p359a.p360a.p361a.p362i.C5857c;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* compiled from: SDKAccountManager.java */
/* renamed from: com.hihonor.honorid.g.c.a */
/* loaded from: classes.dex */
public final class C2176a implements InterfaceC2175b {

    /* renamed from: a */
    private static C2176a f6729a;

    private C2176a() {
    }

    /* renamed from: b */
    public static synchronized C2176a m6334b(Context context) {
        C2176a c2176a;
        synchronized (C2176a.class) {
            if (f6729a == null) {
                C5863e.m24690a(context);
                C2176a c2176a2 = new C2176a();
                f6729a = c2176a2;
                c2176a2.m6335c(context);
            }
            c2176a = f6729a;
        }
        return c2176a;
    }

    /* renamed from: c */
    private void m6335c(Context context) {
        C5863e.m24692b("SDKAccountManager", "init SDKAccountManager", true);
        C5857c.m24653a(context);
    }

    @Override // com.hihonor.honorid.p166g.InterfaceC2175b
    /* renamed from: a */
    public boolean mo6333a(Context context, HonorAccount honorAccount) {
        if (!C2171a.m6321a(honorAccount)) {
            C5863e.m24692b("SDKAccountManager", "the account is invalid , cannot be added into file", true);
            return false;
        }
        C2178a.m6345a(context).m6347a(honorAccount);
        ArrayList arrayList = new ArrayList();
        arrayList.add(honorAccount);
        new C2152b(C2170e.m6315a()).m6098a(new WriteHnAccountUseCase(context, arrayList, true), new WriteHnAccountUseCase.RequestValues(honorAccount.m6163c()), null);
        return true;
    }

    @Override // com.hihonor.honorid.p166g.InterfaceC2175b
    /* renamed from: a */
    public ArrayList<HonorAccount> mo6332a(Context context) {
        C5863e.m24692b("SDKAccountManager", "MemCache has no account,parse from file", true);
        ArrayList<HonorAccount> m6336a = C2177b.m6336a("accounts.xml", context, true);
        if (!m6336a.isEmpty()) {
            C2178a.m6345a(context).m6347a(m6336a.get(0));
        }
        return m6336a;
    }
}
