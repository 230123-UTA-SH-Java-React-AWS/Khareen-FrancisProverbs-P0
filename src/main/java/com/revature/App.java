package com.revature;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.revature.controllers.AbilityController;
import com.revature.controllers.PokemonController;
import com.revature.model.Pokemon;
import com.revature.repository.PokemonRepository;
import com.revature.utils.ConnectionUtil;
import com.sun.net.httpserver.HttpServer;


/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws Exception{
        System.out.println("Starting backend server...");

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/Login", new PokemonController());
        server.createContext("/Register", new AbilityController());

        server.setExecutor(null);
        server.start();
    }
}