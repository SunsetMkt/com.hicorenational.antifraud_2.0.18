package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import bean.AppInfoBean;
import bean.PolicBean;
import bean.ShareConfigBean;
import bean.SurveyH5Bean;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import manager.LoginManager;
import network.gson.ResponseDataTypeAdaptor;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p245d.C4440a;
import p245d.C4441b;
import p357j.C5846e;
import p388ui.callview.WebFullCallView;
import p388ui.p391f.DialogC6827c;
import p388ui.presenter.WebFullPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.C7248x;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.C7301n1;
import util.C7337y1;
import util.C7340z1;
import util.p395c2.C7265a;
import util.p396d2.C7269a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;
import zxing.android.CaptureActivity;

/* loaded from: classes2.dex */
public class WebFullActivity extends BaseActivity implements WebFullCallView {
    private AgentWeb mAgentWeb;

    @BindView(C2113R.id.web_container)
    LinearLayout mLinearLayout;

    @BindView(C2113R.id.ll_network_no)
    View mLlNetworkNo;
    private WebFullPresenter mPresenter;

    @BindView(C2113R.id.progress_bar)
    ProgressBar mProgressBar;
    private ValueCallback<Uri[]> mUploadMessage5;
    private WebView mWebview;
    private String orginUrl;
    private SwipBackLayout swipBackLayout;
    private C7248x viewFrag;
    private String TAG = WebFullActivity.class.getSimpleName();
    private int mMaxSelNum = 6;
    private HashMap<Object, String> mHashMap = null;
    private final String mEventTag = "event";
    private String backValue = "1";
    private DialogC6827c mShareDialog = null;

    /* renamed from: ui.activity.WebFullActivity$a */
    class C6717a implements OnWebListener {
        C6717a() {
        }

        @Override // interfaces.OnWebListener
        public void shouldIntercept(C7269a c7269a) {
        }

        @Override // interfaces.OnWebListener
        public void webJsFinish() {
            WebFullActivity.this.onErrorView(false);
        }

        @Override // interfaces.OnWebListener
        public void webJsParame(String str) {
            C7301n1.m26454a(WebFullActivity.this.TAG, "param==" + str);
            WebFullActivity.this.mPresenter.SurveyH5Param(str);
        }
    }

    /* renamed from: ui.activity.WebFullActivity$b */
    class C6718b implements PermissionsListener {

        /* renamed from: a */
        final /* synthetic */ WebChromeClient.FileChooserParams f23527a;

        C6718b(WebChromeClient.FileChooserParams fileChooserParams) {
            this.f23527a = fileChooserParams;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(WebFullActivity.this.mActivity, list, z, true, this);
            WebFullActivity.this.receiveCleanData();
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            String[] acceptTypes = this.f23527a.getAcceptTypes();
            if (acceptTypes == null || acceptTypes.length <= 0) {
                return;
            }
            if (acceptTypes[0].contains("image")) {
                C5846e.m24617a(WebFullActivity.this.mActivity, 200L, PictureMimeType.ofImage(), WebFullActivity.this.mMaxSelNum).forResult(1001);
                return;
            }
            if (acceptTypes[0].contains("video")) {
                return;
            }
            if (acceptTypes[0].contains("audio")) {
                C5846e.m24617a(WebFullActivity.this.mActivity, 200L, PictureMimeType.ofAudio(), WebFullActivity.this.mMaxSelNum).forResult(1002);
            } else if (acceptTypes[0].contains("apk")) {
                Intent intent = new Intent(WebFullActivity.this.mActivity, (Class<?>) H5AppSelectedActivity.class);
                intent.putExtra("extra_select_limite", WebFullActivity.this.mMaxSelNum);
                WebFullActivity.this.startActivityForResult(intent, 1003);
            }
        }
    }

    /* renamed from: ui.activity.WebFullActivity$c */
    class C6719c implements PermissionsListener {

        /* renamed from: a */
        final /* synthetic */ PermissionRequest f23529a;

        C6719c(PermissionRequest permissionRequest) {
            this.f23529a = permissionRequest;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            if (this.f23529a == null) {
                WebFullActivity.this.camerPrimssDlg(z);
            } else {
                C7310c.m26513a(WebFullActivity.this.mActivity, list, z, false, this);
                this.f23529a.deny();
            }
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if ("vivo" != Build.BRAND || Build.VERSION.SDK_INT != 23) {
                PermissionRequest permissionRequest = this.f23529a;
                if (permissionRequest == null) {
                    WebFullActivity.this.goScan();
                    return;
                } else {
                    permissionRequest.grant(new String[]{"android.webkit.resource.VIDEO_CAPTURE"});
                    return;
                }
            }
            if (!C7310c.m26526f()) {
                PermissionRequest permissionRequest2 = this.f23529a;
                if (permissionRequest2 != null) {
                    permissionRequest2.deny();
                }
                C7292k1.m26406j(WebFullActivity.this.mActivity);
                return;
            }
            PermissionRequest permissionRequest3 = this.f23529a;
            if (permissionRequest3 == null) {
                WebFullActivity.this.goScan();
            } else {
                permissionRequest3.grant(new String[]{"android.webkit.resource.VIDEO_CAPTURE"});
            }
        }
    }

    /* renamed from: ui.activity.WebFullActivity$d */
    class C6720d implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ boolean f23531a;

        C6720d(boolean z) {
            this.f23531a = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.f23531a) {
                C7292k1.m26406j(WebFullActivity.this.mActivity);
            } else {
                WebFullActivity.this.varCamerPrims();
            }
        }
    }

    /* renamed from: ui.activity.WebFullActivity$e */
    private class C6721e extends com.just.agentweb.WebChromeClient {
        private C6721e() {
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (Build.VERSION.SDK_INT >= 21) {
                for (String str : permissionRequest.getResources()) {
                    if (str.equals("android.webkit.resource.VIDEO_CAPTURE")) {
                        WebFullActivity.this.varCamerPrims(permissionRequest);
                        return;
                    }
                }
            }
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            ProgressBar progressBar = WebFullActivity.this.mProgressBar;
            if (progressBar == null) {
                return;
            }
            if (i2 == 100) {
                progressBar.setVisibility(8);
            } else {
                progressBar.setProgress(i2);
            }
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            WebFullActivity.this.mUploadMessage5 = valueCallback;
            WebFullActivity.this.chooseFilePermission(fileChooserParams);
            return true;
        }

        /* synthetic */ C6721e(WebFullActivity webFullActivity, C6717a c6717a) {
            this();
        }
    }

    /* renamed from: ui.activity.WebFullActivity$f */
    public class C6722f extends WebViewClient {
        public C6722f() {
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            WebFullActivity.this.onErrorView(true);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (!webResourceRequest.getUrl().toString().startsWith("tel:")) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            C7337y1.m26778e(WebFullActivity.this.mActivity, webResourceRequest.getUrl().toString());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void camerPrimssDlg(boolean z) {
        C7257b1.m26230f(this.mActivity, "权限开启", "国家反诈中心未取得权限，这样会导致此功能无法使用。", "取消", "去授权", new C6720d(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseFilePermission(WebChromeClient.FileChooserParams fileChooserParams) {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25521A, C7308a.f25547z}, new C6718b(fileChooserParams));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goScan() {
        startActivityForResult(new Intent(this.mActivity, (Class<?>) CaptureActivity.class), 0);
    }

    private void initAgentWeb() {
        this.mAgentWeb = AgentWeb.with(this).setAgentWebParent(this.mLinearLayout, new LinearLayout.LayoutParams(-1, -1)).closeIndicator().setWebViewClient(new C6722f()).setWebChromeClient(new C6721e(this, null)).addJavascriptInterface("appjs", this.viewFrag.m26132a()).setAgentWebWebSettings(AbsAgentWebSettings.getInstance()).setMainFrameErrorView(C2113R.layout.web_page_error, -1).createAgentWeb().ready().m8080go(this.orginUrl);
        this.mWebview = this.mAgentWeb.getWebCreator().getWebView();
        this.mWebview.setHorizontalScrollBarEnabled(false);
        this.mWebview.getSettings().setTextZoom(100);
        this.mWebview.getSettings().setMediaPlaybackRequiresUserGesture(false);
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
    public void varCamerPrims() {
        varCamerPrims(null);
    }

    /* renamed from: a */
    public /* synthetic */ void m25420a(String str) {
        this.mWebview.evaluateJavascript(str, null);
    }

    public void appCallH5(String str, String str2, boolean z) {
        String str3 = str.substring(0, str.lastIndexOf(125)) + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + "}";
        if (this.mWebview != null) {
            if (!z) {
                final String str4 = "javascript:appCallH5(" + str3 + ")";
                C7301n1.m26454a(this.TAG, "js===" + str4);
                this.mWebview.postDelayed(new Runnable() { // from class: ui.activity.r1
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebFullActivity.this.m25421b(str4);
                    }
                }, 0L);
                return;
            }
            final String str5 = "javascript:appCallH5('" + str3 + "')";
            C7301n1.m26454a(this.TAG, "js===" + str5);
            this.mWebview.postDelayed(new Runnable() { // from class: ui.activity.p1
                @Override // java.lang.Runnable
                public final void run() {
                    WebFullActivity.this.m25420a(str5);
                }
            }, 0L);
        }
    }

    public void appCallH5Other(String str, String str2) {
        if (this.mWebview != null) {
            final String str3 = "javascript:" + str + "(" + str2 + ")";
            C7301n1.m26454a(str + " appCallH5Other-->", str3);
            this.mWebview.postDelayed(new Runnable() { // from class: ui.activity.s1
                @Override // java.lang.Runnable
                public final void run() {
                    WebFullActivity.this.m25422c(str3);
                }
            }, 0L);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void m25421b(String str) {
        this.mWebview.evaluateJavascript(str, null);
    }

    /* renamed from: c */
    public /* synthetic */ void m25422c(String str) {
        this.mWebview.evaluateJavascript(str, null);
    }

    /* renamed from: d */
    public /* synthetic */ void m25423d(String str) {
        appCallH5(str, "\"response\":{\"verifiedStatus\":\"1\"}", false);
    }

    @Override // p388ui.callview.WebFullCallView
    public void eventH5Action(final String str, Map<String, Object> map) {
        if (!map.containsKey("action") || map.get("action") == null) {
            return;
        }
        switch (Integer.parseInt(map.get("action").toString())) {
            case 1:
                finish();
                break;
            case 2:
                if (map.containsKey(SurveyH5Bean.VALUE)) {
                    if (!TextUtils.equals("0", String.valueOf(map.get(SurveyH5Bean.VALUE)))) {
                        C7161b.m25698a((Activity) this, true, false);
                        break;
                    } else {
                        C7161b.m25698a((Activity) this, true, true);
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
                C7340z1.m26805a(this.mActivity).m26811a(17, new IVerifyListener() { // from class: ui.activity.q1
                    @Override // interfaces.IVerifyListener
                    public final void onSuccessVerify() {
                        WebFullActivity.this.m25423d(str);
                    }
                });
                break;
            case 6:
                this.backValue = String.valueOf(map.get(SurveyH5Bean.VALUE));
                if (!TextUtils.equals(this.backValue, "1")) {
                    this.swipBackLayout.setInterEvent(true);
                    break;
                } else {
                    this.swipBackLayout.setInterEvent(false);
                    break;
                }
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

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C7161b.m25698a((Activity) this, true, true);
        C6049c.m24987f().m25001e(this);
        this.swipBackLayout = SwipBackLayout.m26045a(this.mActivity);
        this.swipBackLayout.m26049a();
        this.orginUrl = getIntent().getStringExtra(C7292k1.f25365Q);
        this.mPresenter = new WebFullPresenter(this, this);
        this.viewFrag = new C7248x();
        initWebViewListener();
        initAgentWeb();
    }

    protected void initWebViewListener() {
        this.viewFrag.m26133a(this.mActivity, this.mWebview, new C6717a());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
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

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        appCallH5Other("onBackEvent", "0");
        if (TextUtils.equals(this.backValue, "1")) {
            super.onBackPressed();
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
        AgentWeb agentWeb = this.mAgentWeb;
        if (agentWeb != null) {
            agentWeb.destroy();
        }
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

    @Override // p388ui.callview.WebFullCallView
    public void onSurveyBeanRequest(String str, String str2, boolean z) {
        appCallH5(str, str2, z);
    }

    @OnClick({C2113R.id.ll_network_no})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == C2113R.id.ll_network_no) {
            this.mWebview.reload();
            this.mWebview.setVisibility(0);
            this.mLlNetworkNo.setVisibility(8);
        }
    }

    public void putActionMap(Object obj, String str) {
        if (this.mHashMap == null) {
            this.mHashMap = new HashMap<>();
        }
        this.mHashMap.put(obj, str);
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_web_full;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims(PermissionRequest permissionRequest) {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25524c}, new C6719c(permissionRequest));
    }
}
