//package choonsik.backtoyproject.common.config;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.filter.CorsFilter;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//
//    private final CorsFilter corsFilter;
//
//
//    /**
//     * Csrf 필터 HttpSecurity #csrf
//     * 사용자 이름비밀번호인증필터  HttpSecurity #formLogin
//     * 기본인증필터 HttpSecurity #httpBasic
//     * 인증 필터 HttpSecurity #authorizeHttpRequests
//     */
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http
//            .csrf(Customizer.withDefaults())
//            .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
//            .httpBasic(Customizer.withDefaults())
//            .formLogin(form -> form.loginPage("/api/v1/member/signUp").loginProcessingUrl("/signUp").defaultSuccessUrl("/"));
//
//
//
//        return http.build();
//    }
//
//
//    public class CustomDsl extends AbstractHttpConfigurer<CustomDsl, HttpSecurity> {
//
//        @Override
//        public void configure(HttpSecurity builder) {
//            builder.addFilter(corsFilter);
//
//        }
//    }
//}
