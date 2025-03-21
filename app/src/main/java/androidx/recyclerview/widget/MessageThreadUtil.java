package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
class MessageThreadUtil<T> implements ThreadUtil<T> {

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$1 */
    class C06441 implements ThreadUtil.MainThreadCallback<T> {
        static final int ADD_TILE = 2;
        static final int REMOVE_TILE = 3;
        static final int UPDATE_ITEM_COUNT = 1;
        final /* synthetic */ ThreadUtil.MainThreadCallback val$callback;
        final MessageQueue mQueue = new MessageQueue();
        private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
        private Runnable mMainThreadRunnable = new Runnable() { // from class: androidx.recyclerview.widget.MessageThreadUtil.1.1
            @Override // java.lang.Runnable
            public void run() {
                SyncQueueItem next = C06441.this.mQueue.next();
                while (next != null) {
                    int i2 = next.what;
                    if (i2 == 1) {
                        C06441.this.val$callback.updateItemCount(next.arg1, next.arg2);
                    } else if (i2 == 2) {
                        C06441.this.val$callback.addTile(next.arg1, (TileList.Tile) next.data);
                    } else if (i2 != 3) {
                        String str = "Unsupported message, what=" + next.what;
                    } else {
                        C06441.this.val$callback.removeTile(next.arg1, next.arg2);
                    }
                    next = C06441.this.mQueue.next();
                }
            }
        };

        C06441(ThreadUtil.MainThreadCallback mainThreadCallback) {
            this.val$callback = mainThreadCallback;
        }

        private void sendMessage(SyncQueueItem syncQueueItem) {
            this.mQueue.sendMessage(syncQueueItem);
            this.mMainThreadHandler.post(this.mMainThreadRunnable);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int i2, TileList.Tile<T> tile) {
            sendMessage(SyncQueueItem.obtainMessage(2, i2, tile));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int i2, int i3) {
            sendMessage(SyncQueueItem.obtainMessage(3, i2, i3));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i2, int i3) {
            sendMessage(SyncQueueItem.obtainMessage(1, i2, i3));
        }
    }

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$2 */
    class C06452 implements ThreadUtil.BackgroundCallback<T> {
        static final int LOAD_TILE = 3;
        static final int RECYCLE_TILE = 4;
        static final int REFRESH = 1;
        static final int UPDATE_RANGE = 2;
        final /* synthetic */ ThreadUtil.BackgroundCallback val$callback;
        final MessageQueue mQueue = new MessageQueue();
        private final Executor mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
        AtomicBoolean mBackgroundRunning = new AtomicBoolean(false);
        private Runnable mBackgroundRunnable = new Runnable() { // from class: androidx.recyclerview.widget.MessageThreadUtil.2.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    SyncQueueItem next = C06452.this.mQueue.next();
                    if (next == null) {
                        C06452.this.mBackgroundRunning.set(false);
                        return;
                    }
                    int i2 = next.what;
                    if (i2 == 1) {
                        C06452.this.mQueue.removeMessages(1);
                        C06452.this.val$callback.refresh(next.arg1);
                    } else if (i2 == 2) {
                        C06452.this.mQueue.removeMessages(2);
                        C06452.this.mQueue.removeMessages(3);
                        C06452.this.val$callback.updateRange(next.arg1, next.arg2, next.arg3, next.arg4, next.arg5);
                    } else if (i2 == 3) {
                        C06452.this.val$callback.loadTile(next.arg1, next.arg2);
                    } else if (i2 != 4) {
                        String str = "Unsupported message, what=" + next.what;
                    } else {
                        C06452.this.val$callback.recycleTile((TileList.Tile) next.data);
                    }
                }
            }
        };

        C06452(ThreadUtil.BackgroundCallback backgroundCallback) {
            this.val$callback = backgroundCallback;
        }

        private void maybeExecuteBackgroundRunnable() {
            if (this.mBackgroundRunning.compareAndSet(false, true)) {
                this.mExecutor.execute(this.mBackgroundRunnable);
            }
        }

        private void sendMessage(SyncQueueItem syncQueueItem) {
            this.mQueue.sendMessage(syncQueueItem);
            maybeExecuteBackgroundRunnable();
        }

        private void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
            this.mQueue.sendMessageAtFrontOfQueue(syncQueueItem);
            maybeExecuteBackgroundRunnable();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int i2, int i3) {
            sendMessage(SyncQueueItem.obtainMessage(3, i2, i3));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            sendMessage(SyncQueueItem.obtainMessage(4, 0, tile));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int i2) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, i2, (Object) null));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int i2, int i3, int i4, int i5, int i6) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, i2, i3, i4, i5, i6, null));
        }
    }

    static class MessageQueue {
        private SyncQueueItem mRoot;

        MessageQueue() {
        }

        synchronized SyncQueueItem next() {
            if (this.mRoot == null) {
                return null;
            }
            SyncQueueItem syncQueueItem = this.mRoot;
            this.mRoot = this.mRoot.next;
            return syncQueueItem;
        }

        synchronized void removeMessages(int i2) {
            while (this.mRoot != null && this.mRoot.what == i2) {
                SyncQueueItem syncQueueItem = this.mRoot;
                this.mRoot = this.mRoot.next;
                syncQueueItem.recycle();
            }
            if (this.mRoot != null) {
                SyncQueueItem syncQueueItem2 = this.mRoot;
                SyncQueueItem syncQueueItem3 = syncQueueItem2.next;
                while (syncQueueItem3 != null) {
                    SyncQueueItem syncQueueItem4 = syncQueueItem3.next;
                    if (syncQueueItem3.what == i2) {
                        syncQueueItem2.next = syncQueueItem4;
                        syncQueueItem3.recycle();
                    } else {
                        syncQueueItem2 = syncQueueItem3;
                    }
                    syncQueueItem3 = syncQueueItem4;
                }
            }
        }

        synchronized void sendMessage(SyncQueueItem syncQueueItem) {
            if (this.mRoot == null) {
                this.mRoot = syncQueueItem;
                return;
            }
            SyncQueueItem syncQueueItem2 = this.mRoot;
            while (syncQueueItem2.next != null) {
                syncQueueItem2 = syncQueueItem2.next;
            }
            syncQueueItem2.next = syncQueueItem;
        }

        synchronized void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
            syncQueueItem.next = this.mRoot;
            this.mRoot = syncQueueItem;
        }
    }

    MessageThreadUtil() {
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new C06452(backgroundCallback);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new C06441(mainThreadCallback);
    }

    static class SyncQueueItem {
        private static SyncQueueItem sPool;
        private static final Object sPoolLock = new Object();
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        SyncQueueItem next;
        public int what;

        SyncQueueItem() {
        }

        static SyncQueueItem obtainMessage(int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
            SyncQueueItem syncQueueItem;
            synchronized (sPoolLock) {
                if (sPool == null) {
                    syncQueueItem = new SyncQueueItem();
                } else {
                    syncQueueItem = sPool;
                    sPool = sPool.next;
                    syncQueueItem.next = null;
                }
                syncQueueItem.what = i2;
                syncQueueItem.arg1 = i3;
                syncQueueItem.arg2 = i4;
                syncQueueItem.arg3 = i5;
                syncQueueItem.arg4 = i6;
                syncQueueItem.arg5 = i7;
                syncQueueItem.data = obj;
            }
            return syncQueueItem;
        }

        void recycle() {
            this.next = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (sPoolLock) {
                if (sPool != null) {
                    this.next = sPool;
                }
                sPool = this;
            }
        }

        static SyncQueueItem obtainMessage(int i2, int i3, int i4) {
            return obtainMessage(i2, i3, i4, 0, 0, 0, null);
        }

        static SyncQueueItem obtainMessage(int i2, int i3, Object obj) {
            return obtainMessage(i2, i3, 0, 0, 0, 0, obj);
        }
    }
}
