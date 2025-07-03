package com.mjc813.contactjsp.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDto implements IContact {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String zipNumber;
    private String email;

    public String getContactFullInfo(){
        return toString();
    }

    @Override
    public String toString() {
        return "ContactDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", zipNumber='" + zipNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
