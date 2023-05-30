package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sets")
public class Set {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "system_no", nullable = false)
    private Integer sysNo;

    @Column(name = "cul_set_no", length = 255, nullable = false)
    private Integer culSetNo;

    @Column(name = "row_set_no", nullable = false)
    private Integer rowSetNo;

    @Column(name = "booked_flg", nullable = false )
    private Boolean bookedFlg;

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

    public Integer getCulSetNo() {
        return culSetNo;
    }

    public void setCulSeatNo(Integer culSetNo) {
        this.culSetNo = culSetNo;
    }

    public Integer getRowSeatNo() {
        return rowSetNo;
    }

    public void setRowSeatNo(Integer rowSetNo) {
        this.rowSetNo = rowSetNo;
    }

    public Boolean getBookedFlg() {
        return bookedFlg;
    }

    public void setBookedFlg(Boolean bookedFlg) {
        this.bookedFlg = bookedFlg;
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