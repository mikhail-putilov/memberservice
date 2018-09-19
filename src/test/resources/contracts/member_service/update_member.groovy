package contracts.member_service

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should update member"

    request {
        url $(consumer(regex('/member/\\d+')), producer('/member/4'))
        method PUT()
        headers {
            contentType applicationJsonUtf8()
            accept applicationJsonUtf8()
        }
        body(
                id: $(consumer(anyNumber()), producer(4)),
                firstName: $(consumer(anyNonBlankString()), producer("John_updated")),
                lastName: $(consumer(anyNonBlankString()), producer("Doe_updated")),
                dateOfBirth: $(consumer(anyIso8601WithOffset()), producer("2007-12-03T10:15:30+01:00")),
                postalCode: $(consumer(anyNonBlankString()), producer("654321"))
        )
    }

    response {
        status 200
        body(
                id: fromRequest().path(1),
                firstName: fromRequest().body('$.firstName'),
                lastName: fromRequest().body('$.lastName'),
                dateOfBirth: $(consumer("2007-12-03T10:15:30+01:00"), producer(anyIso8601WithOffset())),
                postalCode: fromRequest().body('$.postalCode')
        )
    }
}