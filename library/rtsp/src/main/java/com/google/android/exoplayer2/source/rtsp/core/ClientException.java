package com.google.android.exoplayer2.source.rtsp.core;

public class ClientException extends Exception {

  private ClientException(String message) {
    super(message);
  }

  public static Exception timeoutException() {
    return new ClientException("Client timeout exception");
  }

  public static Exception ioException() {
    return new ClientException("IO exception");
  }

  public static Exception malformedResponseException() {
    return new ClientException("Malformed response exception");
  }

  public static Exception unknownException() {
    return new ClientException("Unknown client exception");
  }

  public static Exception noResponseException() {
    return new ClientException("No response exception");
  }
}
