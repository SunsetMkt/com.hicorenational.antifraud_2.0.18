package com.vivo.push.p237f;

import android.content.Context;
import com.vivo.push.AbstractC4016v;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.C3924m;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.C3926b;
import com.vivo.push.p231a.C3825a;
import com.vivo.push.p232b.C3831c;
import com.vivo.push.p232b.C3833e;
import com.vivo.push.p232b.C3851w;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.util.C3984aa;
import com.vivo.push.util.C3992c;
import com.vivo.push.util.C4010u;
import com.vivo.push.util.C4014y;
import p388ui.activity.BaseProgressUploadActivity;

/* compiled from: SendCommandTask.java */
/* renamed from: com.vivo.push.f.ai */
/* loaded from: classes2.dex */
final class C3890ai extends AbstractRunnableC3971s {
    C3890ai(AbstractC4016v abstractC4016v) {
        super(abstractC4016v);
    }

    @Override // com.vivo.push.AbstractRunnableC3971s
    /* renamed from: a */
    protected final void mo12952a(AbstractC4016v abstractC4016v) {
        Context context = this.f14186a;
        if (context == null) {
            C4010u.m13309d("SendCommandTask", "SendCommandTask " + abstractC4016v + " ; mContext is Null");
            return;
        }
        if (abstractC4016v == null) {
            C4010u.m13309d("SendCommandTask", "SendCommandTask pushCommand is Null");
            return;
        }
        C3926b m13179a = C3984aa.m13179a(context, C3932a.m13069a().m13075f());
        int m13325b = abstractC4016v.m13325b();
        if (m13325b != 0) {
            if (m13325b == 2009) {
                C4010u.m13299a(ClientConfigManagerImpl.getInstance(this.f14186a).isDebug());
                if (C4010u.m13305b()) {
                    C3924m.m13016a();
                    C3932a.m13069a().m13074e().mo13122e();
                    C3992c c3992c = new C3992c();
                    c3992c.m13239a(this.f14186a, "com.vivo.push_preferences.hybridapptoken_v1");
                    c3992c.m13238a();
                    C3992c c3992c2 = new C3992c();
                    c3992c2.m13239a(this.f14186a, "com.vivo.push_preferences.appconfig_v1");
                    c3992c2.m13238a();
                    if (!C3924m.m13016a().m13047f()) {
                        ClientConfigManagerImpl.getInstance(this.f14186a).clearPush();
                    }
                }
            } else if (m13325b != 2011) {
                switch (m13325b) {
                    case BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2 /* 2002 */:
                    case 2003:
                    case 2004:
                    case 2005:
                        if (m13179a == null || m13179a.m13067c()) {
                            C3924m.m13016a().m13034a(((C3831c) abstractC4016v).m12843f(), 1005);
                            break;
                        } else {
                            C3831c c3831c = (C3831c) abstractC4016v;
                            int m13316a = C4014y.m13316a(c3831c);
                            if (m13316a != 0) {
                                C3924m.m13016a().m13034a(c3831c.m12843f(), m13316a);
                                return;
                            }
                        }
                        break;
                }
            } else {
                C4010u.m13299a(ClientConfigManagerImpl.getInstance(this.f14186a).isDebug(((C3851w) abstractC4016v).m12885d()));
            }
        }
        if (m13179a == null) {
            C4010u.m13309d("SendCommandTask", "SendCommandTask " + abstractC4016v + " ; pushPkgInfo is Null");
            return;
        }
        String m13060a = m13179a.m13060a();
        if (m13179a.m13067c()) {
            try {
                C3924m.m13016a().m13034a(((C3831c) abstractC4016v).m12843f(), 1004);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            abstractC4016v = new C3833e();
            C4010u.m13309d("SendCommandTask", "SendCommandTask " + abstractC4016v + " ; pkgName is InBlackList ");
        }
        C3825a.m12828a(this.f14186a, m13060a, abstractC4016v);
    }
}
