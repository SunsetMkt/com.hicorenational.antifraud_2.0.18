package adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import bean.UploadFileBean;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;
import p357j.C5845d;
import p388ui.activity.PreviewPictureActivity;

/* loaded from: classes.dex */
public class PicturePreviewAdapter extends RecyclerView.Adapter<ListiewHolder> {

    /* renamed from: a */
    private Context f236a;

    /* renamed from: b */
    private List<UploadFileBean> f237b;

    /* renamed from: c */
    private ArrayList<LocalMedia> f238c = new ArrayList<>();

    public class ListiewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a */
        public ImageView f239a;

        public ListiewHolder(View view) {
            super(view);
            this.f239a = (ImageView) view.findViewById(C2113R.id.picture_select);
        }
    }

    public PicturePreviewAdapter(Context context, List<UploadFileBean> list) {
        this.f237b = new ArrayList();
        this.f236a = context;
        if (this.f237b != null) {
            this.f237b = list;
            m254a();
        }
    }

    /* renamed from: a */
    private void m254a() {
        for (int i2 = 0; i2 < this.f237b.size(); i2++) {
            LocalMedia localMedia = new LocalMedia();
            String fileUrl = this.f237b.get(i2).getFileUrl();
            if (TextUtils.isEmpty(fileUrl)) {
                localMedia.setPath(this.f237b.get(i2).getFilePath());
            } else {
                localMedia.setPath(fileUrl);
            }
            localMedia.setFileName(this.f237b.get(i2).getFileName());
            this.f238c.add(localMedia);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f237b.size();
    }

    public void setData(List<UploadFileBean> list) {
        this.f237b = list;
        m254a();
        notifyDataSetChanged();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ListiewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ListiewHolder(LayoutInflater.from(this.f236a).inflate(C2113R.layout.item_picture, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ListiewHolder listiewHolder, final int i2) {
        UploadFileBean uploadFileBean;
        if (this.f237b.size() > 0 && (uploadFileBean = this.f237b.get(i2)) != null) {
            if (!TextUtils.isEmpty(uploadFileBean.getFileUrl())) {
                C5845d.m24603a(this.f236a, uploadFileBean.getFileUrl(), listiewHolder.f239a, 4);
            } else if (!TextUtils.isEmpty(uploadFileBean.getFilePath())) {
                C5845d.m24603a(this.f236a, uploadFileBean.getFilePath(), listiewHolder.f239a, 4);
            }
        }
        listiewHolder.f239a.setOnClickListener(new View.OnClickListener() { // from class: adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PicturePreviewAdapter.this.m255a(i2, view);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m255a(int i2, View view) {
        Intent intent = new Intent(this.f236a, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f22711f, this.f238c);
        intent.putExtra(PreviewPictureActivity.f22712g, i2);
        this.f236a.startActivity(intent);
    }
}
