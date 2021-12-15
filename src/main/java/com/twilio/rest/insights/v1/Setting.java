/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.insights.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Setting extends Resource {
    private static final long serialVersionUID = 225451731122321L;

    /**
     * Create a SettingFetcher to execute fetch.
     *
     * @return SettingFetcher capable of executing the fetch
     */
    public static SettingFetcher fetcher() {
        return new SettingFetcher();
    }

    /**
     * Create a SettingUpdater to execute update.
     *
     * @return SettingUpdater capable of executing the update
     */
    public static SettingUpdater updater() {
        return new SettingUpdater();
    }

    /**
     * Converts a JSON String into a Setting object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Setting object represented by the provided JSON
     */
    public static Setting fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Setting.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Setting object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Setting object represented by the provided JSON
     */
    public static Setting fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Setting.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final Boolean advancedFeatures;
    private final Boolean voiceTrace;
    private final URI url;

    @JsonCreator
    private Setting(@JsonProperty("account_sid")
                    final String accountSid,
                    @JsonProperty("advanced_features")
                    final Boolean advancedFeatures,
                    @JsonProperty("voice_trace")
                    final Boolean voiceTrace,
                    @JsonProperty("url")
                    final URI url) {
        this.accountSid = accountSid;
        this.advancedFeatures = advancedFeatures;
        this.voiceTrace = voiceTrace;
        this.url = url;
    }

    /**
     * Returns The account_sid.
     *
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The advanced_features.
     *
     * @return The advanced_features
     */
    public final Boolean getAdvancedFeatures() {
        return this.advancedFeatures;
    }

    /**
     * Returns The voice_trace.
     *
     * @return The voice_trace
     */
    public final Boolean getVoiceTrace() {
        return this.voiceTrace;
    }

    /**
     * Returns The url.
     *
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Setting other = (Setting) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(advancedFeatures, other.advancedFeatures) &&
               Objects.equals(voiceTrace, other.voiceTrace) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            advancedFeatures,
                            voiceTrace,
                            url);
    }
}