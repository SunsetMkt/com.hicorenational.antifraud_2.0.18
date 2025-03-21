package anet.channel.p017a;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.flow.FlowStat;
import anet.channel.flow.INetworkAnalysis;
import anet.channel.util.ALog;
import com.taobao.analysis.FlowCenter;

/* compiled from: Taobao */
/* renamed from: anet.channel.a.b */
/* loaded from: classes.dex */
public class C0744b implements INetworkAnalysis {

    /* renamed from: a */
    private boolean f746a;

    public C0744b() {
        try {
            Class.forName("com.taobao.analysis.FlowCenter");
            this.f746a = true;
        } catch (Exception unused) {
            this.f746a = false;
            ALog.m715e("DefaultNetworkAnalysis", "no NWNetworkAnalysisSDK sdk", null, new Object[0]);
        }
    }

    @Override // anet.channel.flow.INetworkAnalysis
    public void commitFlow(FlowStat flowStat) {
        if (this.f746a) {
            FlowCenter.getInstance().commitFlow(GlobalAppRuntimeInfo.getContext(), flowStat.refer, flowStat.protocoltype, flowStat.req_identifier, flowStat.upstream, flowStat.downstream);
        }
    }
}
