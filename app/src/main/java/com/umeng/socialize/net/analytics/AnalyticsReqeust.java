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

/* loaded from: classes2.dex */
public class AnalyticsReqeust extends SocializeRequest {

    /* renamed from: a */
    private static final String f13694a = "/share/multi_add/";

    /* renamed from: b */
    private static final int f13695b = 9;

    /* renamed from: c */
    private String f13696c;

    /* renamed from: d */
    private String f13697d;

    /* renamed from: e */
    private String f13698e;

    /* renamed from: f */
    private String f13699f;

    /* renamed from: g */
    private String f13700g;

    /* renamed from: h */
    private String f13701h;

    /* renamed from: i */
    private String f13702i;

    /* renamed from: j */
    private UMediaObject f13703j;

    public AnalyticsReqeust(Context context, String str, String str2) {
        super(context, "", AnalyticsResponse.class, 9, URequest.RequestMethod.POST);
        this.mContext = context;
        this.f13697d = str;
        this.f13702i = str2;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    protected String getPath() {
        return f13694a + SocializeUtils.getAppkey(this.mContext) + "/" + Config.EntityKey + "/";
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        super.onPrepareRequest();
        Object[] objArr = new Object[2];
        objArr[0] = this.f13697d;
        String str = this.f13696c;
        if (str == null) {
            str = "";
        }
        objArr[1] = str;
        String format = String.format("{\"%s\":\"%s\"}", objArr);
        String appkey = SocializeUtils.getAppkey(this.mContext);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_DESCRIPTOR, Config.Descriptor);
        addStringParams("to", format);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_SHARE_SNS, format);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_AK, appkey);
        addStringParams("type", this.f13699f);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_SHARE_USID, this.f13696c);
        addStringParams("ct", this.f13702i);
        if (!TextUtils.isEmpty(this.f13701h)) {
            addStringParams("url", this.f13701h);
        }
        if (!TextUtils.isEmpty(this.f13700g)) {
            addStringParams("title", this.f13700g);
        }
        addMediaParams(this.f13703j);
    }

    public void setMedia(UMediaObject uMediaObject) {
        if (uMediaObject instanceof UMImage) {
            this.f13703j = uMediaObject;
            return;
        }
        if (uMediaObject instanceof UMusic) {
            UMusic uMusic = (UMusic) uMediaObject;
            this.f13700g = uMusic.getTitle();
            this.f13701h = uMusic.toUrl();
            this.f13702i = uMusic.getDescription();
            this.f13703j = uMusic.getThumbImage();
            return;
        }
        if (uMediaObject instanceof UMVideo) {
            UMVideo uMVideo = (UMVideo) uMediaObject;
            this.f13700g = uMVideo.getTitle();
            this.f13701h = uMVideo.toUrl();
            this.f13702i = uMVideo.getDescription();
            this.f13703j = uMVideo.getThumbImage();
            return;
        }
        if (uMediaObject instanceof UMWeb) {
            UMWeb uMWeb = (UMWeb) uMediaObject;
            this.f13700g = uMWeb.getTitle();
            this.f13701h = uMWeb.toUrl();
            this.f13702i = uMWeb.getDescription();
            this.f13703j = uMWeb.getThumbImage();
            return;
        }
        if (uMediaObject instanceof UMMin) {
            UMMin uMMin = (UMMin) uMediaObject;
            this.f13700g = uMMin.getTitle();
            this.f13701h = uMMin.toUrl();
            this.f13702i = uMMin.getDescription();
            this.f13703j = uMMin.getThumbImage();
        }
    }

    public void setPlatform(String str) {
        this.f13697d = str;
    }

    public void setText(String str) {
        this.f13702i = str;
    }

    public void setType(String str) {
        this.f13699f = str;
    }

    public void setUID(String str) {
        this.f13698e = str;
    }

    public void setmUsid(String str) {
        this.f13696c = str;
    }
}
