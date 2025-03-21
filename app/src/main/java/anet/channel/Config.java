package anet.channel;

import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.security.C0807c;
import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.umeng.analytics.pro.C3336at;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class Config {

    /* renamed from: b */
    private String f661b;

    /* renamed from: c */
    private String f662c;

    /* renamed from: d */
    private ENV f663d = ENV.ONLINE;

    /* renamed from: e */
    private ISecurity f664e;

    /* renamed from: a */
    private static Map<String, Config> f660a = new HashMap();
    public static final Config DEFAULT_CONFIG = new Builder().setTag("[default]").setAppkey("[default]").setEnv(ENV.ONLINE).build();

    /* compiled from: Taobao */
    public static class Builder {

        /* renamed from: a */
        private String f665a;

        /* renamed from: b */
        private String f666b;

        /* renamed from: c */
        private ENV f667c = ENV.ONLINE;

        /* renamed from: d */
        private String f668d;

        /* renamed from: e */
        private String f669e;

        public Config build() {
            if (TextUtils.isEmpty(this.f666b)) {
                throw new RuntimeException("appkey can not be null or empty!");
            }
            synchronized (Config.f660a) {
                for (Config config : Config.f660a.values()) {
                    if (config.f663d == this.f667c && config.f662c.equals(this.f666b)) {
                        ALog.m718w("awcn.Config", "duplicated config exist!", null, "appkey", this.f666b, C3336at.f11487a, this.f667c);
                        if (!TextUtils.isEmpty(this.f665a)) {
                            Config.f660a.put(this.f665a, config);
                        }
                        return config;
                    }
                }
                Config config2 = new Config();
                config2.f662c = this.f666b;
                config2.f663d = this.f667c;
                if (TextUtils.isEmpty(this.f665a)) {
                    config2.f661b = StringUtils.concatString(this.f666b, "$", this.f667c.toString());
                } else {
                    config2.f661b = this.f665a;
                }
                if (TextUtils.isEmpty(this.f669e)) {
                    config2.f664e = C0807c.m581a().createSecurity(this.f668d);
                } else {
                    config2.f664e = C0807c.m581a().createNonSecurity(this.f669e);
                }
                synchronized (Config.f660a) {
                    Config.f660a.put(config2.f661b, config2);
                }
                return config2;
            }
        }

        public Builder setAppSecret(String str) {
            this.f669e = str;
            return this;
        }

        public Builder setAppkey(String str) {
            this.f666b = str;
            return this;
        }

        public Builder setAuthCode(String str) {
            this.f668d = str;
            return this;
        }

        public Builder setEnv(ENV env) {
            this.f667c = env;
            return this;
        }

        public Builder setTag(String str) {
            this.f665a = str;
            return this;
        }
    }

    protected Config() {
    }

    public static Config getConfig(String str, ENV env) {
        synchronized (f660a) {
            for (Config config : f660a.values()) {
                if (config.f663d == env && config.f662c.equals(str)) {
                    return config;
                }
            }
            return null;
        }
    }

    public static Config getConfigByTag(String str) {
        Config config;
        synchronized (f660a) {
            config = f660a.get(str);
        }
        return config;
    }

    public String getAppkey() {
        return this.f662c;
    }

    public ENV getEnv() {
        return this.f663d;
    }

    public ISecurity getSecurity() {
        return this.f664e;
    }

    public String getTag() {
        return this.f661b;
    }

    public String toString() {
        return this.f661b;
    }
}
