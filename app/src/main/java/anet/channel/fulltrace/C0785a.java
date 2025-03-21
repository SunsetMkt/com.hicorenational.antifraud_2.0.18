package anet.channel.fulltrace;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* renamed from: anet.channel.fulltrace.a */
/* loaded from: classes.dex */
public class C0785a {

    /* renamed from: a */
    private static volatile IFullTraceAnalysis f849a = new a(null);

    /* renamed from: b */
    private static boolean f850b = false;

    /* compiled from: Taobao */
    /* renamed from: anet.channel.fulltrace.a$a */
    private static class a implements IFullTraceAnalysis {

        /* renamed from: a */
        private IFullTraceAnalysis f851a;

        a(IFullTraceAnalysis iFullTraceAnalysis) {
            this.f851a = iFullTraceAnalysis;
            boolean unused = C0785a.f850b = true;
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public void commitRequest(String str, RequestStatistic requestStatistic) {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (C0785a.f850b && (iFullTraceAnalysis = this.f851a) != null) {
                try {
                    iFullTraceAnalysis.commitRequest(str, requestStatistic);
                } catch (Throwable th) {
                    boolean unused = C0785a.f850b = false;
                    ALog.m714e("anet.AnalysisFactory", "fulltrace commit fail.", null, th, new Object[0]);
                }
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public String createRequest() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!C0785a.f850b || (iFullTraceAnalysis = this.f851a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.createRequest();
            } catch (Throwable th) {
                boolean unused = C0785a.f850b = false;
                ALog.m714e("anet.AnalysisFactory", "createRequest fail.", null, th, new Object[0]);
                return null;
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public C0786b getSceneInfo() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!C0785a.f850b || (iFullTraceAnalysis = this.f851a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.getSceneInfo();
            } catch (Throwable th) {
                boolean unused = C0785a.f850b = false;
                ALog.m714e("anet.AnalysisFactory", "getSceneInfo fail", null, th, new Object[0]);
                return null;
            }
        }
    }

    /* renamed from: a */
    public static IFullTraceAnalysis m516a() {
        return f849a;
    }

    /* renamed from: a */
    public static void m517a(IFullTraceAnalysis iFullTraceAnalysis) {
        f849a = new a(iFullTraceAnalysis);
    }
}
