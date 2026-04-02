package ui.view;

import android.content.Context;
import android.widget.ImageView;
import com.hicorenational.antifraud.R;
import com.youth.banner.loader.ImageLoader;

/* JADX INFO: compiled from: GlideImageLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends ImageLoader {
    private static s a;

    /* JADX INFO: renamed from: b */
    private static Context f14796b;

    private s() {
    }

    public static s getImageLoader(Context context) {
        f14796b = context;
        if (a == null) {
            a = new s();
        }
        return a;
    }

    @Override // com.youth.banner.loader.ImageLoaderInterface
    public void displayImage(Context context, Object obj, ImageView imageView) {
        com.bumptech.glide.b.e(context).a(obj).a((com.bumptech.glide.r.a<?>) new com.bumptech.glide.r.h().e(R.mipmap.banner1).a(com.bumptech.glide.load.p.j.a)).a(imageView);
    }
}
