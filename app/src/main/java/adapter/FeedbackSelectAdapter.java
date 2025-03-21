package adapter;

import android.view.View;
import android.widget.ImageView;
import bean.UploadStateInfo;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;

/* loaded from: classes.dex */
public class FeedbackSelectAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {

    /* renamed from: a0 */
    static final int f192a0 = 0;

    /* renamed from: b0 */
    static final int f193b0 = 1;

    /* renamed from: V */
    private List<LocalMedia> f194V;

    /* renamed from: W */
    private InterfaceC0061b f195W;

    /* renamed from: X */
    private boolean f196X;

    /* renamed from: Y */
    private int f197Y;

    /* renamed from: Z */
    List<UploadStateInfo> f198Z;

    /* renamed from: adapter.FeedbackSelectAdapter$a */
    class ViewOnClickListenerC0060a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ BaseViewHolder f199a;

        ViewOnClickListenerC0060a(BaseViewHolder baseViewHolder) {
            this.f199a = baseViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FeedbackSelectAdapter.this.f195W != null) {
                FeedbackSelectAdapter.this.f195W.onItemClickListener(this.f199a.getAdapterPosition(), FeedbackSelectAdapter.this.f194V);
            }
        }
    }

    /* renamed from: adapter.FeedbackSelectAdapter$b */
    public interface InterfaceC0061b {
        void onItemClickListener(int i2, List<LocalMedia> list);
    }

    public FeedbackSelectAdapter(int i2, List<LocalMedia> list, int i3, List<UploadStateInfo> list2) {
        super(i2, list);
        this.f196X = true;
        this.f197Y = 9;
        this.f194V = list;
        this.f197Y = i3;
        this.f198Z = list2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.f194V.size();
        return (!this.f196X || size >= this.f197Y) ? size : size + 1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.f196X) {
            int size = this.f194V.size();
            if (i2 + 1 == getItemCount() && size < this.f197Y + 1) {
                return 1;
            }
        }
        return 0;
    }

    /* renamed from: k */
    public void m231k(boolean z) {
        this.f196X = z;
    }

    public void setOnItemClickListener(InterfaceC0061b interfaceC0061b) {
        this.f195W = interfaceC0061b;
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
        imageView3.setVisibility(0);
        imageView.setVisibility(0);
        if (localMedia.isCut()) {
            ComponentCallbacks2C1576b.m3649e(this.f5580x).mo3719a(localMedia.getCutPath()).m3768a(imageView);
        } else {
            ComponentCallbacks2C1576b.m3649e(this.f5580x).mo3719a(path).m3768a(imageView);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((FeedbackSelectAdapter) baseViewHolder, i2);
        baseViewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0060a(baseViewHolder));
    }
}
