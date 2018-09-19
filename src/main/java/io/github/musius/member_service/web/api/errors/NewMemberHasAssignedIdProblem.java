package io.github.musius.member_service.web.api.errors;

import org.zalando.problem.AbstractThrowableProblem;

import static java.lang.String.format;
import static org.zalando.problem.Status.BAD_REQUEST;

public final class NewMemberHasAssignedIdProblem extends AbstractThrowableProblem {

    private final Long idFromEntity;

    public NewMemberHasAssignedIdProblem(final Long idFromEntity) {
        super(null, "It is prohibited to assign ids for new members", BAD_REQUEST, format("try to delete id field: \"id\":%d", idFromEntity));
        this.idFromEntity = idFromEntity;
    }

    public Long getIdFromEntity() {
        return idFromEntity;
    }

}