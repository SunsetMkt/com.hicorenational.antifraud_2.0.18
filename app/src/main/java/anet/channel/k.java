package anet.channel;

import anet.channel.util.HttpConstant;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class k implements b.a.j.c {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    @Override // b.a.j.c
    public boolean handleCache(String str, Map<String, String> map) {
        return "weex".equals(map.get(HttpConstant.F_REFER));
    }
}
