package com.vivo.push.p232b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.AbstractC4016v;
import com.vivo.push.C3862d;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.util.C4011v;

/* compiled from: OnNotificationClickReceiveCommand.java */
/* renamed from: com.vivo.push.b.p */
/* loaded from: classes2.dex */
public final class C3844p extends AbstractC4016v {

    /* renamed from: a */
    private String f13936a;

    /* renamed from: b */
    private String f13937b;

    /* renamed from: c */
    private byte[] f13938c;

    /* renamed from: d */
    private long f13939d;

    /* renamed from: e */
    private InsideNotificationItem f13940e;

    /* renamed from: f */
    private String f13941f;

    /* renamed from: g */
    private String f13942g;

    /* renamed from: h */
    private Uri f13943h;

    /* renamed from: i */
    private String f13944i;

    /* renamed from: j */
    private Bundle f13945j;

    public C3844p(String str, long j2, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f13936a = str;
        this.f13939d = j2;
        this.f13940e = insideNotificationItem;
    }

    /* renamed from: a */
    public final void m12862a(Uri uri) {
        this.f13943h = uri;
    }

    /* renamed from: b */
    public final void m12863b(String str) {
        this.f13941f = str;
    }

    /* renamed from: c */
    public final void m12864c(String str) {
        this.f13942g = str;
    }

    /* renamed from: d */
    public final String m12865d() {
        return this.f13936a;
    }

    /* renamed from: e */
    public final long m12867e() {
        return this.f13939d;
    }

    /* renamed from: f */
    public final InsideNotificationItem m12868f() {
        return this.f13940e;
    }

    /* renamed from: g */
    public final String m12869g() {
        return this.f13941f;
    }

    /* renamed from: h */
    public final String m12870h() {
        return this.f13942g;
    }

    /* renamed from: i */
    public final String m12871i() {
        return this.f13944i;
    }

    /* renamed from: j */
    public final Uri m12872j() {
        return this.f13943h;
    }

    /* renamed from: k */
    public final Bundle m12873k() {
        Bundle bundle = this.f13945j;
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

    @Override // com.vivo.push.AbstractC4016v
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    /* renamed from: e */
    private static Uri m12861e(String str) {
        try {
            return Uri.parse(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected final void mo12833c(C3862d c3862d) {
        c3862d.m12917a("package_name", this.f13936a);
        c3862d.m12915a("notify_id", this.f13939d);
        c3862d.m12917a("notification_v1", C4011v.m13313b(this.f13940e));
        c3862d.m12917a("open_pkg_name", this.f13937b);
        c3862d.m12920a("open_pkg_name_encode", this.f13938c);
        c3862d.m12917a("notify_action", this.f13941f);
        c3862d.m12917a("notify_componet_pkg", this.f13942g);
        c3862d.m12917a("notify_componet_class_name", this.f13944i);
        Uri uri = this.f13943h;
        if (uri != null) {
            c3862d.m12917a("notify_uri_data", uri.toString());
        }
    }

    /* renamed from: d */
    public final void m12866d(String str) {
        this.f13944i = str;
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected final void mo12834d(C3862d c3862d) {
        this.f13936a = c3862d.m12913a("package_name");
        this.f13939d = c3862d.m12922b("notify_id", -1L);
        this.f13937b = c3862d.m12913a("open_pkg_name");
        this.f13938c = c3862d.m12924b("open_pkg_name_encode");
        this.f13941f = c3862d.m12913a("notify_action");
        this.f13942g = c3862d.m12913a("notify_componet_pkg");
        this.f13944i = c3862d.m12913a("notify_componet_class_name");
        String m12913a = c3862d.m12913a("notification_v1");
        if (!TextUtils.isEmpty(m12913a)) {
            this.f13940e = C4011v.m13311a(m12913a);
        }
        InsideNotificationItem insideNotificationItem = this.f13940e;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f13939d);
        }
        String m12913a2 = c3862d.m12913a("notify_uri_data");
        if (!TextUtils.isEmpty(m12913a2)) {
            this.f13943h = m12861e(m12913a2);
        }
        this.f13945j = c3862d.m12923b();
    }

    public C3844p() {
        super(5);
    }
}
