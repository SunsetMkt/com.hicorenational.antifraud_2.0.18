package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import bean.APIH5Bean;
import bean.ShareConfigBean;
import bean.SurveyH5Bean;
import butterknife.BindView;
import butterknife.OnClick;
import com.google.gson.C2051e;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import interfaces.IHandler;
import interfaces.OnWebListener;
import java.net.URLDecoder;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import manager.AccountManager;
import network.gson.ObjectTypeAdapter;
import network.http.RegionConfigHttp;
import network.http.StatisticsShareHttp;
import p245d.C4440a;
import p388ui.callview.WebShareView;
import p388ui.p391f.DialogC6827c;
import p388ui.presenter.WebPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.MyWebView;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.p396d2.C7269a;
import util.p396d2.C7270b;

/* loaded from: classes2.dex */
public class WebActivity extends BaseActivity implements WebShareView, IHandler.HandleWebActListener {
    private String articId;
    private int caragyCode;

    @BindView(C2113R.id.fl_mask)
    View mFlmask;

    @BindView(C2113R.id.ll_network_no)
    View mLlNetworkNo;
    private String mOrginUrl;
    private String mPersonalize;
    private WebPresenter mPresenter;

    @BindView(C2113R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(C2113R.id.ll_progress)
    View mProgressLoad;

    @BindView(C2113R.id.rl_title)
    View mRlTitle;

    @BindView(C2113R.id.iv_back)
    ImageView mTIvBack;

    @BindView(C2113R.id.iv_right)
    ImageView mTIvShare;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @BindView(C2113R.id.webview)
    MyWebView mWebview;
    private ShareConfigBean shareBean;
    private boolean shareFullScreen;
    private SwipBackLayout swipBackLayout;
    private int toPage;
    private String mTitle = "";
    private String mShareBaseUrl = "";

    /* renamed from: ui.activity.WebActivity$a */
    class C6710a implements IClickListener {
        C6710a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            WebActivity webActivity = WebActivity.this;
            webActivity.mWebview.loadUrl(webActivity.mOrginUrl);
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* renamed from: ui.activity.WebActivity$b */
    class C6711b implements OnWebListener {
        C6711b() {
        }

        @Override // interfaces.OnWebListener
        public void shouldIntercept(C7269a c7269a) {
            WebActivity.this.sendWebMsg(c7269a);
        }

        @Override // interfaces.OnWebListener
        public void webJsFinish() {
        }

        @Override // interfaces.OnWebListener
        public void webJsParame(String str) {
            SurveyH5Bean surveyH5Bean;
            String str2;
            if (TextUtils.isEmpty(str) || (surveyH5Bean = (SurveyH5Bean) ObjectTypeAdapter.buildNewGson().m5569a(str, SurveyH5Bean.class)) == null || surveyH5Bean.getParams() == null) {
                return;
            }
            try {
                Map<String, Object> params = surveyH5Bean.getParams();
                int parseInt = Integer.parseInt(params.get("action").toString());
                if (parseInt != 17) {
                    if (parseInt == 16) {
                        MyWebView.cleanCache();
                        return;
                    }
                    return;
                }
                String obj = params.get(SurveyH5Bean.VALUE).toString();
                WebActivity webActivity = WebActivity.this;
                if (TextUtils.equals(obj, "0")) {
                    str2 = C4440a.f16886h + C4440a.m16392a(8);
                } else {
                    str2 = C4440a.f16881c;
                }
                webActivity.mShareBaseUrl = str2;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: ui.activity.WebActivity$c */
    class C6712c extends WebChromeClient {
        C6712c() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            WebActivity webActivity = WebActivity.this;
            ProgressBar progressBar = webActivity.mProgressBar;
            if (progressBar == null || webActivity.mProgressLoad == null) {
                return;
            }
            if (i2 == 100) {
                progressBar.setVisibility(8);
                WebActivity.this.mProgressLoad.setVisibility(8);
            } else {
                progressBar.setVisibility(0);
                WebActivity.this.mProgressBar.setProgress(i2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            WebActivity webActivity;
            TextView textView;
            super.onReceivedTitle(webView, str);
            if (!TextUtils.isEmpty(WebActivity.this.mTitle) || TextUtils.isEmpty(str) || (textView = (webActivity = WebActivity.this).mTvTitle) == null) {
                return;
            }
            textView.setText(webActivity.mTitle);
        }
    }

    private void initView() {
        this.shareFullScreen = false;
        this.mRlTitle.setBackgroundResource(C2113R.drawable.status_bar_bg);
        this.mTvTitle.setText(this.mTitle);
        this.swipBackLayout.setInterEvent(false);
        this.mTIvBack.setVisibility(0);
        this.mTIvShare.setBackgroundResource(0);
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
                Intent intent = new Intent(this.mActivity, (Class<?>) PromosWebDetActivity.class);
                intent.putExtra(C7292k1.f25363P, decode);
                intent.putExtra(C7292k1.f25365Q, m26326a);
                intent.putExtra(C7292k1.f25371T, this.articId);
                startActivity(intent);
            }
            String m26323b2 = c7269a.m26323b("isfullScreen");
            String m26323b3 = c7269a.m26323b("stylecolor");
            String m26323b4 = c7269a.m26323b("toPage");
            if (TextUtils.equals("yes", m26323b2)) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(2);
            } else if (TextUtils.equals("no", m26323b2)) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(3);
            } else if (TextUtils.equals("black", m26323b3)) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(4);
            } else if (TextUtils.equals("white", m26323b3)) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(5);
            } else if (TextUtils.equals("1", m26323b4)) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(8);
            } else if (TextUtils.equals("2", m26323b4)) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(9);
            } else if (TextUtils.equals("3", m26323b4)) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(10);
            }
            if (TextUtils.equals(c7269a.m26323b("appBack"), "1")) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(11);
            }
        } catch (Exception unused) {
        }
    }

    private void testPage(int i2) {
        this.toPage = i2;
        C7161b.m25698a((Activity) this, true, false);
        this.mRlTitle.setBackgroundResource(C2113R.drawable.transparent);
        this.mTvTitle.setText(this.mTitle + "人群防诈骗指数测试");
        this.swipBackLayout.setInterEvent(true);
        this.mFlmask.setVisibility(8);
        this.mTIvBack.setImageResource(C2113R.mipmap.iv_white_back);
        this.mTvTitle.setTextColor(Color.parseColor("#ffffff"));
        this.mTIvShare.setBackgroundResource(C2113R.drawable.iv_share_white);
    }

    private void turnPage() {
        Intent intent = new Intent();
        if (!RegionConfigHttp.existNodeRegion()) {
            intent.setClass(this, AddressActivity.class);
        } else if (AccountManager.isLogin()) {
            intent.setClass(this, MainActivity.class);
        } else {
            intent.setClass(this, LoginActivity.class);
        }
        startActivity(intent);
        if (isFinishing()) {
            return;
        }
        finish();
    }

    /* renamed from: a */
    public /* synthetic */ void m25419a() {
        StatisticsShareHttp.getInstance().shareArticleHttp(this.articId);
    }

    @Override // interfaces.IHandler.HandleListener
    public void handleMsg(Message message) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        initView();
        switch (message.what) {
            case 2:
                C7161b.m25698a((Activity) this, true, false);
                this.mRlTitle.setVisibility(0);
                this.mFlmask.setVisibility(8);
                this.mRlTitle.setBackgroundResource(C2113R.drawable.transparent);
                this.swipBackLayout.setInterEvent(true);
                this.mTvTitle.setText("");
                this.mTIvBack.setVisibility(8);
                this.mTIvShare.setBackgroundResource(C2113R.drawable.iv_share_white);
                this.shareFullScreen = true;
                break;
            case 3:
                C7161b.m25698a((Activity) this, true, true);
                this.mRlTitle.setVisibility(0);
                this.mFlmask.setVisibility(0);
                this.swipBackLayout.setInterEvent(false);
                break;
            case 4:
                C7161b.m25698a((Activity) this, true, true);
                this.mRlTitle.setVisibility(8);
                this.mFlmask.setVisibility(8);
                this.swipBackLayout.setInterEvent(true);
                break;
            case 5:
                C7161b.m25698a((Activity) this, true, false);
                this.mRlTitle.setVisibility(8);
                this.mFlmask.setVisibility(8);
                this.swipBackLayout.setInterEvent(true);
                break;
            case 8:
                this.toPage = 1;
                C7161b.m25698a((Activity) this, true, true);
                this.mRlTitle.setBackgroundResource(C2113R.drawable.status_bar_bg);
                this.mTvTitle.setText(this.mTitle);
                this.swipBackLayout.setInterEvent(false);
                this.mFlmask.setVisibility(0);
                this.mTIvBack.setImageResource(C2113R.drawable.back_bla_arrow);
                this.mTvTitle.setTextColor(Color.parseColor("#1D1A33"));
                this.mTIvShare.setBackgroundResource(0);
                break;
            case 9:
                testPage(2);
                break;
            case 10:
                testPage(3);
                break;
            case 11:
                onBackPressed();
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C7161b.m25698a((Activity) this, true, true);
        this.swipBackLayout = SwipBackLayout.m26045a(this.mActivity);
        this.swipBackLayout.m26049a();
        IHandler.setHandleMsgListener(this);
        this.mTitle = getIntent().getStringExtra(C7292k1.f25363P);
        this.mOrginUrl = getIntent().getStringExtra(C7292k1.f25365Q);
        this.caragyCode = getIntent().getIntExtra(C7292k1.f25375V, -9);
        this.mPersonalize = getIntent().getStringExtra(C7292k1.f25383Z);
        this.mTvTitle.setText(this.mTitle);
        initWebView(this.mWebview);
        this.mWebview.loadUrl(this.mOrginUrl);
        this.mProgressLoad.setVisibility(0);
        this.mPresenter = new WebPresenter(this.mActivity, this);
        if (TextUtils.equals(this.mPersonalize, C7292k1.f25386a0)) {
            this.swipBackLayout.setInterEvent(true);
        }
    }

    protected void initWebView(MyWebView myWebView) {
        myWebView.setListener(this.mActivity, new C6711b());
        myWebView.setWebChromeClient(new C6712c());
        myWebView.setWebViewClient(new C6713d());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.mWebview.canGoBack()) {
            if (TextUtils.equals(this.mPersonalize, C7292k1.f25386a0)) {
                turnPage();
            }
            super.onBackPressed();
            return;
        }
        int i2 = this.toPage;
        if (i2 == 3) {
            C7257b1.m26211b(this.mActivity, "确定要退出答题?", "退出后已作答题目将不会保存", "退出", "继续", new C6710a());
        } else if (i2 == 2) {
            this.mWebview.loadUrl(this.mOrginUrl);
        } else {
            super.onBackPressed();
        }
    }

    @Override // p388ui.callview.WebShareView
    public void onSuccessShareConfig(APIH5Bean aPIH5Bean) {
        if (aPIH5Bean != null) {
            try {
                if (!TextUtils.isEmpty(aPIH5Bean.getValue())) {
                    this.shareBean = (ShareConfigBean) new C2051e().m5569a(aPIH5Bean.getValue(), ShareConfigBean.class);
                    String replace = this.shareBean.title.replace("{0}", this.mTitle);
                    String replace2 = this.shareBean.downloadUrl.replace("{1}", C4440a.m16411m() + "").replace("{2}", this.caragyCode + "");
                    this.shareBean.title = replace;
                    this.shareBean.downloadUrl = replace2;
                }
            } catch (Exception unused) {
            }
        }
        ShareConfigBean shareConfigBean = this.shareBean;
        if (shareConfigBean != null) {
            new DialogC6827c(this.mActivity, shareConfigBean, 2, new DialogC6827c.b() { // from class: ui.activity.o1
                @Override // p388ui.p391f.DialogC6827c.b
                /* renamed from: a */
                public final void mo25436a() {
                    WebActivity.this.m25419a();
                }
            }).show();
        }
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
            if (this.shareFullScreen) {
                this.mPresenter.requestAticleInfo(this.mShareBaseUrl, this.articId);
                return;
            } else {
                this.mPresenter.requestShareConfig();
                return;
            }
        }
        if (id != C2113R.id.ll_network_no) {
            return;
        }
        this.mWebview.reload();
        this.mWebview.setVisibility(0);
        this.mLlNetworkNo.setVisibility(8);
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_web;
    }

    /* renamed from: ui.activity.WebActivity$d */
    class C6713d extends WebViewClient {
        C6713d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            View view = WebActivity.this.mLlNetworkNo;
            if (view != null) {
                view.setVisibility(0);
            }
            MyWebView myWebView = WebActivity.this.mWebview;
            if (myWebView != null) {
                myWebView.setVisibility(8);
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            AtomicReference atomicReference = new AtomicReference();
            if (Build.VERSION.SDK_INT >= 21) {
                atomicReference.set(webResourceRequest.getUrl().getPath());
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return false;
            }
            try {
                if (!str.startsWith("http:") && !str.startsWith("https:")) {
                    WebActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                }
                webView.loadUrl(str);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }
}
