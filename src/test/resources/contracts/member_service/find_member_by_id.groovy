package contracts.member_service

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should find member by id"

    request {
        url $(consumer(regex('/member/\\d+')), producer('/member/3'))
        method GET()
        headers {
            contentType applicationJsonUtf8()
            accept applicationJsonUtf8()
        }
    }

    response {
        status 200
        body (
                id: fromRequest().path(1),
                firstName: $(anyNonBlankString()),
                lastName: $(anyNonBlankString()),
                dateOfBirth: $(anyIso8601WithOffset()),
                postalCode: $(anyNonBlankString())
        )
    }
}