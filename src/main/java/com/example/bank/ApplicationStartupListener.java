package com.example.bank;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import io.sentry.Sentry;

@Component
public class ApplicationStartupListener implements ApplicationListener<ContextStartedEvent> {

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        // This will get triggered when the application context starts

        try {
            // Simulate or check any initialization logic you want to validate here
        } catch (Exception ex) {
            // Capture exception during application context startup
            Sentry.captureException(ex);
        }
    }

}
