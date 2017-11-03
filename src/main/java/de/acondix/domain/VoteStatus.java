package de.acondix.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public enum VoteStatus {

    OK,
    INVALID_VOTE,
    INVALID_COUNTRY,
    INVALID_IP
    ;

    private static final List<VoteStatus> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();

    public static VoteStatus randomVoteStatus()  {
        return VALUES.get(ThreadLocalRandom.current().nextInt(0, SIZE));
    }
}
