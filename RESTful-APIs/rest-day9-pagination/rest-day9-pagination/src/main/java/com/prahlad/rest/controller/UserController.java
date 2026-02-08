package com.prahlad.rest.controller;

import com.prahlad.rest.dto.*;
import com.prahlad.rest.service.FileService;
import com.prahlad.rest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import org.springframework.http.MediaType;


@RestController
@RequestMapping("/api/users")
public class UserController 
{

    private final UserService userService;
    private final FileService fileService;

    public UserController(UserService userService, FileService fileService) 
    {
        this.userService = userService;
        this.fileService = fileService;
    }

    @PostMapping
    public UserResponseDto create(@Valid @RequestBody UserRequestDto dto) 
    {
        return userService.create(dto);
    }

    @GetMapping
    public PageResponseDto<UserResponseDto> getUsers(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false) String keyword) 
    {

        return userService.getUsers(page, size, keyword);
    }

    @PostMapping(
            value = "/{id}/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public UserResponseDto uploadProfileImage(
            @PathVariable Long id,
            @RequestPart("file") MultipartFile file
    ) throws IOException 
    {

        String path = fileService.upload(file);
        return userService.updateProfileImage(id, path);
    }
}