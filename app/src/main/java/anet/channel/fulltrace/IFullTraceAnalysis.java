package anet.channel.fulltrace;

import anet.channel.statist.RequestStatistic;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IFullTraceAnalysis {
    void commitRequest(String str, RequestStatistic requestStatistic);

    String createRequest();

    C0786b getSceneInfo();
}
