package choonsik.backtoyproject.scheduler.repository;

import choonsik.backtoyproject.member.entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;

public interface RefreshTokenRepository extends JpaRepository<Member, Long> {

    @Modifying
    @Transactional
    @Query("update Member m set m.refreshToken = null where m.refreshToken < :now")
    void updateExpiredRefreshTokens(@Param("now") LocalDateTime now);

    @Modifying
    @Transactional
    @Query("update Member m set m.refreshToken = :now where m.username = :username")
    void saveRefreshToken(@Param("username") String username, @Param("now") Date now);
}