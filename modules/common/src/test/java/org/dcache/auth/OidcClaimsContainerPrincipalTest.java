package org.dcache.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OidcClaimsContainerPrincipalTest {
    private final ObjectMapper mapper = new ObjectMapper();
    private String j1;
    private ObjectNode n1;  // subclass of JsonNode that I can add to
    private String idp = "MY-OP";

    @Before
    public void setup() throws IOException {
        j1 = """
                {
                  "sub": "32018447-cf2e-4496-8362-24f736e95c0b",
                  "email_verified": true,
                  "realm_access": {
                    "roles": [
                      "default-roles-production",
                      "batch",
                      "it",
                      "windows",
                      "owncloud",
                      "wlan_desy",
                      "afs",
                      "mailbox",
                      "offline_access",
                      "bastion",
                      "uma_authorization",
                      "unix",
                      "eduroam"
                    ]
                  },
                  "name": "Philipp Anton Schwarz",
                  "groups": [
                    "/it",
                    "/BPMusers"
                  ],
                  "preferred_username": "paschwar",
                  "given_name": "Philipp Anton",
                  "family_name": "Schwarz",
                  "email": "anton.schwarz@desy.de"
                }
                """;
        n1 = mapper.readValue(j1, ObjectNode.class);
    }

    @Test
    public void jsonConversion() throws Exception {
        OidcClaimsContainerPrincipal p = new OidcClaimsContainerPrincipal(n1, idp);
        assertThat(p.hashCode(), equalTo(n1.toString().hashCode()));
        assertThat(p.getName(), equalTo("OidcClaims[" + idp + "]"));
        assertThat(p.getName(), equalTo(p.toString()));
        assertThat(p.claimStringify(), equalTo(n1.toString()));
        assertThat(p.fullStringify(), equalTo(n1.toString() + "@" + idp));
    }

    @Test
    public void equalityCheck() throws Exception {
        OidcClaimsContainerPrincipal p1 = new OidcClaimsContainerPrincipal(n1, idp);
        OidcClaimsContainerPrincipal p1s = new OidcClaimsContainerPrincipal(n1, idp);

        ObjectNode n2 = n1.deepCopy().put("Kaguya", "Shinomya");
        OidcClaimsContainerPrincipal p2 = new OidcClaimsContainerPrincipal(n2, idp);

        OidcClaimsContainerPrincipal p3 = new OidcClaimsContainerPrincipal(n2, "Miyuki_Shirogane");

        assertThat(p1, equalTo(p1s));  // should be identical
        assertThat(p1, not(anyOf(equalTo(p2), equalTo(p3))));  // different claims, different claims + idp
        assertThat(p2, not(equalTo(p3)));  // different idp
    }
}
