package contracts.member_service

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should list all members within given range"

    request {
        url('/member/') {
            queryParameters {
                parameter 'page': $(consumer(anyNumber()), producer(0))
                parameter 'size': $(consumer(anyNumber()), producer(3))
                parameter 'sort': $(consumer(anyOf('firstName', 'lastName', 'dateOfBirth', 'postalCode')), producer('firstName'))
            }
        }
        method GET()
        headers {
            contentType applicationJsonUtf8()
            accept applicationJsonUtf8()
        }
    }

    response {
        status 200
        body([
                id         : $(anyNumber()),
                firstName  : $(anyNonBlankString()),
                lastName   : $(anyNonBlankString()),
                dateOfBirth: $(anyIso8601WithOffset()),
                postalCode : $(anyNonBlankString())
        ])
    }
}