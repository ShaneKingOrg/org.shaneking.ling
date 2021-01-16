package org.shaneking.ling.persistence.sql.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.shaneking.ling.zero.lang.String0;
import org.shaneking.ling.zero.util.Date0;

import javax.persistence.Column;
import javax.persistence.Transient;

@Accessors(chain = true)
@ToString
public abstract class IdAdtEntity<J> extends IdEntity<J> {
  @Transient
  public static final String COLUMN__INVALID = "invalid";
  @Transient
  public static final String COLUMN__LAST_MODIFY_DATE_TIME = "last_modify_date_time";
  @Transient
  public static final String COLUMN__LAST_MODIFY_USER_ID = "last_modify_user_id";

  @Transient
  public static final String FIELD__INVALID = "invalid";
  @Transient
  public static final String FIELD__LAST_MODIFY_DATE_TIME = "lastModifyDateTime";
  @Transient
  public static final String FIELD__LAST_MODIFY_USER_ID = "lastModifyUserId";

  @Column(length = 1, columnDefinition = "COMMENT 'The invalid status of record {Y:invalid,N:valid(default)}'")
  @Getter
  @Setter
  private String invalid;

  /**
   * @see org.shaneking.ling.zero.util.Date0#DATE_TIME
   */
  @Column(length = 20, columnDefinition = "COMMENT 'The last modification date time of record'")
  @Getter
  @Setter
  private String lastModifyDateTime;

  @Column(length = 40, columnDefinition = "COMMENT 'The last modified user of record'")
  @Getter
  @Setter
  private String lastModifyUserId;

  public IdAdtEntity<J> initInvalid() {
    return this.setInvalid(String0.null2EmptyTo(this.getInvalid(), String0.N));
  }

  public IdAdtEntity<J> initWithUserId(@NonNull String userId) {
    return this.initInvalid().setLastModifyDateTime(String0.null2EmptyTo(this.getLastModifyDateTime(), Date0.on().dateTime())).setLastModifyUserId(String0.null2EmptyTo(this.getLastModifyUserId(), userId));
  }

  public IdAdtEntity<J> initWithUserIdAndSkId(@NonNull String userId, @NonNull String skId) {
    this.initSkId(skId);
    return this.initWithUserId(userId);
  }
}