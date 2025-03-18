package com.example.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.sentry.Sentry;

@SpringBootApplication
public class BankApplication {

    public static void main(String[] args) {
        // Initialize Sentry before starting the application
        Sentry.init(options -> options.setDsn("https://c227b6eb177da1c255c148f0dd0dc9b2@o4508290930900992.ingest.us.sentry.io/4508998023118848"));

        try {
            SpringApplication.run(BankApplication.class, args);
        } catch (Exception ex) {
            // Capture any exceptions that occur during the startup process
            Sentry.captureException(ex);
            System.exit(1); // Exit with error code if application fails to start
        }
    }
}
