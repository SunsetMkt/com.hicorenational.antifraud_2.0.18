package com.vivo.push;

import android.content.Intent;
import com.vivo.push.p232b.C3837i;
import com.vivo.push.p232b.C3838j;
import com.vivo.push.p232b.C3839k;
import com.vivo.push.p232b.C3840l;
import com.vivo.push.p232b.C3841m;
import com.vivo.push.p232b.C3842n;
import com.vivo.push.p232b.C3843o;
import com.vivo.push.p232b.C3844p;
import com.vivo.push.p232b.C3845q;
import com.vivo.push.p232b.C3846r;
import com.vivo.push.p232b.C3848t;
import com.vivo.push.p232b.C3849u;
import com.vivo.push.p237f.AbstractC3882aa;
import com.vivo.push.p237f.C3889ah;
import com.vivo.push.util.C4010u;

/* compiled from: PushClientFactory.java */
/* renamed from: com.vivo.push.l */
/* loaded from: classes2.dex */
public final class C3923l implements IPushClientFactory {

    /* renamed from: a */
    private C3889ah f14068a = new C3889ah();

    @Override // com.vivo.push.IPushClientFactory
    public final AbstractC3882aa createReceiveTask(AbstractC4016v abstractC4016v) {
        return C3889ah.m12963b(abstractC4016v);
    }

    @Override // com.vivo.push.IPushClientFactory
    public final AbstractC4016v createReceiverCommand(Intent intent) {
        AbstractC4016v c3849u;
        int intExtra = intent.getIntExtra("command", -1);
        if (intExtra < 0) {
            intExtra = intent.getIntExtra("method", -1);
        }
        if (intExtra == 20) {
            c3849u = new C3849u();
        } else if (intExtra != 2016) {
            switch (intExtra) {
                case 1:
                case 2:
                    c3849u = new C3848t(intExtra);
                    break;
                case 3:
                    c3849u = new C3843o();
                    break;
                case 4:
                    c3849u = new C3845q();
                    break;
                case 5:
                    c3849u = new C3844p();
                    break;
                case 6:
                    c3849u = new C3846r();
                    break;
                case 7:
                    c3849u = new C3842n();
                    break;
                case 8:
                    c3849u = new C3841m();
                    break;
                case 9:
                    c3849u = new C3839k();
                    break;
                case 10:
                case 11:
                    c3849u = new C3837i(intExtra);
                    break;
                case 12:
                    c3849u = new C3838j();
                    break;
                default:
                    c3849u = null;
                    break;
            }
        } else {
            c3849u = new C3840l();
        }
        if (c3849u != null) {
            C3862d m12911a = C3862d.m12911a(intent);
            if (m12911a == null) {
                C4010u.m13301b("PushCommand", "bundleWapper is null");
            } else {
                c3849u.m13327b(m12911a);
            }
        }
        return c3849u;
    }

    @Override // com.vivo.push.IPushClientFactory
    public final AbstractRunnableC3971s createTask(AbstractC4016v abstractC4016v) {
        return C3889ah.m12962a(abstractC4016v);
    }
}
