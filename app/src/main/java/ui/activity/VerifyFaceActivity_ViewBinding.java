package ui.activity;

import android.view.View;
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
public class VerifyFaceActivity_ViewBinding implements Unbinder {
    private VerifyFaceActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13952e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ VerifyFaceActivity a;

        a(VerifyFaceActivity verifyFaceActivity) {
            this.a = verifyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ VerifyFaceActivity a;

        b(VerifyFaceActivity verifyFaceActivity) {
            this.a = verifyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ VerifyFaceActivity a;

        c(VerifyFaceActivity verifyFaceActivity) {
            this.a = verifyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ VerifyFaceActivity a;

        d(VerifyFaceActivity verifyFaceActivity) {
            this.a = verifyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public VerifyFaceActivity_ViewBinding(VerifyFaceActivity verifyFaceActivity) {
        this(verifyFaceActivity, verifyFaceActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VerifyFaceActivity verifyFaceActivity = this.a;
        if (verifyFaceActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        verifyFaceActivity.mIvBack = null;
        verifyFaceActivity.mTvTitle = null;
        verifyFaceActivity.mTvRight = null;
        verifyFaceActivity.mTvCardType = null;
        verifyFaceActivity.mUserName = null;
        verifyFaceActivity.mUserID = null;
        verifyFaceActivity.mConfirm = null;
        this.f13949b.setOnClickListener(null);
        this.f13949b = null;
        this.f13950c.setOnClickListener(null);
        this.f13950c = null;
        this.f13951d.setOnClickListener(null);
        this.f13951d = null;
        this.f13952e.setOnClickListener(null);
        this.f13952e = null;
    }

    @UiThread
    public VerifyFaceActivity_ViewBinding(VerifyFaceActivity verifyFaceActivity, View view) {
        this.a = verifyFaceActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        verifyFaceActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13949b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(verifyFaceActivity));
        verifyFaceActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_right, "field 'mTvRight' and method 'onViewClicked'");
        verifyFaceActivity.mTvRight = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_right, "field 'mTvRight'", TextView.class);
        this.f13950c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(verifyFaceActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_card_type, "field 'mTvCardType' and method 'onViewClicked'");
        verifyFaceActivity.mTvCardType = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_card_type, "field 'mTvCardType'", TextView.class);
        this.f13951d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(verifyFaceActivity));
        verifyFaceActivity.mUserName = (EditText) Utils.findRequiredViewAsType(view, R.id.user_name, "field 'mUserName'", EditText.class);
        verifyFaceActivity.mUserID = (EditText) Utils.findRequiredViewAsType(view, R.id.user_ID, "field 'mUserID'", EditText.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        verifyFaceActivity.mConfirm = (TextView) Utils.castView(viewFindRequiredView4, R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f13952e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(verifyFaceActivity));
    }
}
