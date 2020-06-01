package org.example.guardian.snackshak;

import org.junit.Test;

public class SnackShackTest {
    @Test
    public void executorServiceTest() {
        SnackShack snackShack = new SnackShack();
        snackShack.takeOrder(3);
    }
}
