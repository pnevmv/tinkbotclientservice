package ru.chnr.vn.tinkbotclientservice.services;

import net.devh.boot.grpc.client.inject.GrpcClient;

import org.springframework.stereotype.Service;
import ru.chnr.vn.common.generated.BotClientGrpc;
import ru.chnr.vn.common.generated.BotID;
import ru.chnr.vn.common.generated.Token;

@Service
public class BotService {

    @GrpcClient("botService")
    private BotClientGrpc.BotClientBlockingStub botClientBlockingStub;


    public long createBot(String t){
        Token token = Token
                .newBuilder()
                .setToken(t)
                .build();

        long response = botClientBlockingStub
                .createBot(token)
                .getBotID();

        System.out.println("new bot id " + response);

        return response;
    }

    public boolean deleteBot(long id){
        boolean response = botClientBlockingStub.deleteBot(
                BotID.newBuilder().setBotID(id).build()
        ).getValue();

        System.out.println("deleted bot with id " + id + " " + response);
        return response;
    }
}
