package com.example.loginteste.data.model;

import java.util.List;

public class OrderResponse {
    private boolean updateRequired;
    private List<Order> atendimentos;

    public List<Order> getAtendimentos() {
        return atendimentos;
    }
}
