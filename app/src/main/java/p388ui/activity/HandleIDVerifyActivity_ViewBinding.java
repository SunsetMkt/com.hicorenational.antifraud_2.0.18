package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
public class HandleIDVerifyActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HandleIDVerifyActivity f22384a;

    /* renamed from: b */
    private View f22385b;

    /* renamed from: c */
    private View f22386c;

    /* renamed from: ui.activity.HandleIDVerifyActivity_ViewBinding$a */
    class C6329a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ HandleIDVerifyActivity f22387a;

        C6329a(HandleIDVerifyActivity handleIDVerifyActivity) {
            this.f22387a = handleIDVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22387a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.HandleIDVerifyActivity_ViewBinding$b */
    class C6330b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ HandleIDVerifyActivity f22389a;

        C6330b(HandleIDVerifyActivity handleIDVerifyActivity) {
            this.f22389a = handleIDVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22389a.onViewClicked(view);
        }
    }

    @UiThread
    public HandleIDVerifyActivity_ViewBinding(HandleIDVerifyActivity handleIDVerifyActivity) {
        this(handleIDVerifyActivity, handleIDVerifyActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HandleIDVerifyActivity handleIDVerifyActivity = this.f22384a;
        if (handleIDVerifyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22384a = null;
        handleIDVerifyActivity.mIvBack = null;
        handleIDVerifyActivity.mTvTitle = null;
        handleIDVerifyActivity.mTvRight = null;
        handleIDVerifyActivity.mEtName = null;
        handleIDVerifyActivity.mEtUserId = null;
        handleIDVerifyActivity.mConfirm = null;
        handleIDVerifyActivity.mTCbSelect = null;
        handleIDVerifyActivity.mTvSelectTips = null;
        this.f22385b.setOnClickListener(null);
        this.f22385b = null;
        this.f22386c.setOnClickListener(null);
        this.f22386c = null;
    }

    @UiThread
    public HandleIDVerifyActivity_ViewBinding(HandleIDVerifyActivity handleIDVerifyActivity, View view) {
        this.f22384a = handleIDVerifyActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        handleIDVerifyActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22385b = findRequiredView;
        findRequiredView.setOnClickListener(new C6329a(handleIDVerifyActivity));
        handleIDVerifyActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        handleIDVerifyActivity.mTvRight = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_right, "field 'mTvRight'", TextView.class);
        handleIDVerifyActivity.mEtName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.user_name, "field 'mEtName'", EditText.class);
        handleIDVerifyActivity.mEtUserId = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.user_ID, "field 'mEtUserId'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_idvrfy_start, "field 'mConfirm' and method 'onViewClicked'");
        handleIDVerifyActivity.mConfirm = (Button) Utils.castView(findRequiredView2, C2113R.id.btn_idvrfy_start, "field 'mConfirm'", Button.class);
        this.f22386c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6330b(handleIDVerifyActivity));
        handleIDVerifyActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, C2113R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        handleIDVerifyActivity.mTvSelectTips = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_select_tip, "field 'mTvSelectTips'", TextView.class);
    }
}
