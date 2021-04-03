package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidMultiInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"222", "1", "2324", "2421"}
        );
        int[] extend = new int[]{222, 1, 2324, 2421};
        ValidateInput input = new ValidateInput(out, in);
        int[] selected = new int[]{input.askInt("Enter menu:"),
                input.askInt("Enter menu:"),
                input.askInt("Enter menu:"),
                input.askInt("Enter menu:"),
        };

        assertThat(selected, is(extend));
    }

    @Test
    public void whenValidInputNegativeNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-41"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-41));
    }
}