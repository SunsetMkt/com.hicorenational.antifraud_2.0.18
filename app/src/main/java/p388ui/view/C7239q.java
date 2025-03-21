package p388ui.view;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.load.p118p.AbstractC1665j;
import com.bumptech.glide.p137r.AbstractC1822a;
import com.bumptech.glide.p137r.C1829h;
import com.hicorenational.antifraud.C2113R;
import com.youth.banner.loader.ImageLoader;

/* compiled from: GlideImageLoader.java */
/* renamed from: ui.view.q */
/* loaded from: classes2.dex */
public class C7239q extends ImageLoader {

    /* renamed from: a */
    private static C7239q f24972a;

    /* renamed from: b */
    private static Context f24973b;

    private C7239q() {
    }

    public static C7239q getImageLoader(Context context) {
        f24973b = context;
        if (f24972a == null) {
            f24972a = new C7239q();
        }
        return f24972a;
    }

    @Override // com.youth.banner.loader.ImageLoaderInterface
    public void displayImage(Context context, Object obj, ImageView imageView) {
        ComponentCallbacks2C1576b.m3649e(context).mo3718a(obj).mo3763a((AbstractC1822a<?>) new C1829h().m4777e(C2113R.mipmap.banner1).m4753a(AbstractC1665j.f4537a)).m3768a(imageView);
    }
}
