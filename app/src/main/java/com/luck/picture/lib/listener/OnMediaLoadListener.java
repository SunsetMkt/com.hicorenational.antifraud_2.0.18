package com.luck.picture.lib.listener;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface OnMediaLoadListener<T> {
    void loadComplete(List<T> list);

    void loadMediaDataError();
}
