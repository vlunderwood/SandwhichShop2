package dmacc.beans;

//@author valei - vlunderwood CIS175 - Fall 2023 Nov 02, 2023

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Enter a sandwhich name.")
	@Size(max = 50, min = 1, message = "Must be between 1-50 characters")
	private String itemName;
	@NotEmpty(message = "Enter a sandwhich description and any extras wanted.")
	@Size(max = 1000, min = 1, message = "Must be between 1-1000 characters")
	private String itemDescription;
	@NotEmpty(message = "Enter a price")
    @Min(value = 1, message = "Price must be greater than $1.00")
	private String itemPrice;
}
