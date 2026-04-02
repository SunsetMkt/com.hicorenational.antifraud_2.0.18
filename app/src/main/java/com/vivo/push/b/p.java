package com.vivo.push.b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* JADX INFO: compiled from: OnNotificationClickReceiveCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p extends com.vivo.push.v {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f8460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InsideNotificationItem f8462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f8464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Uri f8465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f8466i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Bundle f8467j;

    public p(String str, long j2, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.a = str;
        this.f8461d = j2;
        this.f8462e = insideNotificationItem;
    }

    public final void a(Uri uri) {
        this.f8465h = uri;
    }

    public final void b(String str) {
        this.f8463f = str;
    }

    public final void c(String str) {
        this.f8464g = str;
    }

    public final String d() {
        return this.a;
    }

    public final long e() {
        return this.f8461d;
    }

    public final InsideNotificationItem f() {
        return this.f8462e;
    }

    public final String g() {
        return this.f8463f;
    }

    public final String h() {
        return this.f8464g;
    }

    public final String i() {
        return this.f8466i;
    }

    public final Uri j() {
        return this.f8465h;
    }

    public final Bundle k() {
        Bundle bundle = this.f8467j;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        try {
            bundle2.remove("command_type");
            bundle2.remove("security_avoid_pull");
            bundle2.remove("security_avoid_pull_rsa");
            bundle2.remove("security_avoid_rsa_public_key");
            bundle2.remove("security_avoid_rsa_public_key");
            bundle2.remove("notify_action");
            bundle2.remove("notify_componet_pkg");
            bundle2.remove("notify_componet_class_name");
            bundle2.remove("notification_v1");
            bundle2.remove("command");
            bundle2.remove("package_name");
            bundle2.remove("method");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bundle2;
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    private static Uri e(String str) {
        try {
            return Uri.parse(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("package_name", this.a);
        dVar.a("notify_id", this.f8461d);
        dVar.a("notification_v1", com.vivo.push.util.v.b(this.f8462e));
        dVar.a("open_pkg_name", this.f8459b);
        dVar.a("open_pkg_name_encode", this.f8460c);
        dVar.a("notify_action", this.f8463f);
        dVar.a("notify_componet_pkg", this.f8464g);
        dVar.a("notify_componet_class_name", this.f8466i);
        Uri uri = this.f8465h;
        if (uri != null) {
            dVar.a("notify_uri_data", uri.toString());
        }
    }

    public final void d(String str) {
        this.f8466i = str;
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.a = dVar.a("package_name");
        this.f8461d = dVar.b("notify_id", -1L);
        this.f8459b = dVar.a("open_pkg_name");
        this.f8460c = dVar.b("open_pkg_name_encode");
        this.f8463f = dVar.a("notify_action");
        this.f8464g = dVar.a("notify_componet_pkg");
        this.f8466i = dVar.a("notify_componet_class_name");
        String strA = dVar.a("notification_v1");
        if (!TextUtils.isEmpty(strA)) {
            this.f8462e = com.vivo.push.util.v.a(strA);
        }
        InsideNotificationItem insideNotificationItem = this.f8462e;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f8461d);
        }
        String strA2 = dVar.a("notify_uri_data");
        if (!TextUtils.isEmpty(strA2)) {
            this.f8465h = e(strA2);
        }
        this.f8467j = dVar.b();
    }

    public p() {
        super(5);
    }
}
