package com.banking.dto;

import java.time.LocalDateTime;

public class ErrorDetails {

	private String erromessage;
	private String errorcode;
	private String tocontact;
	private LocalDateTime timestamp;
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetails(String erromessage, String errorcode, String tocontact, LocalDateTime timestamp) {
		super();
		this.erromessage = erromessage;
		this.errorcode = errorcode;
		this.tocontact = tocontact;
		this.timestamp = timestamp;
	}
	public String getErromessage() {
		return erromessage;
	}
	public void setErromessage(String erromessage) {
		this.erromessage = erromessage;
	}
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String getTocontact() {
		return tocontact;
	}
	public void setTocontact(String tocontact) {
		this.tocontact = tocontact;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "ErrorDetails [erromessage=" + erromessage + ", errorcode=" + errorcode + ", tocontact=" + tocontact
				+ ", timestamp=" + timestamp + "]";
	}
	
	public static class ErrorDetailsBuilder {
        private String errorMessage;
        private String errorCode;
        private String toContact;
        private LocalDateTime timestamp;

        public ErrorDetailsBuilder() {}

        public ErrorDetailsBuilder errorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public ErrorDetailsBuilder errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public ErrorDetailsBuilder toContact(String toContact) {
            this.toContact = toContact;
            return this;
        }

        public ErrorDetailsBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorDetails build() {
            return new ErrorDetails(errorMessage, errorCode, toContact, timestamp);
        }
    }

	
	
	
}
