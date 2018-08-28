package ee.sda.maven.tickets;

import java.time.LocalDateTime;

public class NoPersonDataException extends Exception {

  private LocalDateTime timestamp;

  public NoPersonDataException(String message, LocalDateTime timestamp) {
    super(message);
    this.timestamp = timestamp;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

}
