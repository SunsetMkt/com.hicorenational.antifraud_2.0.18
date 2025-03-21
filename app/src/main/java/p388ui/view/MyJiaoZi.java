package p388ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.jzvd.JzvdStd;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class MyJiaoZi extends JzvdStd {

    /* renamed from: i1 */
    ImageView f24586i1;

    /* renamed from: j1 */
    public InterfaceC7184b f24587j1;

    /* renamed from: k1 */
    private int f24588k1;

    /* renamed from: l1 */
    private View f24589l1;

    /* renamed from: ui.view.MyJiaoZi$a */
    class ViewOnClickListenerC7183a implements View.OnClickListener {
        ViewOnClickListenerC7183a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MyJiaoZi myJiaoZi = MyJiaoZi.this;
            InterfaceC7184b interfaceC7184b = myJiaoZi.f24587j1;
            if (interfaceC7184b != null) {
                interfaceC7184b.m25802a(myJiaoZi.f24588k1, MyJiaoZi.this.f24589l1);
            }
        }
    }

    /* renamed from: ui.view.MyJiaoZi$b */
    public interface InterfaceC7184b {
        /* renamed from: a */
        void m25802a(int i2, View view);
    }

    public MyJiaoZi(Context context) {
        super(context);
        this.f24586i1 = new ImageView(context);
        this.f24586i1.setImageResource(C2113R.drawable.ic_video_delete);
        this.f24586i1.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f24586i1.setX(100.0f);
        this.f24586i1.setY(200.0f);
        addView(this.f24586i1);
    }

    public void setOnDeleteClickListener(InterfaceC7184b interfaceC7184b) {
        this.f24587j1 = interfaceC7184b;
    }

    @Override // cn.jzvd.JzvdStd, cn.jzvd.Jzvd
    /* renamed from: u */
    public void mo2485u() {
        super.mo2485u();
        ImageView imageView = this.f24586i1;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // cn.jzvd.JzvdStd, cn.jzvd.Jzvd
    /* renamed from: v */
    public void mo2486v() {
        super.mo2486v();
        ImageView imageView = this.f24586i1;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // cn.jzvd.JzvdStd, cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2455a(Context context) {
        super.mo2455a(context);
    }

    /* renamed from: a */
    public void m25801a(int i2, View view) {
        this.f24588k1 = i2;
        this.f24589l1 = view;
    }

    public MyJiaoZi(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24586i1 = new ImageView(context);
        this.f24586i1.setImageResource(C2113R.drawable.ic_video_delete);
        this.f24586i1.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f24586i1.setX(300.0f);
        this.f24586i1.setY(0.0f);
        this.f24586i1.setOnClickListener(new ViewOnClickListenerC7183a());
        addView(this.f24586i1);
    }
}
