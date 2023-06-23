package org.example;
import java.util.Collections;
public class Reviews implements Comparable<Reviews> {
    String reviewText;
    float rating;
    String reviewCreatedOnDate;



    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getReviewCreatedOnDate() {
        return reviewCreatedOnDate;
    }

    public void setReviewCreatedOnDate(String reviewCreatedOnDate) {
        this.reviewCreatedOnDate = reviewCreatedOnDate;
    }



    @Override
    public int compareTo(Reviews otherReview) {

        int textComparison = this.reviewText.compareTo(otherReview.getReviewText());
        if (textComparison != 0) {
            return textComparison;
        }


        int ratingComparison = Float.compare(otherReview.getRating(), this.rating);
        if (ratingComparison != 0) {
            return ratingComparison;
        }


        return this.reviewCreatedOnDate.compareTo(otherReview.getReviewCreatedOnDate());
    }


}

