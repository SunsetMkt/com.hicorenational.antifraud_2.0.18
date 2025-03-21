package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class SignCriminalDetialActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignCriminalDetialActivity f23123a;

    /* renamed from: b */
    private View f23124b;

    /* renamed from: ui.activity.SignCriminalDetialActivity_ViewBinding$a */
    class C6585a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignCriminalDetialActivity f23125a;

        C6585a(SignCriminalDetialActivity signCriminalDetialActivity) {
            this.f23125a = signCriminalDetialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23125a.onClick(view);
        }
    }

    @UiThread
    public SignCriminalDetialActivity_ViewBinding(SignCriminalDetialActivity signCriminalDetialActivity) {
        this(signCriminalDetialActivity, signCriminalDetialActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCriminalDetialActivity signCriminalDetialActivity = this.f23123a;
        if (signCriminalDetialActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23123a = null;
        signCriminalDetialActivity.mIvBack = null;
        signCriminalDetialActivity.mTvTitle = null;
        signCriminalDetialActivity.mRlPhoneView = null;
        signCriminalDetialActivity.mTvPhone = null;
        signCriminalDetialActivity.mRlSocityView = null;
        signCriminalDetialActivity.mTvSocial = null;
        signCriminalDetialActivity.mRlAudioView = null;
        signCriminalDetialActivity.mRecyclerAudio = null;
        signCriminalDetialActivity.mRlPicView = null;
        signCriminalDetialActivity.mRecyView = null;
        this.f23124b.setOnClickListener(null);
        this.f23124b = null;
    }

    @UiThread
    public SignCriminalDetialActivity_ViewBinding(SignCriminalDetialActivity signCriminalDetialActivity, View view) {
        this.f23123a = signCriminalDetialActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signCriminalDetialActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23124b = findRequiredView;
        findRequiredView.setOnClickListener(new C6585a(signCriminalDetialActivity));
        signCriminalDetialActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCriminalDetialActivity.mRlPhoneView = Utils.findRequiredView(view, C2113R.id.rl_phone_view, "field 'mRlPhoneView'");
        signCriminalDetialActivity.mTvPhone = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_phone_num, "field 'mTvPhone'", TextView.class);
        signCriminalDetialActivity.mRlSocityView = Utils.findRequiredView(view, C2113R.id.rl_socity_view, "field 'mRlSocityView'");
        signCriminalDetialActivity.mTvSocial = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_social_num, "field 'mTvSocial'", TextView.class);
        signCriminalDetialActivity.mRlAudioView = Utils.findRequiredView(view, C2113R.id.rl_audio_view, "field 'mRlAudioView'");
        signCriminalDetialActivity.mRecyclerAudio = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview_audio, "field 'mRecyclerAudio'", RecyclerView.class);
        signCriminalDetialActivity.mRlPicView = Utils.findRequiredView(view, C2113R.id.rl_pic_view, "field 'mRlPicView'");
        signCriminalDetialActivity.mRecyView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyView'", RecyclerView.class);
    }
}
