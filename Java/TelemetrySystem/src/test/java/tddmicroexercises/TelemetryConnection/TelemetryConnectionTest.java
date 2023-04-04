package tddmicroexercises.TelemetryConnection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tddmicroexercises.telemetrysystem.TelemetryConnection.Connection;
import tddmicroexercises.telemetrysystem.TelemetryConnection.TelemetryConnection;

public class TelemetryConnectionTest {

    @Test
    public void checkConnectionSetUp() {
        // create a mock connection object
        Connection connection = new TelemetryConnection();

        // set up the mock to return false for the initial connection status
        Assertions.assertFalse(connection.getConnectionStatus());

        // call the connect method with some connection details
        connection.connect("Connection details");

        // check that the mock connection status has been updated to true
        assertTrue(connection.getConnectionStatus());

        // call the disconnect method
        connection.disconnect();

        // check that the mock connection status has been updated to false
        assertFalse(connection.getConnectionStatus());
    }
}
