package com.umeng.socialize.net.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SocializeUtils;

/* JADX INFO: loaded from: classes2.dex */
public class AnalyticsReqeust extends SocializeRequest {
    private static final String a = "/share/multi_add/";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f8321b = 9;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f8324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f8326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f8327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f8328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private UMediaObject f8329j;

    public AnalyticsReqeust(Context context, String str, String str2) {
        super(context, "", AnalyticsResponse.class, 9, URequest.RequestMethod.POST);
        this.mContext = context;
        this.f8323d = str;
        this.f8328i = str2;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    protected String getPath() {
        return a + SocializeUtils.getAppkey(this.mContext) + "/" + Config.EntityKey + "/";
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        super.onPrepareRequest();
        Object[] objArr = new Object[2];
        objArr[0] = this.f8323d;
        String str = this.f8322c;
        if (str == null) {
            str = "";
        }
        objArr[1] = str;
        String str2 = String.format("{\"%s\":\"%s\"}", objArr);
        String appkey = SocializeUtils.getAppkey(this.mContext);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_DESCRIPTOR, Config.Descriptor);
        addStringParams("to", str2);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_SHARE_SNS, str2);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_AK, appkey);
        addStringParams("type", this.f8325f);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_SHARE_USID, this.f8322c);
        addStringParams("ct", this.f8328i);
        if (!TextUtils.isEmpty(this.f8327h)) {
            addStringParams("url", this.f8327h);
        }
        if (!TextUtils.isEmpty(this.f8326g)) {
            addStringParams("title", this.f8326g);
        }
        addMediaParams(this.f8329j);
    }

    public void setMedia(UMediaObject uMediaObject) {
        if (uMediaObject instanceof UMImage) {
            this.f8329j = uMediaObject;
            return;
        }
        if (uMediaObject instanceof UMusic) {
            UMusic uMusic = (UMusic) uMediaObject;
            this.f8326g = uMusic.getTitle();
            this.f8327h = uMusic.toUrl();
            this.f8328i = uMusic.getDescription();
            this.f8329j = uMusic.getThumbImage();
            return;
        }
        if (uMediaObject instanceof UMVideo) {
            UMVideo uMVideo = (UMVideo) uMediaObject;
            this.f8326g = uMVideo.getTitle();
            this.f8327h = uMVideo.toUrl();
            this.f8328i = uMVideo.getDescription();
            this.f8329j = uMVideo.getThumbImage();
            return;
        }
        if (uMediaObject instanceof UMWeb) {
            UMWeb uMWeb = (UMWeb) uMediaObject;
            this.f8326g = uMWeb.getTitle();
            this.f8327h = uMWeb.toUrl();
            this.f8328i = uMWeb.getDescription();
            this.f8329j = uMWeb.getThumbImage();
            return;
        }
        if (uMediaObject instanceof UMMin) {
            UMMin uMMin = (UMMin) uMediaObject;
            this.f8326g = uMMin.getTitle();
            this.f8327h = uMMin.toUrl();
            this.f8328i = uMMin.getDescription();
            this.f8329j = uMMin.getThumbImage();
        }
    }

    public void setPlatform(String str) {
        this.f8323d = str;
    }

    public void setText(String str) {
        this.f8328i = str;
    }

    public void setType(String str) {
        this.f8325f = str;
    }

    public void setUID(String str) {
        this.f8324e = str;
    }

    public void setmUsid(String str) {
        this.f8322c = str;
    }
}
