package choonsik.backtoyproject.scheduler.service;

import choonsik.backtoyproject.common.constants.Constants;
import choonsik.backtoyproject.scheduler.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    public void deleteToken() {
        LocalDateTime now = LocalDateTime.now();
        refreshTokenRepository.updateExpiredRefreshTokens(now);
    }

    public void saveRefreshToken(String username) {
        Date currentTime = new Date(System.currentTimeMillis());
        Date now = new Date(currentTime.getTime() + Constants.refreshToken);
        refreshTokenRepository.saveRefreshToken(username, now);
    }
}
