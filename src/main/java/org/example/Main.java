import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Reviews;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<Reviews> reviewsList = new ArrayList<>();

        try {
            Reviews[] reviewArray = objectMapper.readValue(new File("reviews.json"), Reviews[].class);
            Collections.addAll(reviewsList, reviewArray);


            float minimumRating = 4.0f;


            List<Reviews> filteredReviews = reviewsList.stream()
                    .filter(review -> review.getRating() >= minimumRating)
                    .collect(Collectors.toList());


            Collections.sort(filteredReviews);


            System.out.println("Review Text\tRating\tDate");
            for (Reviews review : filteredReviews) {
                System.out.println(review.getReviewText() + "\t" + review.getRating() + "\t" + review.getReviewCreatedOnDate());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
