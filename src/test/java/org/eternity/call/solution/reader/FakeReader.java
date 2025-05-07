package org.eternity.call.solution.reader;

import org.eternity.call.solution.calls.Call;
import org.eternity.call.solution.calls.Reader;

import java.util.List;

public class FakeReader implements Reader {
    private List<Call> calls;

    public FakeReader(Call ... calls) {
        this.calls = List.of(calls);
    }
    @Override
    public List<Call> read() {
        return calls;
    }
}
