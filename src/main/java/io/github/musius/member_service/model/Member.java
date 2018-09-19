package io.github.musius.member_service.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Comparator;

@SuppressWarnings("WeakerAccess")
public class Member implements Serializable, Comparable<Member> {
    private static final Comparator<Member> NATURAL_ORDER =
            Comparator.comparing(Member::getId)
                    .thenComparing(Member::getFirstName)
                    .thenComparing(Member::getLastName)
                    .thenComparing(Member::getDateOfBirth)
                    .thenComparing(Member::getPostalCode);
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private ZonedDateTime dateOfBirth;
    private String postalCode;

    // for spring:
    public Member() {

    }

    public Member(Long id, String firstName, String lastName, ZonedDateTime dateOfBirth, String postalCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public int compareTo(Member o) {
        return NATURAL_ORDER.compare(this, o);
    }
}
