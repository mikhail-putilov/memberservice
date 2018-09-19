package io.github.musius.member_service.web.api.errors;

import org.zalando.problem.AbstractThrowableProblem;

import static java.lang.String.format;
import static org.zalando.problem.Status.BAD_REQUEST;

public final class MemberIdAlreadyUsedProblem extends AbstractThrowableProblem {

    private final Long id;

    public MemberIdAlreadyUsedProblem(final Long id) {
        super(null, format("Member id %d already used", id), BAD_REQUEST);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}