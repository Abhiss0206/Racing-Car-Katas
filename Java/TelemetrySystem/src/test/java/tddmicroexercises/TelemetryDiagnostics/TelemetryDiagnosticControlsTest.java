package tddmicroexercises.TelemetryDiagnostics;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.*;

import tddmicroexercises.telemetrysystem.TelemetryClient.ITelemetryClient;
import tddmicroexercises.telemetrysystem.TelemetryConnection.Connection;
import tddmicroexercises.telemetrysystem.TelemetryConnection.TelemetryConnection;
import tddmicroexercises.telemetrysystem.TelemetryDiagnostics.TelemetryDiagnosticControls;
import tddmicroexercises.telemetrysystem.TelemetryClient.TelemetryClient;

public class TelemetryDiagnosticControlsTest {

    @Test
    public void testCheckTransmission() throws Exception {
        // Setup
        ITelemetryClient mockClient = mock(ITelemetryClient.class);
        Connection mockConnection = mock(Connection.class);

        TelemetryDiagnosticControls controls = new TelemetryDiagnosticControls(mockClient, mockConnection);

        when(mockConnection.getConnectionStatus()).thenReturn(false, false, true);
        when(mockClient.receive()).thenReturn("test diagnostic info");

        // Exercise
        controls.checkTransmission();

        // Verify
        verify(mockConnection, times(2)).connect("*111#");
        verify(mockConnection).disconnect();
        verify(mockClient).send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        verify(mockClient).receive();
        assertEquals("test diagnostic info", controls.getDiagnosticInfo());
    }

    @Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        ITelemetryClient telemetryClient = new TelemetryClient();
        Connection telemetryConnection = new TelemetryConnection();
        TelemetryDiagnosticControls controls = new TelemetryDiagnosticControls(telemetryClient, telemetryConnection);
        controls.checkTransmission();
        Assertions.assertFalse(controls.getDiagnosticInfo().isEmpty());
    }
}


