/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.conference;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.type.Endpoint;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Participant extends Resource {
    private static final long serialVersionUID = 89883663840219L;

    public enum Status {
        QUEUED("queued"),
        CONNECTING("connecting"),
        RINGING("ringing"),
        CONNECTED("connected"),
        COMPLETE("complete"),
        FAILED("failed");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    /**
     * Create a ParticipantFetcher to execute fetch.
     *
     * @param pathAccountSid The SID of the Account that created the resource to
     *                       fetch
     * @param pathConferenceSid The SID of the conference with the participant to
     *                          fetch
     * @param pathCallSid The Call SID or URL encoded label of the participant to
     *                    fetch
     * @return ParticipantFetcher capable of executing the fetch
     */
    public static ParticipantFetcher fetcher(final String pathAccountSid,
                                             final String pathConferenceSid,
                                             final String pathCallSid) {
        return new ParticipantFetcher(pathAccountSid, pathConferenceSid, pathCallSid);
    }

    /**
     * Create a ParticipantFetcher to execute fetch.
     *
     * @param pathConferenceSid The SID of the conference with the participant to
     *                          fetch
     * @param pathCallSid The Call SID or URL encoded label of the participant to
     *                    fetch
     * @return ParticipantFetcher capable of executing the fetch
     */
    public static ParticipantFetcher fetcher(final String pathConferenceSid,
                                             final String pathCallSid) {
        return new ParticipantFetcher(pathConferenceSid, pathCallSid);
    }

    /**
     * Create a ParticipantUpdater to execute update.
     *
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       update
     * @param pathConferenceSid The SID of the conference with the participant to
     *                          update
     * @param pathCallSid The Call SID or URL encoded label of the participant to
     *                    update
     * @return ParticipantUpdater capable of executing the update
     */
    public static ParticipantUpdater updater(final String pathAccountSid,
                                             final String pathConferenceSid,
                                             final String pathCallSid) {
        return new ParticipantUpdater(pathAccountSid, pathConferenceSid, pathCallSid);
    }

    /**
     * Create a ParticipantUpdater to execute update.
     *
     * @param pathConferenceSid The SID of the conference with the participant to
     *                          update
     * @param pathCallSid The Call SID or URL encoded label of the participant to
     *                    update
     * @return ParticipantUpdater capable of executing the update
     */
    public static ParticipantUpdater updater(final String pathConferenceSid,
                                             final String pathCallSid) {
        return new ParticipantUpdater(pathConferenceSid, pathCallSid);
    }

    /**
     * Create a ParticipantCreator to execute create.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param pathConferenceSid The SID of the participant's conference
     * @param from The phone number, Client identifier, or username portion of SIP
     *             address that made this call.
     * @param to The phone number, SIP address or Client identifier that received
     *           this call.
     * @return ParticipantCreator capable of executing the create
     */
    public static ParticipantCreator creator(final String pathAccountSid,
                                             final String pathConferenceSid,
                                             final com.twilio.type.Endpoint from,
                                             final com.twilio.type.Endpoint to) {
        return new ParticipantCreator(pathAccountSid, pathConferenceSid, from, to);
    }

    /**
     * Create a ParticipantCreator to execute create.
     *
     * @param pathConferenceSid The SID of the participant's conference
     * @param from The phone number, Client identifier, or username portion of SIP
     *             address that made this call.
     * @param to The phone number, SIP address or Client identifier that received
     *           this call.
     * @return ParticipantCreator capable of executing the create
     */
    public static ParticipantCreator creator(final String pathConferenceSid,
                                             final com.twilio.type.Endpoint from,
                                             final com.twilio.type.Endpoint to) {
        return new ParticipantCreator(pathConferenceSid, from, to);
    }

    /**
     * Create a ParticipantDeleter to execute delete.
     *
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       delete
     * @param pathConferenceSid The SID of the conference with the participants to
     *                          delete
     * @param pathCallSid The Call SID or URL encoded label of the participant to
     *                    delete
     * @return ParticipantDeleter capable of executing the delete
     */
    public static ParticipantDeleter deleter(final String pathAccountSid,
                                             final String pathConferenceSid,
                                             final String pathCallSid) {
        return new ParticipantDeleter(pathAccountSid, pathConferenceSid, pathCallSid);
    }

    /**
     * Create a ParticipantDeleter to execute delete.
     *
     * @param pathConferenceSid The SID of the conference with the participants to
     *                          delete
     * @param pathCallSid The Call SID or URL encoded label of the participant to
     *                    delete
     * @return ParticipantDeleter capable of executing the delete
     */
    public static ParticipantDeleter deleter(final String pathConferenceSid,
                                             final String pathCallSid) {
        return new ParticipantDeleter(pathConferenceSid, pathCallSid);
    }

    /**
     * Create a ParticipantReader to execute read.
     *
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       read
     * @param pathConferenceSid The SID of the conference with the participants to
     *                          read
     * @return ParticipantReader capable of executing the read
     */
    public static ParticipantReader reader(final String pathAccountSid,
                                           final String pathConferenceSid) {
        return new ParticipantReader(pathAccountSid, pathConferenceSid);
    }

    /**
     * Create a ParticipantReader to execute read.
     *
     * @param pathConferenceSid The SID of the conference with the participants to
     *                          read
     * @return ParticipantReader capable of executing the read
     */
    public static ParticipantReader reader(final String pathConferenceSid) {
        return new ParticipantReader(pathConferenceSid);
    }

    /**
     * Converts a JSON String into a Participant object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Participant object represented by the provided JSON
     */
    public static Participant fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Participant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Participant object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Participant object represented by the provided JSON
     */
    public static Participant fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Participant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String callSid;
    private final String label;
    private final String callSidToCoach;
    private final Boolean coaching;
    private final String conferenceSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final Boolean endConferenceOnExit;
    private final Boolean muted;
    private final Boolean hold;
    private final Boolean startConferenceOnEnter;
    private final Participant.Status status;
    private final String uri;

    @JsonCreator
    private Participant(@JsonProperty("account_sid")
                        final String accountSid,
                        @JsonProperty("call_sid")
                        final String callSid,
                        @JsonProperty("label")
                        final String label,
                        @JsonProperty("call_sid_to_coach")
                        final String callSidToCoach,
                        @JsonProperty("coaching")
                        final Boolean coaching,
                        @JsonProperty("conference_sid")
                        final String conferenceSid,
                        @JsonProperty("date_created")
                        final String dateCreated,
                        @JsonProperty("date_updated")
                        final String dateUpdated,
                        @JsonProperty("end_conference_on_exit")
                        final Boolean endConferenceOnExit,
                        @JsonProperty("muted")
                        final Boolean muted,
                        @JsonProperty("hold")
                        final Boolean hold,
                        @JsonProperty("start_conference_on_enter")
                        final Boolean startConferenceOnEnter,
                        @JsonProperty("status")
                        final Participant.Status status,
                        @JsonProperty("uri")
                        final String uri) {
        this.accountSid = accountSid;
        this.callSid = callSid;
        this.label = label;
        this.callSidToCoach = callSidToCoach;
        this.coaching = coaching;
        this.conferenceSid = conferenceSid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.endConferenceOnExit = endConferenceOnExit;
        this.muted = muted;
        this.hold = hold;
        this.startConferenceOnEnter = startConferenceOnEnter;
        this.status = status;
        this.uri = uri;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The SID of the Call the resource is associated with.
     *
     * @return The SID of the Call the resource is associated with
     */
    public final String getCallSid() {
        return this.callSid;
    }

    /**
     * Returns The label of this participant.
     *
     * @return The label of this participant
     */
    public final String getLabel() {
        return this.label;
    }

    /**
     * Returns The SID of the participant who is being `coached`.
     *
     * @return The SID of the participant who is being `coached`
     */
    public final String getCallSidToCoach() {
        return this.callSidToCoach;
    }

    /**
     * Returns Indicates if the participant changed to coach.
     *
     * @return Indicates if the participant changed to coach
     */
    public final Boolean getCoaching() {
        return this.coaching;
    }

    /**
     * Returns The SID of the conference the participant is in.
     *
     * @return The SID of the conference the participant is in
     */
    public final String getConferenceSid() {
        return this.conferenceSid;
    }

    /**
     * Returns The RFC 2822 date and time in GMT that the resource was created.
     *
     * @return The RFC 2822 date and time in GMT that the resource was created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The RFC 2822 date and time in GMT that the resource was last updated.
     *
     * @return The RFC 2822 date and time in GMT that the resource was last updated
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns Whether the conference ends when the participant leaves.
     *
     * @return Whether the conference ends when the participant leaves
     */
    public final Boolean getEndConferenceOnExit() {
        return this.endConferenceOnExit;
    }

    /**
     * Returns Whether the participant is muted.
     *
     * @return Whether the participant is muted
     */
    public final Boolean getMuted() {
        return this.muted;
    }

    /**
     * Returns Whether the participant is on hold.
     *
     * @return Whether the participant is on hold
     */
    public final Boolean getHold() {
        return this.hold;
    }

    /**
     * Returns Whether the conference starts when the participant joins the
     * conference.
     *
     * @return Whether the conference starts when the participant joins the
     *         conference
     */
    public final Boolean getStartConferenceOnEnter() {
        return this.startConferenceOnEnter;
    }

    /**
     * Returns The status of the participant's call in a session.
     *
     * @return The status of the participant's call in a session
     */
    public final Participant.Status getStatus() {
        return this.status;
    }

    /**
     * Returns The URI of the resource, relative to `https://api.twilio.com`.
     *
     * @return The URI of the resource, relative to `https://api.twilio.com`
     */
    public final String getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Participant other = (Participant) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(callSid, other.callSid) &&
               Objects.equals(label, other.label) &&
               Objects.equals(callSidToCoach, other.callSidToCoach) &&
               Objects.equals(coaching, other.coaching) &&
               Objects.equals(conferenceSid, other.conferenceSid) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(endConferenceOnExit, other.endConferenceOnExit) &&
               Objects.equals(muted, other.muted) &&
               Objects.equals(hold, other.hold) &&
               Objects.equals(startConferenceOnEnter, other.startConferenceOnEnter) &&
               Objects.equals(status, other.status) &&
               Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            callSid,
                            label,
                            callSidToCoach,
                            coaching,
                            conferenceSid,
                            dateCreated,
                            dateUpdated,
                            endConferenceOnExit,
                            muted,
                            hold,
                            startConferenceOnEnter,
                            status,
                            uri);
    }
}