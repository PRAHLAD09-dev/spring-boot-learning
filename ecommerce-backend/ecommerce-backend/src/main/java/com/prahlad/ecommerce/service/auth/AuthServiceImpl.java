package com.prahlad.ecommerce.service.auth;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prahlad.ecommerce.dto.auth.AuthResponse;
import com.prahlad.ecommerce.dto.auth.LoginRequest;
import com.prahlad.ecommerce.dto.auth.MerchantRegisterRequest;
import com.prahlad.ecommerce.dto.auth.UserRegisterRequest;
import com.prahlad.ecommerce.entity.Merchant;
import com.prahlad.ecommerce.entity.User;
import com.prahlad.ecommerce.enums.Role;
import com.prahlad.ecommerce.repository.MerchantRepository;
import com.prahlad.ecommerce.repository.UserRepository;
import com.prahlad.ecommerce.security.JwtUtil;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService 
{

    private final UserRepository userRepository;
    private final MerchantRepository merchantRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public  AuthResponse registerUser(UserRegisterRequest request)
    {

        if (userRepository.findByEmail(request.email()).isPresent()) 
        {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .active(true)
                .build();

        userRepository.save(user);

        return new AuthResponse(
                "User registered successfully",
                user.getEmail(),
                user.getRole().name(),
                null
        );
    }

    @Override
    public AuthResponse registerMerchant(MerchantRegisterRequest request)
    {

        if (merchantRepository.findByEmail(request.email()).isPresent()) 
        {
            throw new RuntimeException("Email already exists");
        }

        Merchant merchant = Merchant.builder()
                .businessName(request.businessName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .approved(false)
                .build();

        merchantRepository.save(merchant);

        return new AuthResponse(
                "Merchant registered successfully",
                merchant.getEmail(),
                "MERCHANT",
                null
        );
    }

 
    @Override
    public AuthResponse login(LoginRequest request) 
    {

      
        Optional<User> userOptional = userRepository.findByEmail(request.email());

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (!passwordEncoder.matches(request.password(), user.getPassword())) 
            {
                throw new RuntimeException("Invalid credentials");
            }

            String token = jwtUtil.generateToken(user);

            return new AuthResponse(
                    "Login successful",
                    user.getEmail(),
                    user.getRole().name(),
                    token
            );
        }


        Optional<Merchant> merchantOptional =
                merchantRepository.findByEmail(request.email());

        if (merchantOptional.isPresent()) {
            Merchant merchant = merchantOptional.get();

            if (!passwordEncoder.matches(request.password(), merchant.getPassword())) 
            {
                throw new RuntimeException("Invalid credentials");
            }

            User tempUser = User.builder()
                    .id(merchant.getId())
                    .email(merchant.getEmail())
                    .role(Role.MERCHANT)
                    .build();

            String token = jwtUtil.generateToken(tempUser);

            return new AuthResponse(
                    "Login successful",
                    merchant.getEmail(),
                    "MERCHANT",
                    token
            );
        }

        throw new RuntimeException("Invalid credentials");
    }


}