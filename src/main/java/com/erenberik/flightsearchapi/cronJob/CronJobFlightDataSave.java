package com.erenberik.flightsearchapi.cronJob;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CronJobFlightDataSave {
    private final FlightDataSaveService flightDataSaveService;

    @Scheduled(cron = "0 0 0 * * *") //Executes every day at 00:00
    public void updateFlightsScheduledJob() {
        flightDataSaveService.saveFlightDataFromExternalApi();
    }
}
