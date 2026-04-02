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
public class H5AppSelectedActivity_ViewBinding implements Unbinder {
    private H5AppSelectedActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13402d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ H5AppSelectedActivity a;

        a(H5AppSelectedActivity h5AppSelectedActivity) {
            this.a = h5AppSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ H5AppSelectedActivity a;

        b(H5AppSelectedActivity h5AppSelectedActivity) {
            this.a = h5AppSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ H5AppSelectedActivity a;

        c(H5AppSelectedActivity h5AppSelectedActivity) {
            this.a = h5AppSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public H5AppSelectedActivity_ViewBinding(H5AppSelectedActivity h5AppSelectedActivity) {
        this(h5AppSelectedActivity, h5AppSelectedActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        H5AppSelectedActivity h5AppSelectedActivity = this.a;
        if (h5AppSelectedActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        h5AppSelectedActivity.mIvBack = null;
        h5AppSelectedActivity.mTvTitle = null;
        h5AppSelectedActivity.mIvRight = null;
        h5AppSelectedActivity.mExpandableList = null;
        h5AppSelectedActivity.mBtnReport = null;
        this.f13400b.setOnClickListener(null);
        this.f13400b = null;
        this.f13401c.setOnClickListener(null);
        this.f13401c = null;
        this.f13402d.setOnClickListener(null);
        this.f13402d = null;
    }

    @UiThread
    public H5AppSelectedActivity_ViewBinding(H5AppSelectedActivity h5AppSelectedActivity, View view) {
        this.a = h5AppSelectedActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        h5AppSelectedActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13400b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(h5AppSelectedActivity));
        h5AppSelectedActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        h5AppSelectedActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f13401c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(h5AppSelectedActivity));
        h5AppSelectedActivity.mExpandableList = (ExpandableListView) Utils.findRequiredViewAsType(view, R.id.recyclerview_app, "field 'mExpandableList'", ExpandableListView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_report, "field 'mBtnReport' and method 'onViewClicked'");
        h5AppSelectedActivity.mBtnReport = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_report, "field 'mBtnReport'", Button.class);
        this.f13402d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(h5AppSelectedActivity));
    }
}
