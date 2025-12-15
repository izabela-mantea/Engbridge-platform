package com.paw.engbridge.controllers;

import com.engbridge.auth.grpc.*;
import com.paw.engbridge.grpc.UACClient;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class GatewayController {

    @Value("${service.content.url}")
    private String contentServiceUrl;



    private final UACClient uacClient;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public GatewayController(UACClient uacClient) {
        this.uacClient = uacClient;
    }
    @GetMapping("/test")
    public String test() {
        return "Gateway works!";
    }
    // Login - apel gRPC catre UAC
    @PostMapping("/api/auth/login")
    public ResponseEntity<?> login(@RequestBody String body) {
        try {
            JsonNode json = objectMapper.readTree(body);
            String username = json.get("username").asText();
            String password = json.get("password").asText();

            // Apel UAC prin gRPC
            LoginRequest loginReq = LoginRequest.newBuilder()
                    .setUsername(username)
                    .setPassword(password)
                    .build();

            LoginResponse response = uacClient.login(loginReq);

            if (response.hasError() && !response.getError().isEmpty()) {
                return ResponseEntity.status(401)
                        .body("{\"error\": \"" + response.getError() + "\"}");
            }

            return ResponseEntity.ok("{\"token\": \"" + response.getToken() + "\"}");

        } catch (Exception e) {
            System.err.println("Login error: " + e.getMessage());
            return ResponseEntity.status(500)
                    .body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    // Register - apel gRPC catre UAC
    @PostMapping("/api/auth/register")
    public ResponseEntity<?> register(@RequestBody String body) {
        try {
            JsonNode json = objectMapper.readTree(body);
            String username = json.get("username").asText();
            String password = json.get("password").asText();
            String email = json.get("email").asText();

            RegisterRequest registerReq = RegisterRequest.newBuilder()
                    .setUsername(username)
                    .setPassword(password)
                    .setEmail(email)
                    .build();

            RegisterResponse response = uacClient.register(registerReq);

            if (!response.getSuccess()) {
                return ResponseEntity.status(400)
                        .body("{\"error\": \"" + response.getMessage() + "\"}");
            }

            return ResponseEntity.ok("{\"message\": \"" + response.getMessage() + "\"}");

        } catch (Exception e) {
            System.err.println("Register error: " + e.getMessage());
            return ResponseEntity.status(500)
                    .body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    // Content Service - cu autentificare
    @RequestMapping(value = "/api/content/**", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<String> contentProxy(@RequestBody(required = false) String body, HttpServletRequest request) {
        String path = request.getRequestURI().replace("/api/content", "");
        String url = contentServiceUrl + path;
        return forwardRequest(url, HttpMethod.valueOf(request.getMethod()), body, request);
    }



    private ResponseEntity<String> forwardRequest(String url, HttpMethod method, String body, HttpServletRequest request) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            if (request != null) {
                addUserHeaders(headers, request);
            }

            HttpEntity<String> entity = new HttpEntity<>(body, headers);

            System.out.println("Forward " + method + " -> " + url);
            ResponseEntity<String> response = restTemplate.exchange(url, method, entity, String.class);
            System.out.println("Status: " + response.getStatusCode());

            return response;

        } catch (org.springframework.web.client.HttpClientErrorException e) {
            System.err.println("HTTP Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        } catch (org.springframework.web.client.HttpServerErrorException e) {
            System.err.println("HTTP Server Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        } catch (Exception e) {
            System.err.println("Forward Error: " + e.getMessage());
            return ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    private void addUserHeaders(HttpHeaders headers, HttpServletRequest request) {
        Object userId = request.getAttribute("X-User-Id");
        Object role = request.getAttribute("X-User-Role");

        if (userId != null) headers.set("X-User-Id", userId.toString());
        if (role != null) headers.set("X-User-Role", role.toString());
    }
}