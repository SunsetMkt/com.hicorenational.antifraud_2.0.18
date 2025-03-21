package com.luck.picture.lib.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.C2639R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnPhotoSelectChangedListener;
import com.luck.picture.lib.tools.AnimUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.VoiceUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p324i.p336c.p337a.InterfaceC5816d;

/* loaded from: classes.dex */
public class PictureImageGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private PictureSelectionConfig config;
    private Context context;
    private OnPhotoSelectChangedListener imageSelectChangedListener;
    private boolean isGo;
    private boolean showCamera;
    private List<LocalMedia> images = new ArrayList();
    private List<LocalMedia> selectImages = new ArrayList();

    public class CameraViewHolder extends RecyclerView.ViewHolder {
        View headerView;
        TextView tvCamera;

        public CameraViewHolder(View view) {
            super(view);
            this.headerView = view;
            this.tvCamera = (TextView) view.findViewById(C2639R.id.tvCamera);
            this.tvCamera.setText(PictureImageGridAdapter.this.config.chooseMode == PictureMimeType.ofAudio() ? PictureImageGridAdapter.this.context.getString(C2639R.string.picture_tape) : PictureImageGridAdapter.this.context.getString(C2639R.string.picture_take_picture));
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View btnCheck;
        View contentView;
        ImageView ivPicture;
        TextView tvCheck;
        TextView tvDuration;
        TextView tvIsGif;
        TextView tvLongChart;
        TextView tvName;

        public ViewHolder(View view) {
            super(view);
            this.contentView = view;
            this.ivPicture = (ImageView) view.findViewById(C2639R.id.ivPicture);
            this.tvCheck = (TextView) view.findViewById(C2639R.id.tvCheck);
            this.btnCheck = view.findViewById(C2639R.id.btnCheck);
            this.tvDuration = (TextView) view.findViewById(C2639R.id.tv_duration);
            this.tvIsGif = (TextView) view.findViewById(C2639R.id.tv_isGif);
            this.tvName = (TextView) view.findViewById(C2639R.id.tv_name);
            this.tvLongChart = (TextView) view.findViewById(C2639R.id.tv_long_chart);
            if (PictureImageGridAdapter.this.config.style == null || PictureImageGridAdapter.this.config.style.pictureCheckedStyle == 0) {
                return;
            }
            this.tvCheck.setBackgroundResource(PictureImageGridAdapter.this.config.style.pictureCheckedStyle);
        }
    }

    public PictureImageGridAdapter(Context context, PictureSelectionConfig pictureSelectionConfig) {
        this.context = context;
        this.config = pictureSelectionConfig;
        this.showCamera = pictureSelectionConfig.isCamera;
    }

    @SuppressLint({"StringFormatMatches"})
    private void changeCheckboxState(ViewHolder viewHolder, LocalMedia localMedia) {
        int i2;
        int i3;
        boolean isSelected = viewHolder.tvCheck.isSelected();
        int size = this.selectImages.size();
        int i4 = 0;
        String mimeType = size > 0 ? this.selectImages.get(0).getMimeType() : "";
        if (this.config.isWithVideoImage) {
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                if (PictureMimeType.eqVideo(this.selectImages.get(i7).getMimeType())) {
                    i6++;
                } else {
                    i5++;
                }
            }
            if (PictureMimeType.eqVideo(localMedia.getMimeType())) {
                int i8 = this.config.maxVideoSelectNum;
                if (i8 <= 0) {
                    Context context = this.context;
                    ToastUtils.m8140s(context, context.getString(C2639R.string.picture_rule));
                    return;
                }
                if (i6 >= i8 && !isSelected) {
                    Context context2 = this.context;
                    ToastUtils.m8140s(context2, StringUtils.getMsg(context2, localMedia.getMimeType(), this.config.maxVideoSelectNum));
                    return;
                } else if (!isSelected && this.config.videoMinSecond > 0 && localMedia.getDuration() < this.config.videoMinSecond) {
                    ToastUtils.m8140s(this.context, viewHolder.itemView.getContext().getString(C2639R.string.picture_choose_min_seconds, Integer.valueOf(this.config.videoMinSecond / 1000)));
                    return;
                } else if (!isSelected && this.config.videoMaxSecond > 0 && localMedia.getDuration() > this.config.videoMaxSecond) {
                    ToastUtils.m8140s(this.context, viewHolder.itemView.getContext().getString(C2639R.string.picture_choose_max_seconds, Integer.valueOf(this.config.videoMaxSecond / 1000)));
                    return;
                }
            }
            if (PictureMimeType.eqImage(localMedia.getMimeType()) && i5 >= this.config.maxSelectNum && !isSelected) {
                Context context3 = this.context;
                ToastUtils.m8140s(context3, StringUtils.getMsg(context3, localMedia.getMimeType(), this.config.maxSelectNum));
                return;
            }
        } else {
            if (!TextUtils.isEmpty(mimeType) && !PictureMimeType.isMimeTypeSame(mimeType, localMedia.getMimeType())) {
                Context context4 = this.context;
                ToastUtils.m8140s(context4, context4.getString(C2639R.string.picture_rule));
                return;
            }
            if (!PictureMimeType.eqVideo(mimeType) || (i2 = this.config.maxVideoSelectNum) <= 0) {
                int i9 = this.config.maxSelectNum;
                if (size >= i9 && !isSelected) {
                    Context context5 = this.context;
                    ToastUtils.m8140s(context5, StringUtils.getMsg(context5, mimeType, i9));
                    return;
                } else if (PictureMimeType.eqVideo(localMedia.getMimeType())) {
                    if (!isSelected && this.config.videoMinSecond > 0 && localMedia.getDuration() < this.config.videoMinSecond) {
                        ToastUtils.m8140s(this.context, viewHolder.itemView.getContext().getString(C2639R.string.picture_choose_min_seconds, Integer.valueOf(this.config.videoMinSecond / 1000)));
                        return;
                    } else if (!isSelected && this.config.videoMaxSecond > 0 && localMedia.getDuration() > this.config.videoMaxSecond) {
                        ToastUtils.m8140s(this.context, viewHolder.itemView.getContext().getString(C2639R.string.picture_choose_max_seconds, Integer.valueOf(this.config.videoMaxSecond / 1000)));
                        return;
                    }
                }
            } else if (size >= i2 && !isSelected) {
                Context context6 = this.context;
                ToastUtils.m8140s(context6, StringUtils.getMsg(context6, mimeType, i2));
                return;
            } else if (!isSelected && this.config.videoMinSecond > 0 && localMedia.getDuration() < this.config.videoMinSecond) {
                ToastUtils.m8140s(this.context, viewHolder.itemView.getContext().getString(C2639R.string.picture_choose_min_seconds, Integer.valueOf(this.config.videoMinSecond / 1000)));
                return;
            } else if (!isSelected && this.config.videoMaxSecond > 0 && localMedia.getDuration() > this.config.videoMaxSecond) {
                ToastUtils.m8140s(this.context, viewHolder.itemView.getContext().getString(C2639R.string.picture_choose_max_seconds, Integer.valueOf(this.config.videoMaxSecond / 1000)));
                return;
            }
        }
        if (isSelected) {
            while (i4 < size) {
                LocalMedia localMedia2 = this.selectImages.get(i4);
                if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.getPath()) && (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId())) {
                    this.selectImages.remove(localMedia2);
                    subSelectPosition();
                    AnimUtils.disZoom(viewHolder.ivPicture, this.config.zoomAnim);
                    break;
                }
                i4++;
            }
        } else {
            if (this.config.selectionMode == 1) {
                singleRadioMediaImage();
            }
            if (localMedia.getWidth() == 0 || localMedia.getHeight() == 0) {
                localMedia.setOrientation(-1);
                if (PictureMimeType.isContent(localMedia.getPath())) {
                    if (PictureMimeType.eqVideo(localMedia.getMimeType())) {
                        int[] videoSizeForUri = MediaUtils.getVideoSizeForUri(this.context, Uri.parse(localMedia.getPath()));
                        i4 = videoSizeForUri[0];
                        i3 = videoSizeForUri[1];
                    } else {
                        if (PictureMimeType.eqImage(localMedia.getMimeType())) {
                            int[] imageSizeForUri = MediaUtils.getImageSizeForUri(this.context, Uri.parse(localMedia.getPath()));
                            i4 = imageSizeForUri[0];
                            i3 = imageSizeForUri[1];
                        }
                        i3 = 0;
                    }
                    localMedia.setWidth(i4);
                    localMedia.setHeight(i3);
                } else {
                    if (PictureMimeType.eqVideo(localMedia.getMimeType())) {
                        int[] videoSizeForUrl = MediaUtils.getVideoSizeForUrl(localMedia.getPath());
                        i4 = videoSizeForUrl[0];
                        i3 = videoSizeForUrl[1];
                    } else {
                        if (PictureMimeType.eqImage(localMedia.getMimeType())) {
                            int[] imageSizeForUrl = MediaUtils.getImageSizeForUrl(localMedia.getPath());
                            i4 = imageSizeForUrl[0];
                            i3 = imageSizeForUrl[1];
                        }
                        i3 = 0;
                    }
                    localMedia.setWidth(i4);
                    localMedia.setHeight(i3);
                }
            }
            MediaUtils.setOrientation(this.context, localMedia);
            this.selectImages.add(localMedia);
            localMedia.setNum(this.selectImages.size());
            VoiceUtils.getInstance().play();
            AnimUtils.zoom(viewHolder.ivPicture, this.config.zoomAnim);
            viewHolder.tvCheck.startAnimation(AnimationUtils.loadAnimation(this.context, C2639R.anim.picture_anim_modal_in));
        }
        notifyItemChanged(viewHolder.getAdapterPosition());
        selectImage(viewHolder, !isSelected);
        OnPhotoSelectChangedListener onPhotoSelectChangedListener = this.imageSelectChangedListener;
        if (onPhotoSelectChangedListener != null) {
            onPhotoSelectChangedListener.onChange(this.selectImages);
        }
    }

    private void notifyCheckChanged(ViewHolder viewHolder, LocalMedia localMedia) {
        viewHolder.tvCheck.setText("");
        int size = this.selectImages.size();
        for (int i2 = 0; i2 < size; i2++) {
            LocalMedia localMedia2 = this.selectImages.get(i2);
            if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                localMedia.setNum(localMedia2.getNum());
                localMedia2.setPosition(localMedia.getPosition());
                viewHolder.tvCheck.setText(String.valueOf(localMedia.getNum()));
            }
        }
    }

    private void singleRadioMediaImage() {
        List<LocalMedia> list = this.selectImages;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.isGo = true;
        int i2 = 0;
        LocalMedia localMedia = this.selectImages.get(0);
        if (this.config.isCamera || this.isGo) {
            i2 = localMedia.position;
        } else {
            int i3 = localMedia.position;
            if (i3 > 0) {
                i2 = i3 - 1;
            }
        }
        notifyItemChanged(i2);
        this.selectImages.clear();
    }

    private void subSelectPosition() {
        if (this.config.checkNumMode) {
            int size = this.selectImages.size();
            int i2 = 0;
            while (i2 < size) {
                LocalMedia localMedia = this.selectImages.get(i2);
                i2++;
                localMedia.setNum(i2);
                notifyItemChanged(localMedia.position);
            }
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m8117a(View view) {
        OnPhotoSelectChangedListener onPhotoSelectChangedListener = this.imageSelectChangedListener;
        if (onPhotoSelectChangedListener != null) {
            onPhotoSelectChangedListener.onTakePhoto();
        }
    }

    public void bindImagesData(List<LocalMedia> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.images = list;
        notifyDataSetChanged();
    }

    public void bindSelectImages(List<LocalMedia> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(list.get(i2));
        }
        this.selectImages = arrayList;
        if (this.config.isSingleDirectReturn) {
            return;
        }
        subSelectPosition();
        OnPhotoSelectChangedListener onPhotoSelectChangedListener = this.imageSelectChangedListener;
        if (onPhotoSelectChangedListener != null) {
            onPhotoSelectChangedListener.onChange(this.selectImages);
        }
    }

    public List<LocalMedia> getImages() {
        List<LocalMedia> list = this.images;
        return list == null ? new ArrayList() : list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.showCamera ? this.images.size() + 1 : this.images.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return (this.showCamera && i2 == 0) ? 1 : 2;
    }

    public List<LocalMedia> getSelectedImages() {
        List<LocalMedia> list = this.selectImages;
        return list == null ? new ArrayList() : list;
    }

    public int getSize() {
        List<LocalMedia> list = this.images;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public boolean isDataEmpty() {
        List<LocalMedia> list = this.images;
        return list == null || list.size() == 0;
    }

    public boolean isSelected(LocalMedia localMedia) {
        int size = this.selectImages.size();
        for (int i2 = 0; i2 < size; i2++) {
            LocalMedia localMedia2 = this.selectImages.get(i2);
            if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.getPath()) && (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean isShowCamera() {
        return this.showCamera;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@InterfaceC5816d RecyclerView.ViewHolder viewHolder, final int i2) {
        if (getItemViewType(i2) == 1) {
            ((CameraViewHolder) viewHolder).headerView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PictureImageGridAdapter.this.m8117a(view);
                }
            });
            return;
        }
        final ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        final LocalMedia localMedia = this.images.get(this.showCamera ? i2 - 1 : i2);
        localMedia.position = viewHolder2.getAdapterPosition();
        final String path = localMedia.getPath();
        final String mimeType = localMedia.getMimeType();
        if (this.config.checkNumMode) {
            notifyCheckChanged(viewHolder2, localMedia);
        }
        if (!this.config.isSingleDirectReturn) {
            selectImage(viewHolder2, isSelected(localMedia));
        }
        boolean isGif = PictureMimeType.isGif(mimeType);
        viewHolder2.tvCheck.setVisibility(this.config.isSingleDirectReturn ? 8 : 0);
        viewHolder2.btnCheck.setVisibility(this.config.isSingleDirectReturn ? 8 : 0);
        viewHolder2.tvIsGif.setVisibility(isGif ? 0 : 8);
        if (PictureMimeType.eqImage(localMedia.getMimeType())) {
            if (localMedia.loadLongImageStatus == -1) {
                localMedia.isLongImage = MediaUtils.isLongImg(localMedia);
                localMedia.loadLongImageStatus = 0;
            }
            viewHolder2.tvLongChart.setVisibility(localMedia.isLongImage ? 0 : 8);
        } else {
            localMedia.loadLongImageStatus = -1;
            viewHolder2.tvLongChart.setVisibility(8);
        }
        boolean eqVideo = PictureMimeType.eqVideo(mimeType);
        boolean eqAudio = PictureMimeType.eqAudio(mimeType);
        if (eqVideo || eqAudio) {
            viewHolder2.tvDuration.setVisibility(0);
            viewHolder2.tvDuration.setText(DateUtils.formatDurationTime(localMedia.getDuration()));
            viewHolder2.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(eqVideo ? C2639R.drawable.picture_icon_video : C2639R.drawable.picture_icon_audio, 0, 0, 0);
        } else {
            viewHolder2.tvDuration.setVisibility(8);
        }
        if (this.config.chooseMode == PictureMimeType.ofAudio()) {
            viewHolder2.ivPicture.setImageResource(C2639R.drawable.picture_audio_placeholder);
        } else {
            ImageEngine imageEngine = PictureSelectionConfig.imageEngine;
            if (imageEngine != null) {
                imageEngine.loadGridImage(this.context, path, viewHolder2.ivPicture);
            }
        }
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.enablePreview || pictureSelectionConfig.enPreviewVideo || pictureSelectionConfig.enablePreviewAudio) {
            viewHolder2.btnCheck.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PictureImageGridAdapter.this.m8119a(path, mimeType, localMedia, viewHolder2, view);
                }
            });
        }
        viewHolder2.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PictureImageGridAdapter.this.m8118a(path, mimeType, i2, localMedia, viewHolder2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i2 == 1 ? new CameraViewHolder(LayoutInflater.from(this.context).inflate(C2639R.layout.picture_item_camera, viewGroup, false)) : new ViewHolder(LayoutInflater.from(this.context).inflate(C2639R.layout.picture_image_grid_item, viewGroup, false));
    }

    public void selectImage(ViewHolder viewHolder, boolean z) {
        viewHolder.tvCheck.setSelected(z);
        if (z) {
            viewHolder.ivPicture.setColorFilter(ContextCompat.getColor(this.context, C2639R.color.picture_color_80), PorterDuff.Mode.SRC_ATOP);
        } else {
            viewHolder.ivPicture.setColorFilter(ContextCompat.getColor(this.context, C2639R.color.picture_color_20), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public void setOnPhotoSelectChangedListener(OnPhotoSelectChangedListener onPhotoSelectChangedListener) {
        this.imageSelectChangedListener = onPhotoSelectChangedListener;
    }

    public void setShowCamera(boolean z) {
        this.showCamera = z;
    }

    /* renamed from: a */
    public /* synthetic */ void m8119a(String str, String str2, LocalMedia localMedia, ViewHolder viewHolder, View view) {
        if (SdkVersionUtils.checkedAndroid_Q()) {
            str = PictureFileUtils.getPath(this.context, Uri.parse(str));
        }
        if (!TextUtils.isEmpty(str) && !new File(str).exists()) {
            Context context = this.context;
            ToastUtils.m8140s(context, PictureMimeType.m8138s(context, str2));
        } else {
            if (SdkVersionUtils.checkedAndroid_Q()) {
                localMedia.setRealPath(str);
            }
            MediaUtils.setOrientation(this.context, localMedia);
            changeCheckboxState(viewHolder, localMedia);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x005f, code lost:
    
        if (r5.selectionMode != 1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x006f, code lost:
    
        if (r5.selectionMode != 1) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ec  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void m8118a(java.lang.String r5, java.lang.String r6, int r7, com.luck.picture.lib.entity.LocalMedia r8, com.luck.picture.lib.adapter.PictureImageGridAdapter.ViewHolder r9, android.view.View r10) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.adapter.PictureImageGridAdapter.m8118a(java.lang.String, java.lang.String, int, com.luck.picture.lib.entity.LocalMedia, com.luck.picture.lib.adapter.PictureImageGridAdapter$ViewHolder, android.view.View):void");
    }
}
