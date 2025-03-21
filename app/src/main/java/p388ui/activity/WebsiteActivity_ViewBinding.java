package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class WebsiteActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private WebsiteActivity f23544a;

    /* renamed from: b */
    private View f23545b;

    /* renamed from: c */
    private View f23546c;

    /* renamed from: d */
    private View f23547d;

    /* renamed from: e */
    private View f23548e;

    /* renamed from: ui.activity.WebsiteActivity_ViewBinding$a */
    class C6725a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WebsiteActivity f23549a;

        C6725a(WebsiteActivity websiteActivity) {
            this.f23549a = websiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23549a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WebsiteActivity_ViewBinding$b */
    class C6726b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WebsiteActivity f23551a;

        C6726b(WebsiteActivity websiteActivity) {
            this.f23551a = websiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23551a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WebsiteActivity_ViewBinding$c */
    class C6727c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WebsiteActivity f23553a;

        C6727c(WebsiteActivity websiteActivity) {
            this.f23553a = websiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23553a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WebsiteActivity_ViewBinding$d */
    class C6728d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WebsiteActivity f23555a;

        C6728d(WebsiteActivity websiteActivity) {
            this.f23555a = websiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23555a.onViewClicked(view);
        }
    }

    @UiThread
    public WebsiteActivity_ViewBinding(WebsiteActivity websiteActivity) {
        this(websiteActivity, websiteActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebsiteActivity websiteActivity = this.f23544a;
        if (websiteActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23544a = null;
        websiteActivity.mIvBack = null;
        websiteActivity.mTvTitle = null;
        websiteActivity.mVline = null;
        websiteActivity.mTvSelectHistory = null;
        websiteActivity.mLinearLayout = null;
        websiteActivity.mTvCommit = null;
        websiteActivity.mBtnCommit = null;
        this.f23545b.setOnClickListener(null);
        this.f23545b = null;
        this.f23546c.setOnClickListener(null);
        this.f23546c = null;
        this.f23547d.setOnClickListener(null);
        this.f23547d = null;
        this.f23548e.setOnClickListener(null);
        this.f23548e = null;
    }

    @UiThread
    public WebsiteActivity_ViewBinding(WebsiteActivity websiteActivity, View view) {
        this.f23544a = websiteActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        websiteActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23545b = findRequiredView;
        findRequiredView.setOnClickListener(new C6725a(websiteActivity));
        websiteActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        websiteActivity.mVline = Utils.findRequiredView(view, C2113R.id.v_line, "field 'mVline'");
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.fl_select_history, "field 'mTvSelectHistory' and method 'onViewClicked'");
        websiteActivity.mTvSelectHistory = findRequiredView2;
        this.f23546c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6726b(websiteActivity));
        websiteActivity.mLinearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.linearlayout, "field 'mLinearLayout'", LinearLayout.class);
        websiteActivity.mTvCommit = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_commit_tip, "field 'mTvCommit'", TextView.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        websiteActivity.mBtnCommit = (Button) Utils.castView(findRequiredView3, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f23547d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6727c(websiteActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.fl_select, "method 'onViewClicked'");
        this.f23548e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6728d(websiteActivity));
    }
}
