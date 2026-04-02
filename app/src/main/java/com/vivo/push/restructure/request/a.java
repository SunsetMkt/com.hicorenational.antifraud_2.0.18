package com.vivo.push.restructure.request;

import android.content.Intent;
import android.os.Bundle;
import com.vivo.push.restructure.request.a.a.b;

/* JADX INFO: compiled from: BaseCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<I extends com.vivo.push.restructure.request.a.a.b, O extends com.vivo.push.restructure.request.a.a.b> {
    private int a = 2020;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private I f8610b;

    protected a(I i2) {
        this.f8610b = i2;
    }

    public final Intent a(int i2) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("client_pkgname", com.vivo.push.restructure.a.a().b().getPackageName());
        bundle.putBoolean("support_rf", true);
        com.vivo.push.restructure.request.a.c cVar = new com.vivo.push.restructure.request.a.c(this.a, i2);
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        cVar.a(aVar);
        bundle.putString("cf_content", aVar.d());
        com.vivo.push.restructure.request.a.a.a aVar2 = new com.vivo.push.restructure.request.a.a.a();
        this.f8610b.a(aVar2);
        bundle.putString("content", aVar2.d());
        intent.putExtras(bundle);
        return intent;
    }

    public abstract O a(com.vivo.push.restructure.request.a.a.a aVar);
}
