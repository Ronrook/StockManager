package com.ronrook.StockManager.infrastructure.adapters;

import com.ronrook.StockManager.application.ports.out.INotificationServicePort;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ConsoleNotificationService implements INotificationServicePort {

    private static final Logger logger = Logger.getLogger(ConsoleNotificationService.class.getName());


    @Override
    public void sendNotification(String message) {
        logger.warning("Notification: " + message);
    }
}
