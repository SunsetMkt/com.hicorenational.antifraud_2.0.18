package p388ui.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bean.AppInfoBean;
import bean.PolicBean;
import bean.ShareConfigBean;
import bean.SurveyH5Bean;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.just.agentweb.AbsAgentWebSettings;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebViewClient;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.xiaomi.mipush.sdk.Constants;
import interfaces.IClickListener;
import interfaces.IVerifyListener;
import interfaces.OnWebListener;
import interfaces.PermissionsListener;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import manager.AccountManager;
import manager.LoginManager;
import network.gson.ResponseDataTypeAdaptor;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p245d.C4440a;
import p245d.C4441b;
import p247e.C4447d;
import p357j.C5846e;
import p388ui.activity.H5AppSelectedActivity;
import p388ui.activity.PromosWebDetActivity;
import p388ui.callview.WebFullCallView;
import p388ui.fragment.WebFragment;
import p388ui.p391f.DialogC6827c;
import p388ui.presenter.WebFrgPresenter;
import p388ui.presenter.WebFullPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.C7248x;
import util.C7257b1;
import util.C7292k1;
import util.C7301n1;
import util.C7313q1;
import util.C7328v1;
import util.C7337y1;
import util.C7340z1;
import util.p395c2.C7265a;
import util.p396d2.C7269a;
import util.p396d2.C7270b;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;
import zxing.android.CaptureActivity;

/* loaded from: classes2.dex */
public class WebFragment extends BaseFragment implements WebFullCallView {
    private String articId;
    private boolean isSendLocation;
    private AgentWeb mAgentWeb;
    private WebFrgPresenter mHttpPresenter;

    @BindView(C2113R.id.iv_right)
    ImageView mIvRight;

    @BindView(C2113R.id.web_container)
    LinearLayout mLinearLayout;

    @BindView(C2113R.id.ll_network_no)
    View mLlNetworkNo;

    @BindView(C2113R.id.net_tips)
    TextView mNetTips;
    private WebFullPresenter mPresenter;

    @BindView(C2113R.id.pro_bar)
    ProgressBar mProgressBar;

    @BindView(C2113R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(C2113R.id.iv_back)
    ImageView mTIvBack;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private ValueCallback<Uri[]> mUploadMessage5;
    private WebView mWebview;
    private C7248x viewFrag;
    private String TAG = WebFragment.class.getSimpleName();
    private String XCUrl = "";
    private String mShareBaseUrl = "";
    private int mMaxSelNum = 6;
    private HashMap<Object, String> mHashMap = null;
    private final String mEventTag = "event";
    private String backValue = "1";
    private DialogC6827c mShareDialog = null;
    Handler mHandler = new HandlerC6879a();

    /* renamed from: ui.fragment.WebFragment$a */
    class HandlerC6879a extends Handler {
        HandlerC6879a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (WebFragment.this.mActivity.isFinishing()) {
                return;
            }
            int i2 = message.what;
            if (i2 == 0) {
                WebFragment.this.mRlTitle.setVisibility(0);
            } else {
                if (i2 != 1) {
                    return;
                }
                WebFragment.this.mRlTitle.setVisibility(8);
            }
        }
    }

    /* renamed from: ui.fragment.WebFragment$b */
    class C6880b implements OnWebListener {
        C6880b() {
        }

        /* renamed from: a */
        public /* synthetic */ void m25610a() {
            WebFragment.this.onErrorView(false);
        }

        @Override // interfaces.OnWebListener
        public void shouldIntercept(C7269a c7269a) {
            WebFragment.this.sendWebMsg(c7269a);
        }

        @Override // interfaces.OnWebListener
        public void webJsFinish() {
            WebFragment.this.mActivity.runOnUiThread(new Runnable() { // from class: ui.fragment.r
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragment.C6880b.this.m25610a();
                }
            });
        }

        @Override // interfaces.OnWebListener
        public void webJsParame(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            WebFragment.this.mPresenter.SurveyH5Param(str);
        }
    }

    /* renamed from: ui.fragment.WebFragment$c */
    class C6881c implements PermissionsListener {

        /* renamed from: a */
        final /* synthetic */ WebChromeClient.FileChooserParams f23878a;

        C6881c(WebChromeClient.FileChooserParams fileChooserParams) {
            this.f23878a = fileChooserParams;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(WebFragment.this.mActivity, list, z, true, this);
            WebFragment.this.receiveCleanData();
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            String[] acceptTypes = this.f23878a.getAcceptTypes();
            if (acceptTypes == null || acceptTypes.length <= 0) {
                return;
            }
            if (acceptTypes[0].contains("image")) {
                C5846e.m24617a(WebFragment.this.mActivity, 200L, PictureMimeType.ofImage(), WebFragment.this.mMaxSelNum).forResult(1001);
                return;
            }
            if (acceptTypes[0].contains("video")) {
                return;
            }
            if (acceptTypes[0].contains("audio")) {
                C5846e.m24617a(WebFragment.this.mActivity, 200L, PictureMimeType.ofAudio(), WebFragment.this.mMaxSelNum).forResult(1002);
            } else if (acceptTypes[0].contains("apk")) {
                Intent intent = new Intent(WebFragment.this.mActivity, (Class<?>) H5AppSelectedActivity.class);
                intent.putExtra("extra_select_limite", WebFragment.this.mMaxSelNum);
                WebFragment.this.startActivityForResult(intent, 1003);
            }
        }
    }

    /* renamed from: ui.fragment.WebFragment$d */
    class C6882d implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ boolean f23880a;

        C6882d(boolean z) {
            this.f23880a = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.f23880a) {
                C7292k1.m26406j(WebFragment.this.mActivity);
            } else {
                WebFragment.this.varCamerPrims();
            }
        }
    }

    /* renamed from: ui.fragment.WebFragment$e */
    class C6883e implements PermissionsListener {

        /* renamed from: a */
        final /* synthetic */ PermissionRequest f23882a;

        C6883e(PermissionRequest permissionRequest) {
            this.f23882a = permissionRequest;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            if (this.f23882a == null) {
                WebFragment.this.camerPrimssDlg(z);
            } else {
                C7310c.m26513a(WebFragment.this.mActivity, list, z, false, this);
                this.f23882a.deny();
            }
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if ("vivo" != Build.BRAND || Build.VERSION.SDK_INT != 23) {
                PermissionRequest permissionRequest = this.f23882a;
                if (permissionRequest == null) {
                    WebFragment.this.goScan();
                    return;
                } else {
                    permissionRequest.grant(new String[]{"android.webkit.resource.VIDEO_CAPTURE"});
                    return;
                }
            }
            if (!C7310c.m26526f()) {
                PermissionRequest permissionRequest2 = this.f23882a;
                if (permissionRequest2 != null) {
                    permissionRequest2.deny();
                }
                C7292k1.m26406j(WebFragment.this.mActivity);
                return;
            }
            PermissionRequest permissionRequest3 = this.f23882a;
            if (permissionRequest3 == null) {
                WebFragment.this.goScan();
            } else {
                permissionRequest3.grant(new String[]{"android.webkit.resource.VIDEO_CAPTURE"});
            }
        }
    }

    /* renamed from: ui.fragment.WebFragment$f */
    private class C6884f extends com.just.agentweb.WebChromeClient {
        private C6884f() {
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (Build.VERSION.SDK_INT >= 21) {
                for (String str : permissionRequest.getResources()) {
                    if (str.equals("android.webkit.resource.VIDEO_CAPTURE")) {
                        WebFragment.this.varCamerPrims(permissionRequest);
                        return;
                    }
                }
            }
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            if (WebFragment.this.mProgressBar == null) {
                return;
            }
            String str = "----onProgressChanged-----------" + i2;
            if (i2 == 100) {
                WebFragment.this.mProgressBar.setVisibility(8);
            } else {
                WebFragment.this.mProgressBar.setVisibility(0);
                WebFragment.this.mProgressBar.setProgress(i2);
            }
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            WebFragment.this.mUploadMessage5 = valueCallback;
            WebFragment.this.chooseFilePermission(fileChooserParams);
            return true;
        }

        /* synthetic */ C6884f(WebFragment webFragment, HandlerC6879a handlerC6879a) {
            this();
        }
    }

    /* renamed from: ui.fragment.WebFragment$g */
    public class C6885g extends WebViewClient {
        public C6885g() {
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (!WebFragment.this.networkStateDeal()) {
            }
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            WebFragment.this.onErrorView(true);
            if (Build.VERSION.SDK_INT < 23 || !webResourceError.getDescription().toString().contains("ERR_CONNECTION_REFUSED")) {
                return;
            }
            WebFragment.this.refreshPage();
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            AtomicReference atomicReference = new AtomicReference();
            if (Build.VERSION.SDK_INT >= 21) {
                atomicReference.set(webResourceRequest.getUrl().getPath());
            }
            if (webResourceRequest.getUrl().toString().startsWith("tel:")) {
                C7337y1.m26778e(WebFragment.this.mActivity, webResourceRequest.getUrl().toString());
                return true;
            }
            if (WebFragment.this.networkStateDeal()) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void camerPrimssDlg(boolean z) {
        C7257b1.m26230f(this.mActivity, "权限开启", "国家反诈中心未取得权限，这样会导致此功能无法使用。", "取消", "去授权", new C6882d(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseFilePermission(WebChromeClient.FileChooserParams fileChooserParams) {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25521A, C7308a.f25547z}, new C6881c(fileChooserParams));
    }

    private String getUrl() {
        String str;
        String str2 = "";
        try {
            String accountId = AccountManager.getAccountId();
            String m26674l = C7328v1.m26674l();
            RegionMudelBean m16408j = C4440a.m16408j();
            if (m16408j == null || TextUtils.isEmpty(m16408j.getAndroidh5host())) {
                str = "";
            } else {
                str = m16408j.getH5Url() + m16408j.getAndroidh5host();
            }
            if (TextUtils.isEmpty(str)) {
                str = C4440a.f16884f;
            }
            C7301n1.m26453a("getUrl()--------url-->>" + str);
            str2 = str + "?userid=" + accountId + "&imei=" + m26674l + "&" + C4440a.m16411m();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        C7301n1.m26453a("getUrl()--------url+-->>" + str2);
        this.XCUrl = str2;
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goScan() {
        startActivityForResult(new Intent(this.mActivity, (Class<?>) CaptureActivity.class), 0);
    }

    private void initAgentWeb() {
        this.mAgentWeb = AgentWeb.with(this).setAgentWebParent(this.mLinearLayout, new LinearLayout.LayoutParams(-1, -1)).closeIndicator().setWebViewClient(new C6885g()).setWebChromeClient(new C6884f(this, null)).addJavascriptInterface("appjs", this.viewFrag.m26132a()).setAgentWebWebSettings(AbsAgentWebSettings.getInstance()).setMainFrameErrorView(C2113R.layout.web_page_error, -1).createAgentWeb().ready().m8080go(getUrl());
        this.mWebview = this.mAgentWeb.getWebCreator().getWebView();
        this.mAgentWeb.getWebCreator().getWebView().setHorizontalScrollBarEnabled(false);
        this.mWebview.getSettings().setTextZoom(100);
        this.mWebview.getSettings().setMediaPlaybackRequiresUserGesture(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean networkStateDeal() {
        if (this.mActivity.isFinishing()) {
            return false;
        }
        if (C7313q1.m26534f()) {
            return true;
        }
        onErrorView(true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onErrorView(boolean z) {
        if (z) {
            View view = this.mLlNetworkNo;
            if (view != null) {
                view.setVisibility(0);
            }
            WebView webView = this.mWebview;
            if (webView != null) {
                webView.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.mLlNetworkNo;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        WebView webView2 = this.mWebview;
        if (webView2 != null) {
            webView2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receiveCleanData() {
        ValueCallback<Uri[]> valueCallback = this.mUploadMessage5;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.mUploadMessage5 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshPage() {
        if (this.mWebview == null || !networkStateDeal()) {
            return;
        }
        onErrorView(false);
        this.mWebview.reload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendWebMsg(C7269a c7269a) {
        if (c7269a.m26325c()) {
            return;
        }
        try {
            String m26323b = c7269a.m26323b("id");
            if (!TextUtils.isEmpty(m26323b)) {
                this.articId = m26323b;
            }
            String m26326a = C7270b.m26326a(c7269a.m26323b("url"));
            if (!TextUtils.isEmpty(m26326a)) {
                String decode = URLDecoder.decode(c7269a.m26323b("title"), "UTF-8");
                String m26323b2 = c7269a.m26323b("source");
                Intent intent = new Intent(this.mActivity, (Class<?>) PromosWebDetActivity.class);
                intent.putExtra(C7292k1.f25363P, decode);
                intent.putExtra(C7292k1.f25365Q, m26326a);
                intent.putExtra(C7292k1.f25371T, this.articId);
                intent.putExtra(C7292k1.f25369S, m26323b2);
                intent.putExtra(C7292k1.f25373U, 2);
                startActivity(intent);
            }
            String m26323b3 = c7269a.m26323b("isOnlyFullScreen");
            String m26323b4 = c7269a.m26323b("isfullScreen");
            String m26323b5 = c7269a.m26323b("stylecolor");
            if (TextUtils.equals("yes", m26323b4)) {
                C6049c.m24987f().m25000d(new C7265a(100, null));
                this.mHandler.sendEmptyMessage(0);
                return;
            }
            if (TextUtils.equals("no", m26323b4)) {
                C6049c.m24987f().m25000d(new C7265a(101, null));
                this.mHandler.sendEmptyMessage(1);
                return;
            }
            if (TextUtils.equals("yes", m26323b3)) {
                C6049c.m24987f().m25000d(new C7265a(100, null));
                this.mHandler.sendEmptyMessage(1);
            } else if (TextUtils.equals("no", m26323b3)) {
                C6049c.m24987f().m25000d(new C7265a(101, null));
                this.mHandler.sendEmptyMessage(1);
            } else if (TextUtils.equals("black", m26323b5)) {
                C6049c.m24987f().m25000d(new C7265a(102, null));
            } else if (TextUtils.equals("white", m26323b5)) {
                C6049c.m24987f().m25000d(new C7265a(103, null));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims() {
        varCamerPrims(null);
    }

    /* renamed from: a */
    public /* synthetic */ void m25606a(String str) {
        this.mWebview.evaluateJavascript(str, null);
    }

    public void appCallH5(String str, String str2, boolean z) {
        String str3 = str.substring(0, str.lastIndexOf(125)) + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + "}";
        if (this.mWebview != null) {
            if (!z) {
                final String str4 = "javascript:appCallH5(" + str3 + ")";
                C7301n1.m26454a(this.TAG, "js===" + str4);
                this.mWebview.postDelayed(new Runnable() { // from class: ui.fragment.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebFragment.this.m25607b(str4);
                    }
                }, 0L);
                return;
            }
            final String str5 = "javascript:appCallH5('" + str3 + "')";
            C7301n1.m26454a(this.TAG, "js===" + str5);
            this.mWebview.postDelayed(new Runnable() { // from class: ui.fragment.s
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragment.this.m25606a(str5);
                }
            }, 0L);
        }
    }

    public void appCallH5Other(String str, String str2) {
        if (this.mWebview != null) {
            final String str3 = "javascript:" + str + "(" + str2 + ")";
            C7301n1.m26454a(str + " appCallH5Other-->", str3);
            this.mWebview.postDelayed(new Runnable() { // from class: ui.fragment.u
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragment.this.m25608c(str3);
                }
            }, 0L);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void m25607b(String str) {
        this.mWebview.evaluateJavascript(str, null);
    }

    /* renamed from: c */
    public /* synthetic */ void m25608c(String str) {
        this.mWebview.evaluateJavascript(str, null);
    }

    public void clearH5localData() {
        this.mWebview.loadUrl("javascript:clearH5localData()");
    }

    /* renamed from: d */
    public /* synthetic */ void m25609d(String str) {
        appCallH5(str, "\"response\":{\"verifiedStatus\":\"1\"}", false);
    }

    @Override // p388ui.callview.WebFullCallView
    public void eventH5Action(final String str, Map<String, Object> map) {
        if (!map.containsKey("action") || map.get("action") == null) {
            return;
        }
        switch (Integer.parseInt(map.get("action").toString())) {
            case 2:
                if (map.containsKey(SurveyH5Bean.VALUE)) {
                    if (!TextUtils.equals("0", String.valueOf(map.get(SurveyH5Bean.VALUE)))) {
                        C7161b.m25698a(this.mActivity, true, false);
                        break;
                    } else {
                        C7161b.m25698a(this.mActivity, true, true);
                        break;
                    }
                }
                break;
            case 3:
                putActionMap("event3", str);
                varCamerPrims();
                break;
            case 4:
                appCallH5(str, "\"response\":" + C7248x.m26131b(), false);
                break;
            case 5:
                putActionMap("event5", str);
                C7340z1.m26805a(this.mActivity).m26811a(17, new IVerifyListener() { // from class: ui.fragment.t
                    @Override // interfaces.IVerifyListener
                    public final void onSuccessVerify() {
                        WebFragment.this.m25609d(str);
                    }
                });
                break;
            case 7:
                LoginManager.getInstance().exitToLogin();
                break;
            case 8:
                String valueOf = String.valueOf(map.get(SurveyH5Bean.VALUE));
                PolicBean policBean = new PolicBean();
                policBean.setPoliceToken(valueOf);
                C4441b.m16413a(policBean);
                break;
            case 9:
                C4441b.m16417e();
                break;
            case 10:
                this.mMaxSelNum = Integer.parseInt(map.get(SurveyH5Bean.VALUE).toString());
                break;
            case 11:
                ShareConfigBean shareConfigBean = (ShareConfigBean) ResponseDataTypeAdaptor.buildGson().m5569a(map.get(SurveyH5Bean.VALUE).toString(), ShareConfigBean.class);
                if (shareConfigBean != null) {
                    if (!TextUtils.isEmpty(shareConfigBean.downloadUrl)) {
                        shareConfigBean.downloadUrl = shareConfigBean.downloadUrl.replace("{0}", C4440a.m16411m() + "");
                    }
                    this.mShareDialog = new DialogC6827c(this.mActivity, shareConfigBean, 2, null);
                    this.mShareDialog.show();
                    break;
                }
                break;
            case 12:
                appCallH5(str, "\"response\":{\"result\":\"" + (TextUtils.equals(String.valueOf(map.get(SurveyH5Bean.VALUE)), C4441b.m16415c()) ? "1" : "0") + "\"}", false);
                break;
            case 13:
                appCallH5(str, "\"response\":{\"result\":\"" + (TextUtils.equals(String.valueOf(map.get(SurveyH5Bean.VALUE)), C4441b.m16414b()) ? "1" : "0") + "\"}", false);
                break;
            case 15:
                onErrorView(false);
                break;
        }
    }

    @Override // p388ui.fragment.BaseFragment
    protected int getLayoutId() {
        return C2113R.layout.fragment_web;
    }

    @Override // p388ui.fragment.BaseFragment
    protected void initPage() {
        this.mIvRight.setBackgroundResource(C2113R.drawable.iv_share_white);
        this.mTIvBack.setVisibility(8);
        this.mRlTitle.setVisibility(8);
        this.mRlTitle.setBackgroundColor(0);
        this.mHttpPresenter = new WebFrgPresenter(this.mActivity);
        this.mPresenter = new WebFullPresenter(this.mActivity, this);
        this.viewFrag = new C7248x();
        initWebViewListener();
        initAgentWeb();
    }

    protected void initWebViewListener() {
        this.viewFrag.m26133a(this.mActivity, this.mWebview, new C6880b());
    }

    public void jsShowPage() {
        WebView webView = this.mWebview;
        if (webView != null) {
            webView.loadUrl("javascript:showpage()");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        int i4 = 0;
        if (i2 == 0) {
            if (i3 != -1 || intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra(CaptureActivity.f25793l);
            C7301n1.m26456b("content-->" + stringExtra);
            appCallH5(this.mHashMap.get("event3"), "\"response\":{\"scanValue\":\"" + stringExtra + "\"}", false);
            this.mHashMap.remove("event3");
        }
        switch (i2) {
            case 1001:
            case 1002:
                List obtainMultipleResult = PictureSelector.obtainMultipleResult(intent);
                if (obtainMultipleResult != null && obtainMultipleResult.size() > 0) {
                    Uri[] uriArr = new Uri[obtainMultipleResult.size()];
                    while (i4 < obtainMultipleResult.size()) {
                        LocalMedia localMedia = (LocalMedia) obtainMultipleResult.get(i4);
                        if (Build.VERSION.SDK_INT > 28) {
                            uriArr[i4] = C7337y1.m26769c(this.mActivity, localMedia.getRealPath());
                        } else {
                            uriArr[i4] = C7337y1.m26769c(this.mActivity, localMedia.getPath());
                        }
                        i4++;
                    }
                    this.mUploadMessage5.onReceiveValue(uriArr);
                    this.mUploadMessage5 = null;
                }
                receiveCleanData();
                break;
            case 1003:
                List obtainMultipleResult2 = PictureSelector.obtainMultipleResult(intent);
                if (obtainMultipleResult2 != null && obtainMultipleResult2.size() > 0) {
                    Uri[] uriArr2 = new Uri[obtainMultipleResult2.size()];
                    while (i4 < obtainMultipleResult2.size()) {
                        AppInfoBean appInfoBean = (AppInfoBean) obtainMultipleResult2.get(i4);
                        if (!TextUtils.isEmpty(appInfoBean.getUri())) {
                            uriArr2[i4] = Uri.parse(appInfoBean.getUri());
                        }
                        i4++;
                    }
                    this.mUploadMessage5.onReceiveValue(uriArr2);
                    this.mUploadMessage5 = null;
                    appCallH5Other("getAppBackInfo", ResponseDataTypeAdaptor.buildGson().m5572a(obtainMultipleResult2));
                }
                receiveCleanData();
                break;
        }
    }

    public boolean onBackPressed() {
        WebView webView = this.mWebview;
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        this.mWebview.goBack();
        return true;
    }

    @Override // p388ui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroyView();
    }

    @InterfaceC6059m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(C7265a c7265a) {
        if (c7265a != null) {
            int m26297a = c7265a.m26297a();
            if (m26297a == 223) {
                C6049c.m24987f().m25002f(c7265a);
                appCallH5(this.mHashMap.get("event5"), "\"response\":{\"verifiedStatus\":\"1\"}", false);
                this.mHashMap.remove("event5");
            } else {
                if (m26297a == 300) {
                    C6049c.m24987f().m25002f(c7265a);
                    if (c7265a.m26300b() != null) {
                        appCallH5Other("getCallBackInfo", ResponseDataTypeAdaptor.buildGson().m5572a(c7265a.m26300b()));
                        return;
                    }
                    return;
                }
                if (m26297a != 302) {
                    return;
                }
                C6049c.m24987f().m25002f(c7265a);
                if (c7265a.m26300b() != null) {
                    appCallH5Other("getSmsBackInfo", ResponseDataTypeAdaptor.buildGson().m5572a(c7265a.m26300b()));
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        jsShowPage();
    }

    @Override // p388ui.callview.WebFullCallView
    public void onSurveyBeanRequest(String str, String str2, boolean z) {
        appCallH5(str, str2, z);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.iv_right, C2113R.id.ll_network_no})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_back) {
            onBackPressed();
            return;
        }
        if (id == C2113R.id.iv_right) {
            this.mHttpPresenter.requestAticleInfo(this.mShareBaseUrl, this.articId);
        } else {
            if (id != C2113R.id.ll_network_no) {
                return;
            }
            this.mNetTips.setText("正在努力加载中...");
            refreshPage();
        }
    }

    public void putActionMap(Object obj, String str) {
        if (this.mHashMap == null) {
            this.mHashMap = new HashMap<>();
        }
        this.mHashMap.put(obj, str);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17171r);
            jsShowPage();
        }
    }

    public void turnPage() {
        RegionMudelBean m16408j = C4440a.m16408j();
        if (m16408j == null || TextUtils.isEmpty(m16408j.getAndroidh5host())) {
            this.mWebview.loadUrl(this.XCUrl + "#/case/caseList?time=" + C4440a.m16411m());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims(PermissionRequest permissionRequest) {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25524c}, new C6883e(permissionRequest));
    }
}
