package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class BeforIdVerifyActivity_ViewBinding implements Unbinder {
    private BeforIdVerifyActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13127c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ BeforIdVerifyActivity a;

        a(BeforIdVerifyActivity beforIdVerifyActivity) {
            this.a = beforIdVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ BeforIdVerifyActivity a;

        b(BeforIdVerifyActivity beforIdVerifyActivity) {
            this.a = beforIdVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public BeforIdVerifyActivity_ViewBinding(BeforIdVerifyActivity beforIdVerifyActivity) {
        this(beforIdVerifyActivity, beforIdVerifyActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BeforIdVerifyActivity beforIdVerifyActivity = this.a;
        if (beforIdVerifyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        beforIdVerifyActivity.mIvBack = null;
        beforIdVerifyActivity.mEtName = null;
        beforIdVerifyActivity.mEtID = null;
        beforIdVerifyActivity.mStart = null;
        this.f13126b.setOnClickListener(null);
        this.f13126b = null;
        this.f13127c.setOnClickListener(null);
        this.f13127c = null;
    }

    @UiThread
    public BeforIdVerifyActivity_ViewBinding(BeforIdVerifyActivity beforIdVerifyActivity, View view) {
        this.a = beforIdVerifyActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        beforIdVerifyActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13126b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(beforIdVerifyActivity));
        beforIdVerifyActivity.mEtName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_name, "field 'mEtName'", EditText.class);
        beforIdVerifyActivity.mEtID = (EditText) Utils.findRequiredViewAsType(view, R.id.et_ID, "field 'mEtID'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_start, "field 'mStart' and method 'onViewClicked'");
        beforIdVerifyActivity.mStart = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_start, "field 'mStart'", Button.class);
        this.f13127c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(beforIdVerifyActivity));
    }
}
