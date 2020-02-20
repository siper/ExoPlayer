package com.google.android.exoplayer2.source.rtsp.core;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.rtsp.RtspMediaException;

public interface FallbackPolicy {
  boolean isActive();
  boolean isAllowRetry(RtspMediaException error);
  boolean execute(ExoPlayer player, MediaSource mediaSource);
}
