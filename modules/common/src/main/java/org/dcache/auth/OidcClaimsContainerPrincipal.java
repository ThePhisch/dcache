package org.dcache.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;

public class OidcClaimsContainerPrincipal implements Principal {

    private static final Logger LOGGER = LoggerFactory.getLogger(OidcClaimsContainerPrincipal.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    private final JsonNode claims;
    private final String idp;

    public OidcClaimsContainerPrincipal(JsonNode claims, String idp) {
        this.idp = idp;
        this.claims = claims;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OidcClaimsContainerPrincipal)) {
            return false;
        }

        OidcClaimsContainerPrincipal other = (OidcClaimsContainerPrincipal) obj;
        return idp.equals(other.idp) && claims.equals(other.claims);
    }

    @Override
    public String toString() {
        return "OidcClaims[" + this.idp + "]";
    }

    @Override
    public int hashCode() {
        return claims.toString().hashCode();
    }

    @Override
    public String getName() {
        return this.toString();
    }

    public String claimStringify() {
        return this.claims.toString();
    }

    public String fullStringify() {
        return this.claimStringify() + "@" + this.idp;
    }

    public static JsonNode makeJsonNode(String s) {
        try {
            return mapper.readValue(s, JsonNode.class);
        } catch (JsonProcessingException e) {
            LOGGER.warn("JSON could not be parsed!");
            return mapper.createObjectNode();
        }
    }
}
