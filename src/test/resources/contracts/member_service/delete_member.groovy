package contracts.member_service

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should delete a member by id"

    request {
        url $(consumer(regex('/member/\\d+')), producer('/member/2'))
        method DELETE()
        headers {
            contentType applicationJsonUtf8()
            accept applicationJsonUtf8()
        }
    }

    response {
        status 200
    }
}