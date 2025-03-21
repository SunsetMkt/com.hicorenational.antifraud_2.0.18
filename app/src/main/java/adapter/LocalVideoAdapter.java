package adapter;

import android.net.Uri;
import android.widget.TextView;
import cn.jzvd.JzvdStd;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.p137r.AbstractC1822a;
import com.bumptech.glide.p137r.C1829h;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
public class LocalVideoAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {
    public LocalVideoAdapter(List<LocalMedia> list) {
        super(C2113R.layout.item_local_video, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        ((TextView) baseViewHolder.m5224c(C2113R.id.video_tip)).setVisibility(8);
        JzvdStd jzvdStd = (JzvdStd) baseViewHolder.m5224c(C2113R.id.image_view);
        C1829h c1829h = new C1829h();
        c1829h.m4777e(C2113R.drawable.ic_add);
        ComponentCallbacks2C1576b.m3649e(this.f5580x).mo3715a(Uri.fromFile(new File(localMedia.getPath()))).mo3763a((AbstractC1822a<?>) c1829h).m3768a(jzvdStd.f2791E0);
        jzvdStd.m2461a(localMedia.getPath(), localMedia.getPath(), 0);
    }
}
