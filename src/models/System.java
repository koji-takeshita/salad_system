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
            name = JpaConst.Q_SYS_GET_ALL,
            query = JpaConst.Q_SYS_GET_ALL_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SYS_GET_ALL_COUNT,
            query = JpaConst.Q_SYS_GET_ALL_COUNT_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SYS_GET_BY_SYS_NO,
            query = JpaConst.Q_SYS_GET_BY_SYS_NO_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SYS_GET_BY_SYS_NO_COUNT,
            query = JpaConst.Q_SYS_GET_BY_SYS_NO_COUNT_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SYS_GET_BY_SYS_LVL,
            query = JpaConst.Q_SYS_GET_BY_SYS_LVL_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_SYS_GET_BY_SYS_LVL_COUNT,
            query = JpaConst.Q_SYS_GET_BY_SYS_LVL_COUNT_DEF
        )

})
@Table(name = JpaConst.TABLE_SYS)
@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
public class System {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "system_no", nullable = false)
    private Integer sysNo;

    @Column(name = "system_name", length = 255, nullable = false)
    private String sysName;

    @Column(name = "system_level", nullable = false)
    private Integer sysLevel;

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