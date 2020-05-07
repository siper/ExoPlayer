package com.google.android.exoplayer2.source.rtsp.core;

import java.io.IOException;

public class ClientException extends IOException {

  private ClientException(String message) {
    super(message);
  }

  public static IOException timeoutException() {
    return new ClientException("Client timeout exception");
  }

  public static IOException ioException() {
    return new ClientException("IO exception");
  }

  public static IOException malformedResponseException() {
    return new ClientException("Malformed response exception");
  }

  public static IOException unknownException() {
    return new ClientException("Unknown client exception");
  }

  public static IOException noResponseException() {
    return new ClientException("No response exception");
  }
}
