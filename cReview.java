/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HPvictus2022
 */
public class cReview extends SuperReview {
    private String itemID;
private String reviewText;

public cReview(String itemID, String reviewText) {
    this.itemID = itemID;
    this.reviewText = reviewText;
}

@Override
public List<cReview> readReview() {
    List<cReview> reviews = new ArrayList<>();
    String filePath = "review.txt";
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\$");
            if (parts.length >= 6 && parts[1].trim().equals(itemID)) {
                reviews.add(new cReview(parts[1].trim(), parts[6].trim()));
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return reviews;
}

public String showReviews() {
    if (reviewText != null && !reviewText.isEmpty()) {
        return reviewText;
    } else {
        return "No reviews available for this item.";
    }
}
}
