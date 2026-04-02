package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class CheckIDActivity_ViewBinding implements Unbinder {
    private CheckIDActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13278e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CheckIDActivity a;

        a(CheckIDActivity checkIDActivity) {
            this.a = checkIDActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CheckIDActivity a;

        b(CheckIDActivity checkIDActivity) {
            this.a = checkIDActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ CheckIDActivity a;

        c(CheckIDActivity checkIDActivity) {
            this.a = checkIDActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ CheckIDActivity a;

        d(CheckIDActivity checkIDActivity) {
            this.a = checkIDActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CheckIDActivity_ViewBinding(CheckIDActivity checkIDActivity) {
        this(checkIDActivity, checkIDActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CheckIDActivity checkIDActivity = this.a;
        if (checkIDActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        checkIDActivity.mIvBack = null;
        checkIDActivity.mTvTitle = null;
        checkIDActivity.mRlAceptRead = null;
        checkIDActivity.mTvAceptRead = null;
        checkIDActivity.mEtCheckPhone = null;
        checkIDActivity.mIdVrfySend = null;
        checkIDActivity.mIdVrfyList = null;
        checkIDActivity.mTvNoReadNum = null;
        this.f13275b.setOnClickListener(null);
        this.f13275b = null;
        this.f13276c.setOnClickListener(null);
        this.f13276c = null;
        this.f13277d.setOnClickListener(null);
        this.f13277d = null;
        this.f13278e.setOnClickListener(null);
        this.f13278e = null;
    }

    @UiThread
    public CheckIDActivity_ViewBinding(CheckIDActivity checkIDActivity, View view) {
        this.a = checkIDActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        checkIDActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13275b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(checkIDActivity));
        checkIDActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_acept_view, "field 'mRlAceptRead' and method 'onViewClicked'");
        checkIDActivity.mRlAceptRead = viewFindRequiredView2;
        this.f13276c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(checkIDActivity));
        checkIDActivity.mTvAceptRead = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_acept_read, "field 'mTvAceptRead'", TextView.class);
        checkIDActivity.mEtCheckPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_check_phone, "field 'mEtCheckPhone'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_idvrfy_send, "field 'mIdVrfySend' and method 'onViewClicked'");
        checkIDActivity.mIdVrfySend = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_idvrfy_send, "field 'mIdVrfySend'", Button.class);
        this.f13277d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(checkIDActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.idvrfy_list, "field 'mIdVrfyList' and method 'onViewClicked'");
        checkIDActivity.mIdVrfyList = viewFindRequiredView4;
        this.f13278e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(checkIDActivity));
        checkIDActivity.mTvNoReadNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_no_read, "field 'mTvNoReadNum'", TextView.class);
    }
}
