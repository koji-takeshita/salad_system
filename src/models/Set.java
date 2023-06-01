package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NamedQueries({
    @NamedQuery(
            name = JpaConst.Q_SET_GET_ALL,
            query = JpaConst.Q_SET_GET_ALL_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SET_GET_ALL_COUNT,
            query = JpaConst.Q_SET_GET_ALL_COUNT_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SET_GET_BY_SYS_NO,
            query = JpaConst.Q_SET_GET_BY_SYS_NO_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SET_GET_BY_SYS_NO_COUNT,
            query = JpaConst.Q_SET_GET_BY_SYS_NO_COUNT_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SET_GET_BY_COL_NO,
            query = JpaConst.Q_SET_GET_BY_COL_NO_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SET_GET_BY_COL_NO_COUNT,
            query = JpaConst.Q_SET_GET_BY_COL_NO_COUNT_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SET_GET_BY_ROW_NO,
            query = JpaConst.Q_SET_GET_BY_ROW_NO_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SET_GET_BY_ROW_NO_COUNT,
            query = JpaConst.Q_SET_GET_BY_ROW_NO_COUNT_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SET_GET_BY_COL_ROW,
            query = JpaConst.Q_SET_GET_BY_COL_ROW_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SET_GET_BY_COL_ROW_COUNT,
            query = JpaConst.Q_SET_GET_BY_COL_ROW_COUNT_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SET_GET_BY_RSV_FLG,
            query = JpaConst.Q_SET_GET_BY_RSV_FLG_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SET_GET_BY_RSV_FLG_COUNT,
            query = JpaConst.Q_SET_GET_BY_RSV_FLG_COUNT_DEF
        )

})
@Table(name = JpaConst.TABLE_SET)
@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
public class Set {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "system_no", nullable = false)
    private Integer sysNo;

    @Column(name = "col_set_no", length = 255, nullable = false)
    private Integer colSetNo;

    @Column(name = "row_set_no", nullable = false)
    private Integer rowSetNo;

    @Column(name = "reserve_flg", nullable = false )
    private Integer rsvFlg;

    @Column(name = "inp_user_id", nullable = false)
    private String inpUserId;

    @Column(name = "inp_date", nullable = false)
    private LocalDateTime inpDate;

    @Column(name = "upd_user_id", nullable = false)
    private String updUserId;

    @Column(name = "upd_date", nullable = false)
    private LocalDateTime updDate;

    @Column(name = "del_flg", nullable = false)
    private Integer delFlg;

}