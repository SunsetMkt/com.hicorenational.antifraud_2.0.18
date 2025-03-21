package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class H5AppSelectedActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private H5AppSelectedActivity f22368a;

    /* renamed from: b */
    private View f22369b;

    /* renamed from: c */
    private View f22370c;

    /* renamed from: d */
    private View f22371d;

    /* renamed from: ui.activity.H5AppSelectedActivity_ViewBinding$a */
    class C6322a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ H5AppSelectedActivity f22372a;

        C6322a(H5AppSelectedActivity h5AppSelectedActivity) {
            this.f22372a = h5AppSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22372a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.H5AppSelectedActivity_ViewBinding$b */
    class C6323b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ H5AppSelectedActivity f22374a;

        C6323b(H5AppSelectedActivity h5AppSelectedActivity) {
            this.f22374a = h5AppSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22374a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.H5AppSelectedActivity_ViewBinding$c */
    class C6324c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ H5AppSelectedActivity f22376a;

        C6324c(H5AppSelectedActivity h5AppSelectedActivity) {
            this.f22376a = h5AppSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22376a.onViewClicked(view);
        }
    }

    @UiThread
    public H5AppSelectedActivity_ViewBinding(H5AppSelectedActivity h5AppSelectedActivity) {
        this(h5AppSelectedActivity, h5AppSelectedActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        H5AppSelectedActivity h5AppSelectedActivity = this.f22368a;
        if (h5AppSelectedActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22368a = null;
        h5AppSelectedActivity.mIvBack = null;
        h5AppSelectedActivity.mTvTitle = null;
        h5AppSelectedActivity.mIvRight = null;
        h5AppSelectedActivity.mExpandableList = null;
        h5AppSelectedActivity.mBtnReport = null;
        this.f22369b.setOnClickListener(null);
        this.f22369b = null;
        this.f22370c.setOnClickListener(null);
        this.f22370c = null;
        this.f22371d.setOnClickListener(null);
        this.f22371d = null;
    }

    @UiThread
    public H5AppSelectedActivity_ViewBinding(H5AppSelectedActivity h5AppSelectedActivity, View view) {
        this.f22368a = h5AppSelectedActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        h5AppSelectedActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22369b = findRequiredView;
        findRequiredView.setOnClickListener(new C6322a(h5AppSelectedActivity));
        h5AppSelectedActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        h5AppSelectedActivity.mIvRight = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f22370c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6323b(h5AppSelectedActivity));
        h5AppSelectedActivity.mExpandableList = (ExpandableListView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview_app, "field 'mExpandableList'", ExpandableListView.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.btn_report, "field 'mBtnReport' and method 'onViewClicked'");
        h5AppSelectedActivity.mBtnReport = (Button) Utils.castView(findRequiredView3, C2113R.id.btn_report, "field 'mBtnReport'", Button.class);
        this.f22371d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6324c(h5AppSelectedActivity));
    }
}
