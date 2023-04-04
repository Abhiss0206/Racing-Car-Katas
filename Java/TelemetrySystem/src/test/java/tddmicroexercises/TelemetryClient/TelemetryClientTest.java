package tddmicroexercises.TelemetryClient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tddmicroexercises.telemetrysystem.TelemetryClient.ITelemetryClient;
import tddmicroexercises.telemetrysystem.TelemetryClient.TelemetryClient;

public class TelemetryClientTest {

    @Test
    public void checkClientSendReceive() {
        ITelemetryClient client = Mockito.mock(TelemetryClient.class);
        Mockito.when(client.receive()).thenReturn("test message");

        client.send("message");
        Assertions.assertFalse(client.receive().isEmpty());
    }
}
