package com.google.android.exoplayer2.source.rtsp;


import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.rtsp.core.Client;
import com.google.android.exoplayer2.source.rtsp.core.FallbackPolicy;

/* package */ final class RtspFallbackPolicy implements FallbackPolicy  {

  private boolean isExecuteCalled;
  private @Client.Mode int mode;

  RtspFallbackPolicy(@Client.Mode int mode) {
    this.mode = mode;
  }

  @Override
  public boolean isAllowRetry(RtspMediaException error) {
    return (RtspMediaException.LOAD_TIMEOUT == error.type &&
        mode != Client.RTSP_INTERLEAVED);
  }

  @Override
  public boolean execute(ExoPlayer player, MediaSource mediaSource) {
    if (!isExecuteCalled) {
      isExecuteCalled = true;
      mode = Client.RTSP_INTERLEAVED;

      new Handler(Looper.getMainLooper()).post(() -> {
        player.stop(true);
        player.setMediaSource(mediaSource);
        player.prepare();
      });

      return true;
    }

    return false;
  }

  @Override
  public boolean isActive() {
    return isExecuteCalled;
  }
}
