package com.just.agentweb;

import android.app.Activity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.just.agentweb.DefaultWebClient;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public final class AgentWeb {
    private static final int ACTIVITY_TAG = 0;
    private static final int FRAGMENT_TAG = 1;
    private static final String TAG = "AgentWeb";
    private Activity mActivity;
    private AgentWeb mAgentWeb;
    private AgentWebJsInterfaceCompat mAgentWebJsInterfaceCompat;
    private IAgentWebSettings mAgentWebSettings;
    private boolean mEnableIndicator;
    private EventInterceptor mEventInterceptor;
    private IEventHandler mIEventHandler;
    private IUrlLoader mIUrlLoader;
    private IVideo mIVideo;
    private IndicatorController mIndicatorController;
    private boolean mIsInterceptUnkownUrl;
    private ArrayMap<String, Object> mJavaObjects;
    private JsAccessEntrace mJsAccessEntrace;
    private JsInterfaceHolder mJsInterfaceHolder;
    private MiddlewareWebClientBase mMiddleWrareWebClientBaseHeader;
    private MiddlewareWebChromeBase mMiddlewareWebChromeBaseHeader;
    private PermissionInterceptor mPermissionInterceptor;
    private SecurityType mSecurityType;
    private int mTagTarget;
    private android.webkit.WebChromeClient mTargetChromeClient;
    private int mUrlHandleWays;
    private ViewGroup mViewGroup;
    private WebChromeClient mWebChromeClient;
    private boolean mWebClientHelper;
    private WebCreator mWebCreator;
    private WebLifeCycle mWebLifeCycle;
    private WebListenerManager mWebListenerManager;
    private WebSecurityCheckLogic mWebSecurityCheckLogic;
    private WebSecurityController<WebSecurityCheckLogic> mWebSecurityController;
    private WebViewClient mWebViewClient;

    public static class CommonBuilder {
        private AgentBuilder mAgentBuilder;

        public CommonBuilder(AgentBuilder agentBuilder) {
            this.mAgentBuilder = agentBuilder;
        }

        public CommonBuilder addJavascriptInterface(@NonNull String str, @NonNull Object obj) {
            this.mAgentBuilder.addJavaObject(str, obj);
            return this;
        }

        public CommonBuilder additionalHttpHeader(String str, String str2, String str3) {
            this.mAgentBuilder.addHeader(str, str2, str3);
            return this;
        }

        public CommonBuilder closeWebViewClientHelper() {
            this.mAgentBuilder.mWebClientHelper = false;
            return this;
        }

        public PreAgentWeb createAgentWeb() {
            return this.mAgentBuilder.buildAgentWeb();
        }

        public CommonBuilder interceptUnkownUrl() {
            this.mAgentBuilder.mIsInterceptUnkownUrl = true;
            return this;
        }

        public CommonBuilder setAgentWebUIController(@Nullable AgentWebUIControllerImplBase agentWebUIControllerImplBase) {
            this.mAgentBuilder.mAgentWebUIController = agentWebUIControllerImplBase;
            return this;
        }

        public CommonBuilder setAgentWebWebSettings(@Nullable IAgentWebSettings iAgentWebSettings) {
            this.mAgentBuilder.mAgentWebSettings = iAgentWebSettings;
            return this;
        }

        public CommonBuilder setEventHanadler(@Nullable IEventHandler iEventHandler) {
            this.mAgentBuilder.mIEventHandler = iEventHandler;
            return this;
        }

        public CommonBuilder setMainFrameErrorView(@NonNull View view) {
            this.mAgentBuilder.mErrorView = view;
            return this;
        }

        public CommonBuilder setOpenOtherPageWays(@Nullable DefaultWebClient.OpenOtherPageWays openOtherPageWays) {
            this.mAgentBuilder.mOpenOtherPage = openOtherPageWays;
            return this;
        }

        public CommonBuilder setPermissionInterceptor(@Nullable PermissionInterceptor permissionInterceptor) {
            this.mAgentBuilder.mPermissionInterceptor = permissionInterceptor;
            return this;
        }

        public CommonBuilder setSecurityType(@NonNull SecurityType securityType) {
            this.mAgentBuilder.mSecurityType = securityType;
            return this;
        }

        public CommonBuilder setWebChromeClient(@Nullable WebChromeClient webChromeClient) {
            this.mAgentBuilder.mWebChromeClient = webChromeClient;
            return this;
        }

        public CommonBuilder setWebLayout(@Nullable IWebLayout iWebLayout) {
            this.mAgentBuilder.mWebLayout = iWebLayout;
            return this;
        }

        public CommonBuilder setWebView(@Nullable WebView webView) {
            this.mAgentBuilder.mWebView = webView;
            return this;
        }

        public CommonBuilder setWebViewClient(@Nullable WebViewClient webViewClient) {
            this.mAgentBuilder.mWebViewClient = webViewClient;
            return this;
        }

        public CommonBuilder useMiddlewareWebChrome(@NonNull MiddlewareWebChromeBase middlewareWebChromeBase) {
            if (middlewareWebChromeBase == null) {
                return this;
            }
            if (this.mAgentBuilder.mChromeMiddleWareHeader == null) {
                AgentBuilder agentBuilder = this.mAgentBuilder;
                agentBuilder.mChromeMiddleWareHeader = agentBuilder.mChromeMiddleWareTail = middlewareWebChromeBase;
            } else {
                this.mAgentBuilder.mChromeMiddleWareTail.enq(middlewareWebChromeBase);
                this.mAgentBuilder.mChromeMiddleWareTail = middlewareWebChromeBase;
            }
            return this;
        }

        public CommonBuilder useMiddlewareWebClient(@NonNull MiddlewareWebClientBase middlewareWebClientBase) {
            if (middlewareWebClientBase == null) {
                return this;
            }
            if (this.mAgentBuilder.mMiddlewareWebClientBaseHeader == null) {
                AgentBuilder agentBuilder = this.mAgentBuilder;
                agentBuilder.mMiddlewareWebClientBaseHeader = agentBuilder.mMiddlewareWebClientBaseTail = middlewareWebClientBase;
            } else {
                this.mAgentBuilder.mMiddlewareWebClientBaseTail.enq(middlewareWebClientBase);
                this.mAgentBuilder.mMiddlewareWebClientBaseTail = middlewareWebClientBase;
            }
            return this;
        }

        public CommonBuilder additionalHttpHeader(String str, Map<String, String> map) {
            this.mAgentBuilder.addHeader(str, map);
            return this;
        }

        public CommonBuilder setMainFrameErrorView(@LayoutRes int i2, @IdRes int i3) {
            this.mAgentBuilder.mErrorLayout = i2;
            this.mAgentBuilder.mReloadId = i3;
            return this;
        }
    }

    private static final class PermissionInterceptorWrapper implements PermissionInterceptor {
        private WeakReference<PermissionInterceptor> mWeakReference;

        @Override // com.just.agentweb.PermissionInterceptor
        public boolean intercept(String str, String[] strArr, String str2) {
            if (this.mWeakReference.get() == null) {
                return false;
            }
            return this.mWeakReference.get().intercept(str, strArr, str2);
        }

        private PermissionInterceptorWrapper(PermissionInterceptor permissionInterceptor) {
            this.mWeakReference = new WeakReference<>(permissionInterceptor);
        }
    }

    public static class PreAgentWeb {
        private boolean isReady = false;
        private AgentWeb mAgentWeb;

        PreAgentWeb(AgentWeb agentWeb) {
            this.mAgentWeb = agentWeb;
        }

        public AgentWeb get() {
            ready();
            return this.mAgentWeb;
        }

        /* renamed from: go */
        public AgentWeb m8080go(@Nullable String str) {
            if (!this.isReady) {
                ready();
            }
            return this.mAgentWeb.m8079go(str);
        }

        public PreAgentWeb ready() {
            if (!this.isReady) {
                this.mAgentWeb.ready();
                this.isReady = true;
            }
            return this;
        }
    }

    public enum SecurityType {
        DEFAULT_CHECK,
        STRICT_CHECK
    }

    private WebCreator configWebCreator(BaseIndicatorView baseIndicatorView, int i2, ViewGroup.LayoutParams layoutParams, int i3, int i4, WebView webView, IWebLayout iWebLayout) {
        return (baseIndicatorView == null || !this.mEnableIndicator) ? this.mEnableIndicator ? new DefaultWebCreator(this.mActivity, this.mViewGroup, layoutParams, i2, i3, i4, webView, iWebLayout) : new DefaultWebCreator(this.mActivity, this.mViewGroup, layoutParams, i2, webView, iWebLayout) : new DefaultWebCreator(this.mActivity, this.mViewGroup, layoutParams, i2, baseIndicatorView, webView, iWebLayout);
    }

    private void doCompat() {
        ArrayMap<String, Object> arrayMap = this.mJavaObjects;
        AgentWebJsInterfaceCompat agentWebJsInterfaceCompat = new AgentWebJsInterfaceCompat(this, this.mActivity);
        this.mAgentWebJsInterfaceCompat = agentWebJsInterfaceCompat;
        arrayMap.put("agentWeb", agentWebJsInterfaceCompat);
    }

    private void doSafeCheck() {
        WebSecurityCheckLogic webSecurityCheckLogic = this.mWebSecurityCheckLogic;
        if (webSecurityCheckLogic == null) {
            webSecurityCheckLogic = WebSecurityLogicImpl.getInstance(this.mWebCreator.getWebViewType());
            this.mWebSecurityCheckLogic = webSecurityCheckLogic;
        }
        this.mWebSecurityController.check(webSecurityCheckLogic);
    }

    private android.webkit.WebChromeClient getChromeClient() {
        IndicatorController indicatorController = this.mIndicatorController;
        if (indicatorController == null) {
            indicatorController = IndicatorHandler.getInstance().inJectIndicator(this.mWebCreator.offer());
        }
        IndicatorController indicatorController2 = indicatorController;
        Activity activity = this.mActivity;
        this.mIndicatorController = indicatorController2;
        IVideo iVideo = getIVideo();
        this.mIVideo = iVideo;
        DefaultChromeClient defaultChromeClient = new DefaultChromeClient(activity, indicatorController2, null, iVideo, this.mPermissionInterceptor, this.mWebCreator.getWebView());
        LogUtils.m8083i(TAG, "WebChromeClient:" + this.mWebChromeClient);
        MiddlewareWebChromeBase middlewareWebChromeBase = this.mMiddlewareWebChromeBaseHeader;
        WebChromeClient webChromeClient = this.mWebChromeClient;
        if (webChromeClient != null) {
            webChromeClient.enq(middlewareWebChromeBase);
            middlewareWebChromeBase = this.mWebChromeClient;
        }
        if (middlewareWebChromeBase == null) {
            this.mTargetChromeClient = defaultChromeClient;
            return defaultChromeClient;
        }
        MiddlewareWebChromeBase middlewareWebChromeBase2 = middlewareWebChromeBase;
        int i2 = 1;
        while (middlewareWebChromeBase2.next() != null) {
            middlewareWebChromeBase2 = middlewareWebChromeBase2.next();
            i2++;
        }
        LogUtils.m8083i(TAG, "MiddlewareWebClientBase middleware count:" + i2);
        middlewareWebChromeBase2.setDelegate(defaultChromeClient);
        this.mTargetChromeClient = middlewareWebChromeBase;
        return middlewareWebChromeBase;
    }

    private IVideo getIVideo() {
        IVideo iVideo = this.mIVideo;
        return iVideo == null ? new VideoImpl(this.mActivity, this.mWebCreator.getWebView()) : iVideo;
    }

    private EventInterceptor getInterceptor() {
        EventInterceptor eventInterceptor = this.mEventInterceptor;
        if (eventInterceptor != null) {
            return eventInterceptor;
        }
        IVideo iVideo = this.mIVideo;
        if (!(iVideo instanceof VideoImpl)) {
            return null;
        }
        EventInterceptor eventInterceptor2 = (EventInterceptor) iVideo;
        this.mEventInterceptor = eventInterceptor2;
        return eventInterceptor2;
    }

    private android.webkit.WebViewClient getWebViewClient() {
        LogUtils.m8083i(TAG, "getDelegate:" + this.mMiddleWrareWebClientBaseHeader);
        DefaultWebClient build = DefaultWebClient.createBuilder().setActivity(this.mActivity).setWebClientHelper(this.mWebClientHelper).setPermissionInterceptor(this.mPermissionInterceptor).setWebView(this.mWebCreator.getWebView()).setInterceptUnkownUrl(this.mIsInterceptUnkownUrl).setUrlHandleWays(this.mUrlHandleWays).build();
        MiddlewareWebClientBase middlewareWebClientBase = this.mMiddleWrareWebClientBaseHeader;
        WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient != null) {
            webViewClient.enq(middlewareWebClientBase);
            middlewareWebClientBase = this.mWebViewClient;
        }
        if (middlewareWebClientBase == null) {
            return build;
        }
        MiddlewareWebClientBase middlewareWebClientBase2 = middlewareWebClientBase;
        int i2 = 1;
        while (middlewareWebClientBase2.next() != null) {
            middlewareWebClientBase2 = middlewareWebClientBase2.next();
            i2++;
        }
        LogUtils.m8083i(TAG, "MiddlewareWebClientBase middleware count:" + i2);
        middlewareWebClientBase2.setDelegate(build);
        return middlewareWebClientBase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: go */
    public AgentWeb m8079go(String str) {
        IndicatorController indicatorController;
        getUrlLoader().loadUrl(str);
        if (!TextUtils.isEmpty(str) && (indicatorController = getIndicatorController()) != null && indicatorController.offerIndicator() != null) {
            getIndicatorController().offerIndicator().show();
        }
        return this;
    }

    private void init() {
        doCompat();
        doSafeCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AgentWeb ready() {
        AgentWebConfig.initCookiesManager(this.mActivity.getApplicationContext());
        IAgentWebSettings iAgentWebSettings = this.mAgentWebSettings;
        if (iAgentWebSettings == null) {
            iAgentWebSettings = AbsAgentWebSettings.getInstance();
            this.mAgentWebSettings = iAgentWebSettings;
        }
        boolean z = iAgentWebSettings instanceof AbsAgentWebSettings;
        if (z) {
            ((AbsAgentWebSettings) iAgentWebSettings).bindAgentWeb(this);
        }
        if (this.mWebListenerManager == null && z) {
            this.mWebListenerManager = (WebListenerManager) iAgentWebSettings;
        }
        iAgentWebSettings.toSetting(this.mWebCreator.getWebView());
        if (this.mJsInterfaceHolder == null) {
            this.mJsInterfaceHolder = JsInterfaceHolderImpl.getJsInterfaceHolder(this.mWebCreator, this.mSecurityType);
        }
        LogUtils.m8083i(TAG, "mJavaObjects:" + this.mJavaObjects.size());
        ArrayMap<String, Object> arrayMap = this.mJavaObjects;
        if (arrayMap != null && !arrayMap.isEmpty()) {
            this.mJsInterfaceHolder.addJavaObjects(this.mJavaObjects);
        }
        WebListenerManager webListenerManager = this.mWebListenerManager;
        if (webListenerManager != null) {
            webListenerManager.setDownloader(this.mWebCreator.getWebView(), null);
            this.mWebListenerManager.setWebChromeClient(this.mWebCreator.getWebView(), getChromeClient());
            this.mWebListenerManager.setWebViewClient(this.mWebCreator.getWebView(), getWebViewClient());
        }
        return this;
    }

    public static AgentBuilder with(@NonNull Activity activity) {
        if (activity != null) {
            return new AgentBuilder(activity);
        }
        throw new NullPointerException("activity can not be null .");
    }

    public boolean back() {
        if (this.mIEventHandler == null) {
            this.mIEventHandler = EventHandlerImpl.getInstantce(this.mWebCreator.getWebView(), getInterceptor());
        }
        return this.mIEventHandler.back();
    }

    public AgentWeb clearWebCache() {
        if (getWebCreator().getWebView() != null) {
            AgentWebUtils.clearWebViewAllCache(this.mActivity, getWebCreator().getWebView());
        } else {
            AgentWebUtils.clearWebViewAllCache(this.mActivity);
        }
        return this;
    }

    public void destroy() {
        this.mWebLifeCycle.onDestroy();
    }

    Activity getActivity() {
        return this.mActivity;
    }

    public IAgentWebSettings getAgentWebSettings() {
        return this.mAgentWebSettings;
    }

    public IEventHandler getIEventHandler() {
        IEventHandler iEventHandler = this.mIEventHandler;
        if (iEventHandler != null) {
            return iEventHandler;
        }
        EventHandlerImpl instantce = EventHandlerImpl.getInstantce(this.mWebCreator.getWebView(), getInterceptor());
        this.mIEventHandler = instantce;
        return instantce;
    }

    public IndicatorController getIndicatorController() {
        return this.mIndicatorController;
    }

    public JsAccessEntrace getJsAccessEntrace() {
        JsAccessEntrace jsAccessEntrace = this.mJsAccessEntrace;
        if (jsAccessEntrace != null) {
            return jsAccessEntrace;
        }
        JsAccessEntraceImpl jsAccessEntraceImpl = JsAccessEntraceImpl.getInstance(this.mWebCreator.getWebView());
        this.mJsAccessEntrace = jsAccessEntraceImpl;
        return jsAccessEntraceImpl;
    }

    public JsInterfaceHolder getJsInterfaceHolder() {
        return this.mJsInterfaceHolder;
    }

    public PermissionInterceptor getPermissionInterceptor() {
        return this.mPermissionInterceptor;
    }

    public IUrlLoader getUrlLoader() {
        return this.mIUrlLoader;
    }

    public WebCreator getWebCreator() {
        return this.mWebCreator;
    }

    public WebLifeCycle getWebLifeCycle() {
        return this.mWebLifeCycle;
    }

    public boolean handleKeyEvent(int i2, KeyEvent keyEvent) {
        if (this.mIEventHandler == null) {
            this.mIEventHandler = EventHandlerImpl.getInstantce(this.mWebCreator.getWebView(), getInterceptor());
        }
        return this.mIEventHandler.onKeyDown(i2, keyEvent);
    }

    private AgentWeb(AgentBuilder agentBuilder) {
        byte b2 = 0;
        this.mAgentWeb = null;
        this.mJavaObjects = new ArrayMap<>();
        this.mTagTarget = 0;
        this.mWebSecurityController = null;
        this.mWebSecurityCheckLogic = null;
        this.mSecurityType = SecurityType.DEFAULT_CHECK;
        this.mAgentWebJsInterfaceCompat = null;
        this.mJsAccessEntrace = null;
        this.mIUrlLoader = null;
        this.mIVideo = null;
        this.mWebClientHelper = true;
        this.mIsInterceptUnkownUrl = false;
        this.mUrlHandleWays = -1;
        this.mJsInterfaceHolder = null;
        this.mTagTarget = agentBuilder.mTag;
        this.mActivity = agentBuilder.mActivity;
        this.mViewGroup = agentBuilder.mViewGroup;
        this.mIEventHandler = agentBuilder.mIEventHandler;
        this.mEnableIndicator = agentBuilder.mEnableIndicator;
        this.mWebCreator = agentBuilder.mWebCreator == null ? configWebCreator(agentBuilder.mBaseIndicatorView, agentBuilder.mIndex, agentBuilder.mLayoutParams, agentBuilder.mIndicatorColor, agentBuilder.mHeight, agentBuilder.mWebView, agentBuilder.mWebLayout) : agentBuilder.mWebCreator;
        this.mIndicatorController = agentBuilder.mIndicatorController;
        this.mWebChromeClient = agentBuilder.mWebChromeClient;
        this.mWebViewClient = agentBuilder.mWebViewClient;
        this.mAgentWeb = this;
        this.mAgentWebSettings = agentBuilder.mAgentWebSettings;
        if (agentBuilder.mJavaObject != null && !agentBuilder.mJavaObject.isEmpty()) {
            this.mJavaObjects.putAll((Map<? extends String, ? extends Object>) agentBuilder.mJavaObject);
            LogUtils.m8083i(TAG, "mJavaObject size:" + this.mJavaObjects.size());
        }
        this.mPermissionInterceptor = agentBuilder.mPermissionInterceptor != null ? new PermissionInterceptorWrapper(agentBuilder.mPermissionInterceptor) : null;
        this.mSecurityType = agentBuilder.mSecurityType;
        this.mIUrlLoader = new UrlLoaderImpl(this.mWebCreator.create().getWebView(), agentBuilder.mHttpHeaders);
        if (this.mWebCreator.getWebParentLayout() instanceof WebParentLayout) {
            WebParentLayout webParentLayout = (WebParentLayout) this.mWebCreator.getWebParentLayout();
            webParentLayout.bindController(agentBuilder.mAgentWebUIController == null ? AgentWebUIControllerImplBase.build() : agentBuilder.mAgentWebUIController);
            webParentLayout.setErrorLayoutRes(agentBuilder.mErrorLayout, agentBuilder.mReloadId);
            webParentLayout.setErrorView(agentBuilder.mErrorView);
        }
        this.mWebLifeCycle = new DefaultWebLifeCycleImpl(this.mWebCreator.getWebView());
        this.mWebSecurityController = new WebSecurityControllerImpl(this.mWebCreator.getWebView(), this.mAgentWeb.mJavaObjects, this.mSecurityType);
        this.mWebClientHelper = agentBuilder.mWebClientHelper;
        this.mIsInterceptUnkownUrl = agentBuilder.mIsInterceptUnkownUrl;
        if (agentBuilder.mOpenOtherPage != null) {
            this.mUrlHandleWays = agentBuilder.mOpenOtherPage.code;
        }
        this.mMiddleWrareWebClientBaseHeader = agentBuilder.mMiddlewareWebClientBaseHeader;
        this.mMiddlewareWebChromeBaseHeader = agentBuilder.mChromeMiddleWareHeader;
        init();
    }

    public static final class AgentBuilder {
        private Activity mActivity;
        private IAgentWebSettings mAgentWebSettings;
        private AbsAgentWebUIController mAgentWebUIController;
        private BaseIndicatorView mBaseIndicatorView;
        private int mErrorLayout;
        private View mErrorView;
        private Fragment mFragment;
        private IEventHandler mIEventHandler;
        private boolean mIsNeedDefaultProgress;
        private ArrayMap<String, Object> mJavaObject;
        private MiddlewareWebClientBase mMiddlewareWebClientBaseHeader;
        private MiddlewareWebClientBase mMiddlewareWebClientBaseTail;
        private int mReloadId;
        private int mTag;
        private ViewGroup mViewGroup;
        private WebChromeClient mWebChromeClient;
        private WebCreator mWebCreator;
        private WebView mWebView;
        private WebViewClient mWebViewClient;
        private int mIndex = -1;
        private IndicatorController mIndicatorController = null;
        private boolean mEnableIndicator = true;
        private ViewGroup.LayoutParams mLayoutParams = null;
        private int mIndicatorColor = -1;
        private HttpHeaders mHttpHeaders = null;
        private int mHeight = -1;
        private SecurityType mSecurityType = SecurityType.DEFAULT_CHECK;
        private boolean mWebClientHelper = true;
        private IWebLayout mWebLayout = null;
        private PermissionInterceptor mPermissionInterceptor = null;
        private DefaultWebClient.OpenOtherPageWays mOpenOtherPage = null;
        private boolean mIsInterceptUnkownUrl = false;
        private MiddlewareWebChromeBase mChromeMiddleWareHeader = null;
        private MiddlewareWebChromeBase mChromeMiddleWareTail = null;

        public AgentBuilder(@NonNull Activity activity, @NonNull Fragment fragment) {
            this.mTag = -1;
            this.mActivity = activity;
            this.mFragment = fragment;
            this.mTag = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addHeader(String str, String str2, String str3) {
            if (this.mHttpHeaders == null) {
                this.mHttpHeaders = HttpHeaders.create();
            }
            this.mHttpHeaders.additionalHttpHeader(str, str2, str3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addJavaObject(String str, Object obj) {
            if (this.mJavaObject == null) {
                this.mJavaObject = new ArrayMap<>();
            }
            this.mJavaObject.put(str, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PreAgentWeb buildAgentWeb() {
            if (this.mTag == 1 && this.mViewGroup == null) {
                throw new NullPointerException("ViewGroup is null,Please check your parameters .");
            }
            return new PreAgentWeb(HookManager.hookAgentWeb(new AgentWeb(this), this));
        }

        public IndicatorBuilder setAgentWebParent(@NonNull ViewGroup viewGroup, @NonNull ViewGroup.LayoutParams layoutParams) {
            this.mViewGroup = viewGroup;
            this.mLayoutParams = layoutParams;
            return new IndicatorBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addHeader(String str, Map<String, String> map) {
            if (this.mHttpHeaders == null) {
                this.mHttpHeaders = HttpHeaders.create();
            }
            this.mHttpHeaders.additionalHttpHeaders(str, map);
        }

        public IndicatorBuilder setAgentWebParent(@NonNull ViewGroup viewGroup, int i2, @NonNull ViewGroup.LayoutParams layoutParams) {
            this.mViewGroup = viewGroup;
            this.mLayoutParams = layoutParams;
            this.mIndex = i2;
            return new IndicatorBuilder(this);
        }

        public AgentBuilder(@NonNull Activity activity) {
            this.mTag = -1;
            this.mActivity = activity;
            this.mTag = 0;
        }
    }

    public static class IndicatorBuilder {
        private AgentBuilder mAgentBuilder;

        public IndicatorBuilder(AgentBuilder agentBuilder) {
            this.mAgentBuilder = null;
            this.mAgentBuilder = agentBuilder;
        }

        public CommonBuilder closeIndicator() {
            this.mAgentBuilder.mEnableIndicator = false;
            this.mAgentBuilder.mIndicatorColor = -1;
            this.mAgentBuilder.mHeight = -1;
            return new CommonBuilder(this.mAgentBuilder);
        }

        public CommonBuilder setCustomIndicator(@NonNull BaseIndicatorView baseIndicatorView) {
            if (baseIndicatorView != null) {
                this.mAgentBuilder.mEnableIndicator = true;
                this.mAgentBuilder.mBaseIndicatorView = baseIndicatorView;
                this.mAgentBuilder.mIsNeedDefaultProgress = false;
            } else {
                this.mAgentBuilder.mEnableIndicator = true;
                this.mAgentBuilder.mIsNeedDefaultProgress = true;
            }
            return new CommonBuilder(this.mAgentBuilder);
        }

        public CommonBuilder useDefaultIndicator(int i2) {
            this.mAgentBuilder.mEnableIndicator = true;
            this.mAgentBuilder.mIndicatorColor = i2;
            return new CommonBuilder(this.mAgentBuilder);
        }

        public CommonBuilder useDefaultIndicator() {
            this.mAgentBuilder.mEnableIndicator = true;
            return new CommonBuilder(this.mAgentBuilder);
        }

        public CommonBuilder useDefaultIndicator(@ColorInt int i2, int i3) {
            this.mAgentBuilder.mIndicatorColor = i2;
            this.mAgentBuilder.mHeight = i3;
            return new CommonBuilder(this.mAgentBuilder);
        }
    }

    public static AgentBuilder with(@NonNull Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            return new AgentBuilder(activity, fragment);
        }
        throw new NullPointerException("activity can not be null .");
    }
}
