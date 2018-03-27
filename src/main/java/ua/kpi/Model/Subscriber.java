package ua.kpi.Model;

import ua.kpi.Model.Address;
import ua.kpi.Model.GroupSubscriber;
/**
 * Created by Gavriliak on 14.02.2018.
 */
public class Subscriber {
    private String surname;
    private String name;
    private String patronymic;
    private String nickName;
    private GroupSubscriber group;
    private String homeNumber;
    private String mobileNumber;
    private String mobileNumber2;
    private String eMail;
    private String skype;
    private Address address;

    public Subscriber() {
        name = "";
        surname = "";
        patronymic = "";
        nickName = "";
        group = null;
        homeNumber = "";
        mobileNumber = "";
        mobileNumber2 = "";
        eMail = "";
        skype = "";
        address = null;

    }

    Subscriber(String name, String surname, String patronymic, String nickName, GroupSubscriber group, String homeNumber,
               String mobileNumber, String mobileNumber2, String eMail, String skype, Address address) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.nickName = nickName;
        this.group = group;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
        this.mobileNumber2 = mobileNumber2;
        this.eMail = eMail;
        this.skype = skype;
        this.address = address;
    }

    @Override
    public String toString() {
        return surname + ' ' + name.charAt(0) + '.' + " - " + nickName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public GroupSubscriber getGroup() {
        return group;
    }

    public void setGroup(GroupSubscriber group) {
        this.group = group;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber2() {
        return mobileNumber2;
    }

    public void setMobileNumber2(String mobileNumber2) {
        this.mobileNumber2 = mobileNumber2;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
