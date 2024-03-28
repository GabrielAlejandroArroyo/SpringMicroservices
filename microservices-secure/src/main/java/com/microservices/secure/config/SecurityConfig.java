package com.microservices.secure.config;


import com.microservices.secure.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//la configuracion basica se setea con estas 3 anotaciones @Configuration @EnableWebSecurity @EnableMethodSecurity
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    // El authenticationConfiguration lo necesito para authenticationManager o lo paso directamente en el metodo authenticationManager
    //@Autowired
    //AuthenticationConfiguration authenticationConfiguration;

    //    primero seteo el security filter chain
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                //condiciones de filtro
//                .csrf(csrf -> csrf.disable())
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(http -> {
//                    // Configura los endpoints publicos
//                    http.requestMatchers(HttpMethod.GET, "/auth/hello").permitAll();
//                    //http.requestMatchers(HttpMethod.GET, "/auth/hello-secured").hasAuthority("READ");
//
//                    // Configura los endpoints privados
//                    http.requestMatchers(HttpMethod.GET, "/auth/hello-secured").hasAuthority("CREATE");
//
//                    // Configura los endpoints No especificados
//                    http.anyRequest().denyAll();
//                } )
//                .build();
//    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                //condiciones de filtro
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }


    // Segundo  seteo el AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        // Retorno  authenticationConfiguration.getAuthenticationManager();
        return  authenticationConfiguration.getAuthenticationManager();
    }

    // Tercero defino un Authentication Provider en primara instancia de la Bd
    // Le puedpo pasar distintos proveedores por defecto Dao
    // El DaoAuthenticationProvider necesita dos componentes PasswordEncoder y UserDetailsService
    //        provider.setPasswordEncoder(null) y  provider.setUserDetailsService(null);
    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }


//    // Simulo usuarios en memoria, para no usar la BD, inmemory
//    @Bean
//    public UserDetailsService userDetailsService(){
//        List<UserDetails> userDetailsList = new ArrayList<>();
//
//        // Agrego usuarios a userDetailsList
//        userDetailsList.add(User.withUsername("santiago")
//                .password("1234")
//                .roles("ADMIN")
//                .authorities("READ", "CREATE")
//                .build());
//
//        userDetailsList.add(User.withUsername("daniel")
//                .password("1234")
//                .roles("USER")
//                .authorities("READ")
//                .build());
//
//        //return new InMemoryUserDetailsManager(userDetails);
//        return new InMemoryUserDetailsManager(userDetailsList);
//    }
//    // Tercero defino un Authentication Provider en primara instancia de la Bd
//    // Le puedpo pasar distintos proveedores por defecto Dao
//    // El DaoAuthenticationProvider necesita dos componentes PasswordEncoder y UserDetailsService
//    //        provider.setPasswordEncoder(null) y  provider.setUserDetailsService(null);
//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        //provider.setPasswordEncoder(null);
//        //provider.setUserDetailsService(null);
//        provider.setPasswordEncoder(passwordEncoder());
//        provider.setUserDetailsService(userDetailsService());
//        return provider;
//    }

    /* Traigo los usuarios de la base de datos*/
//    @Bean
//    public UserDetailsService userDetailsService(){
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // solo utilizar para pruebas
        //return NoOpPasswordEncoder.getInstance();
        //para produccion
        return new BCryptPasswordEncoder();
    }

    //Generacion de Encriptada
//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("1234"));
//        // Contraseña encriptad 1234 -> $2a$10$aEBYDsegXU89UwiC1fHcLOX03LxM.OxqNKF/aVkWVNe2voclvGr0u
//
//    }


}
