package com.group11.mapapi.api.error;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

@NoArgsConstructor(access = AccessLevel.NONE)
public final class ProblemDetailFactory {
    public static ProblemDetail createProblemDetail(final HttpStatus status, final Throwable throwable) {
        final var detail = ProblemDetail.forStatusAndDetail(status, throwable.getMessage());
        detail.setTitle(throwable.getClass().getSimpleName());
        return detail;
    }

    public static ValidationDetail createValidationDetail() {
        return new ValidationDetail();
    }

}
