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

/* renamed from: com.umeng.message.proguard.ar */
/* loaded from: classes2.dex */
public final class C3569ar implements ITagManager {
    @Override // com.umeng.message.common.inter.ITagManager
    public final ITagManager.Result addTags(JSONObject jSONObject, String... strArr) throws Exception {
        Application m12460a = C3604x.m12460a();
        ITagManager.Result result = new ITagManager.Result(C3587g.m12398a(jSONObject, "https://msg.umengcloud.com/v3/tag/add", UMUtils.getAppkey(m12460a)));
        if (TextUtils.equals(result.status, ITagManager.SUCCESS)) {
            MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(m12460a);
            messageSharedPrefs.m12116a(strArr);
            messageSharedPrefs.m12113a(result.remain);
            messageSharedPrefs.m12114a("tag_add_", result.interval);
        }
        return result;
    }

    @Override // com.umeng.message.common.inter.ITagManager
    public final ITagManager.Result deleteTags(JSONObject jSONObject, String... strArr) throws Exception {
        Application m12460a = C3604x.m12460a();
        ITagManager.Result result = new ITagManager.Result(C3587g.m12398a(jSONObject, "https://msg.umengcloud.com/v3/tag/delete", UMUtils.getAppkey(m12460a)));
        if (TextUtils.equals(result.status, ITagManager.SUCCESS)) {
            MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(m12460a);
            if (strArr != null && strArr.length != 0) {
                Set<String> m12291b = messageSharedPrefs.f13043b.m12291b(SocializeProtocolConstants.TAGS, new HashSet());
                for (String str : strArr) {
                    m12291b.remove(str);
                }
                messageSharedPrefs.f13043b.m12286a(SocializeProtocolConstants.TAGS, m12291b);
            }
            messageSharedPrefs.m12113a(result.remain);
            messageSharedPrefs.m12114a("tag_del_", result.interval);
        }
        return result;
    }

    @Override // com.umeng.message.common.inter.ITagManager
    public final List<String> getTags(JSONObject jSONObject) throws Exception {
        Application m12460a = C3604x.m12460a();
        JSONObject m12398a = C3587g.m12398a(jSONObject, "https://msg.umengcloud.com/v3/tag/get", UMUtils.getAppkey(m12460a));
        if (m12398a == null) {
            return null;
        }
        ITagManager.Result result = new ITagManager.Result(m12398a);
        if (!TextUtils.equals(result.status, ITagManager.SUCCESS)) {
            return null;
        }
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(m12460a);
        messageSharedPrefs.m12113a(result.remain);
        messageSharedPrefs.m12114a("tag_get_", result.interval);
        String optString = m12398a.optString(SocializeProtocolConstants.TAGS);
        if (optString.length() <= 0) {
            return null;
        }
        String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        List<String> asList = Arrays.asList(split);
        messageSharedPrefs.f13043b.m12282a(SocializeProtocolConstants.TAGS);
        messageSharedPrefs.m12116a(split);
        return asList;
    }
}
