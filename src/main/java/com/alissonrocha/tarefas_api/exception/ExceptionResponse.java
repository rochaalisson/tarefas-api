package com.alissonrocha.tarefas_api.exception;

import java.time.OffsetDateTime;
import java.util.List;

public record ExceptionResponse(
        String title,
        String detail,
        int status,
        String path,
        OffsetDateTime timestamp
) {
}
