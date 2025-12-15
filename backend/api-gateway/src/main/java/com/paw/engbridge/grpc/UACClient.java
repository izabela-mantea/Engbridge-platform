package com.paw.engbridge.grpc;

import com.engbridge.auth.grpc.AuthServiceGrpc;
import com.engbridge.auth.grpc.ValidateRequest;
import com.engbridge.auth.grpc.ValidateResponse;
import com.engbridge.auth.grpc.ValidateRequest;
import com.engbridge.auth.grpc.ValidateResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class UACClient {

    @Value("${uac.grpc.host}")
    private String host;

    @Value("${uac.grpc.port}")
    private int port;

    private ManagedChannel channel;
    private AuthServiceGrpc.AuthServiceBlockingStub authStub;

    @PostConstruct
    public void init() {
        this.channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();

        this.authStub = AuthServiceGrpc.newBlockingStub(channel);

        System.out.println("UAC gRPC Client initialized: " + host + ":" + port);
    }

    public ValidateResponse validateToken(String token) {
        try {
            ValidateRequest request = ValidateRequest.newBuilder()
                    .setToken(token)
                    .build();

            ValidateResponse response = authStub.validateToken(request);
            System.out.println("Token validated for user: " + response.getUserId());
            return response;

        } catch (StatusRuntimeException e) {
            System.err.println("gRPC call failed: " + e.getStatus());
            throw new RuntimeException("Token validation failed", e);
        }
    }

    @PreDestroy
    public void shutdown() {
        if (channel != null && !channel.isShutdown()) {
            channel.shutdown();
            System.out.println("UAC gRPC Client shutdown");
        }
    }
}