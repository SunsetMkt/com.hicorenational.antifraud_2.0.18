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
public class AppSelectedActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AppSelectedActivity f21835a;

    /* renamed from: b */
    private View f21836b;

    /* renamed from: c */
    private View f21837c;

    /* renamed from: d */
    private View f21838d;

    /* renamed from: ui.activity.AppSelectedActivity_ViewBinding$a */
    class C6125a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AppSelectedActivity f21839a;

        C6125a(AppSelectedActivity appSelectedActivity) {
            this.f21839a = appSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21839a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.AppSelectedActivity_ViewBinding$b */
    class C6126b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AppSelectedActivity f21841a;

        C6126b(AppSelectedActivity appSelectedActivity) {
            this.f21841a = appSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21841a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.AppSelectedActivity_ViewBinding$c */
    class C6127c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AppSelectedActivity f21843a;

        C6127c(AppSelectedActivity appSelectedActivity) {
            this.f21843a = appSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21843a.onViewClicked(view);
        }
    }

    @UiThread
    public AppSelectedActivity_ViewBinding(AppSelectedActivity appSelectedActivity) {
        this(appSelectedActivity, appSelectedActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AppSelectedActivity appSelectedActivity = this.f21835a;
        if (appSelectedActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21835a = null;
        appSelectedActivity.mIvBack = null;
        appSelectedActivity.mTvTitle = null;
        appSelectedActivity.mIvRight = null;
        appSelectedActivity.mExpandableList = null;
        appSelectedActivity.mBtnReport = null;
        this.f21836b.setOnClickListener(null);
        this.f21836b = null;
        this.f21837c.setOnClickListener(null);
        this.f21837c = null;
        this.f21838d.setOnClickListener(null);
        this.f21838d = null;
    }

    @UiThread
    public AppSelectedActivity_ViewBinding(AppSelectedActivity appSelectedActivity, View view) {
        this.f21835a = appSelectedActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        appSelectedActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f21836b = findRequiredView;
        findRequiredView.setOnClickListener(new C6125a(appSelectedActivity));
        appSelectedActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        appSelectedActivity.mIvRight = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f21837c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6126b(appSelectedActivity));
        appSelectedActivity.mExpandableList = (ExpandableListView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview_app, "field 'mExpandableList'", ExpandableListView.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.btn_report, "field 'mBtnReport' and method 'onViewClicked'");
        appSelectedActivity.mBtnReport = (Button) Utils.castView(findRequiredView3, C2113R.id.btn_report, "field 'mBtnReport'", Button.class);
        this.f21838d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6127c(appSelectedActivity));
    }
}
