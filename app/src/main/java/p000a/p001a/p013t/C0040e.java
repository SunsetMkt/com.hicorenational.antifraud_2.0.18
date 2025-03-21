package p000a.p001a.p013t;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.List;
import java.util.Map;
import p000a.p001a.p004l.C0015a;
import p000a.p001a.p008p.InterfaceC0026a;

/* compiled from: Taobao */
/* renamed from: a.a.t.e */
/* loaded from: classes.dex */
class C0040e implements RequestCb {

    /* renamed from: a */
    final /* synthetic */ C0039d f97a;

    C0040e(C0039d c0039d) {
        this.f97a = c0039d;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
        C0047l c0047l;
        C0047l c0047l2;
        C0047l c0047l3;
        int i2;
        int i3;
        c0047l = this.f97a.f93c;
        if (c0047l.f138d.get()) {
            return;
        }
        C0039d.m180b(this.f97a);
        c0047l2 = this.f97a.f93c;
        if (c0047l2.f136b != null) {
            c0047l3 = this.f97a.f93c;
            InterfaceC0026a interfaceC0026a = c0047l3.f136b;
            i2 = this.f97a.f95e;
            i3 = this.f97a.f94d;
            interfaceC0026a.mo150a(i2, i3, byteArray);
        }
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        C0047l c0047l;
        C0047l c0047l2;
        C0047l c0047l3;
        C0047l c0047l4;
        Request request;
        C0047l c0047l5;
        c0047l = this.f97a.f93c;
        if (c0047l.f138d.getAndSet(true)) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            c0047l5 = this.f97a.f93c;
            ALog.m716i("anet.DegradeTask", "[onFinish]", c0047l5.f137c, "code", Integer.valueOf(i2), "msg", str);
        }
        c0047l2 = this.f97a.f93c;
        c0047l2.m197a();
        requestStatistic.isDone.set(true);
        c0047l3 = this.f97a.f93c;
        if (c0047l3.f136b != null) {
            c0047l4 = this.f97a.f93c;
            InterfaceC0026a interfaceC0026a = c0047l4.f136b;
            request = this.f97a.f96f;
            interfaceC0026a.mo151a(new DefaultFinishEvent(i2, str, request));
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        C0047l c0047l;
        C0047l c0047l2;
        C0047l c0047l3;
        C0047l c0047l4;
        C0047l c0047l5;
        c0047l = this.f97a.f93c;
        if (c0047l.f138d.get()) {
            return;
        }
        c0047l2 = this.f97a.f93c;
        c0047l2.m197a();
        c0047l3 = this.f97a.f93c;
        C0015a.m118a(c0047l3.f135a.m833g(), map);
        this.f97a.f94d = HttpHelper.parseContentLength(map);
        c0047l4 = this.f97a.f93c;
        if (c0047l4.f136b != null) {
            c0047l5 = this.f97a.f93c;
            c0047l5.f136b.onResponseCode(i2, map);
        }
    }
}
