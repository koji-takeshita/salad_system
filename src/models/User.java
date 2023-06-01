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
            name = JpaConst.Q_USER_GET_ALL,
            query = JpaConst.Q_USER_GET_ALL_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_USER_GET_ALL_COUNT,
            query = JpaConst.Q_USER_GET_ALL_COUNT_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_USER_GET_BY_SYS_LVL,
            query = JpaConst.Q_USER_GET_BY_SYS_LVL_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_USER_GET_BY_SYS_LVL_COUNT,
            query = JpaConst.Q_USER_GET_BY_SYS_LVL_COUNT_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_USER_GET_BY_MENU_LVL,
            query = JpaConst.Q_USER_GET_BY_MENU_LVL_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_USER_GET_BY_MENU_LVL_COUNT,
            query = JpaConst.Q_USER_GET_BY_MENU_LVL_COUNT_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_USER_GET_BY_USER_ID,
            query = JpaConst.Q_USER_GET_BY_USER_ID_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_USER_GET_BY_USER_ID_COUNT,
            query = JpaConst.Q_USER_GET_BY_USER_ID_COUNT_DEF
        ),
    @NamedQuery(
            name = JpaConst.Q_USER_GET_BY_USER_ID_AND_PASS,
            query = JpaConst.Q_USER_GET_BY_USER_ID_AND_PASS_DEF
        )

})
@Table(name = JpaConst.TABLE_USER)
@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
public class User {

    /**
     * リソースid
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * ユーザーID
     */
    @Column(name = "user_id", nullable = false)
    private String userId;

    /**
     * ユーザー名
     */
    @Column(name = "user_name", nullable = false)
    private String userName;

    /**
     * パスワード
     */
    @Column(name = "password", length = 64, nullable = false)
    private String password;

    /**
     * 利用可能なシステムを開示するか判断するレベル（一般：0、会員：1、管理者：９）
     */
    @Column(name = "system_level", nullable = false)
    private Integer sysLevel;

    /**
     * 利用するシステム内での使用可能な機能を判断するレベル（参照：0、更新：1、管理：９）
     */
    @Column(name = "menu_level", nullable = false)
    private Integer menuLevel;

    /**
     *登録ユーザーID
     */
    @Column(name = "inp_user_id", nullable = false)
    private String inpUserId;

    /**
     * 登録日時
     */
    @Column(name = "inp_date", nullable = false)
    private LocalDateTime inpDate;

    /**
     * 更新ユーザーID
     */
    @Column(name = "upd_user_id", nullable = false)
    private String updUserId;

    /**
     * 更新日時
     */
    @Column(name = "upd_date", nullable = false)
    private LocalDateTime updDate;

    /**
     * 削除された従業員かどうか（現役：0、削除済み：1）
     */
    @Column(name = "del_flg", nullable = false)
    private Integer delFlg;

}