package com.vivo.push.restructure.p239a.p240a;

import com.vivo.push.restructure.p239a.InterfaceC3933a;
import com.vivo.push.restructure.p242c.InterfaceC3956a;
import com.vivo.push.util.C4010u;

/* compiled from: NodeListenerImpl.java */
/* renamed from: com.vivo.push.restructure.a.a.j */
/* loaded from: classes2.dex */
final class C3943j implements InterfaceC3942i<InterfaceC3933a> {

    /* renamed from: a */
    private AbstractC3934a f14135a;

    /* renamed from: b */
    private InterfaceC3947n f14136b;

    /* renamed from: c */
    private InterfaceC3944k f14137c;

    /* renamed from: d */
    private InterfaceC3956a f14138d;

    public C3943j(InterfaceC3947n interfaceC3947n, InterfaceC3944k interfaceC3944k, InterfaceC3956a interfaceC3956a) {
        this.f14136b = interfaceC3947n;
        this.f14137c = interfaceC3944k;
        this.f14138d = interfaceC3956a;
    }

    @Override // com.vivo.push.restructure.p239a.p240a.InterfaceC3942i
    /* renamed from: a */
    public final /* synthetic */ void mo13103a(AbstractC3934a abstractC3934a, InterfaceC3933a interfaceC3933a, int i2) {
        InterfaceC3933a interfaceC3933a2 = interfaceC3933a;
        if (interfaceC3933a2 == null) {
            C4010u.m13298a("onNodeError() receivedMsg is null ");
            return;
        }
        C4010u.m13298a("onNodeError() , msgID = " + interfaceC3933a2.mo13078a() + ", nodeName = " + abstractC3934a.mo13096b());
        InterfaceC3956a interfaceC3956a = this.f14138d;
        if (interfaceC3956a != null) {
            interfaceC3956a.mo13137a(i2, interfaceC3933a2.mo13078a());
        }
        a2(interfaceC3933a2);
    }

    @Override // com.vivo.push.restructure.p239a.p240a.InterfaceC3942i
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo13104a(InterfaceC3933a interfaceC3933a) {
        InterfaceC3933a interfaceC3933a2 = interfaceC3933a;
        if (interfaceC3933a2 == null) {
            C4010u.m13298a("onAllNodeExecuteComplete, receivedMsg is null");
        } else if (this.f14135a == null) {
            C4010u.m13298a("onAllNodeExecuteComplete, mFirstNode is null");
        } else {
            a2(interfaceC3933a2);
        }
    }

    @Override // com.vivo.push.restructure.p239a.p240a.InterfaceC3942i
    /* renamed from: a */
    public final void mo13102a(AbstractC3934a abstractC3934a) {
        this.f14135a = abstractC3934a;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(InterfaceC3933a interfaceC3933a) {
        if (interfaceC3933a == null) {
            return;
        }
        if (!interfaceC3933a.mo13082e()) {
            C4010u.m13298a("core is not support monitor report");
            return;
        }
        C4010u.m13298a("reportNodeMonitorInfo() , isNeedCollectNodeMonitor: " + interfaceC3933a.mo13083f());
        if (interfaceC3933a.mo13083f()) {
            InterfaceC3947n interfaceC3947n = this.f14136b;
            if (interfaceC3947n != null) {
                interfaceC3947n.mo13107a(interfaceC3933a, this.f14135a);
            }
            InterfaceC3944k interfaceC3944k = this.f14137c;
            if (interfaceC3944k != null) {
                interfaceC3944k.mo13105a(interfaceC3933a, this.f14135a.m13097c().toString());
                C4010u.m13298a("reportNodeMonitorInfo() , report client NodeInfo！！！");
            } else {
                C4010u.m13298a("onNodeError , mReporter is null， can not report");
            }
        }
    }
}
