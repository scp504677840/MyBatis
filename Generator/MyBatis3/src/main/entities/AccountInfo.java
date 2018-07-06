package main.entities;

import java.math.BigDecimal;
import java.util.Date;

/**
 * -- auto-generated definition
 * create table account_info
 * (
 *   id           bigint unsigned auto_increment,
 *   gmt_create   datetime                not null,
 *   gmt_modified datetime                not null,
 *   name         varchar(30)             not null,
 *   balance      decimal(10, 2) unsigned not null,
 *   constraint account_info_id_uindex
 *   unique (id)
 * );
 *
 * alter table account_info
 *   add primary key (id);
 */
public class AccountInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_info.id
     *
     * @mbg.generated Fri Jul 06 15:11:49 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_info.gmt_create
     *
     * @mbg.generated Fri Jul 06 15:11:49 CST 2018
     */
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_info.gmt_modified
     *
     * @mbg.generated Fri Jul 06 15:11:49 CST 2018
     */
    private Date gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_info.name
     *
     * @mbg.generated Fri Jul 06 15:11:49 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_info.balance
     *
     * @mbg.generated Fri Jul 06 15:11:49 CST 2018
     */
    private BigDecimal balance;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_info.id
     *
     * @return the value of account_info.id
     *
     * @mbg.generated Fri Jul 06 15:11:49 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_info.id
     *
     * @param id the value for account_info.id
     *
     * @mbg.generated Fri Jul 06 15:11:49 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_info.gmt_create
     *
     * @return the value of account_info.gmt_create
     *
     * @mbg.generated Fri Jul 06 15:11:49 CST 2018
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_info.gmt_create
     *
     * @param gmtCreate the value for account_info.gmt_create
     *
     * @mbg.generated Fri Jul 06 15:11:49 CST 2018
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_info.gmt_modified
     *
     * @return the value of account_info.gmt_modified
     *
     * @mbg.generated Fri Jul 06 15:11:49 CST 2018
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_info.gmt_modified
     *
     * @param gmtModified the value for account_info.gmt_modified
     *
     * @mbg.generated Fri Jul 06 15:11:49 CST 2018
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_info.name
     *
     * @return the value of account_info.name
     *
     * @mbg.generated Fri Jul 06 15:11:49 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_info.name
     *
     * @param name the value for account_info.name
     *
     * @mbg.generated Fri Jul 06 15:11:49 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_info.balance
     *
     * @return the value of account_info.balance
     *
     * @mbg.generated Fri Jul 06 15:11:49 CST 2018
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_info.balance
     *
     * @param balance the value for account_info.balance
     *
     * @mbg.generated Fri Jul 06 15:11:49 CST 2018
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}