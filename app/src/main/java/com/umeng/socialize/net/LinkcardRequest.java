package com.umeng.socialize.net;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LinkcardRequest extends SocializeRequest {

    /* renamed from: a */
    private static final String f13690a = "/share/linkcard/";

    /* renamed from: b */
    private String f13691b;

    /* renamed from: c */
    private BaseMediaObject f13692c;

    public LinkcardRequest(Context context) {
        super(context, "", LinkCardResponse.class, 0, URequest.RequestMethod.POST);
    }

    /* renamed from: a */
    private JSONObject m12658a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("display_name", this.f13692c.getTitle());
            jSONObject.put("image", m12663f());
            jSONObject.put("summary", m12661d());
            jSONObject.put(SocializeProtocolConstants.FULL_IMAGE, m12665h());
            jSONObject.put("url", this.f13692c.toUrl());
            jSONObject.put(SocializeProtocolConstants.LINKS, m12666i());
            jSONObject.put(SocializeProtocolConstants.TAGS, m12662e());
            jSONObject.put(SocializeProtocolConstants.CREATE_AT, m12660c());
            jSONObject.put(SocializeProtocolConstants.OBJECT_TYPE, m12659b());
        } catch (JSONException e2) {
            SLog.error(e2);
        }
        return jSONObject;
    }

    /* renamed from: b */
    private String m12659b() {
        BaseMediaObject baseMediaObject = this.f13692c;
        return baseMediaObject instanceof UMWeb ? "webpage" : baseMediaObject instanceof UMVideo ? "video" : baseMediaObject instanceof UMusic ? "audio" : "webpage";
    }

    /* renamed from: c */
    private String m12660c() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    /* renamed from: d */
    private String m12661d() {
        return (TextUtils.isEmpty(this.f13692c.getDescription()) || this.f13692c.getDescription().length() <= 300) ? this.f13692c.getDescription() : this.f13692c.getDescription().substring(0, 300);
    }

    /* renamed from: e */
    private JSONArray m12662e() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("display_name", Config.Descriptor);
            jSONArray.put(jSONObject);
        } catch (JSONException e2) {
            SLog.error(e2);
        }
        return jSONArray;
    }

    /* renamed from: f */
    private JSONObject m12663f() {
        JSONObject jSONObject = new JSONObject();
        try {
            UMImage thumbImage = this.f13692c.getThumbImage();
            if (thumbImage == null || !thumbImage.isUrlMedia()) {
                jSONObject.put("url", "https://mobile.umeng.com/images/pic/home/social/img-1.png");
            } else {
                jSONObject.put("url", thumbImage.asUrlImage());
            }
            int[] m12664g = m12664g();
            jSONObject.put(SocializeProtocolConstants.WIDTH, m12664g[0]);
            jSONObject.put(SocializeProtocolConstants.HEIGHT, m12664g[1]);
        } catch (JSONException e2) {
            SLog.error(e2);
        }
        return jSONObject;
    }

    /* renamed from: g */
    private int[] m12664g() {
        int[] iArr = {120, 120};
        BaseMediaObject baseMediaObject = this.f13692c;
        if (baseMediaObject != null && baseMediaObject.getmExtra() != null) {
            Map<String, Object> map = this.f13692c.getmExtra();
            if (map.containsKey(SocializeProtocolConstants.WIDTH)) {
                iArr[0] = ((Integer) map.get(SocializeProtocolConstants.WIDTH)).intValue();
            }
            if (map.containsKey(SocializeProtocolConstants.HEIGHT)) {
                iArr[1] = ((Integer) map.get(SocializeProtocolConstants.HEIGHT)).intValue();
            }
        }
        return iArr;
    }

    /* renamed from: h */
    private JSONObject m12665h() {
        JSONObject jSONObject = new JSONObject();
        try {
            UMImage thumbImage = this.f13692c.getThumbImage();
            if (thumbImage == null || !thumbImage.isUrlMedia()) {
                jSONObject.put("url", "https://mobile.umeng.com/images/pic/home/social/img-1.png");
            } else {
                jSONObject.put("url", thumbImage.asUrlImage());
            }
            int[] m12664g = m12664g();
            jSONObject.put(SocializeProtocolConstants.WIDTH, m12664g[0]);
            jSONObject.put(SocializeProtocolConstants.HEIGHT, m12664g[1]);
        } catch (JSONException e2) {
            SLog.error(e2);
        }
        return jSONObject;
    }

    /* renamed from: i */
    private JSONObject m12666i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f13692c.toUrl());
        } catch (JSONException e2) {
            SLog.error(e2);
        }
        return jSONObject;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    protected String getPath() {
        return f13690a + SocializeUtils.getAppkey(this.mContext) + "/" + Config.EntityKey + "/";
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        super.onPrepareRequest();
        addStringParams("linkcard_info", m12658a().toString());
    }

    public void setMedia(BaseMediaObject baseMediaObject) {
        this.f13692c = baseMediaObject;
    }
}
