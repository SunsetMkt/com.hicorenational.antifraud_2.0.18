package ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.jzvd.JzvdStd;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class MyJiaoZi extends JzvdStd {
    ImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f14579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f14581d;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MyJiaoZi myJiaoZi = MyJiaoZi.this;
            b bVar = myJiaoZi.f14579b;
            if (bVar != null) {
                bVar.a(myJiaoZi.f14580c, MyJiaoZi.this.f14581d);
            }
        }
    }

    public interface b {
        void a(int i2, View view);
    }

    public MyJiaoZi(Context context) {
        super(context);
        this.a = new ImageView(context);
        this.a.setImageResource(R.drawable.ic_video_delete);
        this.a.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.a.setX(100.0f);
        this.a.setY(200.0f);
        addView(this.a);
    }

    @Override // cn.jzvd.JzvdStd, cn.jzvd.Jzvd
    public void init(Context context) {
        super.init(context);
    }

    public void setOnDeleteClickListener(b bVar) {
        this.f14579b = bVar;
    }

    @Override // cn.jzvd.JzvdStd, cn.jzvd.Jzvd
    public void setScreenFullscreen() {
        super.setScreenFullscreen();
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // cn.jzvd.JzvdStd, cn.jzvd.Jzvd
    public void setScreenNormal() {
        super.setScreenNormal();
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void a(int i2, View view) {
        this.f14580c = i2;
        this.f14581d = view;
    }

    public MyJiaoZi(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ImageView(context);
        this.a.setImageResource(R.drawable.ic_video_delete);
        this.a.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.a.setX(300.0f);
        this.a.setY(0.0f);
        this.a.setOnClickListener(new a());
        addView(this.a);
    }
}
