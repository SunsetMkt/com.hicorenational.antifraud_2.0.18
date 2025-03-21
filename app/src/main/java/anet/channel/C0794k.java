package anet.channel;

import anet.channel.util.HttpConstant;
import java.util.Map;
import p000a.p001a.p002j.InterfaceC0011c;

/* compiled from: Taobao */
/* renamed from: anet.channel.k */
/* loaded from: classes.dex */
class C0794k implements InterfaceC0011c {

    /* renamed from: a */
    final /* synthetic */ RunnableC0793j f875a;

    C0794k(RunnableC0793j runnableC0793j) {
        this.f875a = runnableC0793j;
    }

    @Override // p000a.p001a.p002j.InterfaceC0011c
    public boolean handleCache(String str, Map<String, String> map) {
        return "weex".equals(map.get(HttpConstant.F_REFER));
    }
}
