package com.scheduler.demoScheduler.entities;

import lombok.Data;

@Data
public class MovieRow {
    private int user_id;
    private int item_id;
    private int rating;
    private int timestamp;
}
