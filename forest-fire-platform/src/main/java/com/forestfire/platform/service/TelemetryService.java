package com.forestfire.platform.service;

import com.forestfire.platform.dto.TelemetryRequest;
import com.forestfire.platform.entity.FireAlarm;
import com.forestfire.platform.entity.SensorTelemetry;
import com.forestfire.platform.repository.FireAlarmRepository;
import com.forestfire.platform.repository.SensorTelemetryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TelemetryService {
    private final SensorTelemetryRepository telemetryRepository;
    private final FireAlarmRepository alarmRepository;

    public TelemetryService(SensorTelemetryRepository telemetryRepository,
                            FireAlarmRepository alarmRepository) {
        this.telemetryRepository = telemetryRepository;
        this.alarmRepository = alarmRepository;
    }

    public SensorTelemetry ingest(TelemetryRequest request) {
        SensorTelemetry telemetry = new SensorTelemetry();
        telemetry.setSensorId(request.getSensorId());
        telemetry.setSectorId(request.getSectorId());
        telemetry.setTemperature(request.getTemperature());
        telemetry.setSmokeLevel(request.getSmokeLevel());
        telemetry.setHumidity(request.getHumidity());
        SensorTelemetry saved = telemetryRepository.save(telemetry);

        // Required project rule:
        // Smoke > 50 ppm AND Temperature > 45 C => fire alarm.
        if (request.getSmokeLevel() > 50 && request.getTemperature() > 45) {
            FireAlarm alarm = new FireAlarm();
            alarm.setSensorId(request.getSensorId());
            alarm.setSectorId(request.getSectorId());
            alarm.setTemperature(request.getTemperature());
            alarm.setSmokeLevel(request.getSmokeLevel());
            alarm.setSeverity("HIGH");
            alarm.setStatus("ACTIVE");
            alarmRepository.save(alarm);
        }
        return saved;
    }

    public List<SensorTelemetry> getAll() { return telemetryRepository.findAll(); }
}
