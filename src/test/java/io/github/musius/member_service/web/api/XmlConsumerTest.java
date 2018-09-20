package io.github.musius.member_service.web.api;

import io.github.musius.member_service.BaseMemberServiceMvcTest;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.ResponseOptions;
import org.junit.Test;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class XmlConsumerTest extends BaseMemberServiceMvcTest {
    @Test
    public void validate_create_member_in_xml() {
        // given:
        MockMvcRequestSpecification request = given()
                .header("Content-Type", "application/xml;charset=UTF-8")
                .header("Accept", "application/xml;charset=UTF-8")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<member>\n" +
                        "    <firstName>Joe</firstName>\n" +
                        "    <lastName>Dough</lastName>\n" +
                        "    <dateOfBirth>2007-12-03T10:15:30+01:00</dateOfBirth>\n" +
                        "    <postalCode>350454</postalCode>\n" +
                        "</member>");

        // when:
        ResponseOptions response = given().spec(request)
                .post("/member");

        // then:
        assertThat(response.statusCode()).isEqualTo(201);
        // and:
        XmlPath parsedXml = XmlPath.from(response.getBody().asString());
        assertThat(parsedXml.get("Member.firstName"), is("Joe"));
        assertThat(parsedXml.get("Member.lastName"), is("Dough"));
        assertThat(parsedXml.get("Member.dateOfBirth"), containsString("2007-12-03"));
        assertThat(parsedXml.get("Member.postalCode"), is("350454"));
        assertThat(parsedXml.get("Member.id"), is(notNullValue()));
    }
}