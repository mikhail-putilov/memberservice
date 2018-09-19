package contracts.member_service

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should create member and assign new id"

    request {
        url "/member"
        headers {
            contentType applicationJsonUtf8()
            accept applicationJsonUtf8()
        }
        method POST()
        body(
                firstName: $(consumer(anyNonBlankString()), producer("John")),
                lastName: $(consumer(anyNonBlankString()), producer("Doe")),
                dateOfBirth: $(consumer(anyIso8601WithOffset()), producer("2007-12-03T10:15:30+01:00")),
                postalCode: $(consumer(anyNonBlankString()), producer("123456"))
        )
    }

    response {
        status 201
        body(
                id: $(anyNumber()),
                firstName: fromRequest().body('$.firstName'),
                lastName: fromRequest().body('$.lastName'),
                dateOfBirth: $(consumer("2007-12-03T10:15:30+01:00"), producer(anyIso8601WithOffset())),
                postalCode: fromRequest().body('$.postalCode')
        )
    }
}