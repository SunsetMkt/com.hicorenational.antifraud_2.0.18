package com.vivo.push.p237f;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2085b;
import com.vivo.push.AbstractC4016v;
import com.vivo.push.C3924m;
import com.vivo.push.C3975t;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.p232b.C3836h;
import com.vivo.push.p232b.C3845q;
import com.vivo.push.p232b.C3852x;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.util.C3984aa;
import com.vivo.push.util.C3990ag;
import com.vivo.push.util.C3995f;
import com.vivo.push.util.C4010u;
import java.util.HashMap;

/* compiled from: OnNotificationArrivedReceiveTask.java */
/* renamed from: com.vivo.push.f.u */
/* loaded from: classes2.dex */
public final class C3911u extends AbstractC3882aa {

    /* compiled from: OnNotificationArrivedReceiveTask.java */
    /* renamed from: com.vivo.push.f.u$a */
    public interface a {
        /* renamed from: a */
        void mo12987a();

        /* renamed from: b */
        void mo12988b();
    }

    C3911u(AbstractC4016v abstractC4016v) {
        super(abstractC4016v);
    }

    @Override // com.vivo.push.AbstractRunnableC3971s
    /* renamed from: a */
    protected final void mo12952a(AbstractC4016v abstractC4016v) {
        if (abstractC4016v == null) {
            C4010u.m13292a("OnNotificationArrivedTask", "command is null");
            return;
        }
        boolean isEnablePush = ClientConfigManagerImpl.getInstance(this.f14186a).isEnablePush();
        C3845q c3845q = (C3845q) abstractC4016v;
        Context context = this.f14186a;
        if (!C3984aa.m13188d(context, context.getPackageName())) {
            C3852x c3852x = new C3852x(2101L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(C2085b.f6162c, String.valueOf(c3845q.m12882f()));
            String mo13112a = C3932a.m13069a().m13074e().mo13112a();
            if (!TextUtils.isEmpty(mo13112a)) {
                hashMap.put("remoteAppId", mo13112a);
            }
            c3852x.m12886a(hashMap);
            C3924m.m13016a().m13032a(c3852x);
            return;
        }
        C3924m.m13016a().m13032a(new C3836h(String.valueOf(c3845q.m12882f())));
        C4010u.m13309d("OnNotificationArrivedTask", "PushMessageReceiver " + this.f14186a.getPackageName() + " isEnablePush :" + isEnablePush);
        if (!isEnablePush) {
            C3852x c3852x2 = new C3852x(1020L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put(C2085b.f6162c, String.valueOf(c3845q.m12882f()));
            String mo13112a2 = C3932a.m13069a().m13074e().mo13112a();
            if (!TextUtils.isEmpty(mo13112a2)) {
                hashMap2.put("remoteAppId", mo13112a2);
            }
            c3852x2.m12886a(hashMap2);
            C3924m.m13016a().m13032a(c3852x2);
            return;
        }
        if (C3924m.m13016a().m13048g() && !m12956a(C3990ag.m13221c(this.f14186a), c3845q.m12875e(), c3845q.m12883g())) {
            C3852x c3852x3 = new C3852x(1021L);
            HashMap<String, String> hashMap3 = new HashMap<>();
            hashMap3.put(C2085b.f6162c, String.valueOf(c3845q.m12882f()));
            String mo13112a3 = C3932a.m13069a().m13074e().mo13112a();
            if (!TextUtils.isEmpty(mo13112a3)) {
                hashMap3.put("remoteAppId", mo13112a3);
            }
            c3852x3.m12886a(hashMap3);
            C3924m.m13016a().m13032a(c3852x3);
            return;
        }
        InsideNotificationItem m12874d = c3845q.m12874d();
        if (m12874d == null) {
            C4010u.m13292a("OnNotificationArrivedTask", "notify is null");
            C4010u.m13308c(this.f14186a, "通知内容为空，" + c3845q.m12882f());
            C3995f.m13248a(c3845q.m12882f(), 1027L);
            return;
        }
        C4010u.m13309d("OnNotificationArrivedTask", "tragetType is " + m12874d.getTargetType() + " ; target is " + m12874d.getTragetContent());
        C3975t.m13171c(new RunnableC3912v(this, m12874d, c3845q));
    }
}
