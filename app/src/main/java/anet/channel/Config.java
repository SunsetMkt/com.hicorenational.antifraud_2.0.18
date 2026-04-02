package anet.channel;

import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.umeng.analytics.pro.at;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public final class Config {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ENV f1327d = ENV.ONLINE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ISecurity f1328e;
    private static Map<String, Config> a = new HashMap();
    public static final Config DEFAULT_CONFIG = new Builder().setTag("[default]").setAppkey("[default]").setEnv(ENV.ONLINE).build();

    /* JADX INFO: compiled from: Taobao */
    public static class Builder {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f1329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ENV f1330c = ENV.ONLINE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f1331d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f1332e;

        public Config build() {
            if (TextUtils.isEmpty(this.f1329b)) {
                throw new RuntimeException("appkey can not be null or empty!");
            }
            synchronized (Config.a) {
                for (Config config : Config.a.values()) {
                    if (config.f1327d == this.f1330c && config.f1326c.equals(this.f1329b)) {
                        ALog.w("awcn.Config", "duplicated config exist!", null, "appkey", this.f1329b, at.a, this.f1330c);
                        if (!TextUtils.isEmpty(this.a)) {
                            Config.a.put(this.a, config);
                        }
                        return config;
                    }
                }
                Config config2 = new Config();
                config2.f1326c = this.f1329b;
                config2.f1327d = this.f1330c;
                if (TextUtils.isEmpty(this.a)) {
                    config2.f1325b = StringUtils.concatString(this.f1329b, "$", this.f1330c.toString());
                } else {
                    config2.f1325b = this.a;
                }
                if (TextUtils.isEmpty(this.f1332e)) {
                    config2.f1328e = anet.channel.security.c.a().createSecurity(this.f1331d);
                } else {
                    config2.f1328e = anet.channel.security.c.a().createNonSecurity(this.f1332e);
                }
                synchronized (Config.a) {
                    Config.a.put(config2.f1325b, config2);
                }
                return config2;
            }
        }

        public Builder setAppSecret(String str) {
            this.f1332e = str;
            return this;
        }

        public Builder setAppkey(String str) {
            this.f1329b = str;
            return this;
        }

        public Builder setAuthCode(String str) {
            this.f1331d = str;
            return this;
        }

        public Builder setEnv(ENV env) {
            this.f1330c = env;
            return this;
        }

        public Builder setTag(String str) {
            this.a = str;
            return this;
        }
    }

    protected Config() {
    }

    public static Config getConfig(String str, ENV env) {
        synchronized (a) {
            for (Config config : a.values()) {
                if (config.f1327d == env && config.f1326c.equals(str)) {
                    return config;
                }
            }
            return null;
        }
    }

    public static Config getConfigByTag(String str) {
        Config config;
        synchronized (a) {
            config = a.get(str);
        }
        return config;
    }

    public String getAppkey() {
        return this.f1326c;
    }

    public ENV getEnv() {
        return this.f1327d;
    }

    public ISecurity getSecurity() {
        return this.f1328e;
    }

    public String getTag() {
        return this.f1325b;
    }

    public String toString() {
        return this.f1325b;
    }
}
