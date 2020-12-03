package ru.curs.demo.service;

import com.example.FooSequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.curs.celesta.CallContext;
import ru.curs.celesta.dbutils.Sequence;
import ru.curs.celestaunit.CelestaTest;
import ru.curs.testscore.TestSequenceSequence;

@CelestaTest
public class TestWithTestScore {
    @Test
    void testSequence(CallContext ctx) {
        Sequence sq = new TestSequenceSequence(ctx);
        Assertions.assertEquals(1, sq.nextValue());
        Assertions.assertEquals(2, sq.nextValue());

    }
}
