package com.umeng.socialize.net;

import com.umeng.socialize.net.analytics.AnalyticsReqeust;
import com.umeng.socialize.net.analytics.AnalyticsResponse;
import com.umeng.socialize.net.base.SocializeClient;

/* loaded from: classes2.dex */
public class RestAPI {

    /* renamed from: a */
    private static SocializeClient f13693a = new SocializeClient();

    public static LinkCardResponse convertLinkCard(LinkcardRequest linkcardRequest) {
        return (LinkCardResponse) f13693a.execute(linkcardRequest);
    }

    public static AnalyticsResponse doShareByRequest(AnalyticsReqeust analyticsReqeust) {
        return (AnalyticsResponse) f13693a.execute(analyticsReqeust);
    }

    public static ActionBarResponse queryShareId(ActionBarRequest actionBarRequest) {
        return (ActionBarResponse) f13693a.execute(actionBarRequest);
    }
}
