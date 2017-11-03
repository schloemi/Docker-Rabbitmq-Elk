package de.acondix.domain;

import java.util.Date;

public class VoteMessage {

    private long designObject;
    private int value;
    private Date votingDate;
    private VoteStatus voteStatus;
    private String ipAddress;
    private boolean isValid;


    public long getDesignObject() {
        return designObject;
    }

    public void setDesignObject(long designObject) {
        this.designObject = designObject;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getVotingDate() {
        return votingDate;
    }

    public void setVotingDate(Date votingDate) {
        this.votingDate = votingDate;
    }

    public VoteStatus getVoteStatus() {
        return voteStatus;
    }

    public void setVoteStatus(VoteStatus voteStatus) {
        this.voteStatus = voteStatus;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
