package choonsik.backtoyproject.scheduler.controller;

import choonsik.backtoyproject.scheduler.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@RequiredArgsConstructor
public class RefreshTokenScheduler {

    private final RefreshTokenService refreshTokenService;

    @Scheduled(cron = "0 */5 * * * *")
    public void printDate() {
        refreshTokenService.deleteToken();
    }
}
