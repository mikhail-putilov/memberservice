package io.github.musius.member_service.model;

import java.time.ZonedDateTime;

public class Member extends BaseEntity<Long> {
    private String firstName;
    private String lastName;
    private ZonedDateTime dateOfBirth;
    private String postalCode;

    public Member() {
        super(null);
    }

    public Member(Long id, String firstName, String lastName, ZonedDateTime dateOfBirth, String postalCode) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.postalCode = postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ZonedDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
