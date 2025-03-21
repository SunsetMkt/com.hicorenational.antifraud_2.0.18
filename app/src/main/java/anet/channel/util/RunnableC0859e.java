package anet.channel.util;

/* compiled from: Taobao */
/* renamed from: anet.channel.util.e */
/* loaded from: classes.dex */
class RunnableC0859e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC0858d f1180a;

    RunnableC0859e(RunnableC0858d runnableC0858d) {
        this.f1180a = runnableC0858d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        r0 = anet.channel.util.C0857c.m735k();
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r4 = this;
            anet.channel.status.NetworkStatusHelper$NetworkStatus r0 = anet.channel.status.NetworkStatusHelper.getStatus()     // Catch: java.lang.Exception -> L79
            java.lang.String r0 = anet.channel.util.C0857c.m720a(r0)     // Catch: java.lang.Exception -> L79
            anet.channel.util.d r1 = r4.f1180a     // Catch: java.lang.Exception -> L79
            java.lang.String r1 = r1.f1178a     // Catch: java.lang.Exception -> L79
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Exception -> L79
            if (r0 != 0) goto L13
            return
        L13:
            java.lang.String r0 = "awcn.Inet64Util"
            java.lang.String r1 = "startIpStackDetect double check"
            r2 = 0
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L79
            anet.channel.util.ALog.m715e(r0, r1, r2, r3)     // Catch: java.lang.Exception -> L79
            int r0 = anet.channel.util.C0857c.m730f()     // Catch: java.lang.Exception -> L79
            anet.channel.util.d r1 = r4.f1180a     // Catch: java.lang.Exception -> L79
            anet.channel.statist.NetTypeStat r1 = r1.f1179b     // Catch: java.lang.Exception -> L79
            int r1 = r1.ipStackType     // Catch: java.lang.Exception -> L79
            if (r1 == r0) goto L49
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r1 = anet.channel.util.C0857c.f1177e     // Catch: java.lang.Exception -> L79
            anet.channel.util.d r2 = r4.f1180a     // Catch: java.lang.Exception -> L79
            java.lang.String r2 = r2.f1178a     // Catch: java.lang.Exception -> L79
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> L79
            r1.put(r2, r3)     // Catch: java.lang.Exception -> L79
            anet.channel.util.d r1 = r4.f1180a     // Catch: java.lang.Exception -> L79
            anet.channel.statist.NetTypeStat r1 = r1.f1179b     // Catch: java.lang.Exception -> L79
            anet.channel.util.d r2 = r4.f1180a     // Catch: java.lang.Exception -> L79
            anet.channel.statist.NetTypeStat r2 = r2.f1179b     // Catch: java.lang.Exception -> L79
            int r2 = r2.ipStackType     // Catch: java.lang.Exception -> L79
            r1.lastIpStackType = r2     // Catch: java.lang.Exception -> L79
            anet.channel.util.d r1 = r4.f1180a     // Catch: java.lang.Exception -> L79
            anet.channel.statist.NetTypeStat r1 = r1.f1179b     // Catch: java.lang.Exception -> L79
            r1.ipStackType = r0     // Catch: java.lang.Exception -> L79
        L49:
            r1 = 2
            if (r0 == r1) goto L4f
            r1 = 3
            if (r0 != r1) goto L68
        L4f:
            anet.channel.util.f r0 = anet.channel.util.C0857c.m731g()     // Catch: java.lang.Exception -> L79
            if (r0 == 0) goto L68
            java.util.concurrent.ConcurrentHashMap<java.lang.String, anet.channel.util.f> r1 = anet.channel.util.C0857c.f1176d     // Catch: java.lang.Exception -> L79
            anet.channel.util.d r2 = r4.f1180a     // Catch: java.lang.Exception -> L79
            java.lang.String r2 = r2.f1178a     // Catch: java.lang.Exception -> L79
            r1.put(r2, r0)     // Catch: java.lang.Exception -> L79
            anet.channel.util.d r1 = r4.f1180a     // Catch: java.lang.Exception -> L79
            anet.channel.statist.NetTypeStat r1 = r1.f1179b     // Catch: java.lang.Exception -> L79
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L79
            r1.nat64Prefix = r0     // Catch: java.lang.Exception -> L79
        L68:
            boolean r0 = anet.channel.GlobalAppRuntimeInfo.isTargetProcess()     // Catch: java.lang.Exception -> L79
            if (r0 == 0) goto L79
            anet.channel.appmonitor.IAppMonitor r0 = anet.channel.appmonitor.AppMonitor.getInstance()     // Catch: java.lang.Exception -> L79
            anet.channel.util.d r1 = r4.f1180a     // Catch: java.lang.Exception -> L79
            anet.channel.statist.NetTypeStat r1 = r1.f1179b     // Catch: java.lang.Exception -> L79
            r0.commitStat(r1)     // Catch: java.lang.Exception -> L79
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.RunnableC0859e.run():void");
    }
}
