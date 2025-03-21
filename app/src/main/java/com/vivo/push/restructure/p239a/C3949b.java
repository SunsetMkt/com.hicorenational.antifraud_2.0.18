package com.vivo.push.restructure.p239a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.restructure.request.p243a.C3959a;
import com.vivo.push.restructure.request.p243a.p244a.C3960a;
import com.vivo.push.util.C4010u;
import com.vivo.push.util.C4011v;
import org.json.JSONException;

/* compiled from: ReceivedMessageImpl.java */
/* renamed from: com.vivo.push.restructure.a.b */
/* loaded from: classes2.dex */
public final class C3949b implements InterfaceC3933a {

    /* renamed from: a */
    private Intent f14142a;

    /* renamed from: c */
    private C3959a f14144c;

    /* renamed from: e */
    private InsideNotificationItem f14146e;

    /* renamed from: f */
    private UnvarnishedMessage f14147f;

    /* renamed from: b */
    private String f14143b = "";

    /* renamed from: d */
    private String f14145d = "";

    public C3949b(Intent intent) {
        this.f14142a = intent;
    }

    /* renamed from: m */
    private boolean m13108m() {
        return mo13087j() == 4;
    }

    /* renamed from: n */
    private boolean m13109n() {
        return mo13087j() == 3;
    }

    /* renamed from: o */
    private InsideNotificationItem m13110o() {
        InsideNotificationItem insideNotificationItem = this.f14146e;
        if (insideNotificationItem != null) {
            return insideNotificationItem;
        }
        InsideNotificationItem insideNotificationItem2 = null;
        Intent intent = this.f14142a;
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("notification_v1");
                if (stringExtra != null && (insideNotificationItem2 = C4011v.m13311a(stringExtra)) != null) {
                    insideNotificationItem2.setMsgId(Long.parseLong(mo13078a()));
                }
            } catch (Exception e2) {
                C4010u.m13292a("ReceivedMessageImpl", "getNotificationMessage " + e2.getMessage());
            }
        }
        this.f14146e = insideNotificationItem2;
        return insideNotificationItem2;
    }

    /* renamed from: p */
    private UnvarnishedMessage m13111p() {
        UnvarnishedMessage unvarnishedMessage = this.f14147f;
        if (unvarnishedMessage != null) {
            return unvarnishedMessage;
        }
        UnvarnishedMessage unvarnishedMessage2 = null;
        Intent intent = this.f14142a;
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("msg_v1");
                if (!TextUtils.isEmpty(stringExtra)) {
                    UnvarnishedMessage unvarnishedMessage3 = new UnvarnishedMessage(stringExtra);
                    try {
                        unvarnishedMessage3.setMsgId(Long.parseLong(mo13078a()));
                        unvarnishedMessage2 = unvarnishedMessage3;
                    } catch (Exception e2) {
                        e = e2;
                        unvarnishedMessage2 = unvarnishedMessage3;
                        C4010u.m13292a("ReceivedMessageImpl", "getTransmissionMessage " + e.getMessage());
                        this.f14147f = unvarnishedMessage2;
                        return unvarnishedMessage2;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        this.f14147f = unvarnishedMessage2;
        return unvarnishedMessage2;
    }

    @Override // com.vivo.push.restructure.p239a.InterfaceC3933a
    /* renamed from: a */
    public final String mo13078a() {
        Bundle extras;
        Intent intent = this.f14142a;
        long j2 = (intent == null || (extras = intent.getExtras()) == null) ? 0L : extras.getLong("notify_id", 0L);
        return j2 != 0 ? String.valueOf(j2) : "";
    }

    @Override // com.vivo.push.restructure.p239a.InterfaceC3933a
    /* renamed from: b */
    public final Intent mo13079b() {
        return this.f14142a;
    }

    @Override // com.vivo.push.restructure.p239a.InterfaceC3933a
    /* renamed from: c */
    public final String mo13080c() {
        if (TextUtils.isEmpty(this.f14143b)) {
            this.f14143b = this.f14142a.getStringExtra("req_id");
        }
        return this.f14143b;
    }

    @Override // com.vivo.push.restructure.p239a.InterfaceC3933a
    /* renamed from: d */
    public final long mo13081d() {
        Intent intent = this.f14142a;
        if (intent != null) {
            return intent.getLongExtra("ipc_start_time", 0L);
        }
        return 0L;
    }

    @Override // com.vivo.push.restructure.p239a.InterfaceC3933a
    /* renamed from: e */
    public final boolean mo13082e() {
        Intent intent = this.f14142a;
        if (intent != null) {
            return intent.getBooleanExtra("core_support_monitor", false);
        }
        return false;
    }

    @Override // com.vivo.push.restructure.p239a.InterfaceC3933a
    /* renamed from: f */
    public final boolean mo13083f() {
        Bundle extras;
        Intent intent = this.f14142a;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return false;
        }
        return extras.getBoolean("client_collect_node", false);
    }

    @Override // com.vivo.push.restructure.p239a.InterfaceC3933a
    /* renamed from: g */
    public final boolean mo13084g() {
        C3959a mo13085h = mo13085h();
        return mo13085h != null && mo13085h.m13139a() == 2018;
    }

    @Override // com.vivo.push.restructure.p239a.InterfaceC3933a
    /* renamed from: h */
    public final C3959a mo13085h() {
        String stringExtra;
        C3960a c3960a;
        if (this.f14144c == null && (stringExtra = this.f14142a.getStringExtra("cf_content")) != null) {
            try {
                c3960a = new C3960a(stringExtra);
            } catch (JSONException unused) {
                c3960a = null;
            }
            if (c3960a != null) {
                this.f14144c = C3959a.f14160a.mo12932a(c3960a);
            }
        }
        return this.f14144c;
    }

    @Override // com.vivo.push.restructure.p239a.InterfaceC3933a
    /* renamed from: i */
    public final String mo13086i() {
        if (TextUtils.isEmpty(this.f14145d)) {
            this.f14145d = this.f14142a.getStringExtra("content");
        }
        return this.f14145d;
    }

    @Override // com.vivo.push.restructure.p239a.InterfaceC3933a
    /* renamed from: j */
    public final int mo13087j() {
        Intent intent = this.f14142a;
        if (intent == null) {
            return -1;
        }
        int intExtra = intent.getIntExtra("command", -1);
        return intExtra < 0 ? this.f14142a.getIntExtra("method", -1) : intExtra;
    }

    @Override // com.vivo.push.restructure.p239a.InterfaceC3933a
    /* renamed from: k */
    public final int mo13088k() {
        if (this.f14142a == null) {
            return 0;
        }
        if (m13108m() && m13110o() != null) {
            return m13110o().getTargetType();
        }
        if (!m13109n() || m13111p() == null) {
            return 0;
        }
        return m13111p().getTargetType();
    }

    @Override // com.vivo.push.restructure.p239a.InterfaceC3933a
    /* renamed from: l */
    public final String mo13089l() {
        return this.f14142a == null ? "" : (!m13108m() || m13110o() == null) ? (!m13109n() || m13111p() == null) ? "" : m13111p().getTragetContent() : m13110o().getTragetContent();
    }
}
