package adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;

/* loaded from: classes.dex */
public class SmsPictureAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {

    /* renamed from: a0 */
    static final int f319a0 = 0;

    /* renamed from: b0 */
    static final int f320b0 = 1;

    /* renamed from: V */
    private List<LocalMedia> f321V;

    /* renamed from: W */
    private InterfaceC0074b f322W;

    /* renamed from: X */
    private boolean f323X;

    /* renamed from: Y */
    private int f324Y;

    /* renamed from: Z */
    private boolean f325Z;

    /* renamed from: adapter.SmsPictureAdapter$a */
    class ViewOnClickListenerC0073a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ BaseViewHolder f326a;

        ViewOnClickListenerC0073a(BaseViewHolder baseViewHolder) {
            this.f326a = baseViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SmsPictureAdapter.this.f322W != null) {
                SmsPictureAdapter.this.f322W.onItemClickListener(this.f326a.getAdapterPosition(), SmsPictureAdapter.this.f321V);
            }
        }
    }

    /* renamed from: adapter.SmsPictureAdapter$b */
    public interface InterfaceC0074b {
        void onItemClickListener(int i2, List<LocalMedia> list);
    }

    public SmsPictureAdapter(int i2, List<LocalMedia> list, int i3, boolean z) {
        super(i2, list);
        this.f323X = true;
        this.f324Y = 9;
        this.f321V = list;
        this.f324Y = i3;
        this.f325Z = z;
        this.f323X = true ^ z;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.f321V.size();
        return (!this.f323X || size >= this.f324Y) ? size : size + 1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.f323X) {
            int size = this.f321V.size();
            if (i2 + 1 == getItemCount() && size < this.f324Y + 1) {
                return 1;
            }
        }
        return 0;
    }

    /* renamed from: k */
    public void m283k(boolean z) {
        this.f323X = z;
    }

    public void setOnItemClickListener(InterfaceC0074b interfaceC0074b) {
        this.f322W = interfaceC0074b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        baseViewHolder.m5194a(C2113R.id.iv_clear);
        ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.picture_select);
        ImageView imageView2 = (ImageView) baseViewHolder.m5224c(C2113R.id.picture_foot);
        ImageView imageView3 = (ImageView) baseViewHolder.m5224c(C2113R.id.iv_clear);
        if (localMedia == null) {
            imageView3.setVisibility(8);
            imageView.setVisibility(8);
            imageView2.setVisibility(0);
            return;
        }
        imageView2.setVisibility(8);
        String path = localMedia.getPath();
        if (!TextUtils.isEmpty(localMedia.getOriginalPath())) {
            path = localMedia.getCompressPath();
        }
        if (this.f325Z) {
            imageView3.setVisibility(8);
        } else {
            imageView3.setVisibility(0);
        }
        imageView.setVisibility(0);
        ComponentCallbacks2C1576b.m3649e(this.f5580x).mo3719a(path).m3768a(imageView);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((SmsPictureAdapter) baseViewHolder, i2);
        baseViewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0073a(baseViewHolder));
    }
}
