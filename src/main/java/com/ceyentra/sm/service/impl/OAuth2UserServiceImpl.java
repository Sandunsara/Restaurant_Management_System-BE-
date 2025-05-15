/**
 * @author :  Dinuth Dheeraka
 * Created : 8/4/2023 3:29 PM
 */
package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.entity.AdminEntity;
import com.ceyentra.sm.entity.StaffEntity;
import com.ceyentra.sm.entity.UserEntity;
import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.UserStatus;
import com.ceyentra.sm.exception.CustomOauthException;
import com.ceyentra.sm.repository.AdminRepo;
import com.ceyentra.sm.repository.StaffRepo;
import com.ceyentra.sm.repository.UserRepo;
import com.ceyentra.sm.service.OAuth2UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service(value = "userService")
@Log4j2
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@RequiredArgsConstructor
public class OAuth2UserServiceImpl implements OAuth2UserService, UserDetailsService {

    private final UserRepo userRepository;
    private final AdminRepo adminRepo;
    private final StaffRepo staffRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("starting function loadUserByUsername @Param username : {}", username);
        try {
            Optional<AdminEntity> admin = adminRepo.findByEmail(username);

            if (admin.isPresent() && admin.get().getStatus().equals(CommonStatus.ACTIVE)) {
                return new org.springframework.security.core.userdetails.User(
                        admin.get().getEmail(), admin.get().getPassword(),
                        getAuthority(admin.get().getUserRole().name())
                );
            }

            Optional<UserEntity> customer = userRepository.findByEmail(username);

            if (customer.isPresent() && customer.get().getStatus().equals(UserStatus.ACTIVE)) {
                return new org.springframework.security.core.userdetails.User(
                        customer.get().getEmail(), customer.get().getPassword(),
                        getAuthority(customer.get().getUserRole().name()));
            }

            Optional<StaffEntity> staff = staffRepo.findByEmail(username);

            if (staff.isPresent() && staff.get().getStatus().equals(CommonStatus.ACTIVE)) {
                return new org.springframework.security.core.userdetails.User(
                        staff.get().getEmail(), staff.get().getPassword(),
                        getAuthority(staff.get().getUserRole().name()));
            }

            throw new CustomOauthException("Invalid Credentials.");

        } catch (Exception e) {
            log.error("function loadUserByUsername {}", e.getMessage(), e);
            throw e;
        }
    }

    private List<SimpleGrantedAuthority> getAuthority(String roleName) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + roleName));
    }

}
