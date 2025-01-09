import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_ACCEPTED;
import static java.net.HttpURLConnection.HTTP_OK;

public class CreatingUser {
    private String email;
    private String password;
    private String name;

    public CreatingUser(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }



    @Step("Запрос на создание нового пользователя")
    public Response creatingUser(CreatingUser user) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .body(user)
                .when().post(Constants.API_CREATING);
    }
    @Step("Пользователь успешно создан")
    public String checkCreatedOK(Response response) {
        return response.then().log().all()
                .assertThat()
                .statusCode(HTTP_OK)
                .extract().path( "accessToken");
    }


    @Step("Созданный пользователь удален")
    public void deleteUser(String token) {
        given().log().all()
                .header("Authorization", token)
                .delete(Constants.API_USER)
                .then().log().all()
                .statusCode(HTTP_ACCEPTED);
    }
}
