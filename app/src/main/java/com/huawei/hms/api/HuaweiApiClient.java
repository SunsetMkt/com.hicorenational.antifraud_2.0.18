package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Deprecated
/* loaded from: classes.dex */
public abstract class HuaweiApiClient implements AidlApiClient {

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i2);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public abstract void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener);

    public void connect(int i2) {
        throw new UnsupportedOperationException();
    }

    public abstract void connect(Activity activity);

    public abstract void connectForeground();

    public abstract void disableLifeCycleManagement(Activity activity);

    public abstract PendingResult<Status> discardAndReconnect();

    public abstract void disconnect();

    public abstract Map<Api<?>, Api.ApiOptions> getApiMap();

    public abstract ConnectionResult getConnectionResult(Api<?> api);

    public abstract List<PermissionInfo> getPermissionInfos();

    public abstract List<Scope> getScopes();

    public abstract Activity getTopActivity();

    public abstract boolean hasConnectedApi(Api<?> api);

    public abstract boolean hasConnectionFailureListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean hasConnectionSuccessListener(ConnectionCallbacks connectionCallbacks);

    public abstract ConnectionResult holdUpConnect();

    public abstract ConnectionResult holdUpConnect(long j2, TimeUnit timeUnit);

    @Override // com.huawei.hms.support.api.client.ApiClient
    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract void onPause(Activity activity);

    public abstract void onResume(Activity activity);

    public abstract void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void reconnect();

    public abstract void removeConnectionFailureListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void removeConnectionSuccessListener(ConnectionCallbacks connectionCallbacks);

    public abstract void setConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void setConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean setSubAppInfo(SubAppInfo subAppInfo);

    public static final class Builder {

        /* renamed from: a */
        private final Context f7118a;

        /* renamed from: b */
        private final List<Scope> f7119b = new ArrayList();

        /* renamed from: c */
        private final List<PermissionInfo> f7120c = new ArrayList();

        /* renamed from: d */
        private final Map<Api<?>, Api.ApiOptions> f7121d = new HashMap();

        /* renamed from: e */
        private OnConnectionFailedListener f7122e;

        /* renamed from: f */
        private ConnectionCallbacks f7123f;

        /* renamed from: g */
        private int f7124g;

        /* renamed from: h */
        private Activity f7125h;

        public Builder(Context context) throws NullPointerException {
            Checker.checkNonNull(context, "context must not be null.");
            Context applicationContext = context.getApplicationContext();
            this.f7118a = applicationContext;
            this.f7124g = -1;
            ResourceLoaderUtil.setmContext(applicationContext);
            m6619a(context);
        }

        /* renamed from: a */
        private void m6619a(Context context) {
            HMSBIInitializer.getInstance(context).initBI();
        }

        public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            this.f7121d.put(api, null);
            if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(api.getApiName())) {
                HiAnalyticsUtil.getInstance().onEvent(this.f7118a.getApplicationContext(), HiAnalyticsConstant.KeyAndValue.GAME_INIT_KEY, HiAnalyticsConstant.REPORT_VAL_SEPARATOR + System.currentTimeMillis());
            }
            return this;
        }

        public Builder addApiWithScope(Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopeArr) {
            Checker.checkNonNull(api, "Api must not be null");
            Checker.checkNonNull(scopeArr, "Scopes must not be null");
            this.f7121d.put(api, null);
            this.f7119b.addAll(new ArrayList(Arrays.asList(scopeArr)));
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            Checker.checkNonNull(connectionCallbacks, "listener must not be null.");
            this.f7123f = connectionCallbacks;
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            Checker.checkNonNull(onConnectionFailedListener, "listener must not be null.");
            this.f7122e = onConnectionFailedListener;
            return this;
        }

        public Builder addScope(Scope scope) {
            Checker.checkNonNull(scope, "scope must not be null.");
            this.f7119b.add(scope);
            return this;
        }

        public Builder allowLifeCycleManagement(Activity activity, int i2, OnConnectionFailedListener onConnectionFailedListener) {
            if (i2 < 0) {
                throw new IllegalArgumentException("allowLifeCycleManagement id should be positive");
            }
            this.f7124g = i2;
            this.f7125h = (Activity) Preconditions.checkNotNull(activity, "activity must not be Null.");
            return this;
        }

        public Builder applyDefaultAccount() {
            return this;
        }

        public HuaweiApiClient build() {
            addApi(new Api<>("Core.API"));
            HuaweiApiClientImpl huaweiApiClientImpl = new HuaweiApiClientImpl(this.f7118a);
            huaweiApiClientImpl.setScopes(this.f7119b);
            huaweiApiClientImpl.setPermissionInfos(this.f7120c);
            huaweiApiClientImpl.setApiMap(this.f7121d);
            huaweiApiClientImpl.setConnectionCallbacks(this.f7123f);
            huaweiApiClientImpl.setConnectionFailedListener(this.f7122e);
            huaweiApiClientImpl.setAutoLifecycleClientId(this.f7124g);
            if (this.f7124g >= 0) {
                m6620a(huaweiApiClientImpl);
            }
            return huaweiApiClientImpl;
        }

        public Builder setAccountName(String str) {
            return this;
        }

        public Builder setHandler(Handler handler) {
            return this;
        }

        public Builder setPopupsGravity(int i2) {
            return this;
        }

        public Builder setViewForPopups(View view) {
            return this;
        }

        /* renamed from: a */
        private void m6620a(HuaweiApiClient huaweiApiClient) {
            AutoLifecycleFragment.getInstance(this.f7125h).startAutoMange(this.f7124g, huaweiApiClient);
        }

        public Builder allowLifeCycleManagement(Activity activity, OnConnectionFailedListener onConnectionFailedListener) {
            return allowLifeCycleManagement(activity, 0, onConnectionFailedListener);
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApiWithScope(Api<O> api, O o, Scope... scopeArr) {
            Checker.checkNonNull(api, "Api must not be null");
            Checker.checkNonNull(o, "Null options are not permitted for this Api");
            Checker.checkNonNull(scopeArr, "Scopes must not be null");
            this.f7121d.put(api, o);
            if (api.getOptions() != null) {
                this.f7119b.addAll(api.getOptions().getScopeList(o));
                this.f7120c.addAll(api.getOptions().getPermissionInfoList(o));
            }
            this.f7119b.addAll(new ArrayList(Arrays.asList(scopeArr)));
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> api, O o) {
            Checker.checkNonNull(api, "Api must not be null");
            Checker.checkNonNull(o, "Null options are not permitted for this Api");
            this.f7121d.put(api, o);
            if (api.getOptions() != null) {
                this.f7119b.addAll(api.getOptions().getScopeList(o));
                this.f7120c.addAll(api.getOptions().getPermissionInfoList(o));
            }
            return this;
        }
    }
}
