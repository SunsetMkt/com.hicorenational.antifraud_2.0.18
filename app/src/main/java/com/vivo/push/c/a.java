package com.vivo.push.c;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import bean.SurveyH5Bean;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.vivo.push.util.u;
import com.vivo.push.x;
import java.util.HashMap;

/* JADX INFO: compiled from: CoreConfigManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, String> f8475b = new HashMap<>();

    public a(Context context) {
        this.a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int e() throws Throwable {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        if (this.a == null) {
            return JosStatusCodes.RNT_CODE_NO_JOS_INFO;
        }
        if (this.f8475b.size() > 0) {
            return 0;
        }
        Cursor cursorQuery = 0;
        cursorQuery = 0;
        try {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient = this.a.getContentResolver().acquireUnstableContentProviderClient(x.a);
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        try {
                            cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(x.a, null, null, null, null);
                        } catch (Exception e2) {
                            e = e2;
                            u.a("CoreConfigManager", "provider exception", e);
                            if (0 != 0) {
                                try {
                                    cursorQuery.close();
                                } catch (Exception e3) {
                                    u.a("CoreConfigManager", "close err ", e3);
                                    return 8005;
                                }
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient == null || Build.VERSION.SDK_INT < 24) {
                                return 8005;
                            }
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                            return 8005;
                        }
                    }
                } else {
                    contentProviderClientAcquireUnstableContentProviderClient = null;
                }
                if (cursorQuery == 0) {
                    cursorQuery = this.a.getContentResolver().query(x.a, null, null, null, null);
                }
                if (cursorQuery == 0) {
                    u.a("CoreConfigManager", "cursor is null");
                    if (cursorQuery != 0) {
                        try {
                            cursorQuery.close();
                        } catch (Exception e4) {
                            u.a("CoreConfigManager", "close err ", e4);
                            return 8008;
                        }
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient == null || Build.VERSION.SDK_INT < 24) {
                        return 8008;
                    }
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                    return 8008;
                }
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex(CommonNetImpl.NAME));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(SurveyH5Bean.VALUE));
                    if (!TextUtils.isEmpty(string)) {
                        this.f8475b.put(string, string2);
                    }
                }
                if (cursorQuery != 0) {
                    try {
                        cursorQuery.close();
                    } catch (Exception e5) {
                        u.a("CoreConfigManager", "close err ", e5);
                    }
                }
                if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                }
                return 0;
            } catch (Exception e6) {
                e = e6;
                contentProviderClientAcquireUnstableContentProviderClient = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                }
                if (0 != 0) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                try {
                    cursorQuery.close();
                } catch (Exception e7) {
                    u.a("CoreConfigManager", "close err ", e7);
                    throw th;
                }
            }
            if (0 != 0 && Build.VERSION.SDK_INT >= 24) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final int a() throws Throwable {
        int iA = a(1);
        u.d("CoreConfigManager", "isSupportNewControlStrategies : ".concat(String.valueOf(iA)));
        return iA;
    }

    public final int b() throws Throwable {
        int iA = a(4);
        u.d("CoreConfigManager", "isSupportSyncProfileInfo : ".concat(String.valueOf(iA)));
        return iA;
    }

    public final boolean c() throws Throwable {
        int iA = a(8);
        u.d("CoreConfigManager", "isSupportdeleteRegid : ".concat(String.valueOf(iA)));
        return iA == 0;
    }

    public final boolean d() throws Throwable {
        int iA = a(16);
        u.d("CoreConfigManager", "isSupportQueryCurrentAppState : ".concat(String.valueOf(iA)));
        return iA == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00b2 A[Catch: Exception -> 0x008d, TRY_ENTER, TryCatch #0 {Exception -> 0x008d, blocks: (B:41:0x0089, B:45:0x0091, B:47:0x0095, B:60:0x00b2, B:62:0x00b7, B:64:0x00bb), top: B:79:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b7 A[Catch: Exception -> 0x008d, TryCatch #0 {Exception -> 0x008d, blocks: (B:41:0x0089, B:45:0x0091, B:47:0x0095, B:60:0x00b2, B:62:0x00b7, B:64:0x00bb), top: B:79:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cb A[Catch: Exception -> 0x00c7, TryCatch #5 {Exception -> 0x00c7, blocks: (B:69:0x00c3, B:73:0x00cb, B:75:0x00cf), top: B:80:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) throws Throwable {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        Cursor cursorQuery;
        Cursor cursorQuery2;
        Cursor cursor = null;
        cursor = null;
        string = null;
        string = null;
        string = null;
        String string = null;
        try {
            try {
            } catch (Exception e2) {
                e = e2;
                contentProviderClientAcquireUnstableContentProviderClient = null;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                contentProviderClientAcquireUnstableContentProviderClient = null;
            }
        } catch (Exception e3) {
            u.a("CoreConfigManager", "queryFromCoreSdk close error", e3);
        }
        if (context == null) {
            u.a("CoreConfigManager", "queryFromCoreSdk context is null");
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(x.f8701f);
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                try {
                    u.a("CoreConfigManager", "queryFromCoreSdk client is null");
                    cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(x.f8701f, null, "queryParameter = ?  ", new String[]{str}, null);
                } catch (Exception e4) {
                    e = e4;
                    cursorQuery = null;
                    u.a("CoreConfigManager", "queryFromCoreSdk error ", e);
                    if (cursorQuery != null) {
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                    return string;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                    throw th;
                }
            } else {
                cursorQuery = null;
            }
        } else {
            contentProviderClientAcquireUnstableContentProviderClient = null;
            cursorQuery = null;
        }
        if (cursorQuery == null) {
            try {
                try {
                    cursorQuery2 = context.getContentResolver().query(x.f8701f, null, "queryParameter = ?  ", new String[]{str}, null);
                } catch (Throwable th3) {
                    th = th3;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e5) {
                            u.a("CoreConfigManager", "queryFromCoreSdk close error", e5);
                            throw th;
                        }
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                u.a("CoreConfigManager", "queryFromCoreSdk error ", e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                }
                return string;
            }
        } else {
            cursorQuery2 = cursorQuery;
        }
        try {
        } catch (Exception e7) {
            cursorQuery = cursorQuery2;
            e = e7;
            u.a("CoreConfigManager", "queryFromCoreSdk error ", e);
            if (cursorQuery != null) {
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
            }
        } catch (Throwable th4) {
            cursor = cursorQuery2;
            th = th4;
            if (cursor != null) {
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
            }
            throw th;
        }
        if (cursorQuery2 == null) {
            u.a("CoreConfigManager", "queryFromCoreSdk cursor is null");
            if (cursorQuery2 != null) {
                try {
                    cursorQuery2.close();
                } catch (Exception e8) {
                    u.a("CoreConfigManager", "queryFromCoreSdk close error", e8);
                }
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.close();
            }
            return null;
        }
        string = cursorQuery2.moveToFirst() ? cursorQuery2.getString(cursorQuery2.getColumnIndex("queryAppState")) : null;
        if (cursorQuery2 != null) {
            cursorQuery2.close();
        }
        if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
            contentProviderClientAcquireUnstableContentProviderClient.close();
        }
        return string;
    }

    private int a(int i2) throws Throwable {
        int iE = e();
        if (iE != 0) {
            return iE;
        }
        HashMap<String, String> map = this.f8475b;
        if (map == null || map.size() == 0) {
            return 8006;
        }
        String str = this.f8475b.get("pushSupport");
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        try {
            return (i2 & Integer.parseInt(str)) > 0 ? 0 : 1;
        } catch (Exception unused) {
            return 8007;
        }
    }
}
