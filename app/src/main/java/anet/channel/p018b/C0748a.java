package anet.channel.p018b;

import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.taobao.alivfssdk.cache.AVFSCache;
import com.taobao.alivfssdk.cache.AVFSCacheConfig;
import com.taobao.alivfssdk.cache.AVFSCacheManager;
import com.taobao.alivfssdk.cache.IAVFSCache;
import p000a.p001a.p002j.InterfaceC0009a;

/* compiled from: Taobao */
/* renamed from: anet.channel.b.a */
/* loaded from: classes.dex */
public class C0748a implements InterfaceC0009a {

    /* renamed from: a */
    private static boolean f757a = true;

    /* renamed from: b */
    private static Object f758b;

    /* renamed from: c */
    private static Object f759c;

    /* renamed from: d */
    private static Object f760d;

    static {
        try {
            Class.forName("com.taobao.alivfssdk.cache.AVFSCacheManager");
            f758b = new C0749b();
            f759c = new C0750c();
            f760d = new C0751d();
        } catch (ClassNotFoundException unused) {
            f757a = false;
            ALog.m718w("anet.AVFSCacheImpl", "no alivfs sdk!", null, new Object[0]);
        }
    }

    /* renamed from: b */
    private IAVFSCache m444b() {
        AVFSCache cacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache");
        if (cacheForModule != null) {
            return cacheForModule.getFileCache();
        }
        return null;
    }

    /* renamed from: a */
    public void m445a() {
        AVFSCache cacheForModule;
        if (f757a && (cacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache")) != null) {
            AVFSCacheConfig aVFSCacheConfig = new AVFSCacheConfig();
            aVFSCacheConfig.limitSize = 5242880L;
            aVFSCacheConfig.fileMemMaxSize = 1048576L;
            cacheForModule.moduleConfig(aVFSCacheConfig);
        }
    }

    @Override // p000a.p001a.p002j.InterfaceC0009a
    public void clear() {
        if (f757a) {
            try {
                IAVFSCache m444b = m444b();
                if (m444b != null) {
                    m444b.removeAllObject((IAVFSCache.OnAllObjectRemoveCallback) f760d);
                }
            } catch (Exception e2) {
                ALog.m714e("anet.AVFSCacheImpl", "clear cache failed", null, e2, new Object[0]);
            }
        }
    }

    @Override // p000a.p001a.p002j.InterfaceC0009a
    public InterfaceC0009a.a get(String str) {
        if (!f757a) {
            return null;
        }
        try {
            IAVFSCache m444b = m444b();
            if (m444b != null) {
                return (InterfaceC0009a.a) m444b.objectForKey(StringUtils.md5ToHex(str));
            }
        } catch (Exception e2) {
            ALog.m714e("anet.AVFSCacheImpl", "get cache failed", null, e2, new Object[0]);
        }
        return null;
    }

    @Override // p000a.p001a.p002j.InterfaceC0009a
    public void put(String str, InterfaceC0009a.a aVar) {
        if (f757a) {
            try {
                IAVFSCache m444b = m444b();
                if (m444b != null) {
                    m444b.setObjectForKey(StringUtils.md5ToHex(str), aVar, (IAVFSCache.OnObjectSetCallback) f758b);
                }
            } catch (Exception e2) {
                ALog.m714e("anet.AVFSCacheImpl", "put cache failed", null, e2, new Object[0]);
            }
        }
    }

    @Override // p000a.p001a.p002j.InterfaceC0009a
    public void remove(String str) {
        if (f757a) {
            try {
                IAVFSCache m444b = m444b();
                if (m444b != null) {
                    m444b.removeObjectForKey(StringUtils.md5ToHex(str), (IAVFSCache.OnObjectRemoveCallback) f759c);
                }
            } catch (Exception e2) {
                ALog.m714e("anet.AVFSCacheImpl", "remove cache failed", null, e2, new Object[0]);
            }
        }
    }
}
