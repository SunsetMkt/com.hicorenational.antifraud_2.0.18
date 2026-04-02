package anet.channel.c;

import com.taobao.orange.OrangeConfigListenerV1;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class b implements OrangeConfigListenerV1 {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void onConfigUpdate(String str, boolean z) {
        this.a.onConfigUpdate(str);
    }
}
