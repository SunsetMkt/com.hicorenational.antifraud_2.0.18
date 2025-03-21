package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class CheckIDActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CheckIDActivity f22140a;

    /* renamed from: b */
    private View f22141b;

    /* renamed from: c */
    private View f22142c;

    /* renamed from: d */
    private View f22143d;

    /* renamed from: e */
    private View f22144e;

    /* renamed from: ui.activity.CheckIDActivity_ViewBinding$a */
    class C6235a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CheckIDActivity f22145a;

        C6235a(CheckIDActivity checkIDActivity) {
            this.f22145a = checkIDActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22145a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CheckIDActivity_ViewBinding$b */
    class C6236b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CheckIDActivity f22147a;

        C6236b(CheckIDActivity checkIDActivity) {
            this.f22147a = checkIDActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22147a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CheckIDActivity_ViewBinding$c */
    class C6237c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CheckIDActivity f22149a;

        C6237c(CheckIDActivity checkIDActivity) {
            this.f22149a = checkIDActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22149a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CheckIDActivity_ViewBinding$d */
    class C6238d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CheckIDActivity f22151a;

        C6238d(CheckIDActivity checkIDActivity) {
            this.f22151a = checkIDActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22151a.onViewClicked(view);
        }
    }

    @UiThread
    public CheckIDActivity_ViewBinding(CheckIDActivity checkIDActivity) {
        this(checkIDActivity, checkIDActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CheckIDActivity checkIDActivity = this.f22140a;
        if (checkIDActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22140a = null;
        checkIDActivity.mIvBack = null;
        checkIDActivity.mTvTitle = null;
        checkIDActivity.mRlAceptRead = null;
        checkIDActivity.mTvAceptRead = null;
        checkIDActivity.mEtCheckPhone = null;
        checkIDActivity.mIdVrfySend = null;
        checkIDActivity.mIdVrfyList = null;
        checkIDActivity.mTvNoReadNum = null;
        this.f22141b.setOnClickListener(null);
        this.f22141b = null;
        this.f22142c.setOnClickListener(null);
        this.f22142c = null;
        this.f22143d.setOnClickListener(null);
        this.f22143d = null;
        this.f22144e.setOnClickListener(null);
        this.f22144e = null;
    }

    @UiThread
    public CheckIDActivity_ViewBinding(CheckIDActivity checkIDActivity, View view) {
        this.f22140a = checkIDActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        checkIDActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22141b = findRequiredView;
        findRequiredView.setOnClickListener(new C6235a(checkIDActivity));
        checkIDActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.rl_acept_view, "field 'mRlAceptRead' and method 'onViewClicked'");
        checkIDActivity.mRlAceptRead = findRequiredView2;
        this.f22142c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6236b(checkIDActivity));
        checkIDActivity.mTvAceptRead = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_acept_read, "field 'mTvAceptRead'", TextView.class);
        checkIDActivity.mEtCheckPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_check_phone, "field 'mEtCheckPhone'", EditText.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.btn_idvrfy_send, "field 'mIdVrfySend' and method 'onViewClicked'");
        checkIDActivity.mIdVrfySend = (Button) Utils.castView(findRequiredView3, C2113R.id.btn_idvrfy_send, "field 'mIdVrfySend'", Button.class);
        this.f22143d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6237c(checkIDActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.idvrfy_list, "field 'mIdVrfyList' and method 'onViewClicked'");
        checkIDActivity.mIdVrfyList = findRequiredView4;
        this.f22144e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6238d(checkIDActivity));
        checkIDActivity.mTvNoReadNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_no_read, "field 'mTvNoReadNum'", TextView.class);
    }
}
