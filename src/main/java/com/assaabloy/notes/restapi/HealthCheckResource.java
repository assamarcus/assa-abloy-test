package com.assaabloy.notes.restapi;

import com.codahale.metrics.health.HealthCheck;

public class HealthCheckResource extends HealthCheck {

    public HealthCheckResource() {
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
