package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.rtsp.core.Client;
import com.google.android.exoplayer2.source.rtsp.core.FallbackPolicy;

/* package */ final class RtspFallbackPolicy extends FallbackPolicy  {

  RtspFallbackPolicy(MediaSource mediaSource, Client.Factory factory) {
    super(mediaSource, factory);
  }

  protected boolean isAllowError(Throwable error) {
    return (error instanceof RtspMediaException &&
        RtspMediaException.LOAD_TIMEOUT == ((RtspMediaException)error).type);
  }
}
