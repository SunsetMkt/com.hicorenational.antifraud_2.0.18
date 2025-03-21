package com.umeng.message.tag;

import android.app.Application;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushTagCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.proguard.C3569ar;
import com.umeng.message.proguard.C3573av;
import com.umeng.message.proguard.C3578b;
import com.umeng.message.proguard.C3584d;
import com.umeng.message.proguard.C3585e;
import com.umeng.message.proguard.C3586f;
import com.umeng.message.proguard.C3604x;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TagManager {

    /* renamed from: b */
    private static volatile TagManager f13414b;

    /* renamed from: a */
    private final ITagManager f13415a = new C3569ar();

    @Deprecated
    public interface TCallBack extends UPushTagCallback<ITagManager.Result> {
    }

    @Deprecated
    public interface TagListCallBack extends UPushTagCallback<List<String>> {
    }

    private TagManager() {
    }

    /* renamed from: b */
    static /* synthetic */ boolean m12476b() {
        boolean z = MessageSharedPrefs.getInstance(C3604x.m12460a()).f13043b.m12288b("tag_send_policy", -1) == 1;
        if (z) {
            UPLog.m12142d("TagManager", "tag server disable!");
        }
        return z;
    }

    /* renamed from: d */
    static /* synthetic */ JSONObject m12478d() throws JSONException {
        Application m12460a = C3604x.m12460a();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", C3585e.m12377a());
        jSONObject.put("utdid", C3584d.m12371o(m12460a));
        jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, MessageSharedPrefs.getInstance(m12460a).m12131k());
        jSONObject.put("ts", System.currentTimeMillis());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static ITagManager.Result m12479e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", ITagManager.SUCCESS);
            jSONObject.put("remain", MessageSharedPrefs.getInstance(C3604x.m12460a()).m12124d());
        } catch (Exception e2) {
            UPLog.m12143e("TagManager", e2);
        }
        return new ITagManager.Result(jSONObject);
    }

    public static TagManager getInstance() {
        if (f13414b == null) {
            synchronized (TagManager.class) {
                if (f13414b == null) {
                    f13414b = new TagManager();
                }
            }
        }
        return f13414b;
    }

    public void addTags(final UPushTagCallback<ITagManager.Result> uPushTagCallback, final String... strArr) {
        C3578b.m12325b(new Runnable() { // from class: com.umeng.message.tag.TagManager.1
            @Override // java.lang.Runnable
            public final void run() {
                ITagManager.Result result = new ITagManager.Result();
                boolean z = false;
                try {
                    if (strArr != null && strArr.length != 0) {
                        if (TagManager.m12475a()) {
                            UPLog.m12144e("TagManager", "No utdid or device_token");
                            result.setErrors("No utdid or device_token");
                            try {
                                return;
                            } catch (Throwable th) {
                                return;
                            }
                        }
                        if (TagManager.m12476b()) {
                            UPLog.m12144e("TagManager", "Tag api is disabled by the server");
                            result.setErrors("Tag api is disabled by the server");
                            try {
                                uPushTagCallback.onMessage(false, result);
                                return;
                            } catch (Throwable th2) {
                                UPLog.m12143e("TagManager", th2);
                                return;
                            }
                        }
                        Application m12460a = C3604x.m12460a();
                        ArrayList arrayList = new ArrayList();
                        Set<String> m12291b = MessageSharedPrefs.getInstance(m12460a).f13043b.m12291b(SocializeProtocolConstants.TAGS, new HashSet());
                        for (String str : strArr) {
                            if (!m12291b.contains(str) && !arrayList.contains(str)) {
                                byte[] bytes = str.getBytes();
                                if (bytes == null || bytes.length > 128 || bytes.length <= 0) {
                                    UPLog.m12144e("TagManager", "tag length must be 1~128 byte");
                                    result.setErrors("tag length must be 1~128 byte");
                                    try {
                                        uPushTagCallback.onMessage(false, result);
                                        return;
                                    } catch (Throwable th3) {
                                        UPLog.m12143e("TagManager", th3);
                                        return;
                                    }
                                }
                                arrayList.add(str);
                            }
                        }
                        if (arrayList.size() > MessageSharedPrefs.getInstance(m12460a).m12124d()) {
                            UPLog.m12144e("TagManager", "tag count limit");
                            result.setErrors("tag count limit");
                            try {
                                uPushTagCallback.onMessage(false, result);
                                return;
                            } catch (Throwable th4) {
                                UPLog.m12143e("TagManager", th4);
                                return;
                            }
                        }
                        if (!MessageSharedPrefs.getInstance(m12460a).m12119a("tag_add_")) {
                            UPLog.m12144e("TagManager", "interval limit");
                            result.setErrors("interval limit");
                            try {
                                uPushTagCallback.onMessage(false, result);
                                return;
                            } catch (Throwable th5) {
                                UPLog.m12143e("TagManager", th5);
                                return;
                            }
                        }
                        if (arrayList.size() == 0) {
                            try {
                                uPushTagCallback.onMessage(true, TagManager.m12479e());
                                return;
                            } catch (Throwable th6) {
                                UPLog.m12143e("TagManager", th6);
                                return;
                            }
                        }
                        try {
                            JSONObject m12478d = TagManager.m12478d();
                            m12478d.put(SocializeProtocolConstants.TAGS, C3573av.m12307a(arrayList));
                            result = TagManager.this.f13415a.addTags(m12478d, strArr);
                            z = true;
                        } catch (Exception e2) {
                            UPLog.m12143e("TagManager", e2);
                        }
                        try {
                            uPushTagCallback.onMessage(z, result);
                            return;
                        } catch (Throwable th7) {
                            UPLog.m12143e("TagManager", th7);
                            return;
                        }
                    }
                    UPLog.m12144e("TagManager", "No tags");
                    result.setErrors("No tags");
                    try {
                        uPushTagCallback.onMessage(false, result);
                    } catch (Throwable th8) {
                        UPLog.m12143e("TagManager", th8);
                    }
                } catch (Throwable th9) {
                    try {
                        UPLog.m12143e("TagManager", th9);
                        try {
                            uPushTagCallback.onMessage(false, result);
                        } catch (Throwable th10) {
                            UPLog.m12143e("TagManager", th10);
                        }
                    } finally {
                        try {
                            uPushTagCallback.onMessage(false, result);
                        } catch (Throwable th11) {
                            UPLog.m12143e("TagManager", th11);
                        }
                    }
                }
            }
        });
    }

    public void deleteTags(final UPushTagCallback<ITagManager.Result> uPushTagCallback, final String... strArr) {
        C3578b.m12325b(new Runnable() { // from class: com.umeng.message.tag.TagManager.2
            @Override // java.lang.Runnable
            public final void run() {
                int i2;
                ITagManager.Result result = new ITagManager.Result();
                boolean z = false;
                try {
                    Application m12460a = C3604x.m12460a();
                    if (strArr != null && strArr.length > 0) {
                        String[] strArr2 = strArr;
                        int length = strArr2.length;
                        while (i2 < length) {
                            byte[] bytes = strArr2[i2].getBytes();
                            i2 = (bytes != null && bytes.length <= 128 && bytes.length > 0) ? i2 + 1 : 0;
                            result.setErrors("tag length must be 1~128 byte.");
                            try {
                                return;
                            } catch (Throwable th) {
                                return;
                            }
                        }
                    }
                    if (!MessageSharedPrefs.getInstance(m12460a).m12119a("tag_del_")) {
                        UPLog.m12144e("TagManager", "interval limit");
                        result.setErrors("interval limit");
                        try {
                            uPushTagCallback.onMessage(false, result);
                            return;
                        } catch (Throwable th2) {
                            UPLog.m12143e("TagManager", th2);
                            return;
                        }
                    }
                    if (TagManager.m12476b()) {
                        result.setErrors("tag server disable.");
                        try {
                            uPushTagCallback.onMessage(false, result);
                            return;
                        } catch (Throwable th3) {
                            UPLog.m12143e("TagManager", th3);
                            return;
                        }
                    }
                    if (TagManager.m12475a()) {
                        result.setErrors("check request failed.");
                        try {
                            uPushTagCallback.onMessage(false, result);
                            return;
                        } catch (Throwable th4) {
                            UPLog.m12143e("TagManager", th4);
                            return;
                        }
                    }
                    if (strArr == null || strArr.length == 0) {
                        UPLog.m12144e("TagManager", "No tags.");
                        result.setErrors("No tags.");
                        try {
                            uPushTagCallback.onMessage(true, result);
                            return;
                        } catch (Throwable th5) {
                            UPLog.m12143e("TagManager", th5);
                            return;
                        }
                    }
                    try {
                        JSONObject m12478d = TagManager.m12478d();
                        String[] strArr3 = strArr;
                        m12478d.put(SocializeProtocolConstants.TAGS, strArr3 == null ? "" : C3573av.m12307a(Arrays.asList(strArr3)));
                        result = TagManager.this.f13415a.deleteTags(m12478d, strArr);
                        z = true;
                    } catch (Exception e2) {
                        UPLog.m12143e("TagManager", e2);
                    }
                    try {
                        uPushTagCallback.onMessage(z, result);
                    } catch (Throwable th6) {
                        UPLog.m12143e("TagManager", th6);
                    }
                } catch (Throwable th7) {
                    try {
                        UPLog.m12143e("TagManager", th7);
                        try {
                            uPushTagCallback.onMessage(false, result);
                        } catch (Throwable th8) {
                            UPLog.m12143e("TagManager", th8);
                        }
                    } finally {
                        try {
                            uPushTagCallback.onMessage(false, result);
                        } catch (Throwable th9) {
                            UPLog.m12143e("TagManager", th9);
                        }
                    }
                }
            }
        });
    }

    public void getTags(final UPushTagCallback<List<String>> uPushTagCallback) {
        C3578b.m12325b(new Runnable() { // from class: com.umeng.message.tag.TagManager.3
            @Override // java.lang.Runnable
            public final void run() {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                try {
                    if (!MessageSharedPrefs.getInstance(C3604x.m12460a()).m12119a("tag_add_")) {
                        UPLog.m12144e("TagManager", "interval limit");
                        try {
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    if (TagManager.m12476b()) {
                        try {
                            uPushTagCallback.onMessage(false, arrayList);
                            return;
                        } catch (Throwable th2) {
                            UPLog.m12143e("TagManager", th2);
                            return;
                        }
                    }
                    if (TagManager.m12475a()) {
                        try {
                            uPushTagCallback.onMessage(false, arrayList);
                            return;
                        } catch (Throwable th3) {
                            UPLog.m12143e("TagManager", th3);
                            return;
                        }
                    }
                    try {
                        List<String> tags = TagManager.this.f13415a.getTags(TagManager.m12478d());
                        if (tags != null && tags.size() > 0) {
                            arrayList.addAll(tags);
                        }
                        z = true;
                    } catch (Exception e2) {
                        UPLog.m12144e("TagManager", "getTags error:", e2);
                    }
                    try {
                        uPushTagCallback.onMessage(z, arrayList);
                    } catch (Throwable th4) {
                        UPLog.m12143e("TagManager", th4);
                    }
                } catch (Throwable th5) {
                    try {
                        UPLog.m12143e("TagManager", th5);
                        try {
                            uPushTagCallback.onMessage(false, arrayList);
                        } catch (Throwable th6) {
                            UPLog.m12143e("TagManager", th6);
                        }
                    } finally {
                        try {
                            uPushTagCallback.onMessage(false, arrayList);
                        } catch (Throwable th7) {
                            UPLog.m12143e("TagManager", th7);
                        }
                    }
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ boolean m12475a() {
        if (TextUtils.isEmpty(C3584d.m12371o(C3604x.m12460a()))) {
            UPLog.m12144e("TagManager", "utdid empty.");
            return true;
        }
        if (C3586f.m12389b()) {
            UPLog.m12142d("TagManager", "check tag failed, silent mode!");
            return true;
        }
        if (!TextUtils.isEmpty(PushAgent.getInstance(C3604x.m12460a()).getRegistrationId())) {
            return false;
        }
        UPLog.m12144e("TagManager", "deviceToken empty.");
        return true;
    }
}
