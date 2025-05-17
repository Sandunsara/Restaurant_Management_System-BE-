package com.ceyentra.sm.dto.web.response;

import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.MainMealTypes;
import com.ceyentra.sm.enums.MealCategory;
import com.ceyentra.sm.enums.MealTypes;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MealResponseDTO {
    Long id;
    String name;
    String image;
    String description;
    Float price;
    Float discount;
    Long rating;
    MealTypes subCategory;
    MainMealTypes mainCategory;
    MealCategory mealType;
    Long restaurantId;
    CommonStatus status;
    Date createdDate;
    Date updatedDate;
}
