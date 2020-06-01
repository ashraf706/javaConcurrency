package org.example.guardian.fruitmachine;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;

public class SlotMachineTest {

    @Test
    public void spinShouldReturnResultObject() {
        SlotMachine slotMachine = new SlotMachine(4d);
        Result result = slotMachine.spin(2d);
        result.toString();
        assertThat(result.getDisplaySlot(), not(isEmptyString()));
    }
}