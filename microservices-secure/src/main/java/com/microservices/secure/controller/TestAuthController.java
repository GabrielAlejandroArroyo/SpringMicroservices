package com.microservices.secure.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class TestAuthController {


    // Estos son controladores Genericos
    @GetMapping("/hello")
    @PreAuthorize("permitAll()")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/hello-secured")
    @PreAuthorize("hasAuthority('READ')")
    public String helloSecured(){
        return "Hello World secured";
    }

    @GetMapping("/hello-secured2")
    @PreAuthorize("hasAuthority('CREATE')")
    public String helloSecured2(){
        return "Hello World secured2";
    }



    // Controldores con authority

    @GetMapping("/get")
    @PreAuthorize("hasAuthority('READ')")
    public String helloGet(){
        return "Hello world - GET";
    }
    @PostMapping("/post")
    @PreAuthorize("hasAuthority('CREATE')")
    public String helloPost(){
        return "Hello world hasAuthority- POST";
    }
    @PutMapping("/put")
    @PreAuthorize("hasAuthority('UPDATE')")
    public String helloPut(){
        return "Hello world hasAuthority- PUT";
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('DELETE')")
    public String helloDelete(){
        return "Hello world hasAuthority- DELETE";
    }

    @PatchMapping("/patch")
    @PreAuthorize("hasAuthority('REFACTOR')")
    public String helloPatch(){
        return "Hello world hasAuthority- PATCH";
    }

    ///////////////////////////

    // Controldores con Role

    @GetMapping("/roles/get")
    @PreAuthorize("hasRole('INVITED')")
    public String helloGetRoles(){
        return "Hello world hasRole - GET";
    }
    @PostMapping("/roles/post")
    @PreAuthorize("hasRole('ADMIN')")
    public String helloPostRoles(){
        return "Hello world hasRole- POST";
    }
    @PutMapping("/roles/put")
    @PreAuthorize("hasRole('ADMIN')")
    public String helloPutRoles(){
        return "Hello world hasRole- PUT";
    }
    @DeleteMapping("/roles/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String helloDeleteRoles(){
        return "Hello world hasRole- DELETE";
    }

    @PatchMapping("/roles/patch")
    @PreAuthorize("hasAnyRole('ADMIN','DEVELOPER')")
    public String helloPatchRoles(){
        return "Hello world hasRole- PATCH";
    }




}
