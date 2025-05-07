package org.eternity.call.problem.reader;

import org.eternity.call.problem.calls.Call;
import org.eternity.call.problem.calls.Reader;

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
