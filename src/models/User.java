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


@Entity
@NamedQueries({
    @NamedQuery(
            name = "getAllUsers",
            query = "SELECT u "
                  + "FROM User AS u "
                  + "WHERE u.delFlg = 0 "
                  + "ORDER BY u.id DESC"
        ),
    @NamedQuery(
            name = "getUserByUserId",
            query = "SELECT u "
                  + "FROM User AS u "
                  + "WHERE u.delFlg = 0 "
                  + "AND u.userId = :"
                  + "userId "
                  + "ORDER BY u.id DESC"
        ),
    @NamedQuery(
            name = "getUserByUserIdAndPass",
            query = "SELECT u "
                  + "FROM User AS u "
                  + "WHERE u.delFlg = 0 "
                  + "AND u.userId = :"
                  + "userId "
                  + "AND u.password = :"
                  + "password "
        )

})
@Table(name = "users")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSysLevel() {
        return sysLevel;
    }

    public void setSysLevel(Integer sysLevel) {
        this.sysLevel = sysLevel;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getInpUserId() {
        return inpUserId;
    }

    public void setInpUserId(String inpUserId) {
        this.inpUserId = inpUserId;
    }

    public LocalDateTime getInpDate() {
        return inpDate;
    }

    public void setInpDate(LocalDateTime inpDate) {
        this.inpDate = inpDate;
    }

    public String getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId;
    }

    public LocalDateTime getUpdDate() {
        return updDate;
    }

    public void setUpdDate(LocalDateTime updDate) {
        this.updDate = updDate;
    }

    public Integer getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Integer delFlg) {
        this.delFlg = delFlg;
    }

}