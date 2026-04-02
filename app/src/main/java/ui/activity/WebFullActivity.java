package ui.activity;

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
import bean.SurveyH5Bean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.just.agentweb.AbsAgentWebSettings;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebViewClient;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.OnWebListener;
import interfaces.PermissionsListener;
import java.util.List;
import java.util.Map;
import network.gson.ResponseDataTypeAdaptor;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.WebFullCallView;
import ui.presenter.WebFullPresenter;
import ui.view.swip.SwipBackLayout;
import util.a2;
import util.g2;
import zxing.android.CaptureActivity;

/* JADX INFO: loaded from: classes2.dex */
public class WebFullActivity extends BaseActivity implements WebFullCallView {
    private AgentWeb mAgentWeb;

    @BindView(R.id.web_container)
    LinearLayout mLinearLayout;

    @BindView(R.id.ll_network_no)
    View mLlNetworkNo;
    private WebFullPresenter mPresenter;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    private ValueCallback<Uri[]> mUploadMessage5;
    private WebView mWebview;
    private String orginUrl;
    private SwipBackLayout swipBackLayout;
    private ui.view.z viewFrag;
    private String TAG = WebFullActivity.class.getSimpleName();
    private int mMaxSelNum = 6;
    private String backValue = "1";

    class a implements OnWebListener {
        a() {
        }

        @Override // interfaces.OnWebListener
        public void shouldIntercept(util.o2.a aVar) {
        }

        @Override // interfaces.OnWebListener
        public void webJsFinish() {
            WebFullActivity.this.onErrorView(false);
        }

        @Override // interfaces.OnWebListener
        public void webJsParame(String str) {
            util.s1.a(WebFullActivity.this.TAG, "param==" + str);
            WebFullActivity.this.mPresenter.SurveyH5Param(str);
        }
    }

    class b implements PermissionsListener {
        final /* synthetic */ WebChromeClient.FileChooserParams a;

        b(WebChromeClient.FileChooserParams fileChooserParams) {
            this.a = fileChooserParams;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(WebFullActivity.this.mActivity, list, z, true, this);
            WebFullActivity.this.receiveCleanData();
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            String[] acceptTypes = this.a.getAcceptTypes();
            if (acceptTypes == null || acceptTypes.length <= 0) {
                return;
            }
            if (acceptTypes[0].contains("image")) {
                k.e.a(WebFullActivity.this.mActivity, 200L, PictureMimeType.ofImage(), WebFullActivity.this.mMaxSelNum).forResult(1001);
                return;
            }
            if (acceptTypes[0].contains("video")) {
                return;
            }
            if (acceptTypes[0].contains("audio")) {
                k.e.a(WebFullActivity.this.mActivity, 200L, PictureMimeType.ofAudio(), WebFullActivity.this.mMaxSelNum).forResult(1002);
            } else if (acceptTypes[0].contains("apk")) {
                Intent intent = new Intent(WebFullActivity.this.mActivity, (Class<?>) H5AppSelectedActivity.class);
                intent.putExtra("extra_select_limite", WebFullActivity.this.mMaxSelNum);
                WebFullActivity.this.startActivityForResult(intent, 1003);
            }
        }
    }

    private class c extends com.just.agentweb.WebChromeClient {
        private c() {
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (Build.VERSION.SDK_INT >= 21) {
                for (String str : permissionRequest.getResources()) {
                    if (str.equals("android.webkit.resource.VIDEO_CAPTURE")) {
                        WebFullActivity.this.mPresenter.varCamerPrims(permissionRequest);
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

        /* synthetic */ c(WebFullActivity webFullActivity, a aVar) {
            this();
        }
    }

    public class d extends WebViewClient {
        public d() {
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
            g2.e(WebFullActivity.this.mActivity, webResourceRequest.getUrl().toString());
            return true;
        }
    }

    public void chooseFilePermission(WebChromeClient.FileChooserParams fileChooserParams) {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z}, new b(fileChooserParams));
    }

    private void initAgentWeb() {
        this.mAgentWeb = AgentWeb.with(this).setAgentWebParent(this.mLinearLayout, new LinearLayout.LayoutParams(-1, -1)).closeIndicator().setWebViewClient(new d()).setWebChromeClient(new c(this, null)).addJavascriptInterface("appjs", this.viewFrag.a()).setAgentWebWebSettings(AbsAgentWebSettings.getInstance()).setMainFrameErrorView(R.layout.web_page_error, -1).createAgentWeb().ready().go(this.orginUrl);
        this.mWebview = this.mAgentWeb.getWebCreator().getWebView();
        this.mWebview.setHorizontalScrollBarEnabled(false);
        this.mWebview.getSettings().setTextZoom(100);
        this.mWebview.getSettings().setMediaPlaybackRequiresUserGesture(false);
    }

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

    public void receiveCleanData() {
        ValueCallback<Uri[]> valueCallback = this.mUploadMessage5;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.mUploadMessage5 = null;
        }
    }

    @Override // ui.callview.WebFullCallView
    public void eventH5Action(int i2, String str, Map<String, Object> map) {
        if (i2 == 10) {
            this.mMaxSelNum = Integer.parseInt(map.get(SurveyH5Bean.VALUE).toString());
        } else {
            if (i2 != 15) {
                return;
            }
            onErrorView(false);
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        org.greenrobot.eventbus.c.f().e(this);
        this.swipBackLayout = SwipBackLayout.a(this.mActivity);
        this.swipBackLayout.a();
        this.orginUrl = getIntent().getStringExtra(util.p1.Q);
        this.viewFrag = new ui.view.z();
        initAgentWeb();
        this.mPresenter = new WebFullPresenter(this.mWebview, this, this);
        initWebViewListener();
    }

    protected void initWebViewListener() {
        this.viewFrag.a(this.mActivity, this.mWebview, new a());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        int i4 = 0;
        if (i2 == 0) {
            if (i3 != -1 || intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra(CaptureActivity.f15121l);
            util.s1.b("content-->" + stringExtra);
            this.mPresenter.appCallH5Map(3, "\"response\":{\"scanValue\":\"" + stringExtra + "\"}", false);
        }
        if (i2 == 1005) {
            a2.a(i2, i3, intent, this);
            return;
        }
        switch (i2) {
            case 1001:
            case 1002:
                List listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent);
                if (listObtainMultipleResult != null && listObtainMultipleResult.size() > 0) {
                    Uri[] uriArr = new Uri[listObtainMultipleResult.size()];
                    while (i4 < listObtainMultipleResult.size()) {
                        LocalMedia localMedia = (LocalMedia) listObtainMultipleResult.get(i4);
                        if (Build.VERSION.SDK_INT > 28) {
                            uriArr[i4] = g2.c(this.mActivity, localMedia.getRealPath());
                        } else {
                            uriArr[i4] = g2.c(this.mActivity, localMedia.getPath());
                        }
                        i4++;
                    }
                    this.mUploadMessage5.onReceiveValue(uriArr);
                    this.mUploadMessage5 = null;
                }
                receiveCleanData();
                break;
            case 1003:
                List listObtainMultipleResult2 = PictureSelector.obtainMultipleResult(intent);
                if (listObtainMultipleResult2 != null && listObtainMultipleResult2.size() > 0) {
                    Uri[] uriArr2 = new Uri[listObtainMultipleResult2.size()];
                    while (i4 < listObtainMultipleResult2.size()) {
                        AppInfoBean appInfoBean = (AppInfoBean) listObtainMultipleResult2.get(i4);
                        if (!TextUtils.isEmpty(appInfoBean.getUri())) {
                            uriArr2[i4] = Uri.parse(appInfoBean.getUri());
                        }
                        i4++;
                    }
                    this.mUploadMessage5.onReceiveValue(uriArr2);
                    this.mUploadMessage5 = null;
                    this.mPresenter.appCallH5Other("getAppBackInfo", ResponseDataTypeAdaptor.buildGson().a(listObtainMultipleResult2));
                }
                receiveCleanData();
                break;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* JADX INFO: renamed from: onBackPressed */
    public void a() {
        this.mPresenter.appCallH5Other("onBackEvent", "0");
        if (TextUtils.equals(this.backValue, "1")) {
            super.a();
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
        AgentWeb agentWeb = this.mAgentWeb;
        if (agentWeb != null) {
            agentWeb.destroy();
        }
    }

    @org.greenrobot.eventbus.m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(util.n2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA == 223) {
                org.greenrobot.eventbus.c.f().f(aVar);
                this.mPresenter.appCallH5Map(5, "\"response\":{\"verifiedStatus\":\"1\"}", false);
                return;
            }
            if (iA == 300) {
                org.greenrobot.eventbus.c.f().f(aVar);
                if (aVar.b() != null) {
                    this.mPresenter.appCallH5Other("getCallBackInfo", ResponseDataTypeAdaptor.buildGson().a(aVar.b()));
                    return;
                }
                return;
            }
            if (iA != 302) {
                return;
            }
            org.greenrobot.eventbus.c.f().f(aVar);
            if (aVar.b() != null) {
                this.mPresenter.appCallH5Other("getSmsBackInfo", ResponseDataTypeAdaptor.buildGson().a(aVar.b()));
            }
        }
    }

    @OnClick({R.id.ll_network_no})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == R.id.ll_network_no) {
            this.mWebview.reload();
            this.mWebview.setVisibility(0);
            this.mLlNetworkNo.setVisibility(8);
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_web_full;
    }
}
