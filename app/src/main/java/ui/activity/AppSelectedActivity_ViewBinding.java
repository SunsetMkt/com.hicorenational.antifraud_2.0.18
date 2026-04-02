package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class AppSelectedActivity_ViewBinding implements Unbinder {
    private AppSelectedActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13107d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AppSelectedActivity a;

        a(AppSelectedActivity appSelectedActivity) {
            this.a = appSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ AppSelectedActivity a;

        b(AppSelectedActivity appSelectedActivity) {
            this.a = appSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ AppSelectedActivity a;

        c(AppSelectedActivity appSelectedActivity) {
            this.a = appSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AppSelectedActivity_ViewBinding(AppSelectedActivity appSelectedActivity) {
        this(appSelectedActivity, appSelectedActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AppSelectedActivity appSelectedActivity = this.a;
        if (appSelectedActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        appSelectedActivity.mIvBack = null;
        appSelectedActivity.mTvTitle = null;
        appSelectedActivity.mIvRight = null;
        appSelectedActivity.mExpandableList = null;
        appSelectedActivity.mBtnReport = null;
        this.f13105b.setOnClickListener(null);
        this.f13105b = null;
        this.f13106c.setOnClickListener(null);
        this.f13106c = null;
        this.f13107d.setOnClickListener(null);
        this.f13107d = null;
    }

    @UiThread
    public AppSelectedActivity_ViewBinding(AppSelectedActivity appSelectedActivity, View view) {
        this.a = appSelectedActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        appSelectedActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13105b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(appSelectedActivity));
        appSelectedActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        appSelectedActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f13106c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(appSelectedActivity));
        appSelectedActivity.mExpandableList = (ExpandableListView) Utils.findRequiredViewAsType(view, R.id.recyclerview_app, "field 'mExpandableList'", ExpandableListView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_report, "field 'mBtnReport' and method 'onViewClicked'");
        appSelectedActivity.mBtnReport = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_report, "field 'mBtnReport'", Button.class);
        this.f13107d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(appSelectedActivity));
    }
}
