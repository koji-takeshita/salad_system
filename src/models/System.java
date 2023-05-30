package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "systems")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSysNo() {
        return sysNo;
    }

    public void setSysNo(Integer sysNo) {
        this.sysNo = sysNo;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public Integer getSysLevel() {
        return sysLevel;
    }

    public void setSysLevel(Integer sysLevel) {
        this.sysLevel = sysLevel;
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