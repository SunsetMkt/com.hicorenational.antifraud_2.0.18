package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class BeforIdVerifyActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BeforIdVerifyActivity f21889a;

    /* renamed from: b */
    private View f21890b;

    /* renamed from: c */
    private View f21891c;

    /* renamed from: ui.activity.BeforIdVerifyActivity_ViewBinding$a */
    class C6153a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ BeforIdVerifyActivity f21892a;

        C6153a(BeforIdVerifyActivity beforIdVerifyActivity) {
            this.f21892a = beforIdVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21892a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.BeforIdVerifyActivity_ViewBinding$b */
    class C6154b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ BeforIdVerifyActivity f21894a;

        C6154b(BeforIdVerifyActivity beforIdVerifyActivity) {
            this.f21894a = beforIdVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21894a.onViewClicked(view);
        }
    }

    @UiThread
    public BeforIdVerifyActivity_ViewBinding(BeforIdVerifyActivity beforIdVerifyActivity) {
        this(beforIdVerifyActivity, beforIdVerifyActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BeforIdVerifyActivity beforIdVerifyActivity = this.f21889a;
        if (beforIdVerifyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21889a = null;
        beforIdVerifyActivity.mIvBack = null;
        beforIdVerifyActivity.mEtName = null;
        beforIdVerifyActivity.mEtID = null;
        beforIdVerifyActivity.mStart = null;
        this.f21890b.setOnClickListener(null);
        this.f21890b = null;
        this.f21891c.setOnClickListener(null);
        this.f21891c = null;
    }

    @UiThread
    public BeforIdVerifyActivity_ViewBinding(BeforIdVerifyActivity beforIdVerifyActivity, View view) {
        this.f21889a = beforIdVerifyActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        beforIdVerifyActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f21890b = findRequiredView;
        findRequiredView.setOnClickListener(new C6153a(beforIdVerifyActivity));
        beforIdVerifyActivity.mEtName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_name, "field 'mEtName'", EditText.class);
        beforIdVerifyActivity.mEtID = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_ID, "field 'mEtID'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_start, "field 'mStart' and method 'onViewClicked'");
        beforIdVerifyActivity.mStart = (Button) Utils.castView(findRequiredView2, C2113R.id.btn_start, "field 'mStart'", Button.class);
        this.f21891c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6154b(beforIdVerifyActivity));
    }
}
