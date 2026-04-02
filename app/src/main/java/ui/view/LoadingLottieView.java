package ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class LoadingLottieView extends LinearLayout {
    private LottieAnimationView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f14558b;

    public LoadingLottieView(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.loading_lottie_view, (ViewGroup) this, true);
        this.a = (LottieAnimationView) findViewById(R.id.lottie_view);
        this.f14558b = (TextView) findViewById(R.id.lottie_text);
        this.a.setRenderMode(com.airbnb.lottie.t.SOFTWARE);
        this.a.setScale(0.4f);
    }

    public void b() {
        this.a.g();
    }

    public void c() {
        this.a.h();
    }

    @Override // android.view.View
    public void clearAnimation() {
        this.a.a();
        this.a.clearAnimation();
        this.a.clearFocus();
    }

    public void setDescText(String str) {
        this.f14558b.setText(str);
    }

    public void setLottieAnimation(String str) {
        this.a.setAnimation(str);
    }

    public void setLottieLoop(boolean z) {
        this.a.setRepeatCount(z ? -1 : 0);
    }

    public LoadingLottieView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingLottieView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    public void a() {
        this.a.a();
    }
}
