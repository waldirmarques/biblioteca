package br.com.apibiblioteca.userbook.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class UserAppDTO {

    private Long id;

    @NotEmpty
    private String name;

    @NotNull
    private int age;

    @NotEmpty
    private String fone;

    public static UserAppDTO from(UserApp userApp) {
        return UserAppDTO
                .builder()
                .id(userApp.getId())
                .name(userApp.getName())
                .age(userApp.getAge())
                .fone(userApp.getFone())
                .build();
    }

    public static List<UserAppDTO> fromAll(List<UserApp> userApps) {
        return userApps.stream().map(UserAppDTO::from).collect(Collectors.toList());
    }

    public static Page<UserAppDTO> fromPage(Page<UserApp> pages) {
        return pages.map(UserAppDTO::from);
    }

}
