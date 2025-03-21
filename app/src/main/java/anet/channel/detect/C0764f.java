package anet.channel.detect;

import anet.channel.AwcnConfig;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;

/* compiled from: Taobao */
/* renamed from: anet.channel.detect.f */
/* loaded from: classes.dex */
class C0764f implements AppLifecycle.AppLifecycleListener {

    /* renamed from: a */
    final /* synthetic */ C0762d f794a;

    C0764f(C0762d c0762d) {
        this.f794a = c0762d;
    }

    @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
    public void background() {
        ALog.m716i("anet.HorseRaceDetector", "background", null, new Object[0]);
        if (AwcnConfig.isHorseRaceEnable()) {
            ThreadPoolExecutorFactory.submitHRTask(new RunnableC0765g(this));
        }
    }

    @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
    public void forground() {
    }
}
