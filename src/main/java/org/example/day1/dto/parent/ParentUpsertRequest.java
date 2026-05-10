package org.example.day1.dto.parent;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParentUpsertRequest {
    @NotBlank
    @Size(min = 2, max = 100)
    private String fullName;

    @NotBlank
    @Size(max = 20)
    @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})$")
    private String phone;

    @Email
    @Size(max = 100)
    private String email;

    @Size(max = 255)
    private String address;

    @Size(max = 20)
    private String relationship;

    @Size(max = 10)
    private String gender;
}
