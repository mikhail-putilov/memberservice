package io.github.musius.member_service.web.api.errors;

import org.zalando.problem.AbstractThrowableProblem;

import static java.lang.String.format;
import static org.zalando.problem.Status.BAD_REQUEST;

public final class MemberIdsDoNotMatchProblem extends AbstractThrowableProblem {

    private final Long idFromPath;
    private final Long idFromEntity;

    public MemberIdsDoNotMatchProblem(final Long idFromPath, final Long idFromEntity) {
        super(null, format("Member id from url %d is not equal to id from entity %d", idFromPath, idFromEntity), BAD_REQUEST);
        this.idFromPath = idFromPath;
        this.idFromEntity = idFromEntity;
    }

    public Long getIdFromEntity() {
        return idFromEntity;
    }

    public Long getIdFromPath() {

        return idFromPath;
    }
}