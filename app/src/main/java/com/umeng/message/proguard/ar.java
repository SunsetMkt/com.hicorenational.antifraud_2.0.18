package com.umeng.message.proguard;

import android.app.Application;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ar implements ITagManager {
    @Override // com.umeng.message.common.inter.ITagManager
    public final ITagManager.Result addTags(JSONObject jSONObject, String... strArr) throws Exception {
        Application a2 = x.a();
        ITagManager.Result result = new ITagManager.Result(g.a(jSONObject, "https://msg.umengcloud.com/v3/tag/add", UMUtils.getAppkey(a2)));
        if (TextUtils.equals(result.status, ITagManager.SUCCESS)) {
            MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a2);
            messageSharedPrefs.a(strArr);
            messageSharedPrefs.a(result.remain);
            messageSharedPrefs.a("tag_add_", result.interval);
        }
        return result;
    }

    @Override // com.umeng.message.common.inter.ITagManager
    public final ITagManager.Result deleteTags(JSONObject jSONObject, String... strArr) throws Exception {
        Application a2 = x.a();
        ITagManager.Result result = new ITagManager.Result(g.a(jSONObject, "https://msg.umengcloud.com/v3/tag/delete", UMUtils.getAppkey(a2)));
        if (TextUtils.equals(result.status, ITagManager.SUCCESS)) {
            MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a2);
            if (strArr != null && strArr.length != 0) {
                Set<String> b2 = messageSharedPrefs.f11128b.b(SocializeProtocolConstants.TAGS, new HashSet());
                for (String str : strArr) {
                    b2.remove(str);
                }
                messageSharedPrefs.f11128b.a(SocializeProtocolConstants.TAGS, b2);
            }
            messageSharedPrefs.a(result.remain);
            messageSharedPrefs.a("tag_del_", result.interval);
        }
        return result;
    }

    @Override // com.umeng.message.common.inter.ITagManager
    public final List<String> getTags(JSONObject jSONObject) throws Exception {
        Application a2 = x.a();
        JSONObject a3 = g.a(jSONObject, "https://msg.umengcloud.com/v3/tag/get", UMUtils.getAppkey(a2));
        if (a3 == null) {
            return null;
        }
        ITagManager.Result result = new ITagManager.Result(a3);
        if (!TextUtils.equals(result.status, ITagManager.SUCCESS)) {
            return null;
        }
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a2);
        messageSharedPrefs.a(result.remain);
        messageSharedPrefs.a("tag_get_", result.interval);
        String optString = a3.optString(SocializeProtocolConstants.TAGS);
        if (optString.length() <= 0) {
            return null;
        }
        String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        List<String> asList = Arrays.asList(split);
        messageSharedPrefs.f11128b.a(SocializeProtocolConstants.TAGS);
        messageSharedPrefs.a(split);
        return asList;
    }
}
