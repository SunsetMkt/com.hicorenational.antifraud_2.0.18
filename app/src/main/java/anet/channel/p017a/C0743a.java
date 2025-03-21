package anet.channel.p017a;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.fulltrace.C0786b;
import anet.channel.fulltrace.IFullTraceAnalysis;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import com.taobao.analysis.abtest.ABTestCenter;
import com.taobao.analysis.fulltrace.FullTraceAnalysis;
import com.taobao.analysis.fulltrace.RequestInfo;
import com.taobao.analysis.scene.SceneIdentifier;

/* compiled from: Taobao */
/* renamed from: anet.channel.a.a */
/* loaded from: classes.dex */
public class C0743a implements IFullTraceAnalysis {

    /* renamed from: a */
    private boolean f745a;

    public C0743a() {
        try {
            Class.forName("com.taobao.analysis.fulltrace.FullTraceAnalysis");
            SceneIdentifier.setContext(GlobalAppRuntimeInfo.getContext());
            this.f745a = true;
        } catch (Exception unused) {
            this.f745a = false;
            ALog.m715e("awcn.DefaultFullTraceAnalysis", "not supoort FullTraceAnalysis", null, new Object[0]);
        }
    }

    @Override // anet.channel.fulltrace.IFullTraceAnalysis
    public void commitRequest(String str, RequestStatistic requestStatistic) {
        if (!this.f745a || requestStatistic == null || TextUtils.isEmpty(str)) {
            return;
        }
        RequestInfo requestInfo = new RequestInfo();
        requestInfo.host = requestStatistic.host;
        requestInfo.bizId = requestStatistic.bizId;
        requestInfo.url = requestStatistic.url;
        requestInfo.retryTimes = requestStatistic.retryTimes;
        requestInfo.netType = requestStatistic.netType;
        requestInfo.protocolType = requestStatistic.protocolType;
        requestInfo.ret = requestStatistic.ret;
        requestInfo.isCbMain = false;
        requestInfo.isReqMain = requestStatistic.isReqMain;
        requestInfo.isReqSync = requestStatistic.isReqSync;
        requestInfo.netErrorCode = String.valueOf(requestStatistic.statusCode);
        requestInfo.pTraceId = requestStatistic.pTraceId;
        requestInfo.netReqStart = requestStatistic.netReqStart;
        requestInfo.netReqServiceBindEnd = requestStatistic.reqServiceTransmissionEnd;
        requestInfo.netReqProcessStart = requestStatistic.reqStart;
        requestInfo.netReqSendStart = requestStatistic.sendStart;
        requestInfo.netRspRecvEnd = requestStatistic.rspEnd;
        requestInfo.netRspCbDispatch = requestStatistic.rspCbDispatch;
        requestInfo.netRspCbStart = requestStatistic.rspCbStart;
        requestInfo.netRspCbEnd = requestStatistic.rspCbEnd;
        requestInfo.reqDeflateSize = requestStatistic.reqHeadDeflateSize + requestStatistic.reqBodyDeflateSize;
        requestInfo.reqInflateSize = requestStatistic.reqHeadInflateSize + requestStatistic.reqBodyInflateSize;
        requestInfo.rspDeflateSize = requestStatistic.rspHeadDeflateSize + requestStatistic.rspBodyDeflateSize;
        requestInfo.rspInflateSize = requestStatistic.rspHeadInflateSize + requestStatistic.rspBodyInflateSize;
        requestInfo.serverRT = requestStatistic.serverRT;
        requestInfo.sendDataTime = requestStatistic.sendDataTime;
        requestInfo.firstDataTime = requestStatistic.firstDataTime;
        requestInfo.recvDataTime = requestStatistic.recDataTime;
        FullTraceAnalysis.getInstance().commitRequest(str, "network", requestInfo);
    }

    @Override // anet.channel.fulltrace.IFullTraceAnalysis
    public String createRequest() {
        if (this.f745a) {
            return FullTraceAnalysis.getInstance().createRequest("network");
        }
        return null;
    }

    @Override // anet.channel.fulltrace.IFullTraceAnalysis
    public C0786b getSceneInfo() {
        if (!this.f745a) {
            return null;
        }
        C0786b c0786b = new C0786b();
        c0786b.f853b = SceneIdentifier.isUrlLaunch();
        c0786b.f854c = SceneIdentifier.getAppLaunchTime();
        c0786b.f855d = SceneIdentifier.getLastLaunchTime();
        c0786b.f856e = SceneIdentifier.getDeviceLevel();
        c0786b.f852a = SceneIdentifier.getStartType();
        c0786b.f857f = SceneIdentifier.getBucketInfo();
        c0786b.f858g = ABTestCenter.getUTABTestBucketId("networksdk");
        return c0786b;
    }
}
