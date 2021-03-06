package sktest.ling.persistence.entity.sql.sqllite;

import lombok.ToString;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.shaneking.ling.persistence.Pagination;
import org.shaneking.ling.persistence.entity.sql.sqllite.SqlliteSqlEntities;
import org.shaneking.ling.test.SKUnit;
import org.shaneking.ling.zero.lang.String0;
import org.shaneking.ling.zero.util.List0;
import sktest.ling.persistence.entity.AbstractSqlEntityPrepare;
import sktest.ling.persistence.entity.sql.AbstractDialectSqlEntityPrepare;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class SqlliteSqlEntityTest extends SKUnit {

  @Test
  void createTableAndIndexIfNotExistSql() throws IOException {
    Files.write(tstOFiles().toPath(), new DialectSqlEntityPrepareSqllite().createTableAndIndexIfNotExistSql().getBytes());
    assertEquals(String.join(String0.BR_LINUX, Files.readAllLines(tstOFiles().toPath())), new DialectSqlEntityPrepareSqllite().createTableAndIndexIfNotExistSql().trim());
  }

  @Test
  void limitStatement() {
    DialectSqlEntityPrepareSqllite dialectSqlEntityPrepareSqllite = new DialectSqlEntityPrepareSqllite();
    dialectSqlEntityPrepareSqllite.setPagination(new Pagination().setSize(Pagination.MAX_SIZE));

    List<String> limit = List0.newArrayList();
    dialectSqlEntityPrepareSqllite.limitStatement(limit, List0.newArrayList());
//    System.out.println(OM3.writeValueAsString(limit));
    assertLinesMatch(List0.newArrayList("limit 1023", "offset 0"), limit);
  }

  @Accessors(chain = true)
  @Table(schema = "sktest1_schema", name = "sktest1_table", uniqueConstraints = {@UniqueConstraint(columnNames = {"has_length", "not_null_col"})})
  @ToString(callSuper = true)
  public class DialectSqlEntityPrepareSqllite extends AbstractDialectSqlEntityPrepare implements SqlliteSqlEntities {
  }

  @Accessors(chain = true)
  @Table(schema = "sktest1_schema", name = "sktest1_table", uniqueConstraints = {@UniqueConstraint(columnNames = {"has_length", "not_null_col"})})
  @ToString(callSuper = true)
  public class SqlEntityPrepareSqllite extends AbstractSqlEntityPrepare implements SqlliteSqlEntities {
  }
}
