package sktest.ling.persistence;

import lombok.ToString;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.shaneking.ling.persistence.sql.Keyword;
import org.shaneking.ling.persistence.sql.Pagination;
import org.shaneking.ling.persistence.sql.entity.IdAdtVerEntity;
import org.shaneking.ling.persistence.sql.entity.IdEntity;
import org.shaneking.ling.persistence.sql.entity.sqllite.SqlliteDialectSqlEntities;
import org.shaneking.ling.test.SKUnit;
import org.shaneking.ling.zero.lang.String0;
import org.shaneking.ling.zero.util.List0;
import sktest.ling.persistence.sql.entity.AbstractIdAdtVerEntity;
import sktest.ling.persistence.sql.entity.mysql.MysqlIdAdtVerEntityTest;

import javax.persistence.Table;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AbstractEntityTest extends SKUnit {
  String id = "1610866165373_KbTy6GDVwpB5rAYJjJb";
  String userId = "1610866165373_eXabaDd3OiEyivRv1GI";
  String dateTime = "2021-01-16 14:49:25";
  MysqlIdAdtVerEntityTest.MysqlIdAdtVerEntity mysqlIdAdtVerEntity = new MysqlIdAdtVerEntityTest.MysqlIdAdtVerEntity();
  @Mock
  private ResultSet resultSet;

  @BeforeEach
  void beforeEach() {
    mysqlIdAdtVerEntity.setHasLength("hasLength").setNoGetMethod("noGetMethod").setNotNullCol("notNullCol").setUniqueCol("uniqueCol").setWithoutAnnotation("withoutAnnotation").setReName("reName").setLongText("longText");
//    mysqlIdAdtVerEntity.setVersion(1).setLastModifyDateTime(Date0.on().dateTime()).setLastModifyUserId(userId).setInvalid(String0.N).setId(id);
    mysqlIdAdtVerEntity.initWithUserIdAndId(userId, id);
    mysqlIdAdtVerEntity.setLastModifyDateTime(dateTime);
  }


  @Test
  void initTableInfo() {
    Test4WithoutTableNameEntity abstractEntity = new Test4WithoutTableNameEntity();
    assertEquals("AbstractEntityTest.Test4WithoutTableNameEntity(super=AbstractIdAdtVerEntity(super=IdAdtVerEntity(super=IdAdtEntity(super=IdEntity(id=null), invalid=null, lastModifyDateTime=null, lastModifyUserId=null), version=null), hasLength=null, noGetMethod=null, notNullCol=null, uniqueCol=null, withoutAnnotation=null, reName=null, longText=null))", abstractEntity.toString());
  }

  @Test
  void initColumnInfo() {
  }

  @Test
  void findHavingConditions() {
  }

  @Test
  void findWhereConditions() {
  }

  @Test
  void fillOc() throws IOException {
    mysqlIdAdtVerEntity.forceWhereCondition("notNullCol").setOp(Keyword.BETWEEN).setCl(List0.newArrayList(String0.Y, String0.N));
    mysqlIdAdtVerEntity.forceWhereCondition("uniqueCol").setOp(Keyword.IN).setCl(List0.newArrayList(String0.Y, String0.N));
    mysqlIdAdtVerEntity.forceWhereCondition("reName").setOp(Keyword.LIKE).setCs(String0.Y);
//    Files.write(tstOFiles().toPath(), mysqlIdAdtVerEntity.selectSql().toString().getBytes());
    assertEquals(String.join(String0.BR_LINUX, Files.readAllLines(tstOFiles().toPath())), mysqlIdAdtVerEntity.selectSql().toString());
  }

  @Test
  void fullTableName() {
  }

  @Test
  void lstSelectFiled() {
  }

  @Test
  void mapRow() throws SQLException {
    Test4WithoutTableNameEntity abstractEntity = new Test4WithoutTableNameEntity();

    Mockito.when(resultSet.getString(IdEntity.FIELD__ID)).thenReturn(id);
    Mockito.when(resultSet.getInt(IdAdtVerEntity.FIELD__VERSION)).thenReturn(1);
    abstractEntity.setSelectList(List0.newArrayList(IdEntity.FIELD__ID, IdAdtVerEntity.FIELD__VERSION, String0.ALPHABET));
    abstractEntity.mapRow(resultSet);

    assertEquals("AbstractEntityTest.Test4WithoutTableNameEntity(super=AbstractIdAdtVerEntity(super=IdAdtVerEntity(super=IdAdtEntity(super=IdEntity(id=1610866165373_KbTy6GDVwpB5rAYJjJb), invalid=null, lastModifyDateTime=null, lastModifyUserId=null), version=1), hasLength=null, noGetMethod=null, notNullCol=null, uniqueCol=null, withoutAnnotation=null, reName=null, longText=null))", abstractEntity.toString());
  }

  @Test
  void deleteSql() throws IOException {
//    Files.write(tstOFiles().toPath(), mysqlIdAdtVerEntity.deleteSql().toString().getBytes());
    assertEquals(String.join(String0.BR_LINUX, Files.readAllLines(tstOFiles().toPath())), mysqlIdAdtVerEntity.deleteSql().toString());
  }

  @Test
  void insertSql() throws IOException {
//    Files.write(tstOFiles().toPath(), mysqlIdAdtVerEntity.insertSql().toString().getBytes());
    assertEquals(String.join(String0.BR_LINUX, Files.readAllLines(tstOFiles().toPath())), mysqlIdAdtVerEntity.insertSql().toString());
  }

  @Test
  void insertStatement() {
  }

  @Test
  void selectCountSql() throws IOException {
//    Files.write(tstOFiles().toPath(), mysqlIdAdtVerEntity.selectCountSql().toString().getBytes());
    assertEquals(String.join(String0.BR_LINUX, Files.readAllLines(tstOFiles().toPath())), mysqlIdAdtVerEntity.selectCountSql().toString());
  }

  @Test
  void selectIdsSql() throws IOException {
//    Files.write(tstOFiles().toPath(), mysqlIdAdtVerEntity.selectIdsSql().toString().getBytes());
    assertEquals(String.join(String0.BR_LINUX, Files.readAllLines(tstOFiles().toPath())), mysqlIdAdtVerEntity.selectIdsSql().toString());
  }

  @Test
  void selectSql() throws IOException {
//    Files.write(tstOFiles().toPath(), mysqlIdAdtVerEntity.selectSql().toString().getBytes());
    assertEquals(String.join(String0.BR_LINUX, Files.readAllLines(tstOFiles().toPath())), mysqlIdAdtVerEntity.selectSql().toString());
  }

  @Test
  void selectStatement() {
  }

  @Test
  void updateSql() throws IOException {
//    Files.write(tstOFiles().toPath(), mysqlIdAdtVerEntity.updateSql().toString().getBytes());
    assertEquals(String.join(String0.BR_LINUX, Files.readAllLines(tstOFiles().toPath())), mysqlIdAdtVerEntity.updateSql().toString());
  }

  @Test
  void updateStatement() {
  }

  @Test
  void fromStatement() {
  }

  @Test
  void groupByStatement() {
  }

  @Test
  void havingStatement() throws IOException {
    mysqlIdAdtVerEntity.setSelectList(List0.newArrayList("notNullCol", "uniqueCol", "reName"));
    mysqlIdAdtVerEntity.setGroupByList(List0.newArrayList("notNullCol", "uniqueCol", "reName"));
    mysqlIdAdtVerEntity.forceHavingCondition("notNullCol").setOp(Keyword.BETWEEN).setCl(List0.newArrayList(String0.Y, String0.N));
    mysqlIdAdtVerEntity.forceHavingCondition("uniqueCol").setOp(Keyword.IN).setCl(List0.newArrayList(String0.Y, String0.N));
    mysqlIdAdtVerEntity.forceHavingCondition("reName").setOp(Keyword.LIKE).setCs(String0.Y);
//    Files.write(tstOFiles().toPath(), mysqlIdAdtVerEntity.selectSql().toString().getBytes());
    assertEquals(String.join(String0.BR_LINUX, Files.readAllLines(tstOFiles().toPath())), mysqlIdAdtVerEntity.selectSql().toString());
  }

  @Test
  void orderByStatement() throws IOException {
    mysqlIdAdtVerEntity.setOrderByList(List0.newArrayList("notNullCol", "uniqueCol", "reName"));
    mysqlIdAdtVerEntity.setPagination(new Pagination().setCount(100L).setPage(1).setSize(30));
//    Files.write(tstOFiles().toPath(), mysqlIdAdtVerEntity.selectSql().toString().getBytes());
    assertEquals(String.join(String0.BR_LINUX, Files.readAllLines(tstOFiles().toPath())), mysqlIdAdtVerEntity.selectSql().toString());
  }

  @Test
  void whereEntityStatement() {
  }

  @Test
  void whereConditionsStatement() {
  }

  @Test
  void whereStatement() {
  }

  @Accessors(chain = true)
  @Table
  @ToString(callSuper = true)
  public class Test4WithoutTableNameEntity extends AbstractIdAdtVerEntity implements SqlliteDialectSqlEntities {
  }
}