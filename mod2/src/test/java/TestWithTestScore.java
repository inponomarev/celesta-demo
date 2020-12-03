import com.example2.SqSequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import ru.curs.celesta.CallContext;
import ru.curs.celesta.dbutils.Sequence;
import ru.curs.celestaunit.CelestaTest;
import ru.curs.celestaunit.CelestaUnitExtension;

public class TestWithTestScore {
    @RegisterExtension
    static CelestaUnitExtension ext =
            CelestaUnitExtension.builder()
                    .withScorePath("nonstandard-test")
                    .build();

    @Test
    void testSequence(CallContext ctx) {
        Sequence sq = new SqSequence(ctx);
        Assertions.assertEquals(1, sq.nextValue());
        Assertions.assertEquals(2, sq.nextValue());

    }
}
